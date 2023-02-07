package Utilisateur;

import Attraction.Attraction;

public class MainUser {

    public static void main (String[] args){
        //Définition des paramètre
        Administrateur admin = new Administrateur();
        Attraction attraction = new Attraction("Petit train",6);
        attraction.setLongueurFile(18);
        admin.modifierAttraction(attraction);

    }



}
