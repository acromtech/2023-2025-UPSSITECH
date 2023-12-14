function PlaySignal(x,Fs,S,AAF)
% PlaySignalOnline Play sound when using matlab Online
%
%    PlaySignal(x,Fs) sends the signal in vector x with sample frequency
%    of Fs Hertz to audio device.
%
%    PlaySignal(x,Fs,S) sends the S time subsampled signal in vector x 
%
%    PlaySignal(x,Fs,S,1) sends the S time subsampled signal in vector x 
%    filtered with an Anti-Aliasing filter to audio device. 

% H. Carfantan 30/11/2011
% Modifié le 3/11/2015 pour prendre en compte les signaux stéréo

  if nargin<3,
      S = 1; 	% Default subsampling factor
      AAF = 0; 	% Default : non Anti-Aliasing Filter
  elseif nargin<4,
      AAF = 0;	% Default : non Anti-Aliasing Filter
  end
  [L,C] = size(x);
  if L>C
      x = x'; % line vectors
      L=C;
  end
  if L>2
      error('Only one- and two-channel audio supported.')
  end
  
  % Synthèse d'un filtre passe-bas (Anti-repliement et reconstruction)
  if S>1,
    Wp =.9/S; Rp = 1; Ws =1/S; Rs = 60;
    [N, Wn] = cheb2ord(Wp, Ws, Rp, Rs);
    [b, a] = cheby2(N,Rs, Ws);
  end
  if ((AAF==1) & (S>1)), % Filtering with an Anti-Aliasing Filter
      fprintf('listening to signal subsampled with a factor %d with AAF filtering\n',S)
      for k =1:C, % C = 2 pour un signal stéréo
        x(k,:) = filter(b,a,x(k,:)); x(k,:) = x(k,:)/max(x(k,:))*.99;
      end
  else
      fprintf('listening to signal subsampled with a factor %d without AAF filtering\n',S)
  end

if 0
% Ecoute à différentes fréquences d'échantillonnage : à éviter
% Peut poser des problème car les cartes sons sont prévues pour fonctionner
% à certaines fréquences d'échantillonnage seulement
% En écoutant à la fréquence d'échantillonnage la plus proche compatible
% avec la carte on, cela provoque des accélérations ou ralentissement du signal

% Subsampling  
  signal = x(:,1:S:end);
  
% Play signal
%   if ispc % Windows version of Matlab
% 	 wavplay(signal,Fs/S,'sync'); 
%   else % Linux version of Matlab
%      p = audioplayer(signal,Fs/S); 
%      playblocking(p);
%      clear p
%   end
  sound(signal,Fs/S); 
else
% Ecoute à la même fréquence d'échantillonnage que le signal original
% par sous-échantillonnage et filtrage passe-bas
% Subsampling
  y = zeros(size(x));
  y(:,1:S:end) = x(:,1:S:end);
  if S>1,
     for k =1:C, % C = 2 pour un signal stéréo
        y(k,:) = filter(b,a,y(k,:))*S;
     end
  end
% Play signal
%   if ispc % Windows version of Matlab
% 	 wavplay(y,Fs,'sync'); 
%   else % Linux version of Matlab
      maxy = max(abs(y));
      if maxy>1, y = y/maxy; end
%      p = audioplayer(y,Fs); 
%      playblocking(p);
%      clear p
%   end
sound(y,Fs); 
duration = length(y)/Fs;
pause(ceil(duration));

end
