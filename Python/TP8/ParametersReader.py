class ParametersReader:
    file = ""

    def __init__(self, filepath):
        self.file = open(filepath, 'r')

    def readNext(self, value):
        print("TODO.")
