class PredictorRandom:
    def __init__(self):
        self.data = read_data("ml-100k/u.data", USER_COUNT, MOVIE_COUNT)

    def compute(self):
        RMSE = compute_rmse(VOTE_COUNT, self.data, np.random.rand(DATA.shape[0], DATA.shape[1]) * 5)
        print("RMSE : ", RMSE)
