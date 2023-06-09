package Utilisateur;

import Attraction.Attraction;

import java.util.List;

/**
 * classe abstraite représentant un Utilisateur
 */
public abstract class Utilisateur {

	/**Adresse IP*/
	String ip = "localhost";
	/**PORT*/
	int port = 1099;
	/**liste des listes d'attractions*/
	List<ListeAttractions> mesListesDeAttractions;

	public abstract void afficherListeAttraction();

	/**
	 * ajoute une liste d'attractions à l'utilisateur
	 * @param nomListe nom de la liste
	 */
	public void creerListe(String nomListe){
		mesListesDeAttractions.add(new ListeAttractions(nomListe));
	}

	/**
	 * modifie le nom du nom de la liste passé en paramètres
	 * @param ancienNom nom de la liste à modifier
	 * @param nouveauNom nom de remplacement
	 */
	public void modifierNomListe(String ancienNom, String nouveauNom){
		try {
			this.mesListesDeAttractions.get(indexOfListeAttractions(getListeParNom(ancienNom))).setNom(nouveauNom);
		}catch (Exception e){
			System.out.println("Erreur: Nom de liste non trouvé");
		}
	}

	/**
	 * supprime la liste passee en paramètres
	 * @param nom nom de la liste à supprimer
	 */
	public void supprimerListe(String nom){
		try {
			mesListesDeAttractions.remove(getListeParNom(nom));
		}catch (Exception e){
			System.out.println("Erreur: Nom de liste non trouvé");
		}
	}

	/**
	 * ajout d'une attraction à une liste de l'utilisateur
	 * @param nomListe nom de la lite dans laquelle ajouter l'attration
	 * @param a attraction à ajouter à la liste
	 */
	public void ajouterAttractionListe(String nomListe, Attraction a){
		mesListesDeAttractions.get(indexOfListeAttractions(getListeParNom(nomListe))).ajoutAttraction(a);
	}

	/**
	 * permet de connaitre la position de l'utilisateur
	 */
	public void connaitrePosition(){
	 // TODO
	}

	/**
	 * toString des listes d'attractions
	 * @return liste des listes d'attractions
	 */
	public String afficherListe(){
		return mesListesDeAttractions.toString();
	}

	/**
	 * return null si liste non trouvée
	 * @param nomListe nom de la liste
	 * @return liste d'attraction ou NULL sinon
	 */
	public ListeAttractions getListeParNom(String nomListe){
		ListeAttractions res=null;
		for (ListeAttractions la:mesListesDeAttractions) {
			if(la.getNom().equals(nomListe))
				res=la;
		}
		return res;
	}

	/**
	 * return -1 si listeAttraction non trouvée dans la liste
	 * @param a Liste d'attractions
	 * @return index int dans la liste, -1 sinon
	 */
	public int indexOfListeAttractions(ListeAttractions a){
		int res;
		try{
			res=mesListesDeAttractions.indexOf(a);
		}catch (Exception e){
			res=-1;
		}
		return res;
	}

	/*
	* GETTERS ET SETTERS
	*/
	public List<ListeAttractions> getMesListesDeAttractions(){
		return mesListesDeAttractions;
	}
}
