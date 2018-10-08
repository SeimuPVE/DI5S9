from Etudiant import *


class EtudiantReader:
    etudiants = []

    def readEtudiants(self, filename):
        with open(filename, 'r') as file:
            etu_info = file.read().split(";")
            self.etudiants.append(Etudiant(etu_info[0], etu_info[1], etu_info[2]))

    def __str__(self) -> str:
        output = ""
        for e in self.etudiants:
            output += str(e) + "\n"
