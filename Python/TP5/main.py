from dbImporter import *

dbImporter = dbImporter()
dbImporter.readCommunes("bdd/communes.csv")

conn = sqlite3.connect('tp5.db')

cursor = conn.cursor()

cursor.execute("""SELECT * FROM communes""")
commune1 = cursor.fetchone()
print(commune1)
