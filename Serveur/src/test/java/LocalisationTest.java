import Attraction.Attraction;
import Localisation.Carte;
import Localisation.Position;
import org.junit.Test;
import static org.junit.Assert.*;

public class LocalisationTest {
    Attraction a1 = new Attraction("Bluefire",50,30);
    Attraction a2 = new Attraction("Silver Star",70,60);
    Attraction a3 = new Attraction("Wodan",40,50);

    Position p1 = new Position(50, 200);
    Position p2 = new Position(500, 300);
    Position p3 = new Position(200, 0);

    Carte c1 = new Carte();

    @Test
    public void testCoordsPosition(){
        assertEquals("La coord X doit être à 50", 50, p1.getPosX());
        assertEquals("La coord Y doit être à 200", 200, p1.getPosY());
    }

    @Test
    public void testLongueurCarte(){
        assertEquals("La carte doit être vide", 0, c1.attractions.size());
        c1.ajouterAttraction(a1,p1);
        assertEquals("La carte doit avoir une attraction", 1, c1.attractions.size());
        c1.ajouterAttraction(a2,p2);
        c1.ajouterAttraction(a3,p3);
        assertEquals("La carte doit avoir 3 attractions", 3, c1.attractions.size());
        c1.supprimerAttracion(a1);
        assertEquals("La carte doit avoir 2 attractions", 2, c1.attractions.size());
    }

    @Test
    public void testModifPosition(){
        c1.ajouterAttraction(a1,p1);
        c1.ajouterAttraction(a2,p2);
        c1.modifierAttraction(a2, p3);
        assertEquals("La coord X doit être à 200", 200, c1.getPosition(a2).getPosX());
        assertEquals("La coord Y doit être à 0", 0, c1.getPosition(a2).getPosY());
    }

    @Test
    public void testCalculCoords(){
        c1.ajouterAttraction(a1,p1);
        c1.ajouterAttraction(a2,p2);
        c1.ajouterAttraction(a3,p3);
        int co1 = c1.calculerDistance(a1,a3);
        int co2 = c1.calculerDistance(a2,a1);
        assertEquals("La distance doit être de 250", 250, co1);
        assertEquals("La distance doit être de 461", 461, co2);
    }
}
