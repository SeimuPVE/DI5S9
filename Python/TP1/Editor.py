class Editor:
    filename = ""

    def __init__(self) -> None:
        super().__init__()

    def menu(self):
        choice = 0
        while(choice != 9):
            while((choice < 1 or choice > 4) and choice != 9):
                print("*------------ Menu ------------*")
                print("1. Choisir un nom de fichier")
                print("2. Ajouter un texte")
                print("3. Afficher le fichier complet")
                print("4. Vider le fichier")
                print("9. Quitter le programme")
                choice = int(input("Choix : "))
            if(choice == 1):
                self.choose_filename()
            elif(choice == 2):
                self.add_text()
            elif(choice == 3):
                self.print_file()
            elif(choice == 4):
                self.empty_file()
            if(choice != 9):
                choice = 0

    def choose_filename(self):
        self.filename = input("Veuillez entrer le nom du fichier : ")

    def add_text(self):
        if(self.filename == ""):
            print("Merci d'entrer un nom de fichier.")
        else:
            text_to_add = input("Entrez le texte à ajouter : ")
            file = open(self.filename, 'a')
            file.write(text_to_add)
            file.close()

    def print_file(self):
        if(self.filename == ""):
            print("Merci d'entrer un nom de fichier.")
        else:
            with open(self.filename, 'r') as file:
                print((file.read()))

    def empty_file(self):
        if(self.filename == ""):
            print("Merci d'entrer un nom de fichier.")
        else:
            open(self.filename, 'w').close()
