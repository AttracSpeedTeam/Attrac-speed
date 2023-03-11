package Serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;
import Attraction.Attraction;

/**
 * interface du service Visiteur
 */
public interface ServiceServeurVisiteur extends Remote {

    String getListeAttrac() throws RemoteException;
}
