package Utilisateur;

import Attraction.Attraction;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import Serveur.ServiceServeur;

public class Administrateur extends Utilisateur {

	public Administrateur() {
		this.ip = "localhost";
		this.port = 1099;
	}

	public Administrateur(String ip, int port) {
		this.ip=ip;
		this.port=port;
	}


	public void modifierAttraction(Attraction attraction){

		try {
			Registry reg = LocateRegistry.getRegistry(ip, port);
			ServiceServeur sa = (ServiceServeur) reg.lookup("ServiceAdmin");
			if(sa.modifDB(attraction)){
				System.out.println("Modif réussi ");
			} else{
				System.out.println("Modif raté");
			}
		} catch (RemoteException e) {
			System.out.println("Erreur pour acceder au serveur");
		} catch (NotBoundException e) {
			System.out.println("Erreur pour acceder à l'élément dans le répertoire");
		}

	}

	@Override
	public void afficherListeAttraction() {
		try {
			Registry reg = LocateRegistry.getRegistry(ip, port);
			ServiceServeur sa = (ServiceServeur) reg.lookup("ServiceAdmin");
			System.out.printf("Liste d'attraction : " + sa.getListeAttrac());
		} catch (RemoteException e) {
			System.out.println("Erreur pour acceder au serveur");
		} catch (NotBoundException e) {
			System.out.println("Erreur pour acceder à l'élément dans le répertoire");
		}
	}

}
