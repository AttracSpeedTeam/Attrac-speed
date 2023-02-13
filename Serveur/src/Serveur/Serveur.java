package Serveur;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Serveur {

    public static void main (String args[]) throws RemoteException {
        ServiceAdmin sa = new ServiceAdmin();
        ServiceUser su = new ServiceUser();


        //Ajout du service Addition dans l'annuaire
        ServiceServeur scA = (ServiceServeur) UnicastRemoteObject.exportObject(sa, 0);
        Registry reg = LocateRegistry.createRegistry(1099);
        reg.rebind("ServiceAdmin", scA);

        ServiceServeur scU = (ServiceServeur) UnicastRemoteObject.exportObject(su, 0);
        reg.rebind("ServiceUser", scU);

        System.out.println("Serveur ready");


    }

}
