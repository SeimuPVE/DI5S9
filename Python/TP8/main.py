from MultiThreadingExample import *
from MultiProcessingExample import *
from ParametersReader import *
from Fourmi import *


print("Start multi threading.")
thread1 = MultiThreadingExample()
thread1.start()

print("Start multi processing.")
thread2 = MultiProcessingExample()
thread2.start()

# print("Start fourmi.")
# reader = ParametersReader("params.xml")
# canvasHeight = 0
# canvasWeight = 0
# numberFourmi = 0
# fourmis = []
#
# for i in range(numberFourmi):
#     fourmis.append(canvas, Fourmi(reader.readNext("colorR"), reader.readNext("colorV"), reader.readNext("colorB"), reader.readNext("followR"), reader.readNext("followV"), reader.readNext("followB"), reader.readNext("probaG"), reader.readNext("probaD"), reader.readNext("probaT"), reader.readNext("doorDd"), reader.readNext("ps"), reader.readNext("numberIt"), reader.readNext("numberItDone")))
#
# for i in range(numberFourmi):
#     fourmis[i].start()
