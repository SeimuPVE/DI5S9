from multiprocessing import Process


class Fourmi:
    canvas = 0
    colorR = 0 # 0-255
    colorV = 0 # 0-255
    colorB = 0 # 0-255
    followR = 0
    followV = 0
    followB = 0
    probaG = 0 # G+D+T = 1
    probaD = 0
    probaT = 0
    doorDd = 0
    Ps = 0
    numberIt = 0
    numberItDone = 0

    def __init__(self, canvas, colorR, colorV, colorB, followR, followV, followB, probaG, probaD, probaT, doorDd, Ps, numberIt, numberItDone):
        self.canvas = canvas
        self.colorR = colorR
        self.colorV = colorV
        self.colorB = colorB
        self.followR = followR
        self.followV = followV
        self.followB = followB
        self.probaG = probaG
        self.probaD = probaD
        self.probaT = probaT
        self.doorDd = doorDd
        self.ps = Ps
        self.numberIt = numberIt
        self.numberItDone = numberItDone

    def step(self):
        self.numberItDone += 1

    def start(self):
        p = Process(target=self.step)
        p.start()
        p.join()
