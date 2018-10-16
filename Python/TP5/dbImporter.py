import sqlite3


class dbImporter:
    db = ""

    def __init__(self):
        self.db = sqlite3.connect('tp5.db')

    def readCommunes(self, filename):
        # Create table.
        cursor = self.db.cursor()
        cursor.execute("""
        CREATE TABLE IF NOT EXISTS communes(
             id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE,
             codeRegion INTEGER,
             nomRegion VARCHAR,
             codeDepartement VARCHAR,
             codeArrondissement INTEGER,
             codeCanton INTEGER,
             codeCommune INTEGER,
             nomCommune VARCHAR,
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
                    if(int(commune[0]) >= 0 and int(commune[0]) <= 99):
                        for i in [2, 3, 4, 5, 7, 8, 9]:
                            if " " in commune[i]:
                                commune[i] = commune[i].replace(' ', '')
                        data = {
                            "codeRegion": int(commune[0]),
                            "nomRegion": commune[1],
                            "codeDepartement": commune[2],
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
                except Exception as e:
                    pass
            self.db.commit()

    def readDepartements(self, filename):
        # Create table.
        cursor = self.db.cursor()
        cursor.execute("""
        CREATE TABLE IF NOT EXISTS departements(
             id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE,
             codeRegion INTEGER,
             nomRegion VARCHAR,
             codeDepartement VARCHAR,
             nomDepartement VARCHAR,
             nombreArrondissements INTEGER,
             nombreCantons INTEGER,
             nombreCommunes INTEGER,
             populationMunicipale INTEGER,
             populationTotale INTEGER
        )
        """)
        self.db.commit()
        # Read CSV and insert data into the DB.
        with open(filename, 'rb') as file:
            for departement in file.readlines():
                departement = departement.decode("Windows-1252")
                departement = departement.split(";")
                try:
                    if(int(departement[0]) >= 0 and int(departement[0]) <= 99):
                        for i in [0, 4, 5, 6, 7, 8, 9]:
                            if " " in departement[i]:
                                departement[i] = departement[i].replace(' ', '')
                        data = {
                            "codeRegion": int(departement[0]),
                            "nomRegion": departement[1],
                            "codeDepartement": departement[2],
                            "nomDepartement": departement[3],
                            "nombreArrondissements": int(departement[4]),
                            "nombreCantons": int(departement[5]),
                            "nombreCommunes": int(departement[6]),
                            "populationMunicipale": int(departement[7]),
                            "populationTotale": int(departement[8]),
                        }
                        cursor.execute("""
                        INSERT INTO departements(   codeRegion,
                                                    nomRegion,
                                                    codeDepartement,
                                                    nomDepartement,
                                                    nombreArrondissements,
                                                    nombreCantons,
                                                    nombreCommunes,
                                                    populationMunicipale,
                                                    populationTotale)
                        VALUES( :codeRegion,
                                :nomRegion,
                                :codeDepartement,
                                :nomDepartement,
                                :nombreArrondissements,
                                :nombreCantons,
                                :nombreCommunes,
                                :populationMunicipale,
                                :populationTotale)
                        """, data)
                except Exception as e:
                    pass
            self.db.commit()

    def readRegions(self, filename):
        # Create table.
        cursor = self.db.cursor()
        cursor.execute("""
        CREATE TABLE IF NOT EXISTS regions(
             id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE,
             codeRegion INTEGER,
             nomRegion VARCHAR,
             nombreArrondissements INTEGER,
             nombreCantons INTEGER,
             nombreCommunes INTEGER,
             populationMunicipale INTEGER,
             populationTotale INTEGER
        )
        """)
        self.db.commit()
        # Read CSV and insert data into the DB.
        with open(filename, 'rb') as file:
            for region in file.readlines():
                region = region.decode("Windows-1252")
                region = region.split(";")
                try:
                    if(int(region[0]) >= 0 and int(region[0]) <= 99):
                        for i in [0, 2, 3, 4, 5, 6]:
                            if " " in region[i]:
                                region[i] = region[i].replace(' ', '')
                        data = {
                            "codeRegion": int(region[0]),
                            "nomRegion": region[1],
                            "nombreArrondissements": int(region[2]),
                            "nombreCantons": int(region[3]),
                            "nombreCommunes": int(region[4]),
                            "populationMunicipale": int(region[5]),
                            "populationTotale": int(region[6])
                        }
                        cursor.execute("""
                        INSERT INTO regions (   codeRegion,
                                                nomRegion,
                                                nombreArrondissements,
                                                nombreCantons,
                                                nombreCommunes,
                                                populationMunicipale,
                                                populationTotale)
                        VALUES( :codeRegion,
                                :nomRegion,
                                :nombreArrondissements,
                                :nombreCantons,
                                :nombreCommunes,
                                :populationMunicipale,
                                :populationTotale)
                        """, data)
                except Exception as e:
                    pass
            self.db.commit()
