from Etudiant import *


class EtudiantReader:
    etudiants = []

    def __init__(self, filename) -> None:
        self.readEtudiants(filename)

    def readEtudiants(self, filename):
        lines = open(filename, 'r').readlines()
        for line in lines:
            etu_info = line.split(";")
            self.etudiants.append(Etudiant(etu_info[0], etu_info[1], etu_info[2]))

    def __str__(self) -> str:
        output = ""
        for e in self.etudiants:
            output += str(e) + "\n"
        return output
