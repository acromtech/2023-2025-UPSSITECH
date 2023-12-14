clear all

K_m = 4800;
T1 = 1.6 ;
T2 = 0.05;

% Fonction de transfert en boucle fermé
% G0 = tf([K_m],[T1*T2 (T1+T2) 1]);
% p = pole(G0);
% z = zero(G0);
% gs = dcgain(G0);

% les poles negatives ==> systeme stable 
% pole strictement réel ==> pas d'oscillations
% step (G0);
% Oui, on retrouve le gain statisue de 4800 et le systable est stabel (converge vers une solution finis) et sans oscillations. 

% G1 = tf([K_m],[T1 1])
% p1 = pole(G1);
% z1 = zero(G1);
% gs1 = dcgain(G1);
% step (G1, G0)

% G2 = tf([K_m],[T2 1]);
% p2 = pole(G2);
% z2 = zero(G2);
% gs2 = dcgain(G2);
% step(G2,G0)
% On remarque que le pole T1 de la fonction G0 a plus d'impact que le pole T2.

% G3 = tf([1],[1 0])
% sys = G0*G3;
% pole(sys);
% zero(sys);
% step(sys);
% Comme un pole est = 0 on est à la limite de la stabilité. Ainsi comme il y a un risque d'voir un système instable, il semble nécessaire de mettre en place une commande (P, PI, PD ou PID)

% Partie 2 : Mise en place d'une commande proportionelle

% 1.
% Kp = 9*10e-6; % A régler
% Rappel : La commande proportionelle a pour objectif de corriger à l'aide d'un gain K le système afin de modifier les poles et les zéros et faire mieux réagir le système afin qu'il soit plus performant
% Ici on souhaite utiliser une première commande pour limiter l'instabilité du système dont la FTBO est :
% W0 = sqrt(Kp*K_m)
% e=1/(2*sqrt(Kp*K_m))
% On peut jouer sur les paramètres W0 et e
% On passe a rltool le systeme en BOUCLE OUVERTE
% FTBF=tf([1],[1/W0 (2*e)/W0 1])
% step(FTBF)
% FTBO = tf ([K_m],[T1 1 0])
% rlocus(FTBO)

% 2.
% e = 0.7607
% W0 =0.6573

% 3.
% Comme on a pas de zéro une erreur de position est probable
% Comme on a 2 poles 
 
% 4.
% rltool(FTBO)
% pole(FTBF)
% zero(FTBF)

% 5.
% Kp = 9.32e-5;
% sgrid on
% FTBO = tf ([Kp*K_m],[T1 1 0])
% rlocus(FTBO)

% 6.
% FTBF =  tf ([Kp*K_m],[T1 1 Kp*K_m])
% minreal_FTBF=minreal(FTBF)
% step(minreal_FTBF)
% damp(minreal_FTBF)

% Pole Damping Frequency Time Constant 
% (rad/seconds) (seconds)  
%  -3.13e-01 + 4.27e-01i     5.91e-01       5.29e-01         3.20e+00    
% -3.13e-01 - 4.27e-01i     5.91e-01       5.29e-01         3.20e+00   

% On satisfait le cahier des charges au niveau du dépassement à 10% mais
% pas au niveau des 3 secondes de temps de réponse à 5% demandé (10s).
% Pour cela on peut soit augmenter le gain -> Dérive et oscillations
% Soit ajouter un correcteur -> Mise en place d'une contre-correction
% Tachyamétrique

% Partie 3 : Mise en place d'une contre-réaction tachyamétrique

% 1. On remarque qu'il y a 2 gains et 2 boucles dont 1 retour d'état (chaine interne) et 1
% retour de sortie

% 2.
K1=1
K2=1
tau=T1/(1+K2*K_m)
K0=K_m/(1+K2*K_m)
G_tach=tf([K0],[tau 1])

% 4.
FTBO_tach=tf([K0*K1],[tau 1 0])
FTBF_tach=tf([K0*K1],[tau 1 K0*K1])
% On peut jouer sur les paramètres W0 et e
K_can=1
W0_tach=sqrt(K0*K1)/tau
e_tach=1/(2*sqrt(K0*K1*tau))

% 5.
% Modification des valeurs de K1 et K0 dans (2.)
step(FTBF_tach)
rlocus(FTBO_tach)