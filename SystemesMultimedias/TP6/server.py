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
BUFFER_SIZE = 4096
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


# Capture frames from the camera.
for frame in camera.capture_continuous(rawCapture, format="bgr", use_video_port=True):
    # Grab the raw NumPy array representing the image, then initialize the timestamp and occupied/unoccupied text.
    image = frame.array
    image.flags.writeable = True

    gray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
    gray = cv2.resize(gray, (WIDTH, HEIGHT), interpolation=cv2.INTER_LINEAR)

    # Send the image to the client.
    print("Waiting on a client...")
    data, address = sock.recvfrom(8)
    sock.sendto(int2bytes(gray.size), address)
    print("A new client is connected. An image of " + str(gray.size) + " bytes will be send.")

    while int(gray.size) > 0:
        if int(gray.size) < BUFFER_SIZE:
            print("Last")
            data = gray[0:gray.size]
            gray = []
            sock.sendto(data, address)
        else:
            print("In")
            data = gray[0:BUFFER_SIZE]
            gray = gray[BUFFER_SIZE:]
            sock.sendto(data, address)
        print(gray.size)

    # Clear the stream in preparation for the next frame.
    rawCapture.truncate(0)

    # If the 'q' key was pressed, break from the loop.
    key = cv2.waitKey(1) & 0xFF
    if key == ord("q"):
        break

sock.close()
camera.close()