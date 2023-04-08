package Utilisateur;

import Attraction.Attraction;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class InterfaceAdmin extends JFrame {

    private JTable table;
    private final Administrateur admin;

    public InterfaceAdmin() throws RemoteException {
        super("Attrac-Speed Management");
        this.admin = new Administrateur();
        //ArrayList<Attraction> attractions = admin.recupererListeAttraction();
        ArrayList<Attraction> attractions = new ArrayList<Attraction>();
        attractions.add(new Attraction("Petit train",19,60));
        attractions.add(new Attraction("Bus magique sans rail",89,20));


        Object[][] data = new Object[attractions.size()][4];
        int i=0;
        for (Attraction a : attractions) {
            data[i][0] = a.getNom();
            data[i][1] = a.getNbPlacesWagon();
            data[i][2] = a.getOuverture();
            data[i][3] = a.getTempsAttente();
            i++;
        }

        String[] nomCol = {"Nom", "Nb de place par tour", "Ouvert", "Temps d'attente"};
        table = new JTable(new DefaultTableModel(data, nomCol));

        add(new JScrollPane(table));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) throws RemoteException {
        new InterfaceAdmin();
    }
}
