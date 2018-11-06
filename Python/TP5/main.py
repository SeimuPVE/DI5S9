from dbWorker import *
from XMLParser import *


# Question 1 ################################################################
dbWorker = dbWorker()
# TODO : mettre une condition pour vérifier si la BDD existe déjà et décommenter les lignes suivantes en conséquence.
#dbImporter.readCommunes("bdd/communes.csv")
#dbImporter.readDepartements("bdd/departements.csv")
#dbImporter.readRegions("bdd/regions.csv")
print("Question 1 : database up !")


# Init ######################################################################
db = sqlite3.connect('tp5.db')
cursor = db.cursor()


# Question 2 ################################################################
print("Question 2, population totale des communes :")
cursor.execute("""SELECT nomCommune, populationTotale FROM communes""")
for commune in cursor.fetchall():
    print(commune)

print("Question 2, population totale des régions :")
cursor.execute("""SELECT nomRegion, populationTotale FROM regions""")
for region in cursor.fetchall():
    print("Dans la région \"" + region[0] + "\" il y a " + str(region[1]) + " habitants.")


# Question 3 ################################################################
print("Question 3 :")
cursor.execute( """
                SELECT communes.nomCommune, GROUP_CONCAT(departements.codeDepartement)
                FROM communes
                INNER JOIN departements ON communes.codeDepartement = departements.codeDepartement
                GROUP BY communes.nomCommune
                HAVING COUNT(*) > 1
                ORDER BY COUNT(*)
                """)
for doublon in cursor.fetchall():
    print(doublon[0] + " existe dans les départements suivants : " + doublon[1])


# Question 4 ################################################################
print("Question 4 :")
dbWorker.writeIntoXML('db.xml')
print("Exportation to XML done.")
