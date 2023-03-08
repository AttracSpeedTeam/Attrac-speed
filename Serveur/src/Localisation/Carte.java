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
		Position pos1 = this.attractions.get(a1);
		Position pos2 = this.attractions.get(a2);
		int x = Math.abs(pos1.getPosX() - pos2.getPosX());
		int y = Math.abs(pos1.getPosY() - pos2.getPosY());
		int distance = (int) Math.ceil(Math.sqrt(x*x + y*y));
		return distance;
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
}
