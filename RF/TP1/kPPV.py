""" Programme à compléter du kPPV. """
import csv
import math


nbExParClasse = 50
nbApprent = 25
nbCaract = 4
nbClasse = 3


# Lis le fichier CSV.
def lecture_fichier_csv():
    with open("iris.data", 'r') as fic:
        lines = csv.reader(fic)
        dataset = list(lines)
    # print(dataset[0], len(data_set))
    for i in range(len(dataset)):
        for j in range(nbCaract):
            dataset[i][j] = float(dataset[i][j])
    # print(dataset[0])
    return dataset


# Retourne les distances entre data et la partie apprentissage de dataset.
def calcul_distances(data, dataset):
    distances = []
    # Exemples de la base d'apprentissage.
    for i in range(nbClasse):
        for j in range(nbApprent):
            distance = 0
            for k in range(0, nbCaract):
                distance += math.pow(data[k] - dataset[i * nbExParClasse + j][k], 2)
            distances.append(math.sqrt(distance))
    return distances


# Retourne le numéro de la classe déterminé à partir des distances.
def calcul_classe(distances):
    distance_min = 99999
    classe = -1
    for i in range(nbClasse):
        for j in range(nbApprent):
            if distances[nbApprent * i + j] < distance_min:
                distance_min = distances[nbApprent * i + j]
                classe = i
    return classe


def nom_classe(indice_classe):
    return dataset[indice_classe * nbExParClasse][4]


if __name__ == "__main__":
    print("Début programme kPPV")
    dataset = lecture_fichier_csv()

    # Initialisation de la matrice de confusion.
    matrice_confusion = [[]]*nbClasse
    for i in range(nbClasse):
        matrice_confusion[i] = [0]*nbClasse

    # Test.
    for i in range(nbClasse):
        for j in range(nbExParClasse - nbApprent):
            matrice_confusion[i][calcul_classe(calcul_distances(dataset[nbExParClasse * i + j + nbApprent], dataset))] += 1

    print(matrice_confusion)

    # Taux de reconnaissance.
    taux_reco = 0
    for i in range(nbClasse):
        taux_reco += matrice_confusion[i][i]
    taux_reco /= nbClasse * (nbExParClasse - nbApprent)

    print(taux_reco)
