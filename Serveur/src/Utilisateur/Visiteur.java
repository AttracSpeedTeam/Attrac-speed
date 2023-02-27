package Utilisateur;

import Serveur.ServiceServeur;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Visiteur extends Utilisateur {

	public Visiteur() {
		this.ip = "localhost";
		this.port = 1099;
	}

	public Visiteur(String ip, int port) {
		this.ip=ip;
		this.port=port;
	}

	@Override
	public void afficherListeAttraction() {
		try {
			Registry reg = LocateRegistry.getRegistry(ip, port);
			ServiceServeur sa = (ServiceServeur) reg.lookup("ServiceUser");
			System.out.printf("Liste d'attractions : " + sa.getListeAttrac());
		} catch (RemoteException e) {
			System.out.println("Erreur pour acceder au serveur");
		} catch (NotBoundException e) {
			System.out.println("Erreur pour acceder à l'élément dans le répertoire");
		}
	}

}
