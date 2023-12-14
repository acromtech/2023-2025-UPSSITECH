package src;
import java.util.ArrayList;
import java.util.Random;

public class MyCustomSet {
	/*attributs*/
	private ArrayList<Integer> Liste;
	private Random r = new Random();
	
	/*constructeur*/
	public MyCustomSet() {
		this.Liste = new ArrayList<>();
	}
	
	/*m�thodes*/
	public void add (int x) {
		if(Liste.contains(x)==false) Liste.add(x);
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
		String s = "";
		for(int i=0;i<size();i++)
			s=s+Liste.get(i)+"-";
		return s;
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
		//return Liste.equals(e);
		
	}
}
