int LONGUEUR_CARTE=200;
int LARGEUR_CARTE=300;
int LONGUEUR_TABLE=1000;
int LARGEUR_TABLE=500;
int PAS_QUADRILLAGE=70;
int NB_CARTE=5;
int PAS_CARTE=50;

PImage img;
int indiceDeplacement=0;
int etat;


void settings() {
  fullScreen(P3D);
  //size(LONGUEUR_IMAGE,LARGEUR_IMAGE,P3D); // créer une fenêtre de taille 400x300
}

void setup(){ // initialiser le sketch
}
  
void draw(){ // boucle infinie de dessin
  background(100);
  
  fill(51);
  stroke(255);
  rectMode(CENTER);
  translate(width/2, height/2,10);
  rotateX(PI/8);
  rect(0,0,LONGUEUR_TABLE,LARGEUR_TABLE,100);
  
  
  for(int i=0;i<NB_CARTE;i++){
    fill(51);
    stroke(255);
    rectMode(CENTER);
    translate(width/2+PAS_CARTE,height/2+PAS_CARTE,30);
    rotateX(PI/8);
    rect(0,0,LONGUEUR_CARTE,LARGEUR_CARTE,10);
  }
}
