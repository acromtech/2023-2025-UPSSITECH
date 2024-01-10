disp('==============================================================');
disp('ETUDE DE L''ASSERVISSEMENT EN POSITION D''UN MOTEUR');
disp('==============================================================');

FIGURE1 = 0;
FIGURE2 = 0;
FIGURE3 = 0;
FIGURE4 = 0;
FIGURE5 = 0;
FIGURE6 = 0;
FIGURE7 = 0;
FIGURE8 = 0;
FIGURE9 = 0;
FIGURE10 = 1;
FIGURE11 = 1;

disp('==============================================================');
disp('Partie 1 : Analyse du système seul');
disp('==============================================================');

% Question 1 : Déterminer la fonction de transfert G0(p) entre l'entrée 
% u(t) du moteur et la vitesse de rotation omega(t) et la définir sous matlab 
% avec la fonction tf. Donner les pôles (pole), les zéros (zero) et le gain 
% statique (dcgain). Quel est le comportement attendu du système 
% (stabilité, oscillations, etc.) ?
% Tracer la réponse indicielle à l'aide de la fonction step. 
% Est-elle cohérente avec les conjec tures précédentes?

% Paramètres du système
Km = 4800;
T1 = 1.6;
T2 = 0.05;

% Fonction de transfert G0(p)
G0 = tf(Km, conv([T1 1], [T2 1]))

% Affichage des pôles, zéros et gain statique
disp('Pôles :');
disp(pole(G0));

disp('Zéros :');
disp(zero(G0));

disp('Gain statique :');
disp(dcgain(G0));

% Tracé de la réponse indicielle
if FIGURE1 == 1
    figure(1);
    step(G0);
    title('Réponse indicielle du système');
end;

% les poles negatives ==> systeme stable 
% pole strictement réel ==> pas d'oscillations
% Oui, on retrouve le gain statisue de 4800 et le systable est stable 
% (converge vers une solution finis) et sans oscillations. 

disp(['==============================================================' newline]);

% Question 2: Définir maintenant les fonctions de transfert suivantes : 
% G1(p) = Km/(1+T1p) et G2(p) = Km/ (1+T2p) Donner le gain statique, les 
% pôles et les zéros de chacune d'entre elles.
% Tracer maintenant chaque réponse indicielle et la superposer avec la 
% réponse indicielle de G0(p). Que constatez-vous? Expliquer. 

% Fonctions de transfert G1(p) et G2(p)
G1 = tf(Km, [T1 1])
G2 = tf(Km, [T2 1])

% Affichage des informations sur G1(p)
disp('G1(p):');
disp('Pôles :');
disp(pole(G1));
disp('Zéros :');
disp(zero(G1));
disp('Gain statique :');
disp(dcgain(G1));

% Affichage des informations sur G2(p)
disp('G2(p):');
disp('Pôles :');
disp(pole(G2));
disp('Zéros :');
disp(zero(G2));
disp('Gain statique :');
disp(dcgain(G2));

% Tracé des réponses indicielles
if FIGURE1 == 1
    figure(1);
    step(G0, G1, G2);
    legend('G0(p)', 'G1(p)', 'G2(p)');
    title('Réponses indicielles de G0, G1 et G2');
end

% On remarque que le pole T1 de la fonction G0 a plus d'impact que le 
% pole T2.

disp(['==============================================================' newline]);

% Question 3 : Donner la fonction de transfert via MATLAB entre theta(p) 
% et U(p) (le bloc G0(p) et le bloc (1/p) sont en série). 
% Etudier la stabilité. Tracer la réponse indicielle

% Fonction de transfert de la chaîne complète
G_complete = series(G0,tf([1], [1 0]));

% Étude de stabilité
pole_G_complete = pole(G_complete);
disp('Pôles de G_complete :');
disp(pole_G_complete);

% Tracé de la réponse indicielle
if FIGURE2 == 1
    figure(2);
    step(G_complete);
    title('Réponse indicielle de G_complete');
end

% Comme un pole est = 0 on est à la limite de la stabilité. 
% Ainsi comme il y a un risque d'voir un système instable, il semble 
% nécessaire de mettre en place une commande (P, PI, PD ou PID)

disp('==============================================================');
disp('Partie 2 : Mise en place d''une commande proportionnelle');
disp('==============================================================');

% On souhaite mettre en place une commande proportionnelle. On notera K est 
% le gain à fixer pour satisfaire les performances souhaitées. 
% La fonction de transfert du moteur entre u(t) et theta(t) est supposée 
% ici définie par G0(p)/p.

disp(['==============================================================' newline]);

% Question 1 : Rappeler le principe de la commande proportionnelle. 
% Dessiner un schénma-bloc de l'asservissement souhaité. 
% S'agit-il d'un retour d'état ou d'un retour de sortie?
% Donner l'expression de la fonction de transfert en boucle ouverte

% La commande proportionelle a pour objectif de corriger à l'aide 
% d'un gain K le système afin de modifier les poles et les zéros et 
% faire mieux réagir le système afin qu'il soit plus performant
% Ici on souhaite utiliser une première commande pour limiter 
% l'instabilité du système.

% Il s'agit d'un retour de sortie, car le contrôle est basé sur la 
% comparaison entre la sortie réelle et la consigne.

% Fonction de transfert en boucle ouverte
Kp = 9*10e-6; % A régler
G_BO = series(Kp,G_complete)

disp(['==============================================================' newline]);

% Question 2 : Déterminer la fonction de transfert, en boucle fermée
% La mettre sous forme canonique et determiner les expressions de 
% l'amortissement zeta et de la pulsation naturelle wn. 
% Préciser également le gain statique. Que déduisez-vous? 

% Le gain K dans un système d'asservissement proportionnel permet d'ajuster 
% l'amplitude de la sortie par rapport à la référence. 
% Dans le contexte de votre problème, où nous mettons en place une 
% commande proportionnelle, le gain K agit sur la boucle fermée du système.
% Voici comment le gain K influe sur le système :

% 1. Amplitude de la sortie : Augmenter le gain K augmente l'amplitude 
% de la sortie en réponse à une référence donnée.

% 2. Stabilité : Cependant, une augmentation excessive du gain peut 
% conduire à une instabilité du système. Il existe un compromis à trouver, 
% car un gain trop élevé peut entraîner des oscillations, 
% voire une instabilité, tandis qu'un gain trop faible peut entraîner 
% une réponse lente et une erreur stationnaire importante.

% 3. Temps de réponse : Le gain K peut également influencer le temps de 
% réponse du système. Une valeur plus élevée de K peut accélérer le 
% temps de réponse du système, mais il faut faire attention à ne pas 
% compromettre la stabilité.

% Paramètres du système
w0 = sqrt(Kp*Km)        % W0 = 0.6573
e=1/(2*sqrt(Kp*Km))     % e = 0.7607
% On peut jouer sur les paramètres W0 et e

% Boucle fermée (forme canonique) avec un retour unitaire
G_BF_can = tf([1],[1/w0 (2*e)/w0 1])

% Obtention des paramètres caractéristiques
[wn, zeta] = damp(G_BF_can);
dcgain_bf = dcgain(G_BF_can);

% Affichage des résultats
disp('Amortissement (zeta) :');
disp(zeta);

disp('Pulsation naturelle (wn) :');
disp(wn);

disp('Gain statique en boucle fermée :');
disp(dcgain_bf);

disp(['==============================================================' newline]);

% Question 3 : Sans calcul, que pouvez-conclure sur les erreurs de 
% position et de vitesse ?

% Sans calculs spécifiques, on peut tirer certaines conclusions générales 
% sur les erreurs de position et de vitesse dans un système 
% d'asservissement proportionnel.

% 1. Erreur de Position : Avec un gain proportionnel K plus élevé, on peut 
% généralement s'attendre à une réduction de l'erreur de position en régime 
% permanent. Cela signifie que le système tend à suivre la consigne plus 
% précisément. Cependant, il est important de noter qu'une augmentation 
% excessive de K peut entraîner un dépassement et des oscillations, ce 
% qui pourrait temporairement augmenter l'erreur de position.

% 2. Erreur de Vitesse : Un système proportionnel bien réglé peut également 
% réduire l'erreur de vitesse. Le gain proportionnel ajuste la vitesse de 
% réponse du système, ce qui peut aider à minimiser les écarts de vitesse 
% entre la consigne et la réponse réelle du système. Cependant, encore une 
% fois, une valeur de K trop élevée peut conduire à une réponse instable et 
% potentiellement augmenter l'erreur de vitesse.

% 3. Dépassement : En augmentant le gain K, on peut également observer 
% un dépassement plus important lors de la réponse à une consigne. 
% Le dépassement est la quantité par laquelle la réponse d'un système 
% dépasse initialement la consigne avant de converger vers la valeur 
% finale. Un dépassement plus important peut augmenter temporairement 
% l'erreur de position, mais cela dépend également de la tolérance 
% spécifique aux dépassements dans l'application.

disp('Pôles :');
disp(pole(G_BF_can));
disp('Zéros :');
disp(zero(G_BF_can));
% Comme on a pas de zéro une erreur de position est probable
% Comme on a 2 poles ...

disp(['==============================================================' newline]);

% Question 4 : Tracer le lieu des racines de l'asservissement pour K 
% variant de 0 à l'infini (fonction rlocus). Repérez les points de départ 
% et d'arrivée du lien. Orientez ce dernier dans le sens des valeurs de 
% K croissantes et faites apparaitre les points irnportants. 
% (Quelles conclusions en tirez-vous ?)

% Tracer le lieu des racines
if FIGURE3==1
    figure(3);
    rlocus(G_BO); 
    % ATTENTION : On passe a rltool le systeme en BOUCLE OUVERTE

    % Ajouter des points importants
    hold on;
    rlocus(G_BO, 0); % Point de départ (Kp = 0)
    rlocus(G_BO, Inf); % Point d'arrivée (Kp tend vers l'infini)
    
    % Orienter le lieu des racines dans le sens des valeurs croissantes de Kp
    axis([-2 2 -2 2]); % Ajustez les limites de l'axe si nécessaire
    
    % Légende et titre
    legend('Lieu des racines', 'Point de départ', 'Point d''arrivée');
    title('Lieu des racines en fonction de Kp');
    
    hold off;
end

% En observant le lieu des racines, on peut voir comment les pôles du 
% système se déplacent en fonction de Kp. Cela peut fournir des 
% informations sur la stabilité et la performance du système pour 
% différentes valeurs de gain proportionnel. Par exemple, si les pôles 
% se déplacent vers la gauche (vers les pôles dominants stables), cela 
% peut indiquer une amélioration de la stabilité avec une augmentation de
% Kp. Cependant, il faut s'assurer de rester dans une plage de stabilité 
% pour éviter toute instabilité.

disp(['==============================================================' newline]);

% Question 5 : Proposer une valeur de K permettant d'obtenir un 
% dépassenent d'environ 10% (fonction sgrid). 
% Retrouver ce résultat par le calcul. 
% Vérifier votre analyse en simulant la réponse indicielle de 
% l'asservissement pour certaines valeurs de K

% Spécifier le dépassement souhaité
Overshoot = 10; % En pourcentage

% Tracer le lieu des racines avec les courbes de gain et d'amortissement
if FIGURE4==1
    figure(4);
    rlocus(G_BO);
    sgrid(Overshoot/100, 0);
    % La fonction sgrid prend deux paramètres, le premier est le dépassement 
    % en pourcentage, et le deuxième est l'angle de phase en degrés. 
    % Le point où les courbes de gain et d'amortissement se croisent sur le 
    % lieu des racines suggère une valeur appropriée de K.
    
    % Ajouter des points importants
    hold on;
    rlocus(G_BO, 0); % Point de départ (Kp = 0)
    rlocus(G_BO, Inf); % Point d'arrivée (Kp tend vers l'infini)
    
    % Légende et titre
    legend('Lieu des racines', 'Courbes de gain et d''amortissement', 'Point de départ', 'Point d''arrivée');
    title('Lieu des racines avec courbes de gain et d''amortissement');
    
    hold off;
end

% Le dépassement (%OS) est lié au coefficient d'amortissement (ζ) par la
% formule : %OS=exp((-ζ*pi)/sqrt(1-ζ^2))*100

% Ainsi, en connaissant le dépassement souhaité (%OS), on peut résoudre 
% cette équation pour ζ et utiliser ensuite ζ pour déterminer K. On peut 
% également utiliser la commande stepinfo pour obtenir les caractéristiques 
% de la réponse indicielle pour différentes valeurs de K et trouver celle 
% qui répond à nos critères de performance.

disp(['==============================================================' newline]);

% Question 6 : Calculer la fonction de transfert en boucle fermée à l'aide 
% de la fonction minreal de matlab. 
% Tracer la réponse indicielle de l'asservissement (fonction step). 
% A l'aide de la commande damp, vérifier l'amortissement et la pulsation 
% naturelle de l'asservissernent. Que concluez-vous ?

% Calcul de la fonction de transfert en boucle fermée
G_BF = tf ([Kp*Km],[T1 1 Kp*Km])
G_BF_minreal = minreal(G_BF)

% Tracer la réponse indicielle
if FIGURE5==1
    figure(5);
    step(G_BF_minreal);
    title('Réponse indicielle de l''asservissement en boucle fermée');
end

% Obtention des paramètres caractéristiques
[damping_ratio, natural_freq] = damp(G_BF_minreal);
dcgain_bf_minreal = dcgain(G_BF_minreal);

% Affichage des résultats
disp('Amortissement :');
disp(damping_ratio);

disp('Pulsation naturelle :');
disp(natural_freq);

disp('Gain statique en boucle fermée :');
disp(dcgain_bf_minreal);

disp(['==============================================================' newline]);

% Question 7 : Tracer maintenant la réponse à une rampe et évaluer 
% l'erreur en vitesse. Conclure. 

% Définir la rampe comme entrée
t = 0:0.01:10;  % ajustez l'intervalle de temps si nécessaire
ramp_input = t;

% Calcul de la réponse en utilisant lsim
output = lsim(G_BF_minreal, ramp_input, t);

% Calcul de l'erreur en vitesse
velocity_error = ramp_input(end) - output(end);

% Tracer la réponse
if FIGURE6==1
    figure(6);
    plot(t, ramp_input, 'r', t, output, 'b');
    title('Réponse à une rampe');
    legend('Entrée en rampe', 'Sortie');
    xlabel('Temps');
    ylabel('Amplitude');
end

% Afficher l'erreur en vitesse
disp(['Erreur en vitesse : ' num2str(velocity_error) newline]);

% On satisfait le cahier des charges au niveau du dépassement à 10% mais
% pas au niveau des 3 secondes de temps de réponse à 5% demandé (10s).
% Pour cela on peut soit augmenter le gain -> Dérive et oscillations
% Soit ajouter un correcteur -> Mise en place d'une contre-correction
% Tachyamétrique

disp('=============================================================='); 
disp('Partie 3 : Mise en place d''une contre-réaction tachyamétrique');
disp(['==============================================================' newline]);

%              +---+    +----+    +---+            +-------------+                 +-----+
% theta*(p) ---| Σ |----| K1 |----| Σ |--- U(p) ---| Km/(1+T1*p) |--- Omega(p) --- | 1/p | ---- theta(p) --->
%              +---+    +----+    +---+            +-------------+      |          +-----+        |
%                |                  |                                   |                         |
%                |                  |                                   |                         |
%                |                  +--------------<K2<-----------------+                         |
%                |                                                                                |
%                +--------------------------------------------------------------------------------+

% Question 1 : Que remarquez-vous ?

% On remarque qu'il y a 2 gains et 2 boucles dont 1 retour d'état 
% (chaine interne) et 1 retour de sortie

disp(['==============================================================' newline]);

% Question 2 : Calculer la fonction de transfert de la boucle interne. 
% L'écrire sous la forme : G_tach(p)=K0/(p*(1+tau*p)) en précisant 
% les expressions de K0 et tau

%               +---+              +-------------+
% U(p) ---------| Σ |--------------| Km/(1+T1*p) |----- Omega(p)
%               +---+              +-------------+
%                 |                       |
%                 |                       |
%                 +---------<K2<----------+

% Paramètres du système
K1 = 1;
K2 = 1;

% Calcul des paramètres tau et K0
tau = T1/(1+K2*Km);
K0 = Km/(1+K2*Km);

% Affichage des paramètres tau et K0
disp(['Coeffiant tau : ' num2str(tau)]);
disp(['Gain statique K0 : ' num2str(K0)]);

% Calcul et affichage de la fonction de transfert G_tach
G_tach = tf([K0],[tau 1])

disp(['==============================================================' newline]);

% Question 3 : Redessiner le schéma-bloc précédent en faisant apparaître 
% explicitement G_tach(p)

%                +-------------+
%    U(p) -------| G_tach(p)   |--------- Omega(p)
%                +-------------+

disp(['==============================================================' newline]);

% Question 4 : En déduire la fonction de transfert de l'asservissement 
% F(p) = theta*(p)/theta(p). Déterminer les expressions de l'amortissement 
% zeta et de la pulsation naturelle wn. Sur quel(s) paramètre(s) agissent 
% K1 et K2?

% Calcul des fonctions de transfert en boucle ouverte et boucle fermée
G_BO_tach=tf([K0*K1],[tau 1 0])
G_BF_tach=tf([K0*K1],[tau 1 K0*K1])

% Calcul de w0_tach et e_tach
wn_tach=sqrt(K0*K1)/tau;
zeta_tach=1/(2*sqrt(K0*K1*tau));

% Affichage des paramètres tau et K0
disp(['Pulsation naturelle (wn_tach) : ' num2str(wn_tach)]);
disp(['Coefficient d''amortissement (zeta_tach) : ' num2str(zeta_tach)]);

disp(['==============================================================' newline]);

% Question 5 : Déterminer les valeurs de ces deux gains permettant de 
% satisfaire le cahier des charges. 
% Tracer la réponse indicielle et la réponse à une rampe de l'asservissement. 
% Verifier que le cahier des charges est respecté.

% Spécifications du cahier des charges
overshoot_spec = 10; % en pourcentage
settling_time_spec = 3; % en secondes

% Boucle de réglage des gains
while true
    % Calcul de tau et K0
    K0 = Km / (1 + K2 * Km);
    tau = T1 / (1 + K2 * Km);
    
    % Calcul des fonctions de transfert en boucle fermée
    G_BF_tach = tf([K0 * K1], [tau, 1, K0 * K1]);
    
    % Vérification des spécifications
    step_info = stepinfo(G_BF_tach);
    
    % Conditions de sortie de la boucle
    if step_info.Overshoot <= overshoot_spec && step_info.SettlingTime <= settling_time_spec
        break;
    end
    
    % Ajustement des gains
    K1 = K1 * 1.1; % Augmentation arbitraire
    K2 = K2 / 1.1; % Augmentation arbitraire
end

% Affichage des gains finaux
disp(['K1 final : ' num2str(K1)]);
disp(['K2 final : ' num2str(K2)]);
disp(['Dépassement : ' num2str(step_info.Overshoot) ' < 10%']);
disp(['Temps de réponse : ' num2str(step_info.SettlingTime) ' < 3s']);

% Tracé de la réponse indicielle
if FIGURE7==1
    figure(7);
    step(G_BF_tach);
    title('Réponse indicielle de l''asservissement en boucle fermée');
end

% Tracé de la réponse à une rampe (erreur de vitesse)
if FIGURE8==1
    figure(8);
    t = 0:0.01:10;
    ramp_input = t;
    lsim(G_BF_tach, ramp_input, t);
    title('Réponse à une rampe de l''asservissement en boucle fermée');
end

disp(['==============================================================' newline]);

% Question 6 : Pour la valeur de K, ainsi déter1ninée, tracer le lieu des 
% racines de l'asservissement lorsque le gain K2 varie de 0 à l'infini. 
% Conclure quant à l'effet de K2

% Valeur finale de K1 et K2 déterminée précédemment
K1_final = K1; % la valeur finale déterminée précédemment
K2_final = K2; % la valeur finale déterminée précédemment

% Calcul de tau et K0
K0_final = Km / (1 + K2_final * Km);
tau_final = T1 / (1 + K2_final * Km);

% Fonction de transfert en boucle fermée
G_BF_tach_final = tf([K0_final * K1_final], [tau_final, 1, K0_final * K1_final]);

% Tracé du lieu des racines en faisant varier K2
if FIGURE9==1
    figure(9);
    rlocus(G_BF_tach_final, linspace(0, 10, 1000));
    title('Lieu des racines en fonction de K2');
    xlabel('Partie réelle');
    ylabel('Partie imaginaire');
end

% Conclusion
disp('Conclusion :');
disp('En faisant varier K2, on peut observer les pôles du système qui se déplacent sur le plan complexe.');

disp(['==============================================================' newline]);

% Question 7 : Comment évoluent les erreurs de position et de vitesse avec 
% ces deux gains ?

% Analyse de la réponse indicielle pour l'erreur de position
[y, t] = step(G_BF_tach_final);
position_error = abs(1 - y(end)); % Erreur de position en régime permanent

% Analyse de la réponse indicielle pour l'erreur de vitesse
vitesse_error = abs(y(end) - y(end - 1)) / (t(end) - t(end - 1)); % Erreur de vitesse

% Affichage des résultats
disp(['Erreur de position : ' num2str(position_error)]);
disp(['Erreur de vitesse : ' num2str(vitesse_error)]);

disp('=============================================================='); 
disp('Pour aller plus loin');
disp(['==============================================================' newline]);

% Contre-réaction tachymétrique et retour d'état

% On souhaite maintenant comparer les structures de commande par 
% contre-réaction tachymétrique et le retour d'état évoqué en cours. 
% La représentation d'état du moteur est définie par les équations suivantes 
% \left\{\begin{array}{l}
% \dot{X}(t)=\left(\begin{array}{cc}
% 0 & 1 \\
% 0 & -\frac{1}{T_1}
% \end{array}\right) X(t)+\left(\begin{array}{c}
% 0 \\
% \frac{K_m}{T_1}
% \end{array}\right) U(t) \\
% Y(t)=X(t)
% \end{array}\right.
% où X (t) est l'état du moteur.

% ======================================================================

% Question 1 : Rappeler le schéma-bloc de principe d'un retour d'état et 
% la loi de commande associée. 

%        +------------+   +---------------+   +-------------+
% -----> |            |   |               |   |             |
%  U(t)  |   Système  |---|   Commande    |---|   Sortie    |---->
% -----> |            |   |               |   |             |
%        +------------+   +---------------+   +-------------+

% Les composants clés sont les suivants :

% 1. Système : Représente le système dynamique que nous voulons contrôler. 
% Dans ce cas, le moteur est représenté par les équations d'état fournies.

% 2. Commande : La loi de commande associée au retour d'état. Elle utilise 
% l'état interne du système pour générer la commande de sortie.

% 3. Sortie : La sortie du système, qui est comparée avec la référence 
% dans un système en boucle fermée.

% Dans le cas d'un retour d'état, la loi de commande peut être écrite 
% sous la forme générale :

% U(t) = -K * H(t) + L * R(t)

% Où :
% U(t) est la commande d'entrée,
% X(t) est le vecteur d'état du système,
% R(t) est la référence de consigne,
% K est la matrice des gains de contre-réaction,
% L est la matrice de gain du retour d'état.

% En ajustant les matrices K et L, on règle ainsi le comportement du système

% ======================================================================

% Question 2 : Écrire la loi de commande U(t) dans le cas de la 
% contre-réaction tachymétrique. Comparer sa structure à celle du retour 
% d'état. Conclure

% Dans le cas de la contre-réaction tachymétrique, la loi de commande 
% s'exprime en utilisant la mesure de la vitesse angulaire Ω(t). 
% La contre-réaction tachymétrique consiste à utiliser la mesure de la 
% vitesse pour générer une commande en rétroaction.

% La loi de commande pour la contre-réaction tachymétrique peut être 
% écrite comme suit :

% U(t) = -K_t * Omega(t) + K_r * R(t)

% Où :
% U(t) est la commande d'entrée,
% Ω(t) est la mesure de la vitesse angulaire,
% R(t) est la référence de consigne,
% K_t est le gain de contre-réaction tachymétrique,
% K_r est le gain du retour de référence.

% Comparaison avec le retour d'état :
% 1. Contre-réaction Tachymétrique :
%   * Utilisation directe de la mesure de la vitesse (Ω(t)) dans la commande.
%   * Paramètres de rétroaction tachymétrique (K_t) ajustés pour régler 
%     la réponse du système.
% 2. Retour d'État :
%   * Utilisation du vecteur d'état complet (X(t)) dans la commande.
%   * Utilisation de deux matrices de gains (K et L) pour ajuster la réponse 
%     du système.

% Conclusion :
% * La contre-réaction tachymétrique est plus spécifique à la mesure de la 
%   vitesse, tandis que le retour d'état utilise l'ensemble du vecteur d'état.
% * La structure de la contre-réaction tachymétrique est simplifiée par 
%   rapport au retour d'état, car elle ne nécessite pas de matrices de gains 
%   complexes.
% * Le choix entre ces deux approches dépend des caractéristiques spécifiques 
%   du système et des exigences de la commande.

% ======================================================================

% Question 3 : A l'aide de la fonction acker fournie dans matlab, calculer 
% le gain du retour d'état permettant d'obtenir les mêmes pôles que ceux 
% calculés précédernment. 

% Définition des matrices d'état et des gains du retour d'état
A = [0 1; 0 -1/T1];
B = [0; Km/T1];
C = eye(2);
D = zeros(2, 1);
K_state_feedback = [K1 K2]; % Remplacez par vos gains du retour d'état

% Création du modèle d'état
sys_state_space = ss(A - B * K_state_feedback, B, C, D);

% Temps de simulation
t = 0:0.01:5; % Ajustez si nécessaire

% Entrée de la simulation (par exemple, un échelon unitaire)
u = ones(size(t));

% Simulation de la réponse indicielle
y = lsim(sys_state_space, u, t);

% Tracé de la réponse indicielle
if FIGURE10==1
    figure(10);
    plot(t, y(:, 1), 'LineWidth', 2);
    title('Réponse indicielle de l''asservissement');
    xlabel('Temps (s)');
    ylabel('Position (\theta)');
    grid on;
end
% Calcul de l'erreur de position
error_position = u - y(:, 1); % Supposant que la référence est un échelon unitaire

% Tracé de l'erreur de position
if FIGURE11==1
    figure(11);
    plot(t, error_position, 'LineWidth', 2);
    title('Erreur de position');
    xlabel('Temps (s)');
    ylabel('Erreur de position');
    grid on;
end
% Affichage de l'erreur de position finale
final_error_position = error_position(end);
disp(['Erreur de position finale : ' num2str(final_error_position)]);


