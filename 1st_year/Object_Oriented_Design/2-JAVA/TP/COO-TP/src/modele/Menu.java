package modele;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	
	List<Hamburger> listeHamburger;
	List<Accompagnement> listeAccompagnement;
	List<Boisson> listeBoisson;
	
	private Menu() {
		this.listeAccompagnement = new ArrayList<>();
		this.listeBoisson = new ArrayList<>();
		this.listeHamburger = new ArrayList<>();
	}
	
	private static class MenuHolder{
		private static final Menu instance = new Menu();
	}
	
	public static Menu getInstance() {
		return MenuHolder.instance;
	}
	
	public void ajouterAliment(Hamburger hamburger) {
		this.listeHamburger.add(hamburger);
	}
	
	public void ajouterAliment(Accompagnement accompagnement) {
		this.listeAccompagnement.add(accompagnement);
	}
	
	public void ajouterAliment(Boisson boisson) {
		this.listeBoisson.add(boisson);
	}
	
	public String toString() {
		return "Menu" + "[listeHambuger = " +this.listeHamburger.toString() + ", listeBoisson = "+this.listeBoisson.toString() + ", listeAccompagnement = "+this.listeAccompagnement.toString()+"]";
	}

	public List<Hamburger> getListHamburger() {
		return this.listeHamburger;
	}

	public List<Accompagnement> getListAccompagnement() {
		return this.listeAccompagnement;
	}
	
	public List<Boisson> getListBoisson(){
		return this.listeBoisson;
	}

	public Hamburger choixHamburger(int numeroHamburger) {
		return this.listeHamburger.get(numeroHamburger-1);
	}

	public Accompagnement choixAccompagnement(int numeroAccompagnement) {
		return this.listeAccompagnement.get(numeroAccompagnement-1);
	}

	public Boisson choixBoisson(int numeroBoisson) {
		return this.listeBoisson.get(numeroBoisson-1);
	}
	
	
}
