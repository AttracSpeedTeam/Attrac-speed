package Utilisateur;

import Attraction.Attraction;
import Serveur.ServiceServeurVisiteur;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

/**
 * classe représentant un Utilisateur de type Visiteur
 */
public class Visiteur extends Utilisateur {

	/**
	 * constructeur par defaut avec ces parametres:
	 * IP=localhost
	 * PORT=1099
	 */
	public Visiteur() {
		this.ip = "localhost";
		this.port = 1099;
		this.mesListesDeAttractions=new ArrayList<>();
	}

	/**
	 * constructeur passant l'ip et le port en parametres
	 * @param ip IP
	 * @param port PORT
	 */
	public Visiteur(String ip, int port) {
		this.ip=ip;
		this.port=port;
		this.mesListesDeAttractions=new ArrayList<>();
	}

	/**
	 * affiche en ligne de commande les attractions de la BDD d'un parc
	 */
	@Override
	public void afficherListeAttraction() {
		try {
			Registry reg = LocateRegistry.getRegistry(ip, port);
			ServiceServeurVisiteur sa = (ServiceServeurVisiteur) reg.lookup("ServiceUser");
			System.out.printf("Liste d'attractions : ");
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

}
