package Serveur;

import Attraction.Attraction;

import java.rmi.RemoteException;
import java.sql.*;

public class ServiceAdmin implements ServiceServeur{


    @Override
    public double modifDB(Attraction attraction) throws RemoteException {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql:///attracspeed","root","");

            String query =  "update attraction" +
                            "set nom_attraction = ? ," +
                            " Nb_place_par_tour = ? ," +
                           // " Emplacement = ?" +
                           // " TailleFileAttenteNormal = ?" +
                           // " TailleFileAttenteFast = ?" +
                            " TailleFileAttenteTotal = ?" +
                           // " Disponible = ?" +
                           // " Horaire_Deb = ?" +
                           // " Horaire_Fin = ?" +
                           // " TempsAttenteActuel ?" +
                            " where nom_attraction = ?";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1,attraction.getNom());
            ps.setInt(2,attraction.getNbPlaces());
            ps.setInt(3,attraction.getLongueurFile());
         //   ps.setDate(4,null);
            ps.setString(4,attraction.getNom());
            ps.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
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
                res += rs.getString(1);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;

    }


}
