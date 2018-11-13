from threading import Thread


class MultiThreadingExample(Thread):
    def __init__(self):
        Thread.__init__(self)

    def run(self):
        n = 1E7
        while n > 0:
            n -= 1
