package Serveur;

import Attraction.Attraction;

import java.rmi.RemoteException;
import java.sql.*;

/**
 * classe de service de connection à la BDD d'un visiteur
 */
public class ServiceUserVisiteur implements ServiceServeurVisiteur {

    /**
     * retourne la liste des attractions sous forme de chaine de caractères
     * @return liste d'attractions String
     * @throws RemoteException
     */
    @Override
    public String getListeAttrac() throws RemoteException {
        String res = "";
        try {
            //jdbc:mysql://localhost:3306/attracspeed?serverTimezone=UTC
            //jdbc:mysql:///attracspeed
            Connection connection = this.connectBDD();
            Statement st = connection.createStatement();
            String query = "Select * from Attraction";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                res += rs.getString(1) + ", ";
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;

    }

    /**
     * permet de récupérer la connexion à la BDD
     * @return connection à la BDD
     * @throws SQLException
     */
    private Connection connectBDD() throws SQLException {
        //RETIRER LE MDP DE LA LIGNE DE CMD    Admin1234!
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/attracspeed?serverTimezone=UTC","root","");
    }
}
