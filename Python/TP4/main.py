import matplotlib.pyplot as plt
import random


# Generate random numbers.
random_numbers = []

for i in range(200):
    random_numbers.append(random.randint(0, 200))

print(random_numbers)

# Print random numbers on a graph.
plt.plot(random_numbers, 'ro', color='b', label='Random numbers')
plt.annotate('Flèche !', xy=(100, 100), xytext=(120, 120), arrowprops=dict(arrowstyle="->", connectionstyle="arc3,rad=.2"))
plt.xlabel('Random x')
plt.ylabel('Random Numbers')
plt.legend()
plt.show()
