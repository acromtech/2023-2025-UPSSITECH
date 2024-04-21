function [theta_obst, HAUT, SING_HAUT,k]=gestionSingulariteFct(i,X,xobst,Y,yobst, theta_obst, HAUT, SING_HAUT,k)

      % Prediction de la mesure theta_obst(i+1) pour prevoir singularite
if HAUT
    theta_obst(i+1)=atan2(-(X(i+1)-xobst),(Y(i+1)-yobst))-2*k*pi;
else
    theta_obst(i+1)=atan2(-(X(i+1)-xobst),(Y(i+1)-yobst))+2*k*pi-pi;
end

   % Reperage de la singularite de ATAN2 en pi lors d'un contournement par le haut

if  X(i+1)<xobst && abs(theta_obst(i+1)-theta_obst(i))>pi/2 && HAUT
    SING_HAUT=1;
    k=k+1;
    k_sauve_haut(i)=k; 
end
   
   % Reperage de la singularite de ATAN2 en pi lors d'un contournement par le bas

if  Y(i+1)<yobst && abs(theta_obst(i+1)-theta_obst(i))>pi/2 && ~HAUT
    k=k+1;
    k_sauve_bas(i)=k;
end

if HAUT && SING_HAUT
   SING_HAUT=0;
   theta_obst(i+1)=atan2(-(X(i+1)-xobst),(Y(i+1)-yobst))-2*k*pi;
end

if ~HAUT
   theta_obst(i+1)=atan2(-(X(i+1)-xobst),(Y(i+1)-yobst))+2*k*pi;    
end
