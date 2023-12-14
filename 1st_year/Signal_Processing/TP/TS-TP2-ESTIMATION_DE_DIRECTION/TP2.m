% I Estimations

% 3.
% filename = 'stereo.wav' ;
% [x,Fe]=wavread(filename);
%PlaySignal(x,Fe)

% 4.
% x1 =x(:,1);
% x2=x(:,2);
% 
% N = length(x1);
% t = (0: N-1)/Fe;
%plot(t,x1,t,x2);

% 5.
% subplot(2,1,1);
% L2 = length(x2); freq2 = (0:L2-1)/L2*Fe; X2 = fft(x2); 
% plot(freq1,20*log10(abs(X1)),freq2,20*log10(abs(X2)))
% 
% subplot(2,1,2);
% L1 = length(x1); freq1 = (0:L1-1)/L1*Fe; X1 = fft(x1);
% L2 = length(x1); freq2 = (0:L2-1)/L2*Fe; X2 = fft(x2);
% plot(freq1,angle(X1),freq2,angle(X2))
% 
% 6.
% [Cx1x2,lags]=xcorr(x1,x2);
% [Cx1,lags]=xcorr(x1,x1);
% plot(lags/Fe,Cx1x2,lags/Fe,Cx1);

% 7.
% [val1,indice1]=max(Cx1);
% [val,indice]=max(Cx1x2);
% y=lags(indice);
% y=y/Fe;
% 
% D=0.25;
% d=y*340;
% alpha=acos(d/D)*360/(2*pi);


% II. Filtrage pour ameliorer la détection du locuteur par corrélation

% II.1
% 1.
% Oui on entends clairement les perturbations

% 2.
% Non, nous n'arrivons pas à situer d'ou viens le signal dans l'espace

% 3.

[x3,Fe3]=wavread('stereo.wav');

[x4,Fe4]=wavread('stereo_bruit2.wav');
PlaySignal(x4,Fe4);
plot(t,x3,t,x4)
% Oui on voit clairement les perturbations

% 4.
L3 = length(x3); freq3 = (0:L3-1)/L3*Fe; X3 = fft(x3);
L4 = length(x4); freq4 = (0:L4-1)/L4*Fe; X4 = fft(x4);
subplot(2,1,1);
plot(freq3,abs(X3),freq4,abs(X4))
subplot(2,1,2);
plot(freq3,20*log10(abs(X3)),freq4,20*log10(abs(X4)))

% 5.
fc=5538;
fp=4600;
alphap=-1;
alphac=-20;

% II.2
% 1.
[num_a,den_a]=butterworth_lowpass(fp,fc,alphap,alphac);
ordre=length(den_a)-1;

% 2.
P=4096; freq=(0:P-1)/P*Fe/2; % Vecteur des frequences
H_a=freqs(num_a,den_a,2*pi*freq); % Réponse en fréquence
plot(freq,20*log10(abs(H_a)));
hold on; DisplayFilterSpecif(fp,fc,alphap,alphac,Fe/2); hold off;

% 3.
[num_n,den_n] = bilinear(num_a,den_a,Fe) % transformation bilinéaire

% 4.
H_n = freqz(num_n,den_n,P,Fe); % R ?eponse en fr ?equences
plot(freq ,20*log10(abs(H_n)));
DisplayFilterSpecif(fp,fc,alphap,alphac,Fe/2); hold off;