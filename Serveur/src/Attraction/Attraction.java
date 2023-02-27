package Attraction;

import java.io.Serializable;

public class Attraction implements Serializable {
	private String nom;
	private int tempsAttente;
	private int nbPlaces;



	private int longueurFile;
	
	public Attraction(String n, int p) {
		this.nom = n;
		this.nbPlaces = p;
		this.longueurFile = 0;
		this.tempsAttente = 0;
	}

	public void setTempsAttente(int tempsAttente) {
		this.tempsAttente = tempsAttente;
	}

	public void setLongueurFile(int longueurFile) {
		this.longueurFile = longueurFile;
	}

	public void calculerTempsAttente() {}
	
	public void majLongueurFile(int l) {
		this.longueurFile = l;
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
				"\n longueurFile=" + longueurFile +
				"\n}";
	}
}
