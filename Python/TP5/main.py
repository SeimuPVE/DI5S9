from dbImporter import *


dbImporter = dbImporter()
dbImporter.readCommunes("bdd/communes.csv")

db = sqlite3.connect('tp5.db')
cursor = db.cursor()
cursor.execute("""SELECT * FROM communes""")

for commune in cursor.fetchall():
    print(commune)
