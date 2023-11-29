function y = syst(x,h,sigma2);
% Fonction syst
%       y = syst(x,h,sigma2);
%
% Calcule la sortie bruitée du système de réponse impulsionnelle h pour une
% entrée donnée x et un bruit blanc Gaussien
% 
% Entrées : x, signal d'entrée du système
%           h, réponse impulsionnelle de durée finie du système
%           sigma2, variance du bruit (par défaut sigma2 = 0.4).
%
% Sortie : y, signal de sortie de même longueur que le signal d'entrée
%
% Attention, l'amplitude de l'entrée doit être inférieure ou égale à 1,
% sinon elle est seuillée (non linéarité du modèle).

% H. Carfantan, février 2012

if nargin<3,
    sigma2 = 0.4;
end

ind = find(abs(x)>1+eps);
if length(ind),
    warning('Le signal d''entrée doit être inférieur à 1 pour ne pas subir de seuillage');
    x(ind) = sign(x(ind));
end

y = conv(x,h); y = y(1:length(x));
y = y + sqrt(sigma2)*randn(size(y));
