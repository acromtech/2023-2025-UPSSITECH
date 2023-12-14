/********************** 
 * QR Code recogniser
 * detects QRCodes and displays results
 *
 * updated on 24/01/2019
 */
 
import processing.video.*;
import com.google.zxing.*;
import java.awt.image.BufferedImage;

Capture cam;
com.google.zxing.Reader reader = new com.google.zxing.MultiFormatReader();
String url="";

void setup() {
 size(640, 550);
 background(0);
 PFont myFont;
 myFont = loadFont("Myriad.vlw");
 textFont(myFont, 14);
 
 cam = new Capture(this, 640, 480);
 cam.start(); // démarrer la caméra
}


void draw() {
   image(cam, 0, 0);
   try
   {
     LuminanceSource source = new BufferedImageLuminanceSource((BufferedImage)cam.getImage());
     BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));    
     Result result = reader.decode(bitmap); 
     if (result.getText() != null) 
     { 
       fill(#000000);
       rect(0,480,640,70);
       fill(#ffffff);
       
       /* is it an url? */
       String[] m = match(result.getText(),"http");
       if (m != null) {
         url = result.getText();
         /*=========================================*/
         /*===============OPEN LINKS================*/
         /*=========================================*/
         JSONObject json=parseJSONObject(url);  //Récupère le lien du JSON déja créé
         String url2=json.getString("url");     //Récupère le champs "url"
         link(url2);                            //Ouvre le lien
          /*=========================================*/
       }else
         url ="";
         
       text(result.getText(),10,500);
       
       ResultPoint[] points = result.getResultPoints();
 
       // Draw some ellipses on at the control points
       noFill();     
       
       for (int i = 0; i < points.length; i++) 
       {
         fill(#e88b10);
         ellipse(points[i].getX(), points[i].getY(), 20,20);
         fill(#0c075a);
         text(i, points[i].getX(), points[i].getY());
       }
       
     }
   } 
   catch (Exception e) {
     // println(e.toString()); 
   }   
}

void captureEvent(Capture c) {
  cam.read();  
}

void mousePressed()
{
  if (url != "")
    link(url);
}
