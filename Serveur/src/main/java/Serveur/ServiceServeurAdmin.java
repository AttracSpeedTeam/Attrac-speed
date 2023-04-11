package Serveur;

import Attraction.Attraction;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


/**
 * interface du service Administrateur
 */
public interface ServiceServeurAdmin extends Remote{
    boolean modifAttraction(Attraction attraction) throws RemoteException;
    boolean ajoutAttractionBDD(Attraction attraction) throws RemoteException;
    boolean retirerAttractionBDD(String name) throws RemoteException;
    ArrayList<Attraction> getListeAttrac() throws RemoteException;

    boolean login(String user, String mdp) throws RemoteException;
}
