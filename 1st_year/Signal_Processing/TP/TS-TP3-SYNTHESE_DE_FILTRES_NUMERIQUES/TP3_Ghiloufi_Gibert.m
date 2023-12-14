
% I Pr�sentation TP
% 3.
load('stereo.mat');
Fe=132300;
% L = length(x); freq = (0:L-1)/L*Fe; X = fft(x); 
% plot(freq,abs(X))
%quand on �chantiollone en freq => on periodise 
%sur le plot on represente jusqu'� Fe donc la moiti� � gauche c'est la G+d
%et la droite c'est la G-D 
%Le pic au milieu c'est la porteuse: on remarquequ'elle divis�e par deux 
%(�crit sur le sujet) freq de porteuse = 38 khz 
% On remarque que deux fr�quences se distingent en 
% - X=19000 Y=31000 porteuse � doite
% - X=113300 Y=31000 porteuse � gauche



% II.
% 5.
F0=16700;
P1=100;
n=(-P1:P1);
h_R=2*F0/Fe*sinc(2*F0*n/Fe);    % Fenetre rectangulaire
h_H=h_R.*hamming(2*P1+1)';        % Fenetre de Hamming

% 6.
% f_c=18000;
% f_p=f_c-2000;
alpha_p=1;
alpha_c=40;

% Dans le cas d'une fenetre rectangulaire :
% [H_R,freq]=freqz(h_R,1,4096,Fe);                                % Calcul de la r�ponse en fr�quence
% plot(freq,20*log10(abs(H_R)),'k-.')                             % Affichage de la r�ponse en fr�quence
% DisplayFilterSpecif(f_p,f_c,-alpha_p,-alpha_c,Fe/2); hold off   % Affichage du gabarit

% F0 d�cale le filtre +grand +d�cale vers la droite
% P1 d�cale le filtre +grand +haut
% F0=16200;
% P1=400;
% Sont les valeurs id�ales pour une fenetre rectangulaire
% N�anmoins les oscilations persistent

% Essayons maintenant avec une fenetre de Hamming :
% [H_H,freq]=freqz(h_H,1,4096,Fe);                                % Calcul de la r�ponse en fr�quence
% plot(freq,20*log10(abs(H_H)),'k-.')                             % Affichage de la r�ponse en fr�quence
% DisplayFilterSpecif(f_p,f_c,-alpha_p,-alpha_c,Fe/2); hold off   % Affichage du gabarit

% On remarque que l'odre du filtre est bien plus �lev� avec les m�me param�tres F0 et P1
% Il n'y a plus d'oscillations en fp
% De plus comme il suffit d'un P1 plus faibe pour faire rentrer le filtre
% dans le gabarit, l'ordre sera plus faible. Et on sait que plus l'odre d'un filtre est faible moins il sera couteux.

% 7.
% ordre=2*P1;     % Ordre
% retard=P1;      % Retard de phase
% propa=P1*1/Fe;  % Propagation de phase

% 8.
% Compte tenu des explications pr�c�dentes on privil�gira plutot un
% fenetrage de Hamming

% II.2
% 1.
% GplusD = filter(h_H,1,x);                                       % Filtrage du signal st�r�o avec le filtre passe bas synth�tis� (fenetrage de Hamming)
% L = length(GplusD); freq = (0:L-1)/L*Fe; X = fft(GplusD); 
% plot(freq,abs(X))
% On remarque que les fr�quences ont bien �t� supprim�es

% 2.
% PlaySignal(GplusD,Fe)
% "Broche"


% III.1
% 1.
f_p1=20000;
f_c1=54000;
f_p2=22000;
f_c2=56000;
f_port=38000;
g = 2*h_H.*cos(2*pi*f_port*(-P1:P1)/Fe);
[G,freq]=freqz(g,1,4096,Fe);                                        % Calcul de la r�ponse en fr�quence
plot(freq,20*log10(abs(G)),'k-.')                                   % Affichage de la r�ponse en fr�quence
DisplayFilterSpecif(f_p1,f_c1,-alpha_p,-alpha_c,Fe/2); hold off     % Affichage du gabarit
DisplayFilterSpecif(f_p2,f_c2,-alpha_p,-alpha_c,Fe/2); hold off     % Affichage du gabarit

% On remarque que le filtre passe bande passe bien dans le gabarit, il
% satisfait donc nos attentes

% 2.
% ordre=2*P1;     % Ordre
% retard=P1;      % Retard de phase
% propa=P1*1/Fe;  % Propagation de phase


