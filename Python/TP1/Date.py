class Date:
    jour = 0
    mois = 0
    annee = 0

    def __init__(self, jour, mois, annee):
        self.jour = jour
        self.mois = mois
        self.annee = annee

    def __init__(self, str_date):
        self.jour = str_date.split('/', 0)
        self.mois = str_date.split('/', 1)
        self.annee = str_date.split('/', 2)

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
