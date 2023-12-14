N = 100;
Fe = 1000;
f0 = 95;

% 3.
%subplot(2,1,1);
t=(0:N-1)/Fe;
%plot(t,sin(2*pi*f0*t));

%subplot(2,1,2);
freq=(0:N-1)/N*Fe; X = fft(sin(2*pi*f0*t));
%plot(freq,abs(X));

% 4. Peut-on ainsi retrouver les fréquences et amplitudes du signal analogique initial `a partir de cette repr ?esentation ?
% Oui
% On remarquera que pour retrouver l’amplitude il faut diviser la TFD par un facteur N
% Facteur N=1/2

% 5. Calculer la fréquence a laquelle elle est maximale et l’amplitude correspondante
% Pour f0=100 on a fmax=100 et A=50
% Pour f0=95 on a fmax=90 et A=32.95

% 6. Calculer l’erreur en fréquence
% 95-90=5Hz

% 7. Calculer l’erreur en amplitude
[v_max,ind]=max(abs(X)); %32,58
err = abs (v_max /N - 1/2);
err_amp = err /0.5 %0.3482 
err_percent=err_amp*100
% Pour f0=100 et N=100 err=0
% Pour f0=100 et N=1000 err=0
% Pour f0=95 et N=100 err=0.3482
% Pour f0=95 et N=1000 err=0
% Pour f0=99.5 et N=100 err=0.0025
% Pour f0=99.5 et N=1000 err=0.3620

% 11. Tout comme en théorie nous avons une erreur en fréquence de 5Hz en
% pratique

% 12. 
% f0=(k0*Fe/N)

% 13.
% En cours on à 36% et en pratique on est a 34% -> pas loin
% Elle vérifie la propriété prédite par le théorie

% III.
% 2.
x=sin(2*pi*f0*t);
M=10*N;
X_ZP=fft(x,M);
freq_ZP=(0:M-1)/M*Fe;
hold on 
plot(freq_ZP,abs(X_ZP))
stem(freq,abs(X));
hold off
% Le signal échantilloné est fidèle au signal analogique de départ grâce au
% nombre élévé d'échantillons M (10 fois plus élevé)
% On revient toujours sur la théorie que f0 est un multiple de Fe/M ce qui
% est la cas de f0=100 et f0=95

% 3.
% x=sin(2*pi*f0*t);
% M=2*N;
% X_ZP=fft(x,M);
% freq_ZP=(0:M-1)/M*Fe;
% hold on
% plot(freq_ZP,abs(X_ZP))
% stem(freq,abs(X));
% hold off
% [v_max,ind]=max(abs(X_ZP)); %32,58
% err = abs (v_max /N - 1/2);
% err_amp = err /0.5; %0.3482 
% err_percent=err_amp*100;


% % IV
% % 3.
% w_r=ones(1,N);
% w_h=hanning(N);
% M=10*N; 
% freq_ZP=(0:M-1)/M*Fe;
% Wh = fft(w_h,M); 
% Wr = fft(w_r,M); 
% hold on
% plot(freq_ZP,20*log10(abs(Wh)));
% plot(freq_ZP,20*log10(abs(Wr)));
% hold off
% En terme visuel on remarque que le lobe principal dans le cadre d'un
% fenetrage rectangulaire est 2 fois moins large que celui de hanning. De
% plus on remarque que le fenetrage rectangulaire ne supprime pas les lobes
% secondaires (>0) alors que le fentrage de hanning, si.
% En d'autres termes : on remarque que la fenetre de hanning réduit les lobes latéraux de la
% réponse en fréquence de la TFSD par rapport à la fenetre rectangulaire
% Cela permet d'obtenir une meilleure résolution en fréquence et une
% meilleure précision en amplitude pour les composantes spectales du signal
% 
% % 4.
% x=sin(2*pi*f0*t);
% 
% X_ZP=fft(x,M);
% x_h=x.*w_h';
% X_h = fft(x_h,M);
% hold on
% stem(freq,abs(X_h));
% plot(freq_ZP,abs(X_ZP));
% hold off