package Localisation;

import java.util.HashMap;
import java.util.Map;

import Attraction.Attraction;

public class Carte {
	
	public Map<Attraction,Position> attractions;
	
	public Carte() {
		this.attractions = new HashMap<Attraction,Position>();
	}
	
	public void calculerDistance(Attraction a1, Attraction a2) {}
	
	public void ajouterAttraction(Attraction n, Position p) {
		this.attractions.put(n, p);
	}
	
	public void supprimerAttracion(Attraction n) {
		this.attractions.remove(n);
	}
	
	public void modifierAttraction(Attraction n, Position p) {
		this.attractions.replace(n,p);
	}
}
