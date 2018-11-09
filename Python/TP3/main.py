from Subscription import *
from Connection import *
import os.path


passfile = "pass.txt"

# Simple program to use cryptography.
if(os.path.exists(passfile)):
    connection = Connection(passfile)
else:
    subscription = Subscription(passfile)
