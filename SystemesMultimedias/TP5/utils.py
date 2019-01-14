import numpy as np


def read_data(file, nbuser, nbfilm):
    res = np.full((nbuser, nbfilm), -1)
    fichier = open(file, 'rU')
    lignes = fichier.readlines()
    for line in lignes:
        # print(line)
        lineSplit = line.split("\t")
        userid = int(lineSplit[0])-1
        filmid = int(lineSplit[1])-1
        score = int(lineSplit[2])
        # print(str(userid)+" "+str(filmid)+" "+str(score))
        res[userid, filmid] = score
    return res

def compute_vote_count(matrice, nbuser, nbfilm):
    nbvote = 0
    for i in range(0, nbuser):
        for j in range(0, nbfilm):
            val = matrice[i, j]
            if val != -1:
                nbvote = nbvote+1
    return nbvote

def compute_rmse(vote_count, rui, ruip):
    tmp = rui - ruip
    tmp = np.square(tmp)
    tmp = np.sum(tmp)
    return np.sqrt(tmp / vote_count)

def sort_keep_index(vec):
    res = sorted(enumerate(vec), key=lambda x: x[1])
    res.reverse()
    return res
