# Import the necessary packages.
from picamera.array import PiRGBArray
from picamera import PiCamera
import cv2
import time
import socket


# Initialize variables.
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
server_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)  # Internet with UDP.
server_socket.listen(10)
sockfd, client_address = server_socket.accept()
print("A new client is connected : " + client_address)


# Capture frames from the camera.
for frame in camera.capture_continuous(rawCapture, format="bgr", use_video_port=True):
    # Grab the raw NumPy array representing the image, then initialize the timestamp and occupied/unoccupied text.
    image = frame.array
    image.flags.writeable = True

    cv2.imshow("Frame", image)
    gray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
    gray = cv2.resize(gray, (WIDTH, HEIGHT), interpolation=cv2.INTER_LINEAR)

    # Send the image to the client.
    while gray.size != 0:
        if gray.size < BUFFER_SIZE:
            data = gray[0:gray.size]
            gray = gray[gray.size:]
            sockfd.send(data)
        else:
            data = gray[0:BUFFER_SIZE]
            gray = gray[BUFFER_SIZE:]
            sockfd.send(data)

    # Clear the stream in preparation for the next frame.
    rawCapture.truncate(0)

    # If the 'q' key was pressed, break from the loop.
    key = cv2.waitKey(1) & 0xFF
    if key == ord("q"):
        break

sockfd.close()
camera.close()
