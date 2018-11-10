import hashlib
import os.path
import base64
import getpass
from Crypto.Cipher import AES


class UserCrypto:
    passfile = "pass.txt"
    username = "admin"
    password = ""
    salt = "t'esbiensaléhein ?"
    is_connected = False

    def __init__(self, passfile):
        self.passfile = passfile
        if(self.userExists()):
            username = input("Username : ")
            password = getpass.getpass("Password : ")
            self.connect(username, password)
        else:
            username = input("Please, enter a new username : ")
            password = getpass.getpass("Password : ")
            password_confirmer = getpass.getpass("Please, confirm the password : ")
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
            self.password = hashlib.sha512(salt_password.encode()).hexdigest()
            passfile.write(username + ":" + self.password + '\n')
            self.is_connected = True
            return self.is_connected

    def connect(self, username, password):
        file = open(self.passfile, "r")
        for line in file:
            if(line.split(":")[0] == username):
                salt_password = username + password + username + self.salt
                self.password = hashlib.sha512(salt_password.encode()).hexdigest()
                if (line.split(":")[1][0:-1] == self.password):
                    print("Connecté !")
                    self.is_connected = True
                    return self.is_connected
                else:
                    print("Mauvais mot de passe...")
                    self.is_connected = False
                    return self.is_connected
        print("Cet utilisateur n'existe pas.")
        return False

    def encryptFile(self, filepath):
        file = open(filepath, "rb")
        data = b""
        lines = file.readlines()
        for line in lines:
            data = data + line + b"\n"

        cipher = AES.new(base64.b64decode(self.password)[:16], AES.MODE_EAX)
        ciphertext, tag = cipher.encrypt_and_digest(data)

        file_out = open(filepath + ".encrypted", "wb")
        [file_out.write(x) for x in (cipher.nonce, tag, ciphertext)]

        file.close()
        file_out.close()

    def uncryptFile(self, filepath):
        file_in = open(filepath, "rb")
        file_out = open(filepath.split(".encrypted")[0], "wb")

        nonce, tag, ciphertext = [file_in.read(x) for x in (16, 16, -1)]
        cipher = AES.new(base64.b64decode(self.password)[:16], AES.MODE_EAX, nonce)

        data = cipher.decrypt_and_verify(ciphertext, tag)
        data = data.split(b"\n")
        [file_out.write(x) for x in data]

        file_in.close()
        file_out.close()
