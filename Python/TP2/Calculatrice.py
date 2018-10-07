#!/usr/bin/python
# -*-coding: utf-8 -*-

from tkinter import *


class Calculatrice:
    window = Tk()
    label = Label(window, text="0")

    calcul = ""


    def AC_function(self):
        self.calcul = ""
        self.label.config(text=0)

    def C_function(self):
        self.calcul = self.calcul[:-1]
        self.label.config(text=self.calcul)

    def number_function(self, number):
        self.calcul += str(number)
        self.label.config(text=self.calcul)

    def plus_function(self):
        self.calcul += "+"
        self.label.config(text=self.calcul)

    def minus_function(self):
        self.calcul += "-"
        self.label.config(text=self.calcul)

    def multiply_function(self):
        self.calcul += "*"
        self.label.config(text=self.calcul)

    def divide_function(self):
        self.calcul += "/"
        self.label.config(text=self.calcul)

    def equal_function(self):
        try:
            self.calcul = str(eval(self.calcul))
            self.label.config(text=self.calcul)
        except ZeroDivisionError:
            self.label.config(text="ERROR, division by zero impossible.")
            self.calcul = ""
        except SyntaxError:
            self.label.config(text="Syntax error.")
            self.calcul = ""


    def __init__(self):
        self.label.grid(row=0, column=0, columnspan=4)

        b = Button(self.window, text="AC", command=self.AC_function, width=16, height=2)
        b.grid(row=1, column=0, columnspan=2)

        b = Button(self.window, text="C", command=self.C_function, width=16, height=2)
        b.grid(row=1, column=2, columnspan=2)

        #buttons = ["7", "8", "9", "4", "5", "6", "1", "2", "3", "0"]
        #row = 2
        #column = 0
        #for button_text in buttons:
        #    b = Button(window, text=button_text, command=lambda: number_function(button_text), width=6, height=2)
        #    b.grid(row=row, column=column)
        #    if column == 2:
        #        column = 0
        #        row = row + 1
        #    else:
        #        column = column + 1


        b = Button(self.window, text=7, command=lambda: self.number_function(7), width=6, height=2)
        b.grid(row=2, column=0)

        b = Button(self.window, text=8, command=lambda: self.number_function(8), width=6, height=2)
        b.grid(row=2, column=1)

        b = Button(self.window, text=9, command=lambda: self.number_function(9), width=6, height=2)
        b.grid(row=2, column=2)

        b = Button(self.window, text=4, command=lambda: self.number_function(4), width=6, height=2)
        b.grid(row=3, column=0)

        b = Button(self.window, text=5, command=lambda: self.number_function(5), width=6, height=2)
        b.grid(row=3, column=1)

        b = Button(self.window, text=6, command=lambda: self.number_function(6), width=6, height=2)
        b.grid(row=3, column=2)

        b = Button(self.window, text=1, command=lambda: self.number_function(1), width=6, height=2)
        b.grid(row=4, column=0)

        b = Button(self.window, text=2, command=lambda: self.number_function(2), width=6, height=2)
        b.grid(row=4, column=1)

        b = Button(self.window, text=3, command=lambda: self.number_function(3), width=6, height=2)
        b.grid(row=4, column=2)

        b = Button(self.window, text=0, command=lambda: self.number_function(0), width=6, height=2)
        b.grid(row=5, column=0)


        b = Button(self.window, text="+", command=self.plus_function, width=6, height=2)
        b.grid(row=2, column=3)

        b = Button(self.window, text="-", command=self.minus_function, width=6, height=2)
        b.grid(row=3, column=3)

        b = Button(self.window, text="*", command=self.multiply_function, width=6, height=2)
        b.grid(row=4, column=3)

        b = Button(self.window, text="/", command=self.divide_function, width=6, height=2)
        b.grid(row=5, column=3)

        b = Button(self.window, text="=", command=self.equal_function, width=16, height=2)
        b.grid(row=5, column=1, columnspan=2)

        self.window.mainloop()
