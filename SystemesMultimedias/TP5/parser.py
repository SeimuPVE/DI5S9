import numpy as np
from numpy import linalg


USER_COUNT = 943
MOVIE_COUNT = 1682
VOTE_COUNT = 100000


class PredictorLinearRegression:
    def __init__(self):
        self.data = read_data("ml-100k/u.data", USER_COUNT, MOVIE_COUNT)
        R_tild = np.zeros(())
        Fi = R_tild[:, i]
        Fj = R_tild[:, j]
        num = Fi.T.dot(Fj)
        denum = linalg.norm(Fi, 2) * linalg.norm(Fj, 2)
        
    def compute(self):
        pass  # TODO.

#class PredictorGradientDescent:
#    
#    def __init__(self, iter = 100, learning_rate = 0.1):
#        self.data = read_data("ml-100k/u.data", USER_COUNT, MOVIE_COUNT)
#        
#    def compute(self):
#        i = 0
#        for (i in range(iter)):
#            pass  # TODO.
        

PredictorBasic().compute()
