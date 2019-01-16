from utils import *


class PredictorRandom:
    USER_COUNT = 943
    MOVIE_COUNT = 1682
    VOTE_COUNT = 100000

    def __init__(self, file):
        self.data = readdata(file, self.USER_COUNT, self.MOVIE_COUNT)

    def compute(self):
        scorealea = 1 + (np.random.random() * 4)
        RMSE = rmse(self.VOTE_COUNT, self.data, scorealea)
        print("Random predictor RMSE :", RMSE)
