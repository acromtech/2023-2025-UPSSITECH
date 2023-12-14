package src;

public class Rectangle extends Figure{
	//Attributes
	//Constructor
	public Rectangle(int lig,int col,int x,int y,char c) {
		super(lig,col,x,y,c);
		fill();
	}
	//Methods
	public void fill() {
		for(int i=0;i<dessin.NbLigMax;i++)
			for(int j=0;j<dessin.NbColMax;j++)
				dessin.setPoint(i,j,this.c);
	}
}
