import matplotlib.pyplot as plt
import random



random_numbers_X = []
random_numbers_Y = []

for i in range(200):
    random_numbers_X.append(random.randint(0, 200))
    random_numbers_Y.append(random.randint(0, 200))

print(random_numbers_X)
print(random_numbers_Y)

# Print random numbers on a graph.
plt.plot(random_numbers_X, random_numbers_Y, 'ro', color='b', label='Point aléatoire')
plt.annotate('Oh ! Il y a une flèche !', xy=(100, 100), xytext=(120, 120), arrowprops=dict(arrowstyle="->", connectionstyle="arc3,rad=.2"))
plt.xlabel('Valeurs aleatoire x')
plt.ylabel('Valeurs aleatoires y')
plt.title("Exemple de nuage de points")
plt.legend()
plt.show()