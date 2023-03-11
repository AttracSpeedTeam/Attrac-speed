package Localisation;

import java.util.HashMap;
import java.util.Map;

import Attraction.Attraction;

/**
 * classe représentant la carte du parc d'attraction
 */
public class Carte {

	/**
	 * Map des positions de chaque attractions
	 */
	public Map<Attraction,Position> attractions;

	/**
	 * constructeur par defaut, initialisation attribut
	 */
	public Carte() {
		this.attractions = new HashMap<Attraction,Position>();
	}

	/**
	 * calcul de la distance en mètres entre 2 attractions par rapport à leur position
	 * @param a1 attraction 1
	 * @param a2 attraction 2
	 * @return distance en mètres
	 */
	public int calculerDistance(Attraction a1, Attraction a2) {
		Position p1 = this.attractions.get(a1);
		Position p2 = this.attractions.get(a2);
		int x = Math.abs(p1.getPosX()-p2.getPosX());
		int y = Math.abs(p1.getPosY()-p2.getPosY());
		return (int) Math.round(Math.sqrt((x*x)+(y*y)));
	}

	/*
	********************
	* GETTERS ET SETTERS
	********************
	*/

	public void ajouterAttraction(Attraction n, Position p) {
		this.attractions.put(n, p);
	}
	
	public void supprimerAttracion(Attraction n) {
		this.attractions.remove(n);
	}
	
	public void modifierAttraction(Attraction n, Position p) {
		this.attractions.replace(n,p);
	}

	public Position getPosition(Attraction a){ return this.attractions.get(a); }
}
