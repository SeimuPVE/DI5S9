# Import the necessary packages.
import cv2
import time
from threading import *


class videocapture(Thread):
    # Initialize the camera and grab a reference to the raw camera capture.
    rawCapture = 0
    time.sleep(0.1)  # Allow the camera to warm up.

    # Sockets
    sock = 0

    """ Thread chargé de charger le serveur. """
    def __init__(self, camera, WIDTH, HEIGHT):
        Thread.__init__(self)
        self.camera = camera
        self.WIDTH = WIDTH
        self.HEIGHT = HEIGHT

    def setimage(self, image):
        self.image = image

    def run(self):
        """ Code à exécuter pendant l'exécution du thread. """
        global CURRENT_IMAGE
        # Capture frames from the camera.
        while (True):
            for frame in self.camera.capture_continuous(self.rawCapture, format="bgr", use_video_port=True):
                # Grab the raw NumPy array representing the image, then initialize the timestamp and occupied/unoccupied text.
                image = frame.array
                image.flags.writeable = True

                gray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
                gray = cv2.resize(gray, (self.WIDTH, self.HEIGHT), interpolation=cv2.INTER_LINEAR)
                CURRENT_IMAGE = gray

        camera.close()
