/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import dao.DaoMembre;
import java.sql.Connection;
import model.Membre;
import model.Statut;

/**
 *
 * @author sio2
 */
public class TestDaoMembre {
    
    public static void main(String[] args) {
        Connection con = ConnexionBdd.ouvrirConnexion();



        Membre membre = new Membre();
        membre.setNom("BOI");
        membre.setPrenom("Alexis");
        
        Statut statut = new Statut();
        statut.setId(2);
        membre.setStatut(statut);
        
        Membre leMembreInsere = DaoMembre.ajouterMembre(con, membre);
    
        
    
        
        ConnexionBdd.fermerConnexion(con);

    }
}
