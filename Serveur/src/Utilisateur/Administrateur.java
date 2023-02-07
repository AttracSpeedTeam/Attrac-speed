package Utilisateur;

import Attraction.Attraction;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import Serveur.ServiceServeur;

public class Administrateur implements Utilisateur{
	private String ip = "localhost";
	private int port = 1099;


	public void modifierAttraction(Attraction attraction){

		try {
			Registry reg = LocateRegistry.getRegistry(ip, port);
			ServiceServeur sa = (ServiceServeur) reg.lookup("ServiceAdmin");
			System.out.printf("cc : " + sa.modifDB(attraction));
		} catch (RemoteException e) {
			System.out.println("Erreur pour acceder au serveur");
		} catch (NotBoundException e) {
			System.out.println("Erreur pour acceder à l'élément dans le répertoire");
		}

	}
	
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

}
