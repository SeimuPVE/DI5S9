# Import the necessary packages.
import numpy
from picamera.array import PiRGBArray
from picamera import PiCamera
import cv2
import time
import socket
from threading import *


def int2bytes(n):
    result = bytearray()
    while n:
        result.append(n & 0xff)
        n = n >> 8
    return result[::-1]


class videoprocess(Thread):
    # Initialize the camera and grab a reference to the raw camera capture.
    rawCapture = 0
    time.sleep(0.1)  # Allow the camera to warm up.

    # Sockets
    sock = 0

    """ Thread chargé de charger le serveur. """
    def __init__(self, camera, WIDTH, HEIGHT, SERVER_ADDR, portclient):
        Thread.__init__(self)
        self.camera = camera
        self.WIDTH = WIDTH
        self.HEIGHT = HEIGHT
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

    def setimage(self, image):
        self.image = image

    def run(self):
        """ Code à exécuter pendant l'exécution du thread. """
        # Capture frames from the camera.
        while (True):
            for frame in self.camera.capture_continuous(self.rawCapture, format="bgr", use_video_port=True):
                # Grab the raw NumPy array representing the image, then initialize the timestamp and occupied/unoccupied text.
                image = frame.array
                image.flags.writeable = True

                gray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
                gray = cv2.resize(gray, (self.WIDTH, self.HEIGHT), interpolation=cv2.INTER_LINEAR)

                # Send the image size to the client.
                data, address = self.sock.recvfrom(8)
                self.sock.sendto(int2bytes(gray.size), address)

                # Send the image to the client.
                self.sock.sendto(gray, address)

                # Clear the stream in preparation for the next frame.
                self.rawCapture.truncate(0)

                # If the 'q' key was pressed, break from the loop.
                key = cv2.waitKey(1) & 0xFF
                if key == ord("q"):
                    break

        sock.close()
        camera.close()



# Preparing camera.
WIDTH = 320
HEIGHT = 180
SERVER_ADDR = "192.168.1.253"

camera = PiCamera()
camera.vflip = True
camera.hflip = True
camera.resolution = (WIDTH, HEIGHT)
camera.framerate = 32
rawCapture = PiRGBArray(camera, size=(WIDTH, HEIGHT))

# Création des threads.
thread_1 = videoprocess(camera, WIDTH, HEIGHT, SERVER_ADDR, 5006)
thread_2 = videoprocess(camera, WIDTH, HEIGHT, SERVER_ADDR, 5007)
thread_3 = videoprocess(camera, WIDTH, HEIGHT, SERVER_ADDR, 5008)

# Lancement des threads.
thread_1.start()
thread_2.start()
thread_3.start()
time.sleep(1) # Warmup des threads.

# Attend que les threads se terminent.
thread_1.join()
thread_2.join()
thread_3.join()
cv2.destroyAllWindows()
