function drawcercle (x0,y0,r,couleur)

% Trace du cercle de centre (x0,y0) et de rayon r.

theta=0;
i=1;
n=20;

while theta<=2*pi

  x(i)=x0+r*cos(theta);
  y(i)=y0+r*sin(theta);
  theta=theta+pi/n;
  i=i+1;

end

hold on;
plot(x,y,couleur);

