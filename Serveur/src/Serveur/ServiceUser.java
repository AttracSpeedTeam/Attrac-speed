package Serveur;

import Attraction.Attraction;

import java.rmi.RemoteException;
import java.sql.*;

public class ServiceUser implements ServiceServeur{
    @Override
    public boolean modifDB(Attraction attraction) throws RemoteException {
        return false;
    }

    @Override
    public String getListeAttrac() throws RemoteException {
        String res = "";
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql:///attracspeed","root","");
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
