package Serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;
import Attraction.Attraction;

public interface ServiceServeurVisiteur extends Remote {

    String getListeAttrac() throws RemoteException;
}
