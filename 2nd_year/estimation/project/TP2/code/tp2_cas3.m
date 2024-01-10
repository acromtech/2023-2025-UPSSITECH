FIGURE1=1;
FIGURE2=1;
FIGURE3=1;
FIGURE4=1;
FIGURE5=1;

% L'équation de mesure (1) satisfait :

% \begin{gathered}
% h(x)=\left(h_1(x), \ldots, h_L(x)\right)^T, \text { avec } \forall l \in\{1, \ldots, L\}, h_l(x)=\left(\begin{array}{c}
% \left\|R M_l\right\| \\
% \overrightarrow{x_0, \overrightarrow{R M_l}}
% \end{array}\right)=\left(\begin{array}{c}
% \sqrt{\left(u_l-u\right)^2+\left(v_l-v\right)^2} \\
% \operatorname{atan2(v_{l}-v,u_{l}-v)}
% \end{array}\right) \\
% \bar{v}=0, C_v \text { donnés. }
% \end{gathered}

% =======================================================================

% Question 11 : Invoquer séquentiellement simulationDonnees.m de façon à 
% exécuter un nombre N suffisamment élevé d'expériences aléatoires. 
% Stocker les réalisations (ou "échantillons") de Z obtenues
% sur ces expériences.

% Nombre d'expériences
N_exp = 1000;

% Initialiser un tableau pour stocker les réalisations de Z
Z_samples = zeros(2 * L, N_exp);

% Répéter les expériences
for i = 1:N_exp
    % Appeler la fonction de simulation pour le cas 3
    [Z,L,m,H,Hfull,bar_v,C_v,x] = simulationDonnees(3,0);

    % Stocker la réalisation de Z dans le tableau
    Z_samples(:, i) = Z;
end

% =======================================================================

% Question 12 : Visualiser graphiquement la distribution empirique des 
% positions absolues (i.e., dans F0) des amers pouvant être établie sur 
% la base des échantillons de Z si on suppose ponctuellement que x est 
% donné.

if FIGURE1==1
    figure(3);
    hold on;
    grid on;
    title('Distribution empirique des positions absolues des amers');
    
    % Afficher les positions absolues réelles des amers
    for i = 1:2:2 * L
        plot(Z_samples(i, :), Z_samples(i + 1, :), 'b.', 'MarkerSize', 8); % Amers réels
    end
    
    % Marquer la position du robot (supposé ponctuellement donné)
    plot(x(1), x(2), 'rx', 'MarkerSize', 10);
    
    legend('Positions réelles de l''amer 1', ...
        'Positions réelles de l''amer 2', ...
        'Positions réelles de l''amer 3',...
        'Positions réelles de l''amer 4',...
        'Positions réelles de l''amer 5',...
        'Position du robot');
    
    hold off;
end

% Question 14 : Procéder à l implémentation de l’algorithme de Gauss-Newton. 
% Tracer autour de l’estimé \hat{\mathrm{x}}_{\mathrm{MLE}} obtenu un 
% ellipse de confiance dans lequel x doit se trouver approximativement avec 
% une probabilité de 99 %. Vérifier la plausibilité.

% Initialisation des paramètres
x_init = [0; 0];
max_iterations = 50;
threshold = 1e-6;

% Algorithme de Gauss-Newton
x_k = x_init;
for iter = 1:max_iterations
    % Calcul de la fonction de mesure h(x_k) et de sa jacobienne J(x_k)
    [h_x, J_x] = compute_measure_and_jacobian(x_k);
    
    % Calcul de l'erreur résiduelle
    residual = Z - h_x;
    
    % Mise à jour des paramètres avec l'algorithme de Gauss-Newton
    x_k = x_k + (J_x' * inv(C_v) * J_x) \ (J_x' * inv(C_v) * residual);
    
    % Vérification de la convergence
    if norm(x_k - x_prev) < threshold
        break;
    end
    
    x_prev = x_k;
end

% Calcul de la matrice de covariance Cov^X
Cov_hat_X = inv(J_x' * inv(C_v) * J_x);

% Calcul des demi-axes de l'ellipse de confiance
confidence_level = 0.99;
radius_x = sqrt(chi2inv(confidence_level, 2)) * sqrt(Cov_hat_X(1, 1));
radius_y = sqrt(chi2inv(confidence_level, 2)) * sqrt(Cov_hat_X(2, 2));

% Paramètres pour tracer l'ellipse de confiance
theta = linspace(0, 2 * pi, 100);
ellipse_x = x_k(1) + radius_x * cos(theta);
ellipse_y = x_k(2) + radius_y * sin(theta);

% Tracer l'estimé ^x et l'ellipse de confiance
figure;
plot(Z(1), Z(2), 'rx'); % Mesure
hold on;
plot(x_k(1), x_k(2), 'go'); % Estimé ^x
plot(ellipse_x, ellipse_y, 'b--'); % Ellipse de confiance

% Paramètres graphiques
title('Estimation ^x et Ellipse de Confiance');
xlabel('Position en u');
ylabel('Position en v');
legend('Mesure', 'Estimé ^x', 'Ellipse de Confiance');
hold off;
