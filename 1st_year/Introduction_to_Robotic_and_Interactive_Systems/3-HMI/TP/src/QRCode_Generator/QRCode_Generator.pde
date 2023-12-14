/********************** 
 * QR Code Generator
 * 
 * 
 */
 
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.google.zxing.*;



com.google.zxing.Reader reader = new com.google.zxing.MultiFormatReader();
String url="";

PImage img;

void setup() {
 size(200, 200);
 background(0);
 PFont myFont;
 myFont = loadFont("Myriad.vlw");
 textFont(myFont, 14);

 BufferedImage bi = CreateQRCode("http://localhost");
 println(bi.toString());
 img = new PImage(bi);
}


void draw() {
  background(255); 
  image(img, 0,0);
}


public BufferedImage CreateQRCode(String url)
  {
    int magnify = 1;
           
    QRCodeWriter writer = new QRCodeWriter();
    BitMatrix matrix;
        
    int size = 100;
    BufferedImage im = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
    
    try
    {
      matrix = writer.encode(url, BarcodeFormat.QR_CODE, size, size, null);
 
          
      im.createGraphics();
      Graphics2D g = (Graphics2D) im.getGraphics();
      g.setColor(Color.WHITE);
      g.fillRect(0, 0, size, size);
 
      //paint the image using the ByteMatrix
      for (int h = 0; h < matrix.getHeight(); h++)
      {
        for (int w = 0; w < matrix.getWidth(); w++)
        {
          // Find the colour of the dot
          if (matrix.get(h, w) == false)
          {
            g.setColor(Color.WHITE);
          }
          else
          {
            g.setColor(Color.BLACK);
          }
          // Paint the dot
          g.fillRect(h * magnify, w * magnify, magnify, magnify);
        }
      }
    }
    catch (Exception e) {}
    return(im);
  }