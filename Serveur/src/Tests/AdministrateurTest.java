package Tests;

import Attraction.Attraction;
import Utilisateur.Administrateur;
import Utilisateur.Visiteur;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.w3c.dom.Attr;

import static org.junit.Assert.*;

public class AdministrateurTest {

    static Administrateur admin;
    static Attraction attraction;
    static Attraction attraction2;
    static Attraction attraction3;

    @BeforeClass
    public static void beforeClass() throws Exception {
        admin = new Administrateur();
        attraction = new Attraction("Petit train", 19,20);
        attraction.majLongueurFile(5);

        attraction2 = new Attraction("Bus magique sans rail", 89,20);
        attraction3 = new Attraction("Le pic piquant", 5,20);

    }

    @Test
    public void modifierAttraction() {
        assertTrue(admin.modifierAttraction(attraction));
    }


    @Test
    public void ajouterAttractionBDD() {
        assertTrue(admin.ajouterAttractionBDD(attraction2));
    }

    @Test
    public void retirerAttraction() {
        admin.ajouterAttractionBDD(attraction3);
        assertTrue(admin.retirerAttraction("Le pic piquant"));
    }

    @Test
    public void modifImpossible(){
        Attraction attraction4 = new Attraction("Petit rat", 59,20);
        assertFalse(admin.modifierAttraction(attraction4));
    }

}