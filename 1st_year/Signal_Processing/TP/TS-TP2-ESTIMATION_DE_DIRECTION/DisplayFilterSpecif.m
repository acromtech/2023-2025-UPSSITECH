function DisplayFilterSpecif(fp,fs,Rp,Rs,fmax)

% DisplayFilterSpecif(f_p,f_c,alpha_p,alpha_s[,fmax])
%
%    Display the filter design specifications of a filter 
%    that loses no more than Rp dB in the passband and 
%    has at least Rs dB of attenuation in the stopband, for example
%    alpha_p = -1, alpha_c = -40;
%
%    f_p and f_c are the passband and stopband edge frequencies, for example,
%        Lowpass:    f_p = .1,      f_c = .2
%        Highpass:   f_p = .2,      f_c = .1
%        Bandpass:   f_p = [.2 .7], f_c = [.1 .8]
%        Bandstop:   f_p = [.1 .8], f_c = [.2 .7]
%    fmax is the highest frequency of the graph

% H. Carfantan 25/10/2008

% default fmax frequency
if (( nargin == 4) | fmax<max(max(fs), max(fp)))
    fmax = max(fs)+max(fp);
end

holdfig = ishold;
if Rp<0, Rp = -Rp; end
if Rs<0, Rs = -Rs; end

if (Rp>Rs)
    help DisplayFilterSpecif
    error('DisplayFilterSpecif parameters Rp and Rs do not define a filter specification');
end
% low-pass & high pass filter
if ( (length(fp)==1) & (length(fs)==1) )
    if (fs>fp)  % low-pass
      Gabf=[ 0  fp(1) fp(1);  fs(1) fs(1) fmax];
      GabH=[-Rp -Rp -Rs;    0   -Rs   -Rs];
    else % High-pass
      Gabf=[ 0  fs(1) fs(1);  fp(1) fp(1) fmax];
      GabH=[-Rs -Rs 0;    -Rs   -Rp   -Rp];
    end
elseif ( (length(fp)==2) & (length(fs)==2) )
    if ( (fs(1)>fp(1)) &  (fs(2)<fp(2)) ) % band-stop
        Gabf=[ 0  0   fp(1) fp(1);  fs(1) fs(1) fs(2) fs(2); fp(2) fp(2) fp(2) fmax];
        GabH=[-Rp -Rp -Rp   -Rs;    -Rp   -Rs   -Rs   -Rp ;  -Rs   -Rs   -Rp   -Rp];
    elseif ( (fs(1)<fp(1)) &  (fs(2)>fp(2)) ) % band-pass
        Gabf=[ 0  0   fs(1) fs(1);  fp(1) fp(1) fp(2) fp(2); fs(2) fs(2) fs(2) fmax];
        GabH=[-Rs -Rs -Rs   0;    -Rs   -Rp   -Rp   -Rs ;  0   -Rs   -Rs   -Rs];
    else
        help DisplayFilterSpecif
        error('DisplayFilterSpecif parameters fp and fs do not define a filter specification');
    end
else
    help DisplayFilterSpecif
    error('DisplayFilterSpecif parameters fp and fs do not define a filter specification');
end
      
hold on; plot(Gabf',GabH','r');
if ~holdfig; hold off; end 
grid on

      
