K_e=10;
K_s = 10;
K_g = 0.105;
K_m = 5.619;
T_m = 0.336 ;
K_1 = 1 ;
K = K_1*K_m*K_s;
A = 9*T_m ;

M = tf([K],[A 9 0]);
G = tf([0 0 K],[A 9 K]);
margin (G);

p = tf('p');
M = ( K_1*K_m*K_s) / (9*T_m*p^2 + 9*p);
rltool (M)