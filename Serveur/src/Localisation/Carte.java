package Localisation;

import java.util.HashMap;
import java.util.Map;

import Attraction.Attraction;

public class Carte {
	
	public Map<Attraction,Position> attractions;
	
	public Carte() {
		this.attractions = new HashMap<Attraction,Position>();
	}
	public int calculerDistance(Attraction a1, Attraction a2) {
		Position p1 = this.attractions.get(a1);
		Position p2 = this.attractions.get(a2);
		int x = Math.abs(p1.getPosX()-p2.getPosX());
		int y = Math.abs(p1.getPosY()-p2.getPosY());
		return (int) Math.round(Math.sqrt((x*x)+(y*y)));
	}
	
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
