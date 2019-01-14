class PredictorBasic:
    def __init__(self):
        self.data = read_data("ml-100k/u.data", USER_COUNT, MOVIE_COUNT)

    def compute(self):
        mean = np.mean(self.data)
        Vu = np.full((USER_COUNT), MOVIE_COUNT)
        Vi = np.full((MOVIE_COUNT), USER_COUNT)
        bu = (np.sum(self.data, axis=1) / Vu) - mean
        bi = (np.sum(self.data, axis=0) / Vi) - mean
        rui = mean + bu + bi  # TODO : non fonctionnel
        RMSE = compute_rmse(VOTE_COUNT, self.data, rui)
        print("RMSE : ", RMSE)
