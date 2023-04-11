package Serveur;

import Attraction.Attraction;

import java.rmi.RemoteException;
import java.security.MessageDigest;
import java.sql.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * classe de service de connection à la BDD d'un utilisateur
 */
public class ServiceAdminVisiteur implements ServiceServeurAdmin, ServiceServeurVisiteur {

    ArrayList<Attraction> attractions;

    public ServiceAdminVisiteur() {
        try {
            attractions = getListeAttrac();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
        autoUpdate();
    }


    class MyTimerTask extends TimerTask {

        public MyTimerTask() {

        }

        @Override
        public void run() {
            updateBDD();
        }
    }


    private void updateBDD() {
        try {
            for (Attraction attraction : attractions) {
                modifDB(attraction);
            }

            System.out.println("Update BDD terminé");

        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }

    }


    public void autoUpdate() {
        Timer timer = new Timer();
        timer.schedule(new MyTimerTask(), 1000, 10000);
    }

    @Override
    public boolean modifAttraction(Attraction attraction) throws RemoteException {
        try {
            if (checkPresence(attraction.getNom())) {
                int i = 0;
                boolean stop = false;
                while (!stop && i < attractions.size()) {
                    if (attractions.get(i).getNom().equalsIgnoreCase(attraction.getNom())) {
                        stop = true;
                    } else {
                        i++;
                    }
                }

                attractions.remove(i);
                attractions.add(attraction);
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * modification d'une attraction dans la BDD
     *
     * @param attraction attraction modifiée (nom identique pour la reconnaitre)
     * @return true si réussi
     * @throws RemoteException
     */


    public boolean modifDB(Attraction attraction) throws RemoteException {
        try {
            if (checkPresence(attraction.getNom())) {
                Connection connection = this.connectBDD();

                String query = "update attraction" +
                        " set nom_attraction = ? ," +
                        " Nb_place_par_tour = ? ," +
                        // " Emplacement = ?" +
                        // " TailleFileAttenteNormal = ?" +
                        // " TailleFileAttenteFast = ?" +
                        " TailleFileAttenteTotal = ? ," +
                        // " Disponible = ?" +
                        // " Horaire_Deb = ?" +
                        // " Horaire_Fin = ?" +
                        " TempsAttenteActuel = ? ," +
                        " duree_Tour = ?" +
                        " where nom_attraction = ?";
                PreparedStatement ps = connection.prepareStatement(query);

                ps.setString(1, attraction.getNom());
                ps.setInt(2, attraction.getNbPlacesWagon());
                ps.setInt(3, attraction.getLongueurFile());
                ps.setInt(4, attraction.getTempsAttente());
                ps.setInt(5, attraction.getTempsEntreChaqueWagon());
                ps.setString(6, attraction.getNom());
                ps.executeUpdate();


                connection.close();
                return true;
            } else {
                return false;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    /**
     * suppression d'une attraction dans la BDD
     *
     * @param name nom de l'attraction à supprimer
     * @return true si réussi
     * @throws RemoteException
     */
    @Override
    public boolean retirerAttractionBDD(String name) throws RemoteException {
        try {
            if (checkPresence(name)) {
                Connection conn = connectBDD();
                String query = "delete from attraction where nom_attraction = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, name);
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
     *
     * @param attraction attraction à insérer
     * @return true si réussi
     * @throws RemoteException
     */
    @Override
    public boolean ajoutAttractionBDD(Attraction attraction) throws RemoteException {
        try {
            if (!checkPresence(attraction.getNom())) {
                Connection conn = connectBDD();
                String query = "insert into attraction values(?,?,?,0,0,0,false,null,null,null)";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, attraction.getNom());
                preparedStatement.setInt(2, attraction.getNbPlacesWagon());
                preparedStatement.setString(3, "coordonnees");
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
     *
     * @return liste d'attractions String
     * @throws RemoteException
     */
    @Override
    public ArrayList<Attraction> getListeAttrac() throws RemoteException {
        ArrayList<Attraction> res = new ArrayList<>();
        try {
            Connection connection = this.connectBDD();
            Statement st = connection.createStatement();
            String query = "Select * from Attraction";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Attraction a = new Attraction(rs.getString(1), rs.getInt(2), rs.getInt(11), rs.getInt(6), rs.getInt(10), rs.getBoolean(7));
                res.add(a);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;

    }

    /**
     * permet de verifier l'existence d'une attraction dans la BDD
     *
     * @param name nom de l'attraction à verifier
     * @return true si l'attraction existe
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean checkPresence(String name) throws SQLException, ClassNotFoundException {
        Connection connection = this.connectBDD();
        String query = " Select count(*) from Attraction where nom_attraction = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        rs.next();
        if (rs.getInt(1) > 0) {
            connection.close();
            return true;
        } else {
            connection.close();
            return false;
        }
    }

    /**
     * permet de récupérer la connexion à la BDD
     *
     * @return connection à la BDD
     * @throws SQLException
     */
    private Connection connectBDD() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/attracspeed?serverTimezone=UTC", "root", "");
    }


    private String sha256(final String base) {
        try {
            final MessageDigest digest = MessageDigest.getInstance("SHA-256");
            final byte[] hash = digest.digest(base.getBytes("UTF-8"));
            final StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                final String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


    public boolean addLogin(String user, String mdp) {
        try {
            Connection conn = connectBDD();

            String query = "insert into admins values(?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, sha256(mdp));
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("ERREUR");
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean login(String user, String mdp) {
        try {
            String name = "";
            Connection conn = this.connectBDD();
            String query = "Select mdp from Admins where name = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, user);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                name = rs.getString(1);
            }
            rs.close();
            conn.close();
            if (name.equals(sha256(mdp))) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
