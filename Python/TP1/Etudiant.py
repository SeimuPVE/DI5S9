from Date import *

class Etudiant:
    nom = ""
    prenom = ""
    address = ""
    age = 0
    date_naissance = Date(0, 0, 0)

    def __init__(self, nom, prenom, date_naissance):
        self.nom = nom
        self.prenom = prenom
        self.date = Date(date_naissance)
        self.adresslec()

    def adresslec(self):
        adress = self.nom + '.' + self.prenom + "@etu.univ-tours.fr"

    def makeAge(self):
        print("makeAge TODO.")

    def __str__(self) -> str:
        return self.prenom + self.nom + " a " + str(self.age) + " ans et son adresse mail est : " + self.address
