package Localisation;

import java.util.HashMap;
import java.util.Map;

public class Carte {
	
	public Map<String,Position> attractions;
	
	public Carte() {
		this.attractions = new HashMap<String,Position>();
	}
	
	public void calculerDistance(String a1, String a2) {}
	
	public void ajouterAttraction(String n, Position p) {
		this.attractions.put(n, p);
	}
	
	public void supprimerAttracion(String n) {
		this.attractions.remove(n);
	}
	
	public void modifierAttraction(String n, Position p) {
		this.attractions.replace(n,p);
	}
}
