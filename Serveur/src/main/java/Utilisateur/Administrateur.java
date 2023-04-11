package Utilisateur;

import Attraction.Attraction;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import Serveur.ServiceAdminVisiteur;
import Serveur.ServiceServeurAdmin;
import Serveur.ServiceServeurVisiteur;

/**
 * classe représentant un Utilisateur de type Administrateur
 */
public class Administrateur extends Utilisateur {

	/**
	 * constructeur par defaut avec ces parametres:
	 * IP=localhost
	 * PORT=1099
	 */
	public Administrateur() {
		this.ip = "localhost";
		this.port = 1099;
		this.mesListesDeAttractions=new ArrayList<>();
	}

	/**
	 * constructeur passant l'ip et le port en parametres
	 * @param ip IP
	 * @param port PORT
	 */
	public Administrateur(String ip, int port) {
		this.ip=ip;
		this.port=port;
		this.mesListesDeAttractions=new ArrayList<>();
	}

	/**
	 * methode permettant la modification dans la base de données d'une attraction
	 * @param attraction attraction modifiée avec comme nom celle à modifier
	 * @return true si la modification a été éxécutée avec succès
	 */
	public boolean modifierAttraction(Attraction attraction){

		try {
			Registry reg = LocateRegistry.getRegistry(ip, port);
			ServiceServeurAdmin sa = (ServiceServeurAdmin) reg.lookup("ServiceAdmin");
			if(sa.modifAttraction(attraction)){
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

	/**
	 * affiche en ligne de commande les attractions de la BDD
	 */
	public void afficherListeAttraction() {
		try {
			Registry reg = LocateRegistry.getRegistry(ip, port);
			ServiceServeurVisiteur sa = (ServiceServeurVisiteur) reg.lookup("ServiceAdmin");
			System.out.println("Liste d'attraction : ");
			ArrayList<Attraction> attractions = sa.getListeAttrac();
			for (Attraction a : attractions){
				System.out.println(a);
			}
		} catch (RemoteException e) {
			System.out.println("Erreur pour acceder au serveur");
		} catch (NotBoundException e) {
			System.out.println("Erreur pour acceder à l'élément dans le répertoire");
		}
	}

	/**
	 * récupère la liste des attractions de la BDD
	 */
	public ArrayList<Attraction> recupererListeAttraction() throws RemoteException {
		ServiceServeurAdmin sa = null;
		try {
			Registry reg = LocateRegistry.getRegistry(ip, port);
			sa = (ServiceServeurAdmin) reg.lookup("ServiceAdmin");
		} catch (RemoteException e) {
			System.out.println("Erreur pour acceder au serveur");
		} catch (NotBoundException e) {
			System.out.println("Erreur pour acceder à l'élément dans le répertoire");
		}
		return sa.getListeAttrac();
	}

	/**
	 * methode permettant l'insertion dans la base de données d'une attraction
	 * @param attraction attraction à insérer
	 * @return true si l'insertion a été éxécutée avec succès
	 */
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

	/**
	 * methode permettant la suppression dans la base de données d'une attraction
	 * @param name nom de l'attraction à supprimer
	 * @return true si la suppression a été éxécutée avec succès
	 */
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
