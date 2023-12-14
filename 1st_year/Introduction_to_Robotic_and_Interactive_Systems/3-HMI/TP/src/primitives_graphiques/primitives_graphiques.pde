/* Variables "globales" du sketch [En réalité, attributs de la classe PApplet] */
color GREEN = color(0,255,0);
color BLUE = color(0,0,255);
color SEMI_TRANSPARENT_RED = color(255,0,0,120);
color BLACK = color(0,0,0);
color WHITE = color(255,255,255);
color ORANGE = color(255,215,0);
color GREY = color(199,199,199);

int LONGUEUR_IMAGE=1000;
int LARGEUR_IMAGE=1000;
int PAS_QUADRILLAGE=70;

PImage img;
int indiceDeplacement=0;
int etat;
PFont font;    // "data" directory to load successfully

void settings() {
  size(LONGUEUR_IMAGE,LARGEUR_IMAGE,P3D); // créer une fenêtre de taille 400x300
}

void setup(){ // initialiser le sketch
  img=loadImage ("image.jpg");                     //Vérifier que l'image est bien dans le répertoire data 
  font = loadFont("Poppins-Bold-48.vlw");    //Vérifier que la police est bien dans le répertoire data 
}
  
void draw(){ // boucle infinie de dessin
  
  /*====================================*/
  /*============TRACE CIRCLE============*/
  /*====================================*/
  /*
  circle(x, y, extent)
    x  (float)  x-coordinate of the ellipse
    y  (float)  y-coordinate of the ellipse
    extent  (float)  width and height of the ellipse by default
  */
  /*
  fill(GREEN);           //Rempli la forme en vert
  circle(200,200,100);   //Création d'un cercle
  */
  
  /*====================================*/
  /*============TRACE SQUARE============*/
  /*====================================*/
  /*
  square(x, y, extent)
    x  (float)  x-coordinate of the rectangle by default
    y  (float)  y-coordinate of the rectangle by default
    extent  (float)  width and height of the rectangle by default
  */
  /*
  fill(BLUE);            //Rempli la forme en bleu
  square(50,50,100);     //Création d'un carré
  */

  /*====================================*/
  /*==========TRACE TRIANGLE============*/
  /*====================================*/
  /*
  triangle(x1, y1, x2, y2, x3, y3)  
    x1  (float)  x-coordinate of the first point
    y1  (float)  y-coordinate of the first point
    x2  (float)  x-coordinate of the second point
    y2  (float)  y-coordinate of the second point
    x3  (float)  x-coordinate of the third point
    y3  (float)  y-coordinate of the third point
  */
  /*
  fill(SEMI_TRANSPARENT_RED);       //Rempli la forme en rouge transparent
  triangle(40,20,250,150,80,250);   //Création d'un triangle
  */
  
  
  /*====================================*/
  /*============TRACE LIGNE=============*/
  /*====================================*/
  /*
  line(x1, y1, x2, y2)  
  line(x1, y1, z1, x2, y2, z2)
    x1  (float)  x-coordinate of the first point
    y1  (float)  y-coordinate of the first point
    x2  (float)  x-coordinate of the second point
    y2  (float)  y-coordinate of the second point
    z1  (float)  z-coordinate of the first point
    z2  (float)  z-coordinate of the second point
  */
  
  /*====================================*/
  /*======MANIPULATION GRAPHIQUE========*/
  /*====================================*/
  /*
  stroke(255);
  strokeWeight(1);
  for(int j=0;j<LARGEUR_IMAGE;j=j+PAS_QUADRILLAGE)
    line(0,j,-1,LONGUEUR_IMAGE,j,-1);
  for(int i=0;i<LONGUEUR_IMAGE;i=i+PAS_QUADRILLAGE)
    line(i,0,-1,i,LARGEUR_IMAGE,-1);
   
  noStroke();
  fill(ORANGE);
  circle(PAS_QUADRILLAGE*1,PAS_QUADRILLAGE*1,PAS_QUADRILLAGE);  
  fill(GREY);
  circle(PAS_QUADRILLAGE*2,PAS_QUADRILLAGE*1,PAS_QUADRILLAGE);
  fill(ORANGE);
  circle(PAS_QUADRILLAGE*5,PAS_QUADRILLAGE*2,PAS_QUADRILLAGE);
  
  stroke(0);
  strokeWeight(1);
  line(0,0,-1,PAS_QUADRILLAGE*4,PAS_QUADRILLAGE*4,-1);
  line(PAS_QUADRILLAGE*2,PAS_QUADRILLAGE*1,1,PAS_QUADRILLAGE*4,PAS_QUADRILLAGE*3,1);
  strokeWeight(2);
  line(PAS_QUADRILLAGE*4,PAS_QUADRILLAGE*3,1,PAS_QUADRILLAGE*5,PAS_QUADRILLAGE*2,1);
  */
  
  /*====================================*/
  /*=======MANIPULATION D'IMAGE=========*/
  /*====================================*/
  /*
  image(img,indiceDeplacement,0);
  if(indiceDeplacement==LARGEUR_IMAGE) etat=0;
  else if(indiceDeplacement==0) etat=1;
  if(etat==0) indiceDeplacement--;
  if(etat==1) indiceDeplacement++;
  */
  /*====================================*/
  /*============TYPOGRAPHIE=============*/
  /*====================================*/
  /*
  textFont(which)  
  textFont(which, size)  
    which  (PFont)  any variable of the type PFont
    size  (float)  the size of the letters in units of pixels
  */
  textFont(font,48);
  text("Chat test !",40,60,1);
  text("Chat test !",600,60+100,1);
  text("Chat test !",40,60+100*2,1);
  text("Chat test !",600,60+100*3,1);
  text("Chat test !",40,60+100*4,1);
  /*
  text(c, x, y)  
  text(c, x, y, z)  
  text(str, x, y)  
  text(chars, start, stop, x, y)  
  text(str, x, y, z)  
  text(chars, start, stop, x, y, z)  
  text(str, x1, y1, x2, y2)  
  text(num, x, y)  
  text(num, x, y, z)  
    c  (char)  the alphanumeric character to be displayed
    x  (float)  x-coordinate of text
    y  (float)  y-coordinate of text
    z  (float)  z-coordinate of text
    chars  (char[])  the alphanumeric symbols to be displayed
    start  (int)  array index at which to start writing characters
    stop  (int)  array index at which to stop writing characters
    x1  (float)  by default, the x-coordinate of text, see rectMode() for more info
    y1  (float)  by default, the y-coordinate of text, see rectMode() for more info
    x2  (float)  by default, the width of the text box, see rectMode() for more info
    y2  (float)  by default, the height of the text box, see rectMode() for more info
    num  (float, int)  the numeric value to be displayed
  */
  
  
  
}
  
