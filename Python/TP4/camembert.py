import matplotlib.pyplot as plt

labels = 'Python', 'Java', 'C++', 'Réseau', 'Mathématiques', 'Base de données', 'Archi. Systèmes'
sizes = [56, 14, 11, 7, 4, 1, 14]
explode = (0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1)

fig1, ax1 = plt.subplots()

ax1.pie(sizes, explode=explode, labels=labels, autopct='%1.1f%%', shadow=True, startangle=90)
ax1.axis('equal')  # Equal aspect ratio ensures that pie is drawn as a circle.

plt.title("Cours importants à Polytech")
plt.show()