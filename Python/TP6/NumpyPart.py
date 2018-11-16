import numpy as np

# python -m pip install --user numpy scipy matplotlib ipython jupyter pandas sympy nose


def tableau():
    x = np.random.rand(4, 3, 2)

    nd = np.ndim(x)
    sh = np.shape(x)
    si = np.size(x)
    # dt = np.dtype(x)

    print("\n", "dimension :", nd, "\n", "shape: ", sh, "\n", "size :", si, "\n")
    print("Tableau :\n", x)


tableau()

m1 = np.array([[0., 1., 2.],
               [3., 4., 5.],
               [6., 7., 8.]])

m2 = np.array([[2., 3., 4.],
               [5., 6., 7.],
               [8., 9., 10.]])

m3 = np.array([[2., 3.],
               [4., 5.]])

m4 = np.array([[1., 1.],
               [0., 1.]])

m5 = np.array([[1.], [1.]])

print("Produit M1M2 (avec *, multiplie chaque champ du tableau) : \n ", m1 * m2)
print("Produit M1M2 (avec dot, multiplie les deux matrices) : \n ", np.dot(m1, m2))
print("Transposée de la matrice M1 : \n ", m1.transpose())
print("Determinant de M3 : \n ", np.linalg.det(m3))
print("Inverse de M3 : \n ", np.linalg.inv(m3))
print("Résolution du systeme M1M2 : \n ", np.linalg.solve(m4, m5))
print("Vecteurs propres de M1 : \n ", np.linalg.eig(m1))
