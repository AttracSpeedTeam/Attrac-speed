package Attraction;

import java.io.Serializable;

public class Attraction implements Serializable {
	private String nom;
	//temps en secondes
	private int tempsAttente;
	private int tempsEntreChaqueAttrac;
	private int nbPlaces;


	private int longueurFile;
	
	public Attraction(String n, int p, int t) {
		this.nom = n;
		this.nbPlaces = p;
		this.tempsEntreChaqueAttrac = t;
		this.longueurFile = 0;
		this.tempsAttente = 0;
	}

	public void calculerTempsAttente() {
		int temps = (int) Math.ceil(this.nbPlaces * tempsEntreChaqueAttrac / nbPlaces); 
		this.tempsAttente = temps;
	}
	
	public void majLongueurFile(int l) {
		this.longueurFile = l;
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
				"\n tempsEntreChaqueAttraction=" + tempsEntreChaqueAttrac + 
				"\n nbPlaces=" + nbPlaces +
				"\n longueurFile=" + longueurFile +
				"\n}";
	}
}
