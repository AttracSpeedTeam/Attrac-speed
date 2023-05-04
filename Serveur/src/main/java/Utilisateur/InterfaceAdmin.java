package Utilisateur;

import Attraction.Attraction;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class InterfaceAdmin extends JFrame {

    private JTable table;
    private JButton ajouter, modifier, supprimer;
    private JPanel boutons, main, info, bas;
    private JTextField attracNom, attracAttente, attracPlaces, attracTemps, attracLongueur, attracOuvert;
    private final Administrateur admin;

    public InterfaceAdmin() throws RemoteException {
        super("Attrac-Speed Management");
        this.admin = new Administrateur();
        ArrayList<Attraction> attractions = admin.recupererListeAttraction();
        /*ArrayList<Attraction> attractions = new ArrayList<Attraction>();
        attractions.add(new Attraction("Petit train",19,60));
        attractions.add(new Attraction("Bus magique sans rail",89,20));*/


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

        ajouter = new JButton("Ajouter");
        ajouter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Attraction attr = getSelected();
                admin.ajouterAttractionBDD(attr);
            }
        });

        modifier = new JButton("Modifier");
        modifier.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Attraction attr = getSelected();
                admin.modifierAttraction(attr);
            }
        });

        supprimer = new JButton("Supprimer");
        supprimer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                admin.retirerAttraction(attracNom.getText());
            }
        });

        boutons = new JPanel(new GridLayout(10,1));
        boutons.add(new JPanel());
        boutons.add(new JPanel());
        boutons.add(ajouter);
        boutons.add(new JPanel());
        boutons.add(modifier);
        boutons.add(new JPanel());
        boutons.add(supprimer);

        info = new JPanel(new GridLayout(6, 2));

        attracNom = new JTextField();
        info.add(new JLabel("Nom :"));
        info.add(attracNom);

        attracAttente = new JTextField();
        info.add(new JLabel("Attente :"));
        info.add(attracAttente);

        attracPlaces = new JTextField();
        info.add(new JLabel("Places :"));
        info.add(attracPlaces);

        attracTemps = new JTextField();
        info.add(new JLabel("Cadence :"));
        info.add(attracTemps);

        attracLongueur = new JTextField();
        info.add(new JLabel("File :"));
        info.add(attracLongueur);

        attracOuvert = new JTextField();
        info.add(new JLabel("Ouvert :"));
        info.add(attracOuvert);

        bas = new JPanel(new GridLayout(1,4));
        bas.add(new JPanel());
        bas.add(info);
        bas.add(new JPanel()); bas.add(new JPanel());

        main = new JPanel(new BorderLayout());
        main.add(new JScrollPane(table), BorderLayout.CENTER);
        main.add(boutons, BorderLayout.WEST);
        main.add(bas, BorderLayout.SOUTH);

        add(main);

        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                afficherSelection(attractions);
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) throws RemoteException {
        new InterfaceAdmin();
    }


    private void afficherSelection(ArrayList<Attraction> attracs) {
        int i = table.getSelectedRow();
        if (i == -1) {
            toutSupprimer();
        } else {
            afficherInfo(attracs.get(i));
        }
    }

    private void toutSupprimer() {
        attracNom.setText("");
        attracAttente.setText("");
        attracPlaces.setText("");
        attracLongueur.setText("");
        attracTemps.setText("");
        attracOuvert.setText("");
    }

    private void afficherInfo(Attraction a){
        attracNom.setText(a.getNom());
        attracAttente.setText(a.getAttente());
        attracPlaces.setText(a.getPlaces());
        attracLongueur.setText(a.getLongueur());
        attracTemps.setText(a.getCadence());
        attracOuvert.setText(a.getOuverture());
    }

    private Attraction getSelected(){
        String nom = attracNom.getText();
        int att = Integer.parseInt(attracAttente.getText().split(" ")[0]);
        int plc = Integer.parseInt(attracPlaces.getText().split(" ")[0]);
        int lg = Integer.parseInt(attracLongueur.getText().split(" ")[0]);
        int tmps = Integer.parseInt(attracTemps.getText().split(" ")[0]);
        boolean open = attracOuvert.getText().equalsIgnoreCase("Oui");
        return new Attraction(nom,att,plc,lg,tmps,open);
    }

}
