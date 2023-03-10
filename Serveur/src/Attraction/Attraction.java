package Attraction;

import java.io.Serializable;

public class Attraction implements Serializable {
	private String nom;
	private int tempsAttente;
	private int nbPlaces;
	private int tempsEntreChaqueAttrac;
	private int longueurFile;
	
	public Attraction(String n, int p, int t) {
		this.nom = n;
		this.nbPlaces = p;
		this.tempsEntreChaqueAttrac = t;
		this.longueurFile = 0;
		this.tempsAttente = 0;
	}

	public void calculerTempsAttente() {
		int longueur = this.longueurFile;
		int temps = -this.tempsEntreChaqueAttrac;
		while (longueur > 0) {
			temps += tempsEntreChaqueAttrac;
			longueur -= nbPlaces;
		}
		this.tempsAttente = temps;
	}

	public void majLongueurFile(int longueurFile) {
		this.longueurFile = longueurFile;
		calculerTempsAttente();
	}

	public String getNom() {
		return this.nom;
	}

	public int getTempsAttente() {
		return tempsAttente;
	}

	public int getNbPlaces() {
		return nbPlaces;
	}

	public int getLongueurFile() {
		return longueurFile;
	}

	@Override
	public String toString() {
		return nom+": {"+
				"\n tempsAttente=" + tempsAttente +
				"\n nbPlaces=" + nbPlaces +
				"\n tempsEntreChaqueAttrac" + tempsEntreChaqueAttrac +
				"\n longueurFile=" + longueurFile +
				"\n}";
	}
}
