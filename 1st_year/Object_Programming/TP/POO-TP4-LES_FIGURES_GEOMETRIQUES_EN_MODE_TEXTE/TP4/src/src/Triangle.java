package src;

public class Triangle extends Figure {
	//Attributes
	//Constructor
	public Triangle(int lig,int x,int y,char c) {
		super(lig/2+1,lig,x,y,c);
		fill();
	}
	//Methods
	public void fill() {
		for(int i=this.dessin.NbLigMax-1,tmp=0; i>=0;i--,tmp++)
			for(int j=tmp; j<this.dessin.NbColMax-tmp;j++)
				dessin.setPoint(i,j,c);
	}
}
