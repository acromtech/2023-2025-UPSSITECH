function drawrob(X0,Y0,Tr0,titre,abscisse,ordonnee)

% (X0,Y0,Tr0) represente la configuration initiale du robot par rapport au
% repere de la scene.
% On donne en plus le titre de la figure, ainsi que les labels en abscisse
% et en ordonnee.

%figure 
title(titre) 
xlabel(abscisse) 
ylabel(ordonnee) 
hold on 

% Trace de la configuration initiale du robot
 
c= X0; 
d=Y0; 
e=Tr0; 
dx=.45; 
dy=.324;

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% 
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% 
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% 2
 
P1=[-0.2 dy]; P2=[-0.2 -dy]; P4=[dx dy]; P3=[dx -dy]; 
P5=[0 dy]; P6=[0 -dy];P7=[0 0]; P8=[dx 0]; 
 
P1=P1*[cos(e) sin(e); -sin(e) cos(e)]+[c d]; 
P2=P2*[cos(e) sin(e); -sin(e) cos(e)]+[c d]; 
P3=P3*[cos(e) sin(e); -sin(e) cos(e)]+[c d]; 
P4=P4*[cos(e) sin(e); -sin(e) cos(e)]+[c d]; 
 
P5=P5*[cos(e) sin(e); -sin(e) cos(e)]+[c d]; 
P6=P6*[cos(e) sin(e); -sin(e) cos(e)]+[c d]; 
P7=P7*[cos(e) sin(e);- sin(e) cos(e)]+[c d]; 
P8=P8*[cos(e) sin(e); -sin(e) cos(e)]+[c d]; 



x_en=[P1(1) P2(1)]; 
y_en=[P1(2) P2(2)]; 
plot(x_en,y_en,'b') 
 
 
x_en=[P2(1) P3(1)]; 
y_en=[P2(2) P3(2)]; 
plot(x_en,y_en,'b') 
 
x_en=[P3(1) P4(1)]; 
y_en=[P3(2) P4(2)]; 
plot(x_en,y_en,'b') 
 
x_en=[P1(1) P4(1)]; 
y_en=[P1(2) P4(2)]; 
plot(x_en,y_en,'b') 
 
x_en=[P3(1) P4(1)]; 
y_en=[P3(2) P4(2)]; 
plot(x_en,y_en,'b') 
 
x_en=[P1(1) P4(1)]; 
y_en=[P1(2) P4(2)]; 
plot(x_en,y_en,'b') 
 
x_en=[P5(1) P6(1)]; 
y_en=[P5(2) P6(2)]; 
plot(x_en,y_en,'b') 
 
x_en=[P7(1) P8(1)]; 
y_en=[P7(2) P8(2)]; 
plot(x_en,y_en,'b') 
 

