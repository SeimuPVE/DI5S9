import matplotlib.pyplot as plt
from scipy import misc
from scipy.misc import imresize, imshow, imread
from scipy.optimize import curve_fit
import scipy as sy
import pylab as plb

data = plb.loadtxt('data.dat')
x = data[:, 0]
y = data[:, 1]


def func(x, a, b, c):
    return a * x ** b + c


def approxPoints():
    p0 = sy.array([1, 1, 1])
    coeffs, matcov = curve_fit(func, x, y, p0)

    yaj = func(x, coeffs[0], coeffs[1], coeffs[2])
    print(coeffs)
    print(matcov)

    plt.plot(x, y, 'x', x, yaj, 'r-')
    plt.show()



# img= misc.imread("E:\Polytech\Python\TP6\image.png")
# img_resized= misc.imresize(monitor, 0.5)
# plt.imshow(img_resized)
# plt.imshow(img)
# plt.show()

approxPoints()
