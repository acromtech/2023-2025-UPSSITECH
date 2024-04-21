function [dist,alpha,theta_obst, theta_pt_obst] = distAlphaInit(X, Y, Tr, xobst,yobst,robst,HAUT)


% Generation des premieres mesures necessaires pour le contournement par le haut
theta_obst(1)=atan2(-(X(1)-xobst),(Y(1)-yobst));
alpha(1)=Tr(1)-theta_obst(1); 
dist(1)=sqrt((X(1)-xobst)^2+(Y(1)-yobst)^2)-robst;
theta_pt_obst = 0;  % Valeur initiale de theta_pt_obst

% Adaptation des mesures si contournement par le bas

if ~HAUT
  disp('Vous contournez par le bas. Appuyez sur une touche pour continuer')
  pause
   dist(1)=-dist(1);
   theta_obst(1)=theta_obst(1)-pi;
   alpha(1)=alpha(1)+pi;
   d0=-d0;
 %  HAUT=0;
end