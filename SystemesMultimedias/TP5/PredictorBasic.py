from utils import *


class PredictorBasic:
    USER_COUNT = 943
    MOVIE_COUNT = 1682
    VOTE_COUNT = 100000

    def __init__(self, fileParam):
        self.file = fileParam
        self.data = readdata(fileParam, self.USER_COUNT, self.MOVIE_COUNT)

    def compute(self):
        r = average_score(self.file)
        vu = np.full(self.USER_COUNT, self.MOVIE_COUNT)
        vi = np.full(self.MOVIE_COUNT, self.USER_COUNT)
        bu = (np.sum(np.sum(self.data, axis=1)) / vu) - r
        bi = (np.sum(np.sum(self.data, axis=0)) / vi) - r

        rui = []
        for x in range(self.USER_COUNT):
            rui.append(r + bu[x] + bi)
        rui = np.asarray(rui)
        RMSE = rmse(self.VOTE_COUNT, self.data, rui)
        print("Basic predictor RMSE : ", RMSE)  # TODO : It doesn't work, correct it.
