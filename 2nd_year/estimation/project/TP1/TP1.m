% -------------------------------------------
% TP1 - Introduction aux variables aléatoires
% -------------------------------------------

% Question 1
N=2000;
% x=randn(1,N);
% [counts,centers] = hist(x,100);
% bar(centers,counts/N/(centers(2)-centers(1)));
% Plus on augmente le nombre d'échantillons plus on aura une gaussienne
% proche de la réalité et avec un taux d'erreur faible.

% Question 2
% hold on
pas=0.1
% moyenne=0
% variance=1
% norm_theo = normpdf(min(x) : pas :max(x),moyenne,variance)
% plot(min(x):pas:max(x),norm_theo,'g','LineWidth',2)

% % Question 3
Y=10+sqrt(2)*x;
moy_y=mean(Y);
var_y=var(Y);
% 
% % Afficher les résultats
% disp(['Moyenne de Y : ' num2str(moy_y)]);
% disp(['Variance de Y : ' num2str(var_y)]);
% Question 4
[counts,centers] = hist(Y,100);
bar(centers,counts/N/(centers(2)-centers(1)));
hold on
moyenne_y=10
variance_y=sqrt(2)
norm_theo_y = normpdf(min(Y) : pas :max(Y),moyenne_y,variance_y)
plot(min(Y):pas:max(Y),norm_theo_y,'g','LineWidth',2)
% En ce qui concerne la question de savoir si on peut retrouver les moments 
% de Y à partir de son histogramme, en théorie, oui. Les moments de Y 
% peuvent être estimés à partir des réalisations de Y et comparés avec les 
% valeurs théoriques. Cependant, l'exactitude de cette estimation dépend de 
% la taille de l'échantillon et de la qualité de l'estimation. Un échantillon
% plus grand donnera généralement une estimation plus précise des moments.
% Dans notre cas c'est bien 10

% Question 5
% Nombre de réalisations
N = 1000;
% Générer des réalisations de X1,1 et X1,2
X1_1 = randn(1, N);
X1_2 = randn(1, N);
% Stocker les réalisations dans une matrice X1
X1 = [X1_1; X1_2];

% Question 6
% Visualiser les réalisations (optionnel)
figure;
scatter(X1(1, :), X1(2, :), 'o');
xlabel('X1,1');
ylabel('X1,2');
title('Réalisations de X1');

% Question 7
% Générer des réalisations de X2,1 et X2,2
X2_1 = 10 + sqrt(2) * randn(1, N); % Loi Gaussienne de moyenne 10 et de variance 2
X2_2 = 2 + sqrt(0.2) * randn(1, N); % Loi Gaussienne de moyenne 2 et de variance 0.2
% Créer une nouvelle figure pour le nuage de points 2D de X2
figure;
scatter(X2_1, X2_2, 'o');
xlabel('X2,1');
ylabel('X2,2');
title('Nuage de points 2D de X2');

% Question 8
% Nombre de réalisations
N = 1000;
% Générer des réalisations de X1,1 et X1,2
X1_1 = randn(1, N);
X1_2 = randn(1, N);
% Valeurs de 'a'
a_values = [1, 5];
% Initialiser la matrice X3
X3 = zeros(2, N, length(a_values));
% Former la matrice X3 pour chaque valeur de 'a'
for i = 1:length(a_values)
 a = a_values(i);
 X3(1, :, i) = X1_1; % x3,1 = x1,1
 X3(2, :, i) = X1_2 + a * X1_1; % x3,2 = x1,2 + a*x1,1
end
% % Visualiser les réalisations (optionnel)
% figure;
% for i = 1:length(a_values)
% subplot(1, length(a_values), i);
% scatter(X3(1, :, i), X3(2, :, i), 'o');
% xlabel('X3,1');
% ylabel('X3,2');
% title(['a = ' num2str(a_values(i))]);
% end

% Question 9
