/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.DaoGroupe.requete;
import static dao.DaoGroupe.rs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Dispositif;
import model.Genre;
import model.Groupe;
import model.Instrument;
import model.Membre;
import model.Statut;
import model.Utilisateur;

/**
 *
 * @author sio2
 */
public class DaoMembre {
    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;


    public static Membre ajouterMembre (Connection connection, Membre unMembre){
        int idGenere = -1;
        try{
            requete=connection.prepareStatement("insert into membre (membre.nom, membre.prenom, membre.statut) values (?,?,?)");
            requete.setString(1, unMembre.getNom());
            requete.setString(2, unMembre.getPrenom());
            requete.setInt(3, unMembre.getStatut().getId());
            
            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unMembre.setId(idGenere);
            }
            
            if (resultatRequete != 1){
                unMembre= null;
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        } 
        return unMembre;
    }
    
    
    public static Membre getLeMembre(Connection connection, int idMembre){

        Membre leMembre = new Membre();
        try
        {
            //preparation de la requete
            requete=connection.prepareStatement("select * from membre left join instrument on membre.idInstrumentPref = instrument.idInstrument left join statut on membre.statut = statut.idStatut left join utilisateur on membre.idUtilisateur = utilisateur.idUtilisateur where membre.idMembre = ? ");
            requete.setInt(1, idMembre);
           /* System.out.println("Requete" + requete); */

            //executer la requete
            rs=requete.executeQuery();

            //On hydrate l'objet métier Groupe et sa relation Genre avec les résultats de la requête
            while ( rs.next() ) {

                leMembre.setId(rs.getInt("membre.idMembre"));
                leMembre.setNom(rs.getString("membre.nom"));
                leMembre.setPrenom(rs.getString("membre.prenom"));
                
           
                Instrument instrumentPref = new Instrument();
                instrumentPref.setIdInstrument(rs.getInt("membre.idInstrumentPref"));
                
                
                Statut leStatut = new Statut();
                leStatut.setId(rs.getInt("membre.statut"));

                
                Utilisateur unUtilisateur = new Utilisateur();
                unUtilisateur.setMembre(leMembre);
                
                
                leMembre.setInstrumentPrefere(instrumentPref);                
                leMembre.setStatut(leStatut);
                

            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return leMembre ;
    }
    
    
    
     public static ArrayList<Membre> getLesMembres(Connection connection){
        ArrayList<Membre> lesMembres = new  ArrayList<Membre>();
        try
        {
            requete=connection.prepareStatement("select * from  membre ");
            rs=requete.executeQuery();
            while ( rs.next() ) {

                Membre leMembre = new Membre();
                leMembre.setId(rs.getInt("membre.idMembre"));
                leMembre.setPrenom(rs.getString("membre.prenom"));
                leMembre.setNom(rs.getString("membre.nom"));
                lesMembres.add(leMembre);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesMembres ;
    }
    
}