package Attraction;

public class Attraction {
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
	
	public void calculerTempsAttente() {}
	
	public void majLongueurFile(int l) {
		this.longueurFile = l;
	}
}
