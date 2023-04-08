package Serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Attraction.Attraction;

/**
 * interface du service Visiteur
 */
public interface ServiceServeurVisiteur extends Remote {

    ArrayList<Attraction> getListeAttrac() throws RemoteException;
}
