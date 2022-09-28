/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import dao.DaoGroupe;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Dispositif;
import model.Genre;
import model.Groupe;
import model.Membre;
import model.Statut;
import model.Titre;


/**
 *
 * @author Zakina
 */
public class TestDaoGroupe {
    
    public static void main(String[] args) {
        Connection con = ConnexionBdd.ouvrirConnexion();
        
      Groupe leGroupe = DaoGroupe.getLeGroupe(con, 1);
        System.out.println(leGroupe.getNom());
        
        ArrayList<Groupe> lesGroupes = DaoGroupe.getLesGroupes(con);
        for (int i=0; i<lesGroupes.size(); i++){
            Groupe grp = lesGroupes.get(i);
            System.out.println("nom du groupe: "+ grp.getNom() + " genre du groupe: " + grp.getGenre().getLibelle());
        }
                
        ArrayList<Groupe> lesGroupesByDispo = DaoGroupe.getLesGroupesByDispositif(con, 1);
        for (int i=0; i<lesGroupesByDispo.size(); i++){
            Groupe grp2 = lesGroupesByDispo.get(i);
            System.out.println("nom des groupe pour le dispositif "+ grp2.getLeDispositif().getLibelle() + " : " + grp2.getNom());
        }
       
        
        ArrayList<Titre> lesTitres = DaoGroupe.getLesTitresGroupe(con, 1);
        for (int i=0; i<lesTitres.size(); i++){
            Titre titre = lesTitres.get(i);
            System.out.println("Titres du groupe " + titre.getGroupe().getNom() + " : " + titre.getIntitule() + " , " + titre.getDuree());
        }
        
        
        ArrayList<Membre> lesMembres = DaoGroupe.getLesMembresGroupe(con, 1);
        for (int i=0; i<lesMembres.size(); i++){
            Membre membre = lesMembres.get(i);
            System.out.println("nom : " + membre.getNom() + " prenom : " + membre.getPrenom());
        }
        
    
    /*    Groupe gp = new Groupe();
        gp.setNom("makitos");
        gp.setDateCreation("2015-05-26");
        
        Genre genre = new Genre();
        genre.setId(1);
        gp.setGenre(genre);
        
        Groupe leGroupeInsere = DaoGroupe.ajouterGroupe(con, gp);
    */
    
        ConnexionBdd.fermerConnexion(con);
    }
        
    }
    


