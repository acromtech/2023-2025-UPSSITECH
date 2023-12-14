package musee;

public class Paire<T, U> {
	private final T premier;
	private final U second;
	
	public Paire(T premier, U second){
		this.premier = premier;
		this.second = second;
	}
	
	public T getPremier() {
		return premier;
	}
	
	public U getSecond() {
		return second;
	}
}
