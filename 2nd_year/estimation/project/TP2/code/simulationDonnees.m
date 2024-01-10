function [Z,L,m,H,Hfull,bar_v,C_v,x] = simulationDonnees(cas_d_etude,plot_p);
%SIMULATIONDONNEES
%  Simulation d'une expérience
%  Syntaxe d'appel :  [Z,L,m,H,Hfull,bar_v,C_v,x] = simulationDonnees(cas_d_etude,plot_p);
%
%  Entrée :
%  . cas_d_etude : index de la section considérée dans le sujet
%  . plot_p : si égal à 1, alors produit un affichage, sinon rien
%
%  Sorties :
%  . Z : réalisation de la variable aléatoire de mesure (2Lx1)
%  . L : nombre d'amers 2D
%  . m : vecteur des positions des amers (2Lx1)
%  . H,Hfull : matrices potentiellement utiles...
%  -> et comme ceci est de la simulation, sont également accessibles
%     . bar_v,C_v : espérance et covariance du bruit de mesure additif Gaussien (2Lx1,2Lx2L)
%     . x         : vecteur de paramètres caché (2x1)

L = 5; % Nombre d'amers
x = [2;1]; % Ground truth
m = [5;-2; 3;4; 0;6; -2;2; -1;-7]; % Positions des amers
H = eye(2);
Hfull = repmat(H,L,1);

switch cas_d_etude
  case 1
    sigma = 0.05; % 3sigma = 15cm
    bar_v = zeros(2*L,1);
    C_v = sigma^2*eye(2*L);
    Z = m - Hfull*x ...
        + bar_v + (chol(C_v))'*randn(2*L,1);
  case 2
    bar_v = zeros(2*L,1);
    C_v = zeros(2*L,2*L);
    for i = 1:L,
      v{i} = diag([0.07^2,0.02^2]);
      V{i} = [cos((i-1)*pi/6) -sin((i-1)*pi/6);
              sin((i-1)*pi/6)  cos((i-1)*pi/6)];
      C_v((2*i-1):(2*i),(2*i-1):(2*i)) = ...
        V{i}*v{i}*V{i}';
    end;
    Z = m - Hfull*x ...
        + bar_v + (chol(C_v))'*randn(2*L,1);
  case 0
    bar_v = zeros(2*L,1);
    C_v = gallery('orthog',2*L,2);
    % Part below is adapted from RandOrthMat function by Ofek Shilon, 2006.
    % https://fr.mathworks.com/matlabcentral/fileexchange/11783-randorthmat?s_tid=mwa_osa_a
    tol = 1e-6;
    C_v = zeros(2*L);
    vi = randn(2*L,1);  
    % the n-dimensional normal distribution has spherical symmetry, which implies
    % that after normalization the drawn vectors would be uniformly distributed on the
    % n-dimensional unit sphere.
    C_v(:,1) = vi ./ norm(vi);
    for i=2:2*L
          nrm = 0;
          while nrm<tol
                vi = randn(2*L,1);
                vi = vi -  C_v(:,1:i-1)  * ( C_v(:,1:i-1).' * vi )  ;
                nrm = norm(vi);
          end
          C_v(:,i) = vi ./ nrm;
    end %i
    %
    v = diag([0.001 0.02].^2);
    % v = kron(eye(5),v)
    for i = 2:L, v = blkdiag(v,diag([0.001*i 0.02*i].^2)); end;
    %
    C_v = C_v * v * C_v';
    % test : récupération des blocs diagonaux 2x2 de C_v
    % pour émuler des bruits mutuellement indépendants
    % C_v = C_v .* kron(eye(5),ones(2));
    % /test
    Z = m - Hfull*x ...
        + bar_v + (chol(C_v))'*randn(2*L,1);
  case 3
    bar_v = zeros(2*L,1);
    C_v = zeros(2*L,2*L);
    for i = 1:L,
      v{i} = diag([0.02^2,0.07^2]);
      C_v((2*i-1):(2*i),(2*i-1):(2*i)) = v{i};
    end;
    Z = bar_v + (chol(C_v))'*randn(2*L,1); % bruit
    for i = 1:L,
      r = (m(2*i-1)-x(1)) ...
          + 1j * (m(2*i)-x(2));
      Z(2*i-1) = ...
        Z(2*i-1) + abs(r);
      Z(2*i) = ...
        Z(2*i) + angle(r);
          norm(m((2*i-1):(2*i))-x);
    end;
  otherwise
    sprintf('Argument cas_d_etude erroné.  Valeur : %d',cas_d_etude)
  end;

if (plot_p)
  close all
  figure(1); axis([-6 10 -8 8]); axis equal;
  hold on; grid on;
  plot(x(1),x(2),'r+'); % Robot
  for i = 1:2:2*L
    plot(m(i),m(i+1),'bo'); % Amers
  end
  title('+ : Robot --- o : Amers');
  drawnow;
  hold off
end;
