# Import the necessary packages.
import cv2
import time
import socket
from threading import *


class videosender(Thread):
    # Initialize the camera and grab a reference to the raw camera capture.
    rawCapture = 0
    time.sleep(0.1)  # Allow the camera to warm up.

    # Sockets
    sock = 0

    """ Thread chargé de charger le serveur. """
    def __init__(self, SERVER_ADDR, portclient):
        Thread.__init__(self)
        self.SERVER_ADDR = SERVER_ADDR
        self.PORT = portclient

        # Initialize the socket.
        self.sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)  # Internet with UDP.
        self.sock.bind((self.SERVER_ADDR, self.PORT))

        print("Waiting on clients...")

        # From teacher (help for FPS ?).
#        self.image = np.zeros((20,20,3), np.uint8)
#        self.fps = fps
#        self.id = id
#        print('thread=live at fps=' + str(fps))

    def int2bytes(n):
        result = bytearray()
        while n:
            result.append(n & 0xff)
            n = n >> 8
        return result[::-1]

    def run(self):
        """ Code à exécuter pendant l'exécution du thread. """
        global CURRENT_IMAGE
        # Capture frames from the camera.
        while (True):
                gray = CURRENT_IMAGE
                # Send the image size to the client.
                data, address = self.sock.recvfrom(8)
                self.sock.sendto(self.int2bytes(gray.size), address)

                # Send the image to the client.
                self.sock.sendto(gray, address)

                # Clear the stream in preparation for the next frame.
                self.rawCapture.truncate(0)

                # If the 'q' key was pressed, break from the loop.
                key = cv2.waitKey(1) & 0xFF
                if key == ord("q"):
                    break

        self.sock.close()
