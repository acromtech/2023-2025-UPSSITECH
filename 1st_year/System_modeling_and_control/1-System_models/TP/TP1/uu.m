A = [-1 2 0; 0 -2 -1 ;0 2 -1];
% -------------------------------------------------------------------------
% EXERCICE 1
% -------------------------------------------------------------------------
% vpropre=eig(A);
% disp(A);
% disp(vpropre);
% rang= rank(A);
% disp(rang);
% D=diag(vpropre);
% disp(D);
% T=inv(A);
% disp(T);

% -------------------------------------------------------------------------
% EXERCICE 2
% -------------------------------------------------------------------------
% P= poly(A);
% disp(P);
% v=-5:0.1:2;
% disp(v);
% val_x=[];
% i=1;
% for v=(-5:0.1:2)
%     val_x(i) = P(1)*v^3 + 4*v^2+7*v +4;
%     i=i+1;
% end
% 
% v=-5:0.1:2;
% 
% plot(v, val_x);

% -------------------------------------------------------------------------
% EXERCICE 3
% -------------------------------------------------------------------------
B1=[0;0;1];
B2=[1;0;0];
% La dimension du vecteur d'etat est de 3
% La dimension du vecteur de commande U lorsque U=B1 est de 1
% La dimension du vecteur de commande U lorsque U=B1B2 est de 2
disp(ctrb(A,B1));
disp(ctrb(A,[B1 B2]));
disp(ctrb(A,B2));

% Seulement si le rang de la matrice de commandabilite est egal e la
% dimension de la matrice X ainsi B=B1 est le seul modele commandable

% -------------------------------------------------------------------------
% EXERCICE 4
% -------------------------------------------------------------------------
C1=[1 0 -2];
C2=[0 0 1];

% La dimension du vecteur de mesure pour Y=C1 est de 0;
% La dimension du vecteur de mesure pour Y=[C1 C2] et de 2;
disp(obsv(A,C1)); %systeme 1
disp(obsv(A,C2)); %systeme 2
disp(obsv(A,[C1;C2])); %systeme 3

% Seulement si il n'y a aucune colonne de 0 ainsi seul les systemes 1 et 3
% sont observables

% -------------------------------------------------------------------------
% EXERCICE 5
% -------------------------------------------------------------------------
% Les 4 modèles ont la même vecteur d'état X, le meme vecteur de commande U et la même matrice dynamique A
%