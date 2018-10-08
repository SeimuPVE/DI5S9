import matplotlib.pyplot as plt
import numpy as np


# Histogram.
x = np.arange(2)
plt.bar(x, height=[0, 100])
plt.xticks(x, ['Hommes', 'Femmes'])

plt.ylabel('Pourcentage de personnes qui font le ménage')
plt.xlabel('Genres')

plt.show()
