import Attraction.Attraction;
import Utilisateur.ListeAttractions;
import org.junit.Test;
import org.junit.*;

/**
 * class de test des fonctionnalités utilisateur
 */
class UtilisateurTest {

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
    }

    /**
     * ajout d'une attraction correct
     */
    @Test
    void ajoutAttractionCorrect() {

        //init données
        Attraction attraction=new Attraction("NomAttraction",20);
        ListeAttractions listeAttractions=new ListeAttractions();

        //utilisation methode
        listeAttractions.ajoutAttraction(attraction);

        //verification

    }

    @Test
    void supprimerAttraction() {
    }
}