from tkinter import *
import hashlib


class Subscription:
    window = 0
    name = Entry()
    password = Entry()
    password_confirm = Entry()
    filepath = ""

    def subscribe(self):
        if(self.password.get() == self.password_confirm.get()):
            passfile = open(self.filepath, "w")
            salt_password = self.name.get() + self.password.get() + self.name.get() + "t'esbiensaléhein ?"
            passfile.write(self.name.get() + ":" + hashlib.sha512(salt_password.encode()).hexdigest() + '\n')

    def __init__(self, filepath):
        self.window = Tk()

        label_pseudo = Label(self.window, text="Pseudo :")
        label_pseudo.grid(row=0, column=0)

        label_password = Label(self.window, text="Password")
        label_password.grid(row=1, column=0)

        label_password = Label(self.window, text="Confirm password")
        label_password.grid(row=2, column=0)

        self.name = Entry(self.window)
        self.name.grid(row=0, column=1)
        self.password = Entry(self.window, show="*")
        self.password.grid(row=1, column=1)
        self.password_confirm = Entry(self.window, show="*")
        self.password_confirm.grid(row=2, column=1)

        b = Button(self.window, text="Ok", command=self.subscribe)
        b.grid(row=3, column=0, columnspan=2)

        self.filepath = filepath

        self.window.mainloop()
