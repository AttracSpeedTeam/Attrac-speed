package Serveur;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * classe serveur
 */
public class Serveur {

    /**
     * lancement du serveur
     * @param args arguments
     * @throws RemoteException
     */
    public static void main (String args[]) throws RemoteException {
        ServiceAdminVisiteur sa = new ServiceAdminVisiteur();
        ServiceUserVisiteur su = new ServiceUserVisiteur();


        //Ajout du service Addition dans l'annuaire
        ServiceServeurAdmin scA = (ServiceServeurAdmin) UnicastRemoteObject.exportObject(sa, 0);
        Registry reg = LocateRegistry.createRegistry(1099);
        reg.rebind("ServiceAdmin", scA);

        ServiceServeurVisiteur scU = (ServiceServeurVisiteur) UnicastRemoteObject.exportObject(su, 0);
        reg.rebind("ServiceUser", scU);

        System.out.println("Serveur ready");


    }

}
