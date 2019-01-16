import numpy as np


def readdata(fileParam, nbuser, nbfilm):
    res = np.full((nbuser, nbfilm), -1)
    res = res * -1
    file = open(fileParam, 'rU')
    lines = file.readlines()
    for line in lines:
        lineSplit = line.split("\t")
        userid = int(lineSplit[0]) - 1
        filmid = int(lineSplit[1]) - 1
        score = int(lineSplit[2])
        res[userid, filmid] = score
    return res


def rmse(C, rui, rui2):
    return np.sqrt(np.sum(np.square(rui - rui2)) / C)


def average_score(fileParam):
    score = 0
    nb_lines = 0
    file = open(fileParam, 'rU')
    lines = file.readlines()
    for line in lines:
        lineSplit = line.split("\t")
        score += int(lineSplit[2])
        nb_lines += 1
    return score / nb_lines


def computenbvote(matrice, nbuser, nbfilm):
    nbvote = 0
    for i in range(0, nbuser):
        for j in range(0, nbfilm):
            val = matrice[i, j]
            if val != -1:
                nbvote = nbvote + 1
    return nbvote
