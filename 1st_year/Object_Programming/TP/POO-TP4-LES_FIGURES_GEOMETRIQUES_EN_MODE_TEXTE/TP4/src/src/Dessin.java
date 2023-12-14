package src;
public class Dessin {
	//Attributes
	int NbLigMax,NbColMax;
	char[][] dessin;
	
	//Constructors
	public Dessin(int NbLigMax,int NbColMax) {
		this.NbLigMax=NbLigMax;
		this.NbColMax=NbColMax;
		dessin=new char[NbLigMax][NbColMax];
		for(int i=0;i<NbLigMax;i++)
			for(int j=0;j<NbColMax;j++)
				dessin[i][j]='.';
	}
	
	//Methods
	public void setPoint(int nl,int nc,char c) {
		if(nl<this.NbLigMax && nc<this.NbColMax && nl>=0 && nc>=0)this.dessin[nl][nc]=c;
	}
	public char getPoint(int nl,int nc) throws IllegalArgumentException{
		if(nl<0 || nc<0 || nl>=this.NbLigMax || nc>=this.NbColMax) throw new IllegalArgumentException();
		return this.dessin[nl][nc];
	}
	public String toString() {
		String s="";
		for(int i=0;i<this.NbLigMax;i++) {
			for(int j=0;j<this.NbColMax;j++)
				s+=this.dessin[i][j];
			s += '\n';
		}
		return s;
	}
}
