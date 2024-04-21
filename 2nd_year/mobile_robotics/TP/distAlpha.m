function [dist,alpha,theta_obst, theta_pt_obst] = distAlpha(i, alpha, theta_obst, dist, X, Y, Tr, xobst,yobst,robst,T,HAUT,EPS)
  
    alpha(i+1)=Tr(i+1)-theta_obst(i+1);
    dist(i+1)=sqrt((X(i+1)-xobst)^2+(Y(i+1)-yobst)^2)-robst;

   % Test contournement par le bas
%if ((Tr(1)<0)||(abs(Tr(1))<EPS && Y(1)<yobst)) && ~HAUT
if ~HAUT
 theta_obst(i+1)=theta_obst(i+1)-pi;
 alpha(i+1)=alpha(i+1)+pi;
 dist(i+1)=-dist(i+1);
end

theta_pt_obst=(theta_obst(i+1)-theta_obst(i))/T; 
endfunction
