import java.io.IOException;

/**
 * 
 * Note: L'interface client Possède toute les fonctions que le client lancera au cours de son utilisation de l'application
 * 
 * */
public interface ClientInt{
	
	/*Creation de liste*/
	public void CreateList() throws IOException;
	/*Ajout d'attraction à la liste*/
	public void AddToList(int idElement) throws IOException;
	/*Suppression d'attraction à la liste*/
	public void DeleteToList(int idElement) throws IOException;
	
	/*Afficher la map*/
	public void PostMap() throws IOException;
	/*Connaitre notre position sur la map*/
	public void KnowPosition() throws IOException;
	
	/*Connexion à un compte client*/
	public void Connexion(String Nom, String Mdp) throws IOException;
	/*Creation d'un compte client*/
	public void CreateAccount(String Nom, String Mdp) throws IOException;
	
	/*Afficher la liste des attractions*/
	public void PostList() throws IOException;
	/*Afficher la page home*/
	public void PostHome() throws IOException;
	/*Afficher la page connexion*/
	public void PostConnexion() throws IOException;
	/*Afficher la page notification*/
	public void PostNotification() throws IOException;
		
	
}