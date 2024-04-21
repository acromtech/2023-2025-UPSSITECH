% Un peu de nettoyage avant de commencer...

clear all 
close all 

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%				INITIALISATIONS 				%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


% Robot
X(1)=2; 
Y(1)=3;
Tr(1)=1/8;
v=1;

% Obstacle circulaire
xobst=4;   % Coordonnees centre du cercle
yobst=0; 
robst=1;   % Rayon

% Distance desiree entre le robot et l'obstacle
d0=2;

initialisation;

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%				BOUCLE DE COMMANDE				%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

i=1;

while (i<NB_IT_MAX)

   % Calcul de la loi de commande de Samson
% à compléter


  % Calcul de la loi de commande linéaire
% à compléter


   % Sauvegarde valeur w pour le tracé
w_sauve(i)=w;

%%%%%%% NE PAS MODIFIER
   % Reconstruction etat robot
[X(i+1),Y(i+1),Tr(i+1)]=est_etat(X(i),Y(i),Tr(i),v,w,T);

   % Generation des mesures
   % Step 1 : calcul theta_obst et gestion Singularité 
   %gestionSingularite;
[theta_obst, HAUT, SING_HAUT,k] = gestionSingulariteFct(i,X,xobst,Y,yobst, 
theta_obst, HAUT, SING_HAUT,k);
    % Step 2 : calcul de la distance et de l'orientation relative
[dist,alpha,theta_obst, theta_pt_obst] = distAlpha(i, alpha, theta_obst, dist, 
X, Y, Tr, xobst,yobst,robst, T, HAUT,EPS);

  % Mise a jour de i

i=i+1

end

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%				SORTIES   GRAPHIQUES				%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% Trace trajectoire du robot
% Traces du robot en config initiale
drawrob(X(1),Y(1),Tr(1),'Deplacement du robot','x','y');  
grid
% Tracé obstacle circulaire 
drawcercle(xobst,yobst,robst,'r'); 
% Traces de la trajectoire du centre du robot
plot(X,Y) 
% Traces du robot dans la dernière configuration
drawrob(X(end),Y(end),Tr(end),'Deplacement du robot','x','y');  
hold off 

% Trace de la distance et de l'orientation relative robot/obstacle
t = [0:T:(i-1)*T]
figure;
plot(t,dist-d0)
title('Distance robot/chemin')
grid

figure;
plot(t,alpha)
title('Orientation relative robot/chemin')
grid

figure;
plot([t(1:end-1)],w_sauve)
title('Commande en orientation: Evolution de w')
grid

