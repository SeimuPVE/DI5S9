import sqlite3


class dbImporter:
    db = ""

    def __init__(self):
        self.db = sqlite3.connect('tp5.db')

    def readCommunes(self, filename):
        total_err = 0
        total_done = 0
        # Create table.
        cursor = self.db.cursor()
        cursor.execute("""
        CREATE TABLE IF NOT EXISTS communes(
             id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE,
             codeRegion INTEGER,
             nomRegion TEXT,
             codeDepartement INTEGER,
             codeArrondissement INTEGER,
             codeCanton INTEGER,
             codeCommune INTEGER,
             nomCommune TEXT,
             populationMunicipale INTEGER,
             populationCompteeAPart INTEGER,
             populationTotale INTEGER
        )
        """)
        self.db.commit()
        # Read CSV and insert data into the DB.
        with open(filename, 'rb') as file:
            for commune in file.readlines():
                commune = commune.decode("Windows-1252")
                commune = commune.split(";")
                try:
                    if(int(commune[0]) >= 0 and int(commune[0]) <= 9):
                        for i in [0, 2, 3, 4, 5, 7, 8, 9]:
                            if " " in commune[i]:
                                commune[i].replace(' ', '')
                        data = {
                            "codeRegion": int(commune[0]),
                            "nomRegion": commune[1],
                            "codeDepartement": int(commune[2]),
                            "codeArrondissement": int(commune[3]),
                            "codeCanton": int(commune[4]),
                            "codeCommune": int(commune[5]),
                            "nomCommune": commune[6],
                            "populationMunicipale": int(commune[7]),
                            "populationCompteeAPart": int(commune[8]),
                            "populationTotale": int(commune[9])
                        }
                        cursor.execute("""
                        INSERT INTO communes(   codeRegion,
                                                nomRegion,
                                                codeDepartement,
                                                codeArrondissement,
                                                codeCanton,
                                                codeCommune,
                                                nomCommune,
                                                populationMunicipale,
                                                populationCompteeAPart,
                                                populationTotale)
                        VALUES( :codeRegion,
                                :nomRegion,
                                :codeDepartement,
                                :codeArrondissement,
                                :codeCanton,
                                :codeCommune,
                                :nomCommune,
                                :populationMunicipale,
                                :populationCompteeAPart,
                                :populationTotale)
                        """, data)
                        self.db.commit()
                        total_done = total_done + 1
                except Exception as e:
                    print(e)
                    total_err = total_err + 1
                print("Total err : " + str(total_err))
                print("Total done : " + str(total_done))
