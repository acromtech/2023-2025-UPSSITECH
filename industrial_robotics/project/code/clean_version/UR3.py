import numpy as np
import matplotlib.pyplot as plt

class UR3:
    def __init__(self):
        self.nb_ddl =   4
        self.o0o1   =   152 # mm
        self.o1o2   =   120 # mm
        self.o2o3   =   244 # mm
        self.la     =   296 # mm
        self.lb     =   92  # mm

        #Paramètres de DHM
        self.a=[0,0,self.o2o3]
        self.alpha=[0,np.pi/2,0]
        self.r=[self.o0o1,-self.o1o2,0]
        # self.theta = qi 

    def MGD(self,q):
        # Calcul des matrices de passages
        for i in range(self.nb_ddl-1):
            T=np.array([[np.cos(q[i])                       ,   -np.sin(q[i])                       ,   0                       ,   self.a[i]], 
                        [np.cos(self.alpha[i])*np.sin(q[i]) ,   np.cos(self.alpha[i])*np.cos(q[i])  ,   -np.sin(self.alpha[i])  ,   -self.r[i]*np.sin(self.alpha[i])],
                        [np.sin(self.alpha[i])*np.sin(q[i]) ,   np.sin(self.alpha[i])*np.cos(q[i])  ,   np.cos(self.alpha[i])   ,   self.r[i]*np.cos(self.alpha[i])],
                        [0                                  ,   0                                   ,   0                       ,   1]])
            if i!=0:
                T0N=T0N@T
            else:
                T0N=T

        Vp  = T0N[:3,3:]

        # Détermination de la position du repère de l'OT 
        T0E = T0N @ np.array([[ 1   ,   0   ,   0   ,   self.la     ], 
                              [ 0   ,   1   ,   0   ,   0           ],
                              [ 0   ,   0   ,   1   ,   self.lb     ],
                              [ 0   ,   0   ,   0   ,   1           ]])

        Vp=T0E[:3,3:]
        X=Vp[0][0]
        Y=Vp[1][0]
        Z=Vp[2][0]

        # Affichage de la position du repère de l'OT 
        #print("\nT0E")
        #print ("Xp = ", Vp[0][0])
        #print ("Yp = ", Vp[1][0])
        #print ("Zp = ", Vp[2][0])

        # Détermination de l'orientation du repère de l’OT avec les angles d'Euler
        la  = (np.arctan2(-T0E[1][2],T0E[2][2]))**2
        nu  = np.arcsin(T0E[0][2])
        v   = np.arctan2(T0E[0][1],T0E[0][0])

        # Affichage de l'orientation du repère de l’OT avec les angles d'Euler
        #print("\nAngles Euler")
        #print ("la = ", la)
        #print ("nu = ", nu)
        #print ("v = ", v)

        return X,Y,Z
    
    def MGI(self,X,Y,Z):
        # Initialisation des variables
        z1 = []
        q1 = []
        q2 = []
        q3 = []
        c3 = []
        all_q = []

        # Détermination des 4 q3
        z1.append(np.sqrt(X**(2) + Y**(2) - ((self.lb - self.o1o2)**(2))))
        z1.append(-np.sqrt(X**(2) + Y**(2) - ((self.lb - self.o1o2)**(2))))
        z1.append(np.sqrt(X**(2) + Y**(2) - ((self.lb - self.o1o2)**(2))))
        z1.append(-np.sqrt(X**(2) + Y**(2) - ((self.lb - self.o1o2)**(2))))
        z2 = Z - self.o0o1

        c3 = ((z1[0])**(2) + z2**(2) - X**(2) - Y**(2)) / (2 * X * Y)

        q3.append(np.arctan2(np.sqrt(1 - c3**(2)), c3))
        q3.append(np.arctan2(np.sqrt(1 - c3**(2)), c3))
        q3.append(np.arctan2(-np.sqrt(1 - c3**(2)), c3))
        q3.append(np.arctan2(-np.sqrt(1 - c3**(2)), c3))

        # Détermination de q1 et q2 pour chaque q3
        for i in range (len(q3)):
            b1=X+Y*np.cos(q3[i])
            b2=Y*np.sin(q3[i])

            s2=(b1*z2-b2*z1[i])/(b1**(2)+b2**(2))
            c2=(b1*z1[i]+b2*z2)/(b1**(2)+b2**(2))
            q2.append(np.arctan2(s2,c2))

            x1_1=self.lb-self.o1o2
            y1_1=self.la*np.cos(q2[i]+q3[i])+self.o2o3*np.cos(q2[i])
            z1_1=X
            x2_1=self.la*np.cos(q2[i]+q3[i])+self.o2o3*np.cos(q2[i])
            y2_1=-self.lb+self.o1o2
            z2_1=Y

            s1=(z1_1*y2_1-z2_1*y1_1)/(x1_1*y2_1-x2_1*y1_1)
            c1=(z2_1*x1_1-z1_1*x2_1)/(x1_1*y2_1-x2_1*y1_1)
            q1.append(np.arctan2(s1,c1))

            print([q1[i],q2[i],q3[i]])
            all_q.append([q1[i],q2[i],q3[i]])
        
        return all_q

    def Jacobienne(self,q):
        
        t= np.array([   [-self.la*np.sin(q[0])*np.cos(q[1]+q[1])+self.lb*np.cos(q[0])-self.o1o2*np.cos(q[0])-self.o2o3*np.cos(q[1])*np.sin(q[0])    ,   -self.la*np.cos(q[0])*np.sin(q[1]+q[2])-self.o2o3*np.cos(q[0])*np.sin(q[1]) ,   -self.la*np.cos(q[0])*np.sin(q[1]+q[2])  ], 
                        [ self.la*np.cos(q[0])*np.cos(q[1]+q[2])-(self.o0o1+self.o1o2-self.o2o3)*np.sin(q[0])-self.o2o3*np.cos(q[1])*np.cos(q[0])   ,   -self.la*np.sin(q[0])*np.sin(q[1]-q[2])-self.o2o3*np.sin(q[1])*np.sin(q[0]) ,   self.la*np.sin(q[0])*np.sin(q[1]-q[2])   ],
                        [ 0                                                                                                                         ,   self.la*np.cos(q[1]+q[2])+self.o2o3*np.cos(q[1])                            ,   self.la*np.cos(q[2]+q[1])                ]])
        print(t)
        print(np.cos(np.pi/2))
        print(self.o2o3*np.cos(q[1])*np.cos(q[0]))
        print(self.la*np.cos(q[0])*np.cos(q[1]+q[2]))
    
    def MDI(self, A, B, V1, V2):
        # Initialisation des variables
        s0, s1, s2 = [], [], [] # postion, vitesse, acceleration
        x0, y0, z0 = [], [], [] # x,y,z position
        x1, y1, z1 = [], [], [] # x,y,z vitesse
        x2, y2, z2 = [], [], [] # x,y,z acceleration
        V_OT = []
        dAB = np.sqrt((A[0] - B[0]) ** 2 + (A[1] - B[1]) ** 2 + (A[2] - B[2]) ** 2)
        T = dAB / (V2 + 2 * V1)
        K1 = V1 / T
        K2 = (V2 - V1) / T

        # Détermination du MDI
        t = np.linspace(0, 4*T, 1000)

        for ti in t:
            if ti < T:
                s2.append(K1)
                s1.append(K1*ti)
                s0.append((1 / 2) * K1 * ti ** 2)
            elif T <= ti < 2 * T:
                s2.append(K2)
                s1.append(K2 * (ti - T) + V1)
                s0.append((K2 / 2) * (ti - T) ** 2 + V1 * (ti - T) + (1 / 2) * K1 * T ** 2)
            elif 2 * T <= ti < 3 * T:
                s2.append(-K2)
                s1.append(-K2 * (ti - 2 * T) + V2)
                s0.append((-K2 / 2) * (ti - 2 * T) ** 2 + V2 * (ti - 2 * T) + ((T ** 2) / 2) * (K2 + K1) + V1 * T)
            elif ti >= 3 * T:
                s2.append(-K1)
                s1.append(-K1 * (ti - 3 * T) + V1)
                s0.append((-K1 / 2) * ((ti - 3 * T) ** 2) + V1 * (ti - 3 * T) + (T ** 2) / 2 * K1 + T * (V1 + V2))

        for i in range(len(t)):
            x0.append(((B[0]-A[0])/dAB)*s0[i]+A[0])
            y0.append(((B[1]-A[1])/dAB)*s0[i]+A[1])
            z0.append(((B[2]-A[2])/dAB)*s0[i]+A[2])
            x1.append(((B[0]-A[0])/dAB)*s1[i])
            y1.append(((B[1]-A[1])/dAB)*s1[i])
            z1.append(((B[2]-A[2])/dAB)*s1[i])
            x2.append(((B[0]-A[0])/dAB)*s2[i])
            y2.append(((B[1]-A[1])/dAB)*s2[i])
            z2.append(((B[2]-A[2])/dAB)*s2[i])
            V_OT.append(np.sqrt(x1[i]**2+y1[i]**2+z1[i]**2))

        print("Graphique de la position, de la vitesse et de l'accélération")
        fig, axes = plt.subplots(1, 3, figsize=(15, 3))
        s_data = [s0, s1, s2]
        labels = ['s0', 's1', 's2']
        for i in range(3):
            axes[i].plot(t, s_data[i], label=labels[i])
            axes[i].set_xlabel('Temps')
            axes[i].set_ylabel(labels[i])
            axes[i].legend()
        plt.tight_layout()
        plt.show()

        print("Graphique de x,y,z")
        fig, axes = plt.subplots(3, 3, figsize=(15, 10))
        data = [(x0, 'x0'), (y0, 'y0'), (z0, 'z0'), 
                (x1, 'x1'), (y1, 'y1'), (z1, 'z1'), 
                (x2, 'x2'), (y2, 'y2'), (z2, 'z2')]
        for i in range(3):
            for j in range(3):
                current_data, label = data[i * 3 + j]
                axes[i, j].plot(t, current_data, label=label)
                axes[i, j].set_xlabel('Temps')
                axes[i, j].set_ylabel(label)
                axes[i, j].legend()
        plt.tight_layout()
        plt.show()

        print("Vérification de la trajectoire")
        fig, axes = plt.subplots(1, 2, figsize=(10, 3))
        axes[0].plot(t, V_OT, label='V_OT')
        axes[0].set_xlabel('Temps')
        axes[0].set_ylabel('V_OT')
        axes[0].legend()

        axes[1].plot(t, s1, label='s1')
        axes[1].set_xlabel('Temps')
        axes[1].set_ylabel('s1')
        axes[1].legend()

        plt.tight_layout()
        plt.show()
