package src;

public class Carre extends Figure{
	//Attributes
	//Constructor
	public Carre(int lig,int x,int y,char c) {
		super(lig,lig,x,y,c);
		fill();
	}
	//Methods
	public void fill() {
		for(int i=0;i<dessin.NbLigMax;i++)
			for(int j=0;j<dessin.NbColMax;j++)
				dessin.setPoint(i,j,this.c);
	}
}
