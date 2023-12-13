et = [];
z = [];
X = [];
Y = [];
for i = 1 : 50
  [Z,L,m,H,Hfull,bar_v,C_v,x] = simulationDonnees(1,0);
  z=horzcat(z,Z);
  % on doit extraire les donnés x et y pour les afficher dans un plot et ainsi afficher les approximations des balises
  % les données étant de la forme [x1,y1,x2,y2,x3,y3,x4,y4,x5,y5]
end
et=sqrt(C_v)(1,1)
z


