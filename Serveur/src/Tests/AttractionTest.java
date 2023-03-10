package Tests;

import Attraction.Attraction;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AttractionTest {

    Attraction a1 = new Attraction("Bluefire",50,30);

    @Test
    public void testAttractionStart(){
        int longueur = a1.getLongueurFile();
        assertEquals("La longueur initiale doit être à 0", 0, longueur);
    }

    @Test
    public void majLongueurFileTemps0(){
        a1.majLongueurFile(40);
        int longueur = a1.getLongueurFile();
        int temps = a1.getTempsAttente();
        assertEquals("La file doit contenir 40 personnes", 40, longueur);
        assertEquals("Le temps d'attente doit être de 0", 0, temps);
    }

    @Test
    public void majLongueurFileTempsEleve(){
        a1.majLongueurFile(250);
        int longueur = a1.getLongueurFile();
        int temps = a1.getTempsAttente();
        assertEquals("La file doit contenir 250 personnes", 250, longueur);
        assertEquals("Le temps d'attente doit être de 150", 120, temps);
    }
}
