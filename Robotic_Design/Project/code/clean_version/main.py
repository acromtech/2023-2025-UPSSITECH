from UR3 import UR3
import numpy as np

# Création d'une instance du robot UR3 et initialisation des paramètres q
robot = UR3()
qdeg=[np.pi/2,0,0]

# MGD -- OK
X,Y,Z=robot.MGD(qdeg)

# MGI -- NOK
g=robot.MGI(X,Y,Z)
print ("MGD -------------------------------------------")
print(robot.MGD(g[0]))
print(robot.MGD(g[1]))
print(robot.MGD(g[2]))
print(robot.MGD(g[3]))
print("\nqdeg=",qdeg[0],qdeg[1],qdeg[2])

# Jacobienne -- OK
#j=robot.Jacobienne(qdeg)
#print("\n Jacobienne:",j)

# MDI -- OK
A=[200,200,100]
B=[300,350,300]
robot.MDI(A,B,1,1.5)