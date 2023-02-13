package Serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;
import Attraction.Attraction;

public interface ServiceServeur extends Remote {

    boolean modifDB(Attraction attraction) throws RemoteException;

    String getListeAttrac() throws RemoteException;
}
