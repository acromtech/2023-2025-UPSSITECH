function [Xs,Ys,thetas]=est_etat(Xp,Yp,thetap,v,w,T)

% Cette fonction estime l'etat suivant du systeme en fonction de la commande
% calculee...

Xs=Xp+T*v*cos(thetap+T*w/2);
Ys=Yp+T*v*sin(thetap+T*w/2);
thetas=thetap+T*w;

