clear all
close all

% Robot
X(1)=2; 
Y(1)=3;
Tr(1)=1/8;


% Obstacle circulaire
xobst=4;   % Coordonnees centre du cercle
yobst=0; 
robst=1;   % Rayon

% Distance desiree entre le robot et l'obstacle
d0=2;

initialisation;

v=1;
A = [0 v;0 0];
B = [0;1];

%%%%%%%%%%%% A compléter

