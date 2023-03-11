package Attraction;

import java.io.Serializable;

/**
 * classe représentant une attraction
 */
public class Attraction implements Serializable {
	/**nom de l'attraction*/
	private String nom;
	/**temps en secondes d'attente actuelle de l'attraction*/
	private int tempsAttente;
	/** nombre de places dans un wagon de l'attraction */
	private int nbPlacesWagon;
	/**temps en secondes entre chaque wagons de l'attraction*/
	private int tempsEntreChaqueWagon;
	/**longueur en mètres de la file d'attendre*/
	private int longueurFile;

	/**
	 * constructeur par defaut d'une attraction
	 * @param n nom de l'attraction
	 * @param p nombre de places dans un wagon
	 * @param t temps (s) entre chaque wagons
	 */
	public Attraction(String n, int p, int t) {
		this.nom = n;
		this.nbPlacesWagon = p;
		this.tempsEntreChaqueWagon = t;
		this.longueurFile = 0;
		this.tempsAttente = 0;
	}

	/**
	 * actualisation de l'attribut tempsAttente
	 * par la longueur de la file
	 */
	private void calculerTempsAttente() {
		int longueur = this.longueurFile;
		int temps = -this.tempsEntreChaqueWagon;
		while (longueur > 0) {
			temps += tempsEntreChaqueWagon;
			longueur -= nbPlacesWagon;
		}
		this.tempsAttente = temps;
	}

	/**
	 * mise à jour de la longueur de la file
	 * puis calcule du temps d'attente
	 * @param longueurFile
	 */
	public void majLongueurFile(int longueurFile) {
		this.longueurFile = longueurFile;
		calculerTempsAttente();
	}

	/*
	********************
	* GETTERS ET SETTERS
	********************
	*/
	public String getNom() {
		return this.nom;
	}

	public int getTempsAttente() {
		return tempsAttente;
	}

	public int getNbPlacesWagon() {
		return nbPlacesWagon;
	}

	public int getLongueurFile() {
		return longueurFile;
	}

	@Override
	public String toString() {
		return nom+": {"+
				"\n tempsAttente=" + tempsAttente +
				"\n nbPlaces=" + nbPlacesWagon +
				"\n tempsEntreChaqueAttrac" + tempsEntreChaqueWagon +
				"\n longueurFile=" + longueurFile +
				"\n}";
	}
}