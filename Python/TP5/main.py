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

print("Question 3 : TODO")
cursor.execute("""SELECT DISTINCT nomCommune, codeDepartement FROM communes c1 WHERE EXISTS (SELECT * FROM communes c2 WHERE c1.nomCommune <> c2.nomCommune)""")
for doublon in cursor.fetchall():
    print(doublon)
