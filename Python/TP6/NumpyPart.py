import numpy as np


def tableau():
    x = np.random.rand(4, 3, 2)

    nd = np.ndim(x)
    sh = np.shape(x)
    si = np.size(x)
    # dt = np.dtype(x)

    print("\n", "dimension :", nd, "\n", "shape: ", sh, "\n", "size :", si, "\n")
    print("Tableau :\n", x)


m1 = np.random.randint(9, size=(3, 3))
print("Matrice 1 : \n ", m1)

m2 = np.random.random_integers(2, 10, size=(3, 3))
print("Matrice 2 : \n ", m2)

prod = np.dot(m1, m2)
print("Produit M1M2 : \n ", prod)

trans = m1.transpose()
print("Transposé de la M1 : \n ", trans)

detM1 = np.linalg.det(m1)
print("Determinant de M1 : \n ", detM1)

invM1 = np.linalg.inv(m1)
print("Inverse de M1 : \n ", invM1)

solvM1M2 = np.linalg.solve(m1, m2)
print("Résolution du systeme M1M2 : \n ", solvM1M2)

valVectProprM1 = np.linalg.eig(m1)
print("Vecteurs propres M1 : \n ", valVectProprM1)