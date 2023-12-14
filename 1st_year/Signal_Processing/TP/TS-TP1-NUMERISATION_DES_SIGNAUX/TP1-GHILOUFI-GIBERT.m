% GROUPE TP : GHILOUFI GIBERT
%%
filename = 'signal0.wav' ;
[X,Fe]=audioread(filename); %Fe=48000
audioinfo(filename); %N=16

PlaySignal(X,Fe,10)
%On fait varier S entre 2 et 10 et on constate que le son est de plus en
%plus �touff�. A partir de S=5 on sens vraiment un changement surtout au
%d�but du son. Modifications produites par repliement spectral car il y a
%des fr�quences > FS/2S (th�oriquement mais pas evident en pratique).
%Les hautes fr�quences ont d�ja �t� supprim� par le sous-�chantillonage, on
%a gard� que les basses fr�quences.

PlaySignal(X,Fe,10,1)
%Avec un filtre anti-repliement le signal semble un peu plus clair mais il n'est pas
%�vident. D'un point de vue th�orique le filtre anti-repliement ne change plus les fr�quences du signal

%Affiche le signal entre 0 et Fe
L = length(x); freq = (0:L-1)/L*Fe; X = fft(x); plot(freq,abs(X))

%Affiche le signal entre -Fe/2 et Fe/2
freq = ((0:L-1)-floor(L/2))/L*Fe; plot(freq,fftshift(abs(X)))

%Sur le trac� on observe fmax=3955 qui v�rifie bien le th�or�me de Shanon
%(Fe >=2fmax) puisque 48000 > 7910
%Ainsi comme Fe = 48000 -> fmax doit �tre inf�rieur � Fe/2=24000


%%
filename2 = 'signal1.wav' ;
[y,Fs]=audioread(filename2); %Fe=44100
audioinfo(filename2); %N=16

PlaySignal(y,Fs,10)
%On fait varier S entre 2 et 10 et on constate comme un d�calage du signal.
%A partir de S=4 on sens vraiment un changement dans le signal
%Modifications produites par repliement spectral car il y a
%des fr�quences > FS/2S

PlaySignal(y,Fs,10,1);
%Avec un filtre anti-repliement les hautes fr�quences ont �t� coup�es. Ces
%fr�quences ont �t� repli�es.

%Affiche le signal entre 0 et Fe
L = length(y); freq = (0:L-1)/L*Fs; X = fft(y); plot(freq,abs(X))

%Affiche le signal entre -Fe/2 et Fe/2
freq = ((0:L-1)-floor(L/2))/L*Fe; plot(freq,fftshift(abs(X)))

%Sur le trac� on observe fmax=545 qui v�rifie bien le th�or�me de Shanon
%(Fe >=2fmax) puisque 44100 > 545
%Th�oriquement comme Fe = 44100 -> fmax doit �tre inf�rieur � Fe/2=22050


%III Quantification
%%
load('SignalQuantif.mat');
b=quanti(x,10);
PlaySignal(b,Fe)
%Plus le nombre de bit est �lev� moins il y a de bruit
%Apr�s �coute du fichier son avec plusieurs valeurs de N on d�termine que lorsque N<5 on entend du bruit
%En d'autres termes l'erreur de quantification se limite � la plage de
%valeur 1<N<5
%Dans la plage 4<=N<=6 On ressent bien une am�lioration (x6) comme le
%prouve la formule du RSBQ=6N+cste

%IV Echantillonage
%1.
%%
load('SignalReconst.mat');

%Repr�sentaton temporelle du signal
subplot(2,1,1);
plot(t,x);
title ('Repr�sentaton temporelle du signal');

%Repr�sentaton fr�quentielle du signal
subplot(2,1,2);
L = length(x); freq = (0:L-1)/L*Fe; X = fft(x); plot(freq,abs(X));
title ('Repr�sentaton fr�quentielle du signal');

%2.
%%
Fe=1 ;
S=2;
y = zeros(size(x)); y(1:S:end) = x(1:S:end);
subplot(2,1,1);
plot(t,y);
subplot(2,1,2);
L = length(y); freq = (0:L-1)/L*Fe; X = fft(y); plot(freq,abs(X))

%3.
%%
% Pour S=2 et Fe=1 -> fmax=0.12
% Si S est trop grand on rique d'avoir des replis spectraux
% Si Fe est fixe -> faire varier le facteur de sous-echantillonage S pour eviter les replis
% spectraux

%4
%%
