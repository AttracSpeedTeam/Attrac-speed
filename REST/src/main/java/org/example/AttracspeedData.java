package org.example;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Path("attraction")
@Produces(MediaType.APPLICATION_JSON)
public class AttracspeedData {

    @GET
    @Path("listeAttractions")
    public List<String> RecupererListeAttractions(@HeaderParam("name") String name) throws SQLException {

        Statement base = Connexion();
        ResultSet res = base.executeQuery("SELECT nom_attraction FROM attraction;");

        ArrayList<String> li=new ArrayList<>();

        while(res.next()){
            li.add(res.getString(1));
        }
        return li;
    }

    @GET
    @Path("{nom}")
    public List<String> RecupererAttraction(@PathParam("nom") String nom, @HeaderParam("name") String name) throws SQLException {

        Statement base = Connexion();
        PreparedStatement ps=
                base.getConnection().prepareStatement("SELECT TempsAttenteActuel,date_format(Horaire_Deb,\"%H:%i\"),date_format(Horaire_Fin,\"%H:%i\"),disponible FROM attraction where nom_attraction LIKE ? ;");

        ps.setString(1,nom);
        ResultSet res =ps.executeQuery();

        ArrayList<String> li=new ArrayList<>();

        while(res.next()){
            //temps attente actuel
            li.add(res.getString(1));
            //heure ouverture
            li.add(res.getString(2));
            //heure fermeture
            li.add(res.getString(3));
            //disponible ?
            li.add(res.getString(4));
            return li;
        }
        return null;
    }

    @GET
    @Path("{nom}/emplacement")
    public String RecupererEmplacement(@PathParam("nom") String nom, @HeaderParam("name") String name) throws SQLException {
        Statement base = Connexion();
        PreparedStatement ps=
                base.getConnection().prepareStatement("SELECT emplacement FROM attraction where nom_attraction LIKE ? ;");

        ps.setString(1,nom);
        ResultSet res =ps.executeQuery();

        while(res.next()){
            //emplacement
            return res.getString(1);
        }
        return null;
    }

    public Statement Connexion(){
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/attracspeed","root","");
            Statement stmt=con.createStatement();
            //con.close();
            return stmt;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return null;
        }
    }

}
