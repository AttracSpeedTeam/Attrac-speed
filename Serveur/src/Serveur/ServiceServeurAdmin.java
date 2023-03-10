package Serveur;

import Attraction.Attraction;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiceServeurAdmin extends Remote{
    boolean modifDB(Attraction attraction) throws RemoteException;
    boolean ajoutAttractionBDD(Attraction attraction) throws RemoteException;
    boolean retirerAttractionBDD(String name) throws RemoteException;
}
