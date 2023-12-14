package src;

public class Horaire {
	//Attributes
	protected int heure;
	protected int minute;
	
	//Constructor
	public Horaire (int heure, int minute) throws ExceptionTP2 {
		if(horaireExistePas(heure,minute)) throw new ExceptionTP2(0); // code 0 = Invalid
		this.heure = heure;
		this.minute = minute;
	}
	
	public Horaire(Horaire horaire) {
		this.heure = horaire.heure;
		this.minute = horaire.minute;
	}
	
	//Methods
	public boolean horaireExistePas(int heure, int minute) {
		return (heure<0 || heure>23 || minute<0 || minute>59);
	}
	public boolean apres(Horaire horaire) {
		return(this.heure>horaire.heure 
				|| (this.heure==horaire.heure && this.minute>horaire.minute));
	}
	public boolean equals(Horaire horaire) {
		return (this.heure==horaire.heure && this.minute==horaire.minute);
	}
	public String toString(){
		String ret = this.heure+":"+this.minute;
		return (ret);
	}
}
