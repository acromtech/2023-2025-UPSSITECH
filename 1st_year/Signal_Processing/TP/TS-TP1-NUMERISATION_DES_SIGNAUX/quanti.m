function xq = quanti(x,N);
% quanti quantisation of a signal
%
%   y = quanti(x,N) return the signal x with values approximated coding it 
%   with N bits (quantization).

% H. Carfantan 30/11/2011

M = max(abs(x))*(1+eps);
q = M/2^(N-1);
xq = q*round((x+q/2)/q)-q/2;
