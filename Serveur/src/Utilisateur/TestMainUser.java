package Utilisateur;

import Attraction.Attraction;

public class TestMainUser {

    public static void main(String[] args) {

        Visiteur v=new Visiteur();
        v.creerListe("Liste1");
        v.ajouterAttractionListe("Liste1", new Attraction("Train super rapide", 10));
        v.ajouterAttractionListe("Liste1", new Attraction("Roller Cost Hour", 15));

        v.creerListe("Liste2");
        v.ajouterAttractionListe("Liste2", new Attraction("Le grand roux", 15));

        System.out.println(v.afficherListe());

    }

}
