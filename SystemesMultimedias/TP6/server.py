# Import the necessary packages.
from picamera.array import PiRGBArray
from picamera import PiCamera
import cv2
import time
import socket


def int2bytes(n):
    result = bytearray()
    while n:
        result.append(n & 0xff)
        n = n >> 8
    return result[::-1]


# Initialize variables.
SERVER_ADDR = "192.168.1.253"
PORT = 5006
WIDTH = 320
HEIGHT = 180


# Initialize the camera and grab a reference to the raw camera capture.
camera = PiCamera()
camera.vflip = True
camera.hflip = True
camera.resolution = (WIDTH, HEIGHT)
camera.framerate = 32
rawCapture = PiRGBArray(camera, size=(WIDTH, HEIGHT))
time.sleep(0.1)  # Allow the camera to warm up.


# Initialize the socket.
sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)  # Internet with UDP.
sock.bind((SERVER_ADDR, PORT))

print("Waiting on clients...")


# Capture frames from the camera.
while(True):
    for frame in camera.capture_continuous(rawCapture, format="bgr", use_video_port=True):
        # Grab the raw NumPy array representing the image, then initialize the timestamp and occupied/unoccupied text.
        image = frame.array
        image.flags.writeable = True

        gray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
        gray = cv2.resize(gray, (WIDTH, HEIGHT), interpolation=cv2.INTER_LINEAR)

        # Send the image size to the client.
        data, address = sock.recvfrom(8)
        sock.sendto(int2bytes(gray.size), address)

        # Send the image to the client.
        sock.sendto(gray, address)

        # Clear the stream in preparation for the next frame.
        rawCapture.truncate(0)

        # If the 'q' key was pressed, break from the loop.
        key = cv2.waitKey(1) & 0xFF
        if key == ord("q"):
            break

sock.close()
camera.close()
