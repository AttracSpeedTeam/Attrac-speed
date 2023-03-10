package Utilisateur;

import Attraction.Attraction;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import Serveur.ServiceServeurAdmin;
import Serveur.ServiceServeurVisiteur;

public class Administrateur extends Utilisateur {

	public Administrateur() {
		this.ip = "localhost";
		this.port = 1099;
		this.mesListesDeAttractions=new ArrayList<>();
	}

	public Administrateur(String ip, int port) {
		this.ip=ip;
		this.port=port;
		this.mesListesDeAttractions=new ArrayList<>();
	}


	public boolean modifierAttraction(Attraction attraction){

		try {
			Registry reg = LocateRegistry.getRegistry(ip, port);
			ServiceServeurAdmin sa = (ServiceServeurAdmin) reg.lookup("ServiceAdmin");
			if(sa.modifDB(attraction)){
				System.out.println("Modif réussi ");
				return true;
			} else{
				System.out.println("Modif raté");
			}
		} catch (RemoteException e) {
			System.out.println("Erreur pour acceder au serveur");
		} catch (NotBoundException e) {
			System.out.println("Erreur pour acceder à l'élément dans le répertoire");
		}
		return false;
	}

	@Override
	public void afficherListeAttraction() {
		try {
			Registry reg = LocateRegistry.getRegistry(ip, port);
			ServiceServeurVisiteur sa = (ServiceServeurVisiteur) reg.lookup("ServiceAdmin");
			System.out.println("Liste d'attraction : " + sa.getListeAttrac());
		} catch (RemoteException e) {
			System.out.println("Erreur pour acceder au serveur");
		} catch (NotBoundException e) {
			System.out.println("Erreur pour acceder à l'élément dans le répertoire");
		}
	}

	public boolean ajouterAttractionBDD(Attraction attraction){
		try {
		Registry reg = LocateRegistry.getRegistry(ip, port);
		ServiceServeurAdmin sa = (ServiceServeurAdmin) reg.lookup("ServiceAdmin");
		sa.ajoutAttractionBDD(attraction);
			System.out.println("Ajout de " + attraction.getNom());
		return true;
	} catch (RemoteException e) {
		System.out.println("Erreur pour acceder au serveur");
	} catch (NotBoundException e) {
		System.out.println("Erreur pour acceder à l'élément dans le répertoire");
	}
	return false;
	}

	public boolean retirerAttraction(String name){

		try {
			Registry reg = LocateRegistry.getRegistry(ip, port);
			ServiceServeurAdmin sa = (ServiceServeurAdmin) reg.lookup("ServiceAdmin");
			sa.retirerAttractionBDD(name);
			System.out.println("Suppression de " + name);
			return true;
		} catch (RemoteException e) {
			System.out.println("Erreur pour acceder au serveur");
		} catch (NotBoundException e) {
			System.out.println("Erreur pour acceder à l'élément dans le répertoire");
		}
		System.out.println("Suppression raté");
		return false;


	}


}
