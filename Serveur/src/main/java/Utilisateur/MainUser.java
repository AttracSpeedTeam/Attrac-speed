package Utilisateur;

import Attraction.Attraction;

public class MainUser {

    public static void main (String[] args){
        //Définition des paramètre
        Administrateur admin = new Administrateur();
        Attraction attraction = new Attraction("Petit train",19,20,41,12,true);
        attraction.majLongueurFile(45);
        admin.modifierAttraction(attraction);

        Attraction attraction2 = new Attraction("Bus magique sans rail",89,20);
        admin.ajouterAttractionBDD(attraction2);

        admin.afficherListeAttraction();


        Visiteur v = new Visiteur();
        v.afficherListeAttraction();

        admin.retirerAttraction("Bus magique sans rail");
        v.afficherListeAttraction();
        
        


    }



}
