import matplotlib.pyplot as plt

labels = 'Européennes', 'Africaines', 'Asiatiques', 'Latinas'
sizes = [35, 15, 15, 35]
explode = (0.1, 0.1, 0.1, 0.1)

fig1, ax1 = plt.subplots()

ax1.pie(sizes, explode=explode, labels=labels, autopct='%1.1f%%', shadow=True, startangle=90)
ax1.axis('equal')  # Equal aspect ratio ensures that pie is drawn as a circle.

plt.title("Actrices porno dans le monde")
plt.show()
