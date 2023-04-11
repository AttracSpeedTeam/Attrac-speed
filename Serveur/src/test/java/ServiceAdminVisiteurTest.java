
import Serveur.ServiceAdminVisiteur;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.OrderWith;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ServiceAdminVisiteurTest{

    static ServiceAdminVisiteur sa;


    @BeforeClass
    public static void beforeClass(){
        sa = new ServiceAdminVisiteur();
        sa.addLogin("Test","Bonjour");
    }

    @Test
    public void testALogin() {
        assertTrue(sa.login("Test","Bonjour"));
    }

    @Test
    public void testBDeleteLogin() {assertTrue(sa.deleteLogin("Test"));}

    @Test
    public void testCFailLogin() {assertFalse(sa.login("Oui","baguette"));}

}