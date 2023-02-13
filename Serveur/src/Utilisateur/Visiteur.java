package Utilisateur;

import Serveur.ServiceServeur;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Visiteur implements Utilisateur{
	private String ip = "localhost";
	private int port = 1099;
	public void creerListe() {
		// TODO Auto-generated method stub	
	}

	public void modifierListe() {
		// TODO Auto-generated method stub		
	}

	public void supprimerListe() {
		// TODO Auto-generated method stub		
	}

	public void connaitrePosition() {
		// TODO Auto-generated method stub		
	}

	public void afficherListe() {
		// TODO Auto-generated method stub		
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
