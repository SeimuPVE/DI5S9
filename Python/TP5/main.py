from dbImporter import *


dbImporter = dbImporter()
#dbImporter.readCommunes("bdd/communes.csv")
#dbImporter.readDepartements("bdd/departements.csv")
#dbImporter.readRegions("bdd/regions.csv")
print("Question 1 : database up !")

db = sqlite3.connect('tp5.db')
cursor = db.cursor()

print("Question 2 :")
print("Population totale des communes :")
cursor.execute("""SELECT nomCommune, populationTotale FROM communes""")
for commune in cursor.fetchall():
    print(commune)

print("Population totale des régions :")
cursor.execute("""SELECT nomRegion, populationTotale FROM regions""")
for region in cursor.fetchall():
    print(region)

# SELECT communes.nom, GROUP_CONCAT(departements.code)
# FROM communes
# INNER JOIN departements ON communes.departements = departements.code
# GROUP BY communes.nom
# HAVING COUNT(*) > 1
# ORGER BY COUNT(*)
print("Question 3 : TODO")
cursor.execute( """
                SELECT communes.nomCommune, GROUP_CONCAT(departements.codeDepartement)
                FROM communes
                INNER JOIN departements ON communes.codeDepartement = departements.codeDepartement
                GROUP BY communes.nomCommune
                HAVING COUNT(*) > 1
                ORGER BY COUNT(*)
                """)
for doublon in cursor.fetchall():
    print(doublon)
