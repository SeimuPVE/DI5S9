from multiprocessing import Process


class MultiProcessingExample:
    def calcul(self):
        n = 1E7
        while n > 0:
            n -= 1

    def start(self):
        p = Process(target=self.calcul)
        p.start()
        p.join()
