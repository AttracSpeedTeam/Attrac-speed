import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class App{
	
	/*Liste des attractions que possède le parc*/
	public List<String> Attraction;
	/*Variable de connexion */
	public Connection con;
	
	/*Connexion à la base de données*/
	public boolean ConnexionToBase(){
		try {
			/*Creation de la connexion*/
			Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Attrac-Speed","root","");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("show databases;");
            
			return true; /*retourne true si la connexion est réussi*/
			
		}catch(Exception e)
		{
			return false; /*retourne false si la connexion a échouer*/
		}	
	}
	
	/*Inssertion des noms d'attractions dans la liste en fonction du parc*/
	public void ListAttraction(String NameParc) throws SQLException{
		ConnexionToBase();
		Statement stmt=con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT nom_attraction FROM Attraction;");
		
		while (rs.next()) {
			  String str = rs.getString("nom_attraction");

			  Attraction.add(str);
			}
		
	}
	
}