function [num,den] = butterworth_lowpass(f_p,f_c,alpha_p,alpha_c)
%BUTTERWORTH_LOWPASS : Butterworth analog lowpass filter prototype.
%
%   [NUM,DEN] = BUTTERWORTH_LOWPASS(f_p,f_c,alpha_p,alpha_c)
%   forms the transfer function of a Butterworth analog lowpass filter
%   from the characteristics f_p, f_c, alpha_p, alpha_c of its prototype
%                    NUM(p)
%            H(p) = -------- 
%                    DEN(p)
%   Vectors NUM and DEN are returned with numerator and denominator 
%   coefficients in descending powers of p 

% H. Carfantan 1-04-2020
if alpha_p>0, alpha_p=-alpha_p; end
if alpha_c>0, alpha_p=-alpha_c; end

% Calcul de l'ordre du filtre passe-bas (formule du cours p. 24)
n = ceil(1/2*(log(10^(abs(alpha_c)/10)-1)-log(10^(abs(alpha_p)/10)-1))/(log(f_c)-log(f_p)))
% Calcul de la fréquence de coupure à -3dB du filtre passe-bas (formule du cours p. 24)
f_0 = f_p/(10^(abs(alpha_p)/10)-1)^(1/(2*n))
w_0 = 2*pi*f_0;

% Poles are on the unit circle in the left-half plane.
z = [];
p = exp(1i*(pi*(1:2:n-1)/(2*n) + pi/2));
p = [p; conj(p)];
p = p(:);
if rem(n,2)==1   % n is odd
    p = [p; -1];
end
k = real(prod(-p));

% H. Carfantan 14-12-2017
% Add the 2 arguments output case [NUM,DEN] = BUTTAP(N) 
% and the 2nd argument input [NUM,DEN] = BUTTAP(N,w_c) 
   [num, den] = zp2tf(z,p,k);
   num = num./(w_0.^(n:-1:0));
   den= den./(w_0.^(n:-1:0));