package src;

public abstract class Figure{
	//Attributes
	Dessin dessin;
	int x,y;
	char c;
	
	//Constructor
	public Figure(int lig, int col, int x, int y, char c) {
		this.dessin=new Dessin(lig,col);
		this.x=x;
		this.y=y;
		this.c=c;
	}
	
	//Methods
	public abstract void fill();
	public String toString() {
		return dessin.toString();
	}
}
