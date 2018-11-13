class Date:
    jour = 0
    mois = 0
    annee = 0

    def __init__(self, *args):
        if(len(args) == 3):
            self.jour = args[0]
            self.mois = args[1]
            self.annee = args[2]
        elif(1):
            self.jour = args[0].split('/', 0)
            self.mois = args[0].split('/', 1)
            self.annee = args[0].split('/', 2)
        else:
            raise Exception
#            print("TODO : exception.")

    def __eq__(self, o: object):
        if(self.jour == o.jour and self.mois == o.mois and self.annee == o.annee):
            return True
        return False

    def __lt__(self, other) -> bool:
        if(self.annee < other.annee):
            return True
        elif(self.annee == other.annee):
            if(self.mois < other.mois):
                return True
            elif(self.mois == other.mois):
                if(self.jour < other.jour):
                    return True
        return False

    def __str__(self):
        return self.jour + '/' + self.mois + '/' + self.annee
