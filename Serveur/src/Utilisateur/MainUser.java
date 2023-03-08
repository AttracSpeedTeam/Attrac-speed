package Utilisateur;

import Attraction.Attraction;

public class MainUser {

    public static void main (String[] args){
        //Définition des paramètre
        Administrateur admin = new Administrateur();
        Attraction attraction = new Attraction("Petit train",19);
        attraction.setLongueurFile(5);
        admin.modifierAttraction(attraction);

        Visiteur v = new Visiteur();
        v.afficherListeAttraction();
        
        


    }



}
