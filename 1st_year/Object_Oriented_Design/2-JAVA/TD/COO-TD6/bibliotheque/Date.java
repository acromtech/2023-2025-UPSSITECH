package bibliotheque;

public class Date implements Comparable<Date> {
	int annee;
	int mois;
	int jour;

	public Date(int jour, int mois, int annee) {
		this.jour = jour;
		this.mois = mois;
		this.annee = annee;
	}

	@Override
	public boolean equals(Object objet) {
		if (objet instanceof Date) {
			Date date = (Date) objet;
			return (annee == date.annee && jour == date.jour && mois == date.mois);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return 31 * annee + 31 * mois + 31 * jour;
	}

	public int compareTo(Date date) {
		int comparaison = annee - date.annee;
		if (comparaison == 0)
			comparaison = mois - date.mois;
		if (comparaison == 0)
			comparaison = jour - date.jour;
		return comparaison;
	}

	@Override
	public String toString() {
		return jour + "/" + mois + "/" + annee;
	}

}
