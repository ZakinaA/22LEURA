/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import dao.DaoDispositif;
import java.sql.Connection;
import java.util.ArrayList;
import model.Dispositif;

/**
 *
 * @author sio2
 */
public class TestDaoDispositif {
    

public static void main(String[] args){
    Connection con = ConnexionBdd.ouvrirConnexion();
    
    ArrayList<Dispositif> lesDispositifs = DaoDispositif.getLesDispositifs(con);
    for (int i=0; i<lesDispositifs.size(); i++){
        Dispositif dispo = lesDispositifs.get(i);
        System.out.println("nom du dispositif: " + dispo.getLibelle() + " - annee: " + dispo.getAnnee());
        
    }
    
    Dispositif dispositif = new Dispositif();
    dispositif.setAnnee("2020");
    dispositif.setLibelle("NOR'ZIK 20");
    
    Dispositif leDispositifInsere = DaoDispositif.ajouterDispositif(con, dispositif);
    
    ConnexionBdd.fermerConnexion(con);
}

}
