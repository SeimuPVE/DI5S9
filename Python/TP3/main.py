from Subscription import *
from Connection import *
import os.path


passfile = "pass.txt"

if(os.path.exists(passfile)):
    connection = Connection(passfile)
else:
    subscription = Subscription(passfile)
