FIGURE1=1;
FIGURE2=1;
FIGURE3=1;
FIGURE4=1;
FIGURE5=1;

% Question 1 : Invoquer séquentiellement simulationDonnees.m de façon à
% exécuter un nombre N suffisamment élevé d'expériences aléatoires.
% Stocker les réalisations (ou "échantillons") de Z obtenues sur ces
% expériences. Noter la valeur de σ.

N = 1000; % Nombre d'expériences aléatoires
L = 5; % Nombre d'amers

% Préallocation de la matrice pour stocker les réalisations de Z
Z_samples = zeros(2 * L, N);

% Appels séquentiels à la fonction simulationDonnees
for i = 1:N
    % Modifier le dernier argument de la fonction selon votre cas d'étude
    [Z,L,m,H,Hfull,bar_v,C_v,x] = simulationDonnees(1,0);

    % Stocker la réalisation de Z dans la matrice
    Z_samples(:, i) = Z;
end

% Calculer la valeur de σ à partir des réalisations de Z
sigma_estimate = std(Z_samples(:));

% Afficher la valeur de σ
disp(['Valeur de σ : ' num2str(sigma_estimate)]);

% =======================================================================

% Question 2 : Visualiser graphiquement :
% (a) les distributions empiriques des échantillons des sous-vecteurs
%       Zl, l = 1, . . . , L ;
% (b) leur cohérence avec les lois théoriques des
%       Zl, l = 1, . . . , L ;
% (c) la distribution empirique des positions absolues (i.e., dans F0)
% des amers pouvant être établie sur la base des échantillons de Z si
% on suppose ponctuellement que x est donné.

% (a) Distributions empiriques des échantillons des sous-vecteurs Zl
if FIGURE1==1
    figure(1);
    for l = 1:L
        subplot(L, 1, l);
        histogram(Z_samples(l, :), 'Normalization', 'pdf', 'EdgeColor', 'k', 'FaceColor', [0.5 0.5 0.5]);
        title(['Distribution empirique de Z_' num2str(l)]);
    end
    sgtitle('Distributions empiriques des sous-vecteurs Zl');
end

% (b) Cohérence avec les lois théoriques des Zl
if FIGURE2==1
    figure(2);
    for l = 1:L
        subplot(L, 1, l);

       % Plot de la densité de probabilité théorique (loi normale)
        x_values = linspace(mean(Z_samples(l, :)) - 3 * std(Z_samples(l, :)), mean(Z_samples(l, :)) + 3 * std(Z_samples(l, :)), 100);
        pdf_values = normpdf(x_values, mean(Z_samples(l, :)), std(Z_samples(l, :)));
        plot(x_values, pdf_values,'r','LineWidth', 2);

        % Superposer l'histogramme empirique pour comparaison
        hold on;
        histogram(Z_samples(l, :), 'Normalization', 'pdf', 'EdgeColor', 'k', 'FaceColor', [0.5 0.5 0.5]);

        title(['Cohérence de Z_' num2str(l) ' avec la loi normale']);
        legend('Loi théorique', 'Distribution empirique');
        hold off;
    end
    sgtitle('Cohérence avec les lois théoriques des Zl');
end

% (c) Distribution empirique des positions absolues des amers
% Visualisation graphique
if FIGURE3==1
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

% =======================================================================

% Question 4 : Sur une expérience, produire un estimé ˆx de x. Tracer
% autour de ˆx un ellipse de confiance dans lequel x doit théoriquement
% se trouver avec une probabilité de 99 %. V´erifier la plausibilité du
% résultat.

% Calcul de l'estimation ^x
hat_x = mean(Z_samples, 2);

% Calcul de la matrice de covariance Cov^X
Cov_hat_X = cov(Z_samples');

% Sélectionner une expérience pour l'analyse
experience_index = 1; % Choisissez l'indice de l'expérience que vous souhaitez analyser

% Extraire les résultats de cette expérience
Z_experiment = Z_samples(:, experience_index);
hat_x_experiment = hat_x;
Cov_hat_X_experiment = Cov_hat_X;

% Calculer les valeurs propres et vecteurs propres de la matrice de covariance
[~, D] = eig(Cov_hat_X_experiment);

% Calculer les angles associés aux vecteurs propres
angles = atan2(D(2, 2), D(1, 1));

% Calculer les demi-axes de l'ellipse de confiance
confidence_level = 0.99;
radius_x = sqrt(chi2inv(confidence_level, 2)) * sqrt(D(1, 1));
radius_y = sqrt(chi2inv(confidence_level, 2)) * sqrt(D(2, 2));

% Paramètres pour tracer l'ellipse de confiance
theta = linspace(0, 2 * pi, 100);
ellipse_x = hat_x_experiment(1) + radius_x * cos(theta);
ellipse_y = hat_x_experiment(2) + radius_y * sin(theta);

if FIGURE4==1
    % Tracer l'estimé ^x et l'ellipse de confiance pour l'expérience sélectionnée
    figure(4);
    scatter(Z_samples(1, :), Z_samples(2, :), 'g.');    % Tracer les mesures pour toutes les expériences
    hold on;
    plot(Z_experiment(1), Z_experiment(2), 'rx', 'MarkerSize', 10, 'LineWidth', 2); % Mesure de l'expérience sélectionnée
    plot(hat_x_experiment(1), hat_x_experiment(2), 'ko', 'MarkerSize', 10, 'LineWidth', 2); % Estimé ^x pour l'expérience sélectionnée
    plot(ellipse_x, ellipse_y, 'b', 'LineWidth', 1); % Ellipse de confiance pour l'expérience sélectionnée
    hold off;

    % Titres et légendes
    title('Estimation ^x, Ellipse de Confiance et Mesures');
    xlabel('Position en u');
    ylabel('Position en v');
    legend('Mesures (Toutes les expériences)','Mesure (Expérience sélectionnée)', 'Estimé ^x (Expérience sélectionnée)', 'Ellipse de Confiance (Expérience sélectionnée)', 'Location', 'Best');
end

% Calculer la distance euclidienne entre chaque mesure et l'estimation ^x
distances = sqrt((Z_samples(1, :) - hat_x_experiment(1)).^2 + (Z_samples(2, :) - hat_x_experiment(2)).^2);

% Calculer le nombre de mesures à l'intérieur de l'ellipse de confiance
inside_ellipse = distances < radius_x & distances < radius_y;
percentage_inside_ellipse = sum(inside_ellipse) / numel(inside_ellipse) * 100;

% Afficher le pourcentage dans la console
fprintf('Pourcentage de mesures dans l''ellipse de confiance : %.2f%%\n', percentage_inside_ellipse);

% =======================================================================

% Question 5 : Par exploitation des échantillons de Z sur plusieurs
% résultats d'expériences, visualiser la distribution empirique des
% estimés ˆx de x. Vérifier qu'elle est cohérente avec la loi théorique
% de X.

% Calculer les estimés ^X pour chaque ensemble d'échantillons
estimated_X_samples = mean(m - Z_samples, 1);

% Calculer la loi théorique ^X
theoretical_X = mean(m - mean(Z_samples, 2));

% Afficher la distribution empirique des estimés ^X
if FIGURE5==1
    figure(5);
    histogram(estimated_X_samples, 'Normalization', 'pdf', 'EdgeColor', 'k', 'FaceColor', [0.5 0.5 0.5]);
    hold on;

    % Tracer la valeur théorique ^X
    plot([theoretical_X theoretical_X], [0 30], 'r', 'LineWidth', 2);

    hold off;

    % Titres et légendes
    title('Distribution empirique des estimés ^X');
    xlabel('Estimation ^X');
    ylabel('Fréquence relative');
    grid on;
    legend('Distribution empirique', 'Valeur théorique ^X', 'Location', 'Best');
end

