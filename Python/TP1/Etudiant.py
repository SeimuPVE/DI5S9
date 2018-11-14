from datetime import date
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
        self.date_naissance = Date(date_naissance)
        self.addressmail()
        self.makeAge()

    def addressmail(self):
        self.address = self.nom.lower().replace(" ", "") + '.' + self.prenom.lower().replace(" ", "") + "@etu.univ-tours.fr"

    # TODO.
    def makeAge(self):
        today = date.today()
        self.age = today.year - self.date_naissance.annee
        if(self.date_naissance.mois == today.month):
            if(self.date_naissance.jour < today.day):
                self.age -= 1
        elif(self.date_naissance.mois < today.month):
                self.age -= 1

    def getNom(self):
        return self.nom

    def getPrenom(self):
        return self.prenom

    def getAddress(self):
        return self.address

    def getAge(self):
        return self.age

    def getDateNaissance(self):
        return self.date_naissance

    def __str__(self) -> str:
        return self.prenom[0] + self.prenom[1:].lower() + " " + self.nom[0] + self.nom[1:].lower() + " a " + str(self.age) + " ans et son adresse mail est : " + self.address
