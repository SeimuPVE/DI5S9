import sqlite3


def XMLWrite(filepath, title, tabNames, tabValues):
    file = open(filepath, 'a')
    file.write("<title>" + title + "</title>" + "\n")
    for value in tabValues:
        for i in range(len(tabNames)):
            file.write("    <" + tabNames[i] + ">" + str(value[i]) + "</" + tabNames[i] + ">" + "\n")
        file.write("\n")

# IMPORTANT : doesn't work, don't use it.
def XMLRead(filepath):
    file = open(filepath, 'r')
    number_of_titles = 0
    number_of_tabs = 0
    number_of_values = 0
    titles = []
    values = []

    # Read XML.
    for line in file.readlines():
        if(line.startswith("<title>")):
            titles.append(line.split("<title>")[1].split("</title>")[0])
            values.append([])
            number_of_titles = number_of_titles + 1
            number_of_tabs = 0
        elif(line.startswith("    <")):
            values[number_of_titles - 1].append([[]])
            values[number_of_titles - 1][number_of_tabs].append(line.split(">")[1].split("<")[0])
            number_of_tabs = number_of_tabs + 1

    # Insert into DB.
    db = sqlite3.connect('tp5.db.fromXML')
    cursor = db.cursor()

    # Add communes.
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
    db.commit()
    for i in range(len(values[0])):
        data = {
            "codeRegion": int(values[0][i][0]),
            "nomRegion": values[0][i][1],
            "codeDepartement": values[0][i][2],
            "codeArrondissement": int(values[0][i][3]),
            "codeCanton": int(values[0][i][4]),
            "codeCommune": int(values[0][i][5]),
            "nomCommune": values[0][i][6],
            "populationMunicipale": int(values[0][i][7]),
            "populationCompteeAPart": int(values[0][i][8]),
            "populationTotale": int(values[0][i][9])
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
    db.commit()

    # Add departements.
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
    db.commit()
    for i in range(len(values[1])):
        data = {
            "codeRegion": int(values[1][i][0]),
            "nomRegion": values[1][i][1],
            "codeDepartement": values[1][i][2],
            "nomDepartement": values[1][i][3],
            "nombreArrondissements": int(values[1][i][4]),
            "nombreCantons": int(values[1][i][5]),
            "nombreCommunes": int(values[1][i][6]),
            "populationMunicipale": int(values[1][i][7]),
            "populationTotale": int(values[1][i][8]),
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
    db.commit()

    # Add Departements.
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
    db.commit()
    for i in range(values[2]):
        data = {
            "codevalues[2][i]": int(values[2][i][0]),
            "nomRegion": values[2][i][1],
            "nombreArrondissements": int(values[2][i][2]),
            "nombreCantons": int(values[2][i][3]),
            "nombreCommunes": int(values[2][i][4]),
            "populationMunicipale": int(values[2][i][5]),
            "populationTotale": int(values[2][i][6])
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
    db.commit()
