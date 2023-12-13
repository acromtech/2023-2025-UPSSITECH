function [sys,x0,str,ts] = sf_loi_avant_RP(t,x,u,flag)
% NE PAS MODIFIER CI-DESSOUS ; CF. SEULEMENT mdlOutputs PLUS BAS
%
switch flag,
  case 0,
    [sys,x0,str,ts] = mdlInitializeSizes;
  case 3,
    sys = mdlOutputs(t,x,u);
  case {1,2,4,9}
    sys = [];
  otherwise
    error(['Unhandled flag = ',num2str(flag)]);
end
%=============================================================================
function [sys,x0,str,ts] = mdlInitializeSizes
% NE PAS MODIFIER CI-DESSOUS ; CF. SEULEMENT mdlOutputs PLUS BAS
%
sizes = simsizes;
sizes.NumContStates  = 0;
sizes.NumDiscStates  = 0;
sizes.NumOutputs     = 2;               % [d1;d2]
sizes.NumInputs      = 6;               % [q1;q2;dq1;dq2;ddq1;ddq2]
sizes.DirFeedthrough = 1;
sizes.NumSampleTimes = 1;
sys = simsizes(sizes);
x0  = [];
str = [];
ts  = [-1 0];                           % période héritée du bloc père
%=============================================================================
function sys = mdlOutputs(t,x,u)
%
q1 = u(1); q2 = u(2); dq1 = u(3); dq2 = u(4); ddq1 = u(5); ddq2 = u(6);
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% À COMPLÉTER À PARTIR D'ICI %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% sys DOIT ÊTRE INTIALISÉ AVEC LE CONTENU DU VECTEUR DE SORTIE DU BLOC
% e.g.
g=-9.81
Beff=1/80;
Jm=1/100;
m=15; %kg
r=1/200;
Jeff=Jm + (r^2) *m;
Km_R=0.3;
A=1/2;  % Ev/O1

e1=(r/A)*(2*m*q2*dq1*dq2-m*q2*g*cos(q1))
e2=(-r*(m*q2*dq1^2+m*g*sin(q1)))
sys = [e1;e2];
%=============================================================================
