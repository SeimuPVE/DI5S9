# Import the necessary packages.
import matplotlib.pyplot as plt
import numpy as np
import socket
import sys


# Initialize variables.
UDP_IP = int(sys.argv[0])
UDP_PORT = int(sys.argv[1])
BUFFER_SIZE = 4096
WIDTH = 320
HEIGHT = 180


# Initialize the socket.
sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)  # Internet with UDP.
sock.connect((UDP_IP, UDP_PORT))


# Receive the data.
raw_img = []
while True:
    data = sock.recv(BUFFER_SIZE)
    if not data:
        break
    raw_img.append(data)


# Convert the data in OpenCV img.
im = np.frombuffer(raw_img, dtype='int8')  # Convert bytes to numpy format.
im = np.uint8(im)  # Convert bytes in uint8.
im = np.reshape(im, (WIDTH, HEIGHT))  # Convert 1D raw into matrix.


# Print the image to the screen.
plt.imshow(im)
