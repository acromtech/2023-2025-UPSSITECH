package src;
import java.util.ArrayList;
import java.util.Random;

public class MyCustomSet {
	/*Attributes*/
	protected ArrayList<Integer> Liste;
	private Random r = new Random();
	
	/*Constructor*/
	public MyCustomSet() {
		this.Liste = new ArrayList<>();
	}
	
	public MyCustomSet(MyCustomSet m) {
		this.Liste = new ArrayList<>();
		for(int i=0;i<m.size();i++) {
			this.Liste.add(m.get(i));
		}
	}
	
	/*Methods*/
	public void add (int x) {
		if(!Liste.contains(x)) Liste.add(x);
	}
	public int size() {
		return Liste.size();
	}
	public boolean isEmpty () {
		return Liste.isEmpty();
	}
	public void remove (int x) {
		if(Liste.contains(x)) Liste.remove(Liste.indexOf(x));
	}
	public boolean contains (int x) {
		return Liste.contains(x);
	}
	public String toString () {
		return ("l'ensemble contient "+Liste.size()+" entier(s) :"+Liste.toString());
	}
	public void clear() {
		Liste.clear();
	}
	public int random() {
		if(!Liste.isEmpty()) return Liste.get(r.nextInt(size()));
		else return -1;
	}
	public boolean equals(Object e) {
		MyCustomSet E=(MyCustomSet) e;
		if(E.Liste.size()!=Liste.size()) return false;
		int j=0;
		for(int i=0;i<Liste.size();i++) if(contains(E.Liste.get(i))) j++;
		if(j!=Liste.size()) return false;
		return true;
	}
	public Integer get(int i) {
		if(i>=0 && i<Liste.size())return Liste.get(i);
		else return null;
	}
}
