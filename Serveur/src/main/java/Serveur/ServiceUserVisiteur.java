package Serveur;

import Attraction.Attraction;

import java.rmi.RemoteException;
import java.sql.*;
import java.util.ArrayList;

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
    public ArrayList<Attraction> getListeAttrac() throws RemoteException {
        ArrayList<Attraction> res = new ArrayList<>();
        try {
            //jdbc:mysql://localhost:3306/attracspeed?serverTimezone=UTC
            //jdbc:mysql:///attracspeed
            Connection connection = this.connectBDD();
            Statement st = connection.createStatement();
            String query = "Select * from Attraction";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                Attraction a = new Attraction(rs.getString(1),rs.getInt(10),rs.getInt(2),rs.getInt(11),rs.getInt(4),rs.getBoolean(7));
                res.add(a);
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
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/attracspeed?serverTimezone=UTC","root","");
    }
}
