package Utilisateur;

import Attraction.Attraction;

public class MainUser {

    public static void main (String[] args){
        //Définition des paramètre
        Administrateur admin = new Administrateur();
        Attraction attraction = new Attraction("Petit train",19,60);
        attraction.majLongueurFile(5);
        admin.modifierAttraction(attraction);

        Visiteur v = new Visiteur();
        v.afficherListeAttraction();

    }



}
