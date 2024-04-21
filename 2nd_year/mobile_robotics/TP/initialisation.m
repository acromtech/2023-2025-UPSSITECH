% Les constantes

EPS=1e-4;
NB_IT_MAX=5000; 
k=0;
HAUT=1;
SING_HAUT=0;

% Periode d'echantillonnage
T=0.01;

% Gains de la loi non linéaire
k1=4;
k2=2*sqrt(2);


[dist,alpha,theta_obst, theta_pt_obst] = distAlphaInit(X, Y, Tr, xobst,yobst,robst,HAUT)