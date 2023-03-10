package Utilisateur;

import Attraction.Attraction;

public class MainUser {

    public static void main (String[] args){
        //Définition des paramètre
        Administrateur admin = new Administrateur();
        Attraction attraction = new Attraction("Petit train",19);
        attraction.setLongueurFile(5);
        admin.modifierAttraction(attraction);

        Attraction attraction2 = new Attraction("Bus magique sans rail",89);
        admin.ajouterAttractionBDD(attraction2);

        Visiteur v = new Visiteur();
        v.afficherListeAttraction();

        admin.retirerAttraction("Bus magique sans rail");
        v.afficherListeAttraction();
        
        


    }



}
