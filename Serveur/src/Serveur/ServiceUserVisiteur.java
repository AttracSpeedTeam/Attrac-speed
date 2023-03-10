package Serveur;

import Attraction.Attraction;

import java.rmi.RemoteException;
import java.sql.*;

public class ServiceUserVisiteur implements ServiceServeurVisiteur {


    @Override
    public String getListeAttrac() throws RemoteException {
        String res = "";
        try {
            //jdbc:mysql://localhost:3306/attracspeed?serverTimezone=UTC
            //jdbc:mysql:///attracspeed
            //RETIRER LE MDP DE LA LIGNE DE CMD    Admin1234!
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/attracspeed?serverTimezone=UTC","root","Admin1234!");
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
}
