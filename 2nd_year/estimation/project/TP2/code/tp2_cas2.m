% Question 6 : Invoquer séquentiellement simulationDonnees.m de façon à
% exécuter un nombre N suffisamment élevé d'expériences aléatoires.
% Stocker les réalisations (ou « échantillons ») de Z obtenues sur ces expériences.

N = 1000; % Nombre d'expériences aléatoires
L = 5; % Nombre d'amers

% Initialisation des matrices pour stocker les résultats
Z_samples = zeros(2 * L, N);

% Boucle pour exécuter N expériences aléatoires
for i = 1:N
    % Appel de la fonction de simulation
    [Z,L,m,H,Hfull,bar_v,C_v,x] = simulationDonnees(2, 0);

    % Stocker la réalisation de Z dans la matrice
    Z_samples(:, i) = Z;
end

% =======================================================================

% Question 7 : Visualiser graphiquement la distribution empirique
% des positions absolues (i.e., dans F0) des amers pouvant être établie
% sur la base des échantillons de Z si on suppose ponctuellement que
% x est donné.

% Visualisation graphique
figure(1);
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

% =======================================================================

% Question 9 :Sur une expérience, produire des estimés ^x et ˆx_MLE de x. 
% Tracer autour de chacun d'éux un ellipse de confiance dans lequel x doit
% théoriquement se trouver avec une probabilit´e de 99 %.
% Vérifier la plausibilité du résultat.

% Paramètres
alpha = 0.01; % 1 - Confiance

% Calcul des ellipses de confiance
ellipse_cov_hatX = ellipse(Cov_hatX, alpha);
ellipse_cov_hatX_MLE = ellipse(Cov_hatX_MLE, alpha);

% Visualisation graphique
figure;
hold on;
grid on;
title('Ellipses de confiance autour des estimateurs \hat{x} et \hat{x}_{MLE}');

% Afficher les positions réelles des amers
for i = 1:2:2 * L
    plot(Z_samples(i, :), Z_samples(i + 1, :), 'bo', 'MarkerSize', 8); % Amers réels
end

% Afficher l'estimateur \hat{x} et son ellipse de confiance
plot(estimate_hatX(1), estimate_hatX(2), 'rx', 'MarkerSize', 10);
plot(ellipse_cov_hatX(1, :), ellipse_cov_hatX(2, :), 'r-', 'LineWidth', 1.5);

% Afficher l'estimateur \hat{x}_{MLE} et son ellipse de confiance
plot(estimate_hatX_MLE(1), estimate_hatX_MLE(2), 'gx', 'MarkerSize', 10);
plot(ellipse_cov_hatX_MLE(1, :), ellipse_cov_hatX_MLE(2, :), 'g-', 'LineWidth', 1.5);

legend('Positions réelles des amers', '\hat{x} + Ellipse de confiance', '\hat{x}_{MLE} + Ellipse de confiance');

hold off;
