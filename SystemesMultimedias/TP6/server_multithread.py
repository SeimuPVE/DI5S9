# Import the necessary packages.
from picamera.array import PiRGBArray
from picamera import PiCamera
import cv2
from videocapture import *
from videosender import *


# Global variables.
CURRENT_IMAGE = []
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
thread_capture = videocapture(camera, WIDTH, HEIGHT)
thread_1 = videosender(SERVER_ADDR, 5006)
thread_2 = videosender(SERVER_ADDR, 5007)
thread_3 = videosender(SERVER_ADDR, 5008)

# Lancement des threads.
thread_capture.start()
thread_1.start()
thread_2.start()
thread_3.start()
time.sleep(1) # Warmup des threads.

# Attend que les threads se terminent.
thread_capture.join()
thread_1.join()
thread_2.join()
thread_3.join()
cv2.destroyAllWindows()
