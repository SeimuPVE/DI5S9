import matplotlib.pyplot as plt
import random


random_numbers = []

for i in range(200):
    random_numbers.append(random.randint(0, 200))

print(random_numbers)


plt.plot([1,2,3,4])
plt.ylabel('Label 1')
plt.show()
