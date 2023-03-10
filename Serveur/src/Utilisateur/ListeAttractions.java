package Utilisateur;

import Attraction.Attraction;

import java.util.ArrayList;
import java.util.List;

/**
 * liste d'attractions composée par un utilisateur, représentée par son nom
 */
public class ListeAttractions {

    /**nom de la liste*/
    String nom;
    /**liste d'attractions de la liste*/
    List<Attraction> lAttractions;

    /**
     * constructeur par defaut d'une liste
     * @param nom nom de la liste
     */
    public ListeAttractions(String nom) {
        this.nom=nom;
        this.lAttractions=new ArrayList<Attraction>();
    }

    /**
     * constructeur vide, initialise les attributs
     */
    public ListeAttractions() {
        this.nom="";
        this.lAttractions=new ArrayList<Attraction>();
    }

    /**
     * ajoute une attraction à la liste
     * @param a attraction à ajouter
     */
    public void ajoutAttraction(Attraction a){
        this.lAttractions.add(a);
    }

    /**
     * supprime une attraction à la liste
     * @param a attraction à supprimer
     */
    public void supprimerAttraction(Attraction a){
        this.lAttractions.remove(a);
    }

    /*
    ********************
    * GETTERS ET SETTERS
    ********************
    */

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
