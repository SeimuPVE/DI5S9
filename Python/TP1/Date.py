class Date:
    jour = 0
    mois = 0
    annee = 0

    def __init__(self, *args):
        if(len(args) == 3):
            self.jour = int(args[0])
            self.mois = int(args[1])
            self.annee = int(args[2])
        elif(len(args) == 1):
            date = args[0].split('\n')[0]
            self.jour = int(date.split('/')[0])
            self.mois = int(date.split('/')[1])
            self.annee = int(date.split('/')[2])
        else:
            raise Exception("Date not valid.")
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
        return str(self.jour) + '/' + str(self.mois) + '/' + str(self.annee)
