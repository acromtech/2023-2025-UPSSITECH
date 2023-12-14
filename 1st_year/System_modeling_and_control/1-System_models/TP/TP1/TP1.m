A = [-1 2 0; 0 -2 -1 ;0 2 -1];
% -------------------------------------------------------------------------
disp("EXERCICE 1");
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
disp("EXERCICE 2");
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
disp("EXERCICE 3");
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
disp("EXERCICE 4");
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
disp("EXERCICE 5");
% -------------------------------------------------------------------------
% 1. Les 4 modèles ont la même vecteur d'état X, le meme vecteur de commande U et la même matrice dynamique A
% 2. Les 4 modèles n'ont pas les mêmes vecteurs de commandabilité et
% d'observabilité.
disp("3. Création des modèles linéaires invariants dans l'espace d'état");
S1=ss(A,B1,C1,0);
S2=ss(A,B1,C2,0);
S3=ss(A,B2,C1,0);
S4=ss(A,B2,C2,0);

% Calcul de la fonction de transfert
tt=tf(S1);

disp("4.1. Calcul des poles");
disp(pole(S1));
disp(pole(S2));
disp(pole(S3));
disp(pole(S4));

disp("4.2. Calcul des zéros");
disp(zero(S1));
disp(zero(S2));
disp(zero(S3));
disp(zero(S4));
% 5. Comme tous les poles ne sont pas <0 donc aucun des poles n'est stable

% -------------------------------------------------------------------------
disp("EXERCICE 6");
% -------------------------------------------------------------------------
disp("1. Calcul des fonctions de transfert des 4 modèles précédents ");
M1=tf(S1);
M2=tf(S2);
M3=tf(S3);
M4=tf(S4);

disp("2. L'odre des fonctions de transfert");
disp("S1 est d'ordre 3");
disp("S2 est d'ordre 2");
disp("S3 est d'ordre 1");
disp("S4 est d'ordre 0");

disp("3.1. Calcul des poles");
disp(pole(M1));
disp(pole(M2));
disp(pole(M3));
disp(pole(M4));

disp("3.2. Calcul des zéros");
disp(zero(M1));
disp(zero(M2));
disp(zero(M3));
disp(zero(M4));

% 4. La seule fonction de transfert qui est stable entrée bornée / sortie
% bornée est la fonction de transfert M3 car ses pôles sont <0

