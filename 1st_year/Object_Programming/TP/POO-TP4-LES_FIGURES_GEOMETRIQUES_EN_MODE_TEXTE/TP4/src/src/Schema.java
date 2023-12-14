package src;
import java.util.ArrayList;

public class Schema {
	//Attributes
	private ArrayList<Figure> f;
	protected Dessin dessin;
	//Constructor
	public Schema(int NbLigMax, int NbColMax){
		this.dessin=new Dessin(NbLigMax,NbColMax);
		this.f=new ArrayList<>();
	}
	//Methods
	public String toString() {
		return dessin.toString();
	}
	public void ajout(Figure f) {
		this.f.add(f);
		for(int i=0;i<f.dessin.NbLigMax;i++)
			for(int j=0;j<f.dessin.NbColMax;j++)
				this.dessin.setPoint(i+f.x,j+f.y,f.dessin.getPoint(i,j));
	}
}