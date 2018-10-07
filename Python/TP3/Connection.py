from tkinter import *
import hashlib


class Connection:
    window = 0
    name = Entry()
    password = Entry()
    passfile = ""

    def connect(self):
        file = open(self.passfile, "r")
        for line in file:
            if(line.split(":")[0] == self.name.get()):
                salt_password = self.name.get() + self.password.get() + self.name.get() + "t'esbiensaléhein ?"
                if(line.split(":")[1][0:-1] == hashlib.sha512(salt_password.encode()).hexdigest()):
                    print("Wouhouuu !")
                    return 0
                else:
                    print("Mauvais mot de passe...")
                    return 0
        print("Tu sais que t'existe pas ? Jt'ai cassé !!")

    def __init__(self, passfile):
        self.window = Tk()

        label_pseudo = Label(self.window, text="Pseudo :")
        label_pseudo.grid(row=0, column=0)

        label_password = Label(self.window, text="Password")
        label_password.grid(row=1, column=0)

        self.name = Entry(self.window)
        self.name.grid(row=0, column=1)
        self.password = Entry(self.window, show="*")
        self.password.grid(row=1, column=1)

        b = Button(self.window, text="Connect", command=self.connect)
        b.grid(row=2, column=0, columnspan=2)

        self.passfile = passfile

        self.window.mainloop()
