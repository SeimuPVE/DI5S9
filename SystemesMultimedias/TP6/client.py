# Import the necessary packages.
import matplotlib.pyplot as plt
import numpy as np
import socket
import sys


# Initialize variables.
UDP_IP = str(sys.argv[1])
UDP_PORT = int(sys.argv[2])
BUFFER_SIZE = 4096
WIDTH = 320
HEIGHT = 180


# Initialize the socket.
sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)  # Internet with UDP.


# Receive the data.
sock.sendto(bytes(0), (UDP_IP, UDP_PORT))

img_size, server = sock.recvfrom(8)
img_size = int.from_bytes(img_size, byteorder='big')
print("An image of " + str(img_size) + " bytes will be received.")

raw_img = bytes()
while len(raw_img) < img_size:
    if img_size - len(raw_img) < BUFFER_SIZE:
        data, server = sock.recvfrom(img_size - len(raw_img))
        raw_img = raw_img + data
    else:
        data, server = sock.recvfrom(BUFFER_SIZE)
        raw_img = raw_img + data
    print(len(raw_img))

print("A")

# Convert the data in OpenCV img.
im = np.frombuffer(raw_img, dtype='int8')  # Convert bytes to numpy format.
im = np.uint8(im)  # Convert bytes in uint8.
im = np.reshape(im, (WIDTH, HEIGHT))  # Convert 1D raw into matrix.


# Print the image to the screen.
plt.imshow(im)


# Close the socket.
sock.close()
