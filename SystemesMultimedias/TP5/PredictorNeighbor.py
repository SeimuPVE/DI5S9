class PredictorNeighbor:
    def __init__(self, L = 10):
        self.data = read_data("ml-100k/u.data", USER_COUNT, MOVIE_COUNT)
        self.L = L
        pass  # TODO.
