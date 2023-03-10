package Tests;

import Attraction.Attraction;
import Utilisateur.ListeAttractions;
import Utilisateur.Utilisateur;
import Utilisateur.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * class de test des fonctionnalités utilisateur
 */
public class UtilisateurTest {

    /**
     * creation d'une liste sur un visiteur
     */
    @Test
    public void creerListe() {
        //init données
        Utilisateur user=new Visiteur();

        //utilisation methode
        user.creerListe("NomListe");

        //verification
        assertEquals("NomListe",user.getListeParNom("NomListe").getNom());
    }

    /**
     * modification d'un nom d'une liste
     */
    @Test
    public void modifierNomListe() {
        //init données
        Utilisateur user=new Visiteur();
        user.creerListe("NomListe");

        //utilisation methode
        user.modifierNomListe("NomListe","NouveauNomListe");

        //verification
        //nouveau nom liste présent ?
        assertEquals("NouveauNomListe",user.getListeParNom("NouveauNomListe").getNom());
        //seule liste existante ?
        assertEquals(1,user.getMesListesDeAttractions().size());
    }

    /**
     * suppression d'une liste d'un utilisateur
     */
    @Test
    public void supprimerListe() {
        //init données
        Utilisateur user=new Visiteur();
        user.creerListe("NomListe");

        //utilisation methode
        user.supprimerListe("NomListe");

        //verification
        assertEquals(0,user.getMesListesDeAttractions().size());
    }

    /**
     * ajout d'une attraction dans une liste d'un utilisateur
     */
    @Test
    public void ajouterAttractionListe() {
        //init données
        Utilisateur user=new Visiteur();
        user.creerListe("NomListe");
        Attraction attraction=new Attraction("NomAttraction",20,30);

        //utilisation methode
        user.ajouterAttractionListe("NomListe",attraction);

        //verification
        assertEquals(attraction,user.getListeParNom("NomListe").getlAttractions().get(0));
    }

    //TODO
    @Test
    public void connaitrePosition() {
    }

    /**
     * index de l'attraction correct
     */
    @Test
    public void indexOfListeAttractions() {
        //init données
        Attraction attraction1=new Attraction("NomAttraction1",20,30);
        Attraction attraction2=new Attraction("NomAttraction2",10,20);
        Attraction attraction3=new Attraction("NomAttraction3",20,30);
        Attraction attraction4=new Attraction("NomAttraction4",10,20);

        Utilisateur user=new Visiteur();
        user.creerListe("NomListe1");
        user.creerListe("NomListe2");

        user.ajouterAttractionListe("NomListe1",attraction1);
        user.ajouterAttractionListe("NomListe1",attraction2);
        user.ajouterAttractionListe("NomListe2",attraction3);
        user.ajouterAttractionListe("NomListe2",attraction4);


        //utilisation methode
        int i=user.indexOfListeAttractions(user.getListeParNom("NomListe2"));

        //verification
        assertEquals(1,i);
    }

    /**
     * ajout d'une attraction correct
     */
    @Test
    public void ajoutAttractionCorrect() {
        //init données
        Attraction attraction=new Attraction("NomAttraction",20,30);
        ListeAttractions listeAttractions=new ListeAttractions();

        //utilisation methode
        listeAttractions.ajoutAttraction(attraction);

        //verification
        assertEquals(attraction, listeAttractions.getlAttractions().get(0));
    }

    /**
     * suppression d'une attraction correct
     */
    @Test
    public void supprimerAttractionCorrect() {
        //init données
        Attraction attraction1=new Attraction("NomAttraction1",20,30);
        Attraction attraction2=new Attraction("NomAttraction2",10,20);
        ListeAttractions listeAttractions=new ListeAttractions();

        listeAttractions.ajoutAttraction(attraction1);
        listeAttractions.ajoutAttraction(attraction2);

        //utilisation methode
        listeAttractions.supprimerAttraction(attraction1);

        //verification 1 seule attraction restante
        assertEquals(1, listeAttractions.getlAttractions().size());
    }
}