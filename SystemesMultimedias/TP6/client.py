# Import the necessary packages.
import matplotlib.pyplot as plt
import numpy as np
import cv2
import socket
import sys


# Initialize variables.
UDP_IP = str(sys.argv[1])
UDP_PORT = int(sys.argv[2])
WIDTH = 320
HEIGHT = 180


while(True):
    # Initialize the socket.
    sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)  # Internet with UDP.

    # Receive the data.
    sock.sendto(bytes(0), (UDP_IP, UDP_PORT))

    # Receive the image size.
    img_size, server = sock.recvfrom(8)
    img_size = int.from_bytes(img_size, byteorder='big')
    print(img_size)

    # Receive the image.
    raw_img, server = sock.recvfrom(img_size)
    print(len(raw_img))

    # Convert the data in OpenCV img.
    im = np.frombuffer(raw_img, dtype='int8')  # Convert bytes to numpy format.
    im = np.uint8(im)  # Convert bytes in uint8.
    im = np.reshape(im, (HEIGHT, WIDTH))  # Convert 1D raw into matrix.

    # Print the image to the screen.
    cv2.imshow("Frame", im)

    key = cv2.waitKey(1) & 0xFF
    if key == ord("q"):
        break

# Close the socket.
sock.close()
