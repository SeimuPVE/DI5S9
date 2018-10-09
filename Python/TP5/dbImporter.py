import sqlite3


class dbImporter:
    conn = ""

    def __init__(self):
        self.conn = sqlite3.connect('tp5.db')

    def readCommunes(self, filename):
        # Create table.
        cursor = self.conn.cursor()
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
        self.conn.commit()
        # Read CSV and insert data into the DB.
        with open(filename, 'rb') as file:
            communes = file.read().split(b'\r\n')
            for commune in communes:
                print(commune)
                if(commune[0] >= 0 and commune[0] <= 9):
                    commune = commune.split(";")
                    data = {
                        "codeRegion": int(commune[0].decode("utf-8")),
                        "nomRegion": commune[1].decode("utf-8"),
                        "codeDepartement": int(commune[2].decode("utf-8")),
                        "codeArrondissement": int(commune[3].decode("utf-8")),
                        "codeCanton": int(commune[4].decode("utf-8")),
                        "codeCommune": int(commune[5].decode("utf-8")),
                        "nomCommune": commune[6].decode("utf-8"),
                        "populationMunicipale": int(commune[7].decode("utf-8")),
                        "populationCompteeAPart": int(commune[8].decode("utf-8")),
                        "populationTotale": int(commune[9].decode("utf-8"))
                    }
                    cursor.execute("""
                    INSERT INTO communes(   codeRegion,
                                            nomRegion,
                                            codeDepartement,
                                            codeArrondissement,
                                            codeCanton,
                                            codeCommune,
                                            populationMunicipale,
                                            populationCompteeAPart,
                                            populationTotale)
                    VALUES( :codeRegion,
                            :nomRegion,
                            :codeDepartement,
                            :codeArrondissement,
                            :codeCanton,
                            :codeCommune,
                            :populationMunicipale,
                            :populationCompteeAPart,
                            :populationTotale)
                    """, data)
