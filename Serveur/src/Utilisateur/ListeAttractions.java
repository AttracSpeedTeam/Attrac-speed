package Utilisateur;

import Attraction.Attraction;

import java.util.ArrayList;
import java.util.List;

/**
 * liste d'attractions composée par un utilisateur, représentée par son nom
 */
public class ListeAttractions {

    String nom;
    List<Attraction> lAttractions;

    public ListeAttractions(String nom) {
        this.nom=nom;
        this.lAttractions=new ArrayList<Attraction>();
    }

    public ListeAttractions() {
        this.nom="";
        this.lAttractions=new ArrayList<Attraction>();
    }

    public void ajoutAttraction(Attraction a){
        this.lAttractions.add(a);
    }

    public void supprimerAttraction(Attraction a){
        this.lAttractions.remove(a);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Attraction> getlAttractions() {
        return lAttractions;
    }

    public void setlAttractions(List<Attraction> lAttractions) {
        this.lAttractions = lAttractions;
    }

    @Override
    public String toString() {
        StringBuilder res= new StringBuilder();



        return nom+": {" +
                "\n Attractions=\n " + lAttractions.toString() +
                "\n}\n";
    }
}
