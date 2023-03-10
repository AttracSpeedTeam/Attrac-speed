package Tests;

import Attraction.Attraction;
import Utilisateur.ListeAttractions;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.*;

/**
 * class de test des fonctionnalités utilisateur
 */
class UtilisateurTest {

    /**
     * Convertir void en boolean et effectuer try catch dans les cas ou on ne peut pas tester une récuperation style <get>
     * */

    @Test
    void creerListe() {



    }

    @Test
    void modifierNomListe() {
    }

    @Test
    void supprimerListe() {
    }

    @Test
    void ajouterAttractionListe() {
    }

    @Test
    void connaitrePosition() {
    }

    @Test
    void afficherListe() {
    }

    @Test
    void getListeParNom() {
    }

    @Test
    void indexOfAttraction() {

        //init données
        ListeAttractions liste =  ajoutAttractionCorrect();

        //verification
        //assertEqual(!-1, indexOfAttraction(liste));
    }

    /**
     * ajout d'une attraction correct
     */
    @Test
    ListeAttractions ajoutAttractionCorrect() {

        //init données
        Attraction attraction=new Attraction("NomAttraction",20);
        ListeAttractions listeAttractions=new ListeAttractions();

        //utilisation methode
        listeAttractions.ajoutAttraction(attraction);
        System.out.println(listeAttractions.getlAttractions());

        //verification
        assertEquals(attraction, listeAttractions.getlAttractions());

        return listeAttractions;
    }

    @Test
    void supprimerAttraction() {

        //init données
        ajoutAttractionCorrect();

        //utilisation methode
        supprimerAttraction();

        //verification
        //assertEquals(null, listeAttractions.getlAttractions());
    }
}