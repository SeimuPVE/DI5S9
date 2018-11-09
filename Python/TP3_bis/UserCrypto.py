import hashlib
import os.path


# TODO : add exceptions.
# TODO : add assert and raise.
# TODO : crypt files with AES256 (PyCryptodome).
class UserCrypto:
    passfile = "pass.txt"
    username = "admin"
    password = "PLS_CHANGE_IT"
    salt = "t'esbiensaléhein ?"
    is_connected = False

    def __init__(self, passfile):
        self.passfile = passfile
        if(self.userExists()):
            username = input("Username : ")
            password = input("Password : ")
            self.connect(username, password)
        else:
            username = input("Please, enter a new username : ")
            password = input("Please, enter a new password : ")
            password_confirmer = input("Please, confirm the password : ")
            self.subscribe(username, password, password_confirmer)

    def userExists(self):
        if(os.path.exists(self.passfile)):
            return True
        else:
            return False

    def subscribe(self, username, password, password_confirm):
        if(password == password_confirm):
            passfile = open(self.passfile, "w")
            salt_password = username + password + username + self.salt
            passfile.write(username + ":" + hashlib.sha512(salt_password.encode()).hexdigest() + '\n')
            return True

    def connect(self, username, password):
        file = open(self.passfile, "r")
        for line in file:
            if(line.split(":")[0] == username):
                salt_password = username + password + username + self.salt
                if (line.split(":")[1][0:-1] == hashlib.sha512(salt_password.encode()).hexdigest()):
                    print("Wouhouuu !")
                    return True
                else:
                    print("Mauvais mot de passe...")
                    return False
        print("Tu sais que t'existe pas ? Jt'ai cassé !!")
        return False
