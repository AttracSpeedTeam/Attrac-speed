package Serveur;

import Attraction.Attraction;

import java.rmi.RemoteException;
import java.sql.*;

/**
 * classe de service de connection à la BDD d'un utilisateur
 */
public class ServiceAdminVisiteur implements ServiceServeurAdmin, ServiceServeurVisiteur {

    /**
     * modification d'une attraction dans la BDD
     * @param attraction attraction modifiée (nom identique pour la reconnaitre)
     * @return true si réussi
     * @throws RemoteException
     */
    @Override
    public boolean modifDB(Attraction attraction) throws RemoteException {
        try {
            if(checkPresence(attraction.getNom())){
                Connection connection =  this.connectBDD();

                String query =  "update attraction" +
                            " set nom_attraction = ? ," +
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
            ps.setInt(2,attraction.getNbPlacesWagon());
            ps.setInt(3,attraction.getLongueurFile());
         //   ps.setDate(4,null);
            ps.setString(4,attraction.getNom());
            ps.executeUpdate();

            connection.close();
                return true;
            } else {return false;}
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * suppression d'une attraction dans la BDD
     * @param name nom de l'attraction à supprimer
     * @return true si réussi
     * @throws RemoteException
     */
    @Override
    public boolean retirerAttractionBDD(String name) throws RemoteException {
        try{
            if(checkPresence(name)){
                Connection conn = connectBDD();
                String query = "delete from attraction where nom_attraction = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1,name);
                preparedStatement.executeUpdate();
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * ajout d'une attraction dans la BDD
     * @param attraction attraction à insérer
     * @return true si réussi
     * @throws RemoteException
     */
    @Override
    public boolean ajoutAttractionBDD(Attraction attraction) throws RemoteException {
        try{
            if(!checkPresence(attraction.getNom())){
                Connection conn = connectBDD();
                String query = "insert into attraction values(?,?,?,0,0,0,false,null,null,null)";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1,attraction.getNom());
                preparedStatement.setInt(2,attraction.getNbPlacesWagon());
                preparedStatement.setString(3,"coordonnees");
                preparedStatement.executeUpdate();
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * retourne la liste des attractions sous forme de chaine de caractères
     * @return liste d'attractions String
     * @throws RemoteException
     */
    @Override
    public String getListeAttrac() throws RemoteException {
        String res = "";
        try {
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
     * permet de verifier l'existence d'une attraction dans la BDD
     * @param name nom de l'attraction à verifier
     * @return true si l'attraction existe
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean checkPresence(String name) throws SQLException, ClassNotFoundException {
        Connection connection = this.connectBDD();
        String query =" Select count(*) from Attraction where nom_attraction = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1,name);
        ResultSet rs = ps.executeQuery();
        rs.next();
        if(rs.getInt(1) > 0){
            connection.close();
            return true;
        } else {
            connection.close();
            return false;
        }
    }

    /**
     * permet de récupérer la connexion à la BDD
     * @return connection à la BDD
     * @throws SQLException
     */
    private Connection connectBDD() throws SQLException {
        //RETIRER LE MDP DE LA LIGNE DE CMD    Admin1234!
       return DriverManager.getConnection("jdbc:mysql://localhost:3306/attracspeed?serverTimezone=UTC","root","Admin1234!");
    }
}
