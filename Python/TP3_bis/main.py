from UserCrypto import *


user = UserCrypto("pass.txt")

if(user.is_connected):
    choice = -1
    while(choice != 0):
        print("Que souhaitez vous faire ?")
        print("[0] Quitter")
        print("[1] Chiffrer")
        print("[2] Déchiffrer")
        choice = int(input("Choix : "))
        print(choice)
        if(choice == 1):
            filepath = input("Indiquez le chemin de votre fichier : ")
            user.encryptFile(filepath)
            print("Fichier chiffré en AES256 disponible à l'adresse suivante : " + filepath + ".encrypted")
        elif(choice == 2):
            filepath = input("Indiquez le chemin de votre fichier : ")
            user.uncryptFile(filepath)
            print("Fichier déchiffré disponible à l'adresse suivante : " + filepath.split(".encrypted")[0])
        elif(choice != 0):
            print("Your choice doesn't exist.")
