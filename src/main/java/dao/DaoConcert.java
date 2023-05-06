/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.DaoFestival.requete;
import static dao.DaoFestival.rs;
import static dao.DaoGroupe.requete;
import static dao.DaoGroupe.rs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Concert;
import model.Dispositif;
import model.Festival;
import model.Genre;
import model.Groupe;
import model.LieuConcert;
import model.Membre;

/**
 *
 * @author sio2
 */
public class DaoConcert {
    
    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
    public static ArrayList<Concert> getLesConcerts(Connection connection){
        ArrayList<Concert> lesConcerts = new  ArrayList<Concert>();
        try
        {
            //preparation de la requete
            requete=connection.prepareStatement("select * from donnerconcert left join lieuconcert on donnerconcert.idLieu = lieuconcert.idLieu inner join groupe on donnerconcert.idGroupe = groupe.idGroupe");
            System.out.println("Requete" + requete); 

            //executer la requete
            rs=requete.executeQuery();

            //On hydrate l'objet métier Groupe et sa relation Genre avec les résultats de la requête
            while ( rs.next() ) {
                
                
                Groupe leGroupe = new Groupe();
                leGroupe.setId(rs.getInt("groupe.idGroupe"));
                leGroupe.setNom(rs.getString("groupe.nom"));
                leGroupe.setDateCreation(rs.getString("groupe.dateCreation"));
                leGroupe.setTelephone(rs.getString("groupe.telephone"));
                leGroupe.setMelSiteWeb(rs.getString("groupe.melSiteWeb"));
                leGroupe.setLieurepetition(rs.getString("groupe.lieuRepetition"));


                Concert leConcert = new Concert();
                leConcert.setDateConcert(rs.getString("donnerconcert.dateConcert"));
      
                
                LieuConcert leLieuConcert = new LieuConcert ();
                leLieuConcert.setIdLieu(rs.getInt("lieuconcert.idLieu"));
                leLieuConcert.setNom(rs.getString("lieuconcert.nom"));
                leLieuConcert.setVille(rs.getString("lieuconcert.ville"));
                leLieuConcert.setCodePostal(rs.getString("lieuconcert.codePostal"));
                
                
                
                leConcert.setGroupe(leGroupe);
                leConcert.setLieuconcert(leLieuConcert);
                lesConcerts.add(leConcert);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesConcerts ;
    }
    
    public static Concert getLeConcert(Connection connection, int idLieu){

        Concert leConcert = new Concert();
        try
        {
            //preparation de la requete
            requete=connection.prepareStatement("select * from donnerconcert left join lieuconcert on donnerconcert.idLieu = lieuconcert.idLieu inner join groupe on donnerconcert.idGroupe = groupe.idGroupe = ?");
            requete.setInt(1, idLieu);
           /* System.out.println("Requete" + requete); */

            //executer la requete
            rs=requete.executeQuery();

            //On hydrate l'objet métier Groupe et sa relation Genre avec les résultats de la requête
            while ( rs.next() ) {
                
                leConcert.setDateConcert(rs.getString("donnerconcert.dateConcert"));
                
                Groupe leGroupe = new Groupe();
                leGroupe.setId(rs.getInt("groupe.idGroupe"));
                leGroupe.setNom(rs.getString("groupe.nom"));
                leGroupe.setDateCreation(rs.getString("groupe.dateCreation"));
                leGroupe.setTelephone(rs.getString("groupe.telephone"));
                leGroupe.setMelSiteWeb(rs.getString("groupe.melSiteWeb"));
                leGroupe.setLieurepetition(rs.getString("groupe.lieuRepetition"));
                
                LieuConcert leLieuConcert = new LieuConcert ();
                leLieuConcert.setIdLieu(rs.getInt("lieuconcert.idLieu"));
                leLieuConcert.setNom(rs.getString("lieuconcert.nom"));
                leLieuConcert.setVille(rs.getString("lieuconcert.ville"));
                leLieuConcert.setCodePostal(rs.getString("lieuconcert.codePostal"));

                leConcert.setLieuconcert(leLieuConcert);                
                leConcert.setGroupe(leGroupe);
                
                
                //leConcert.setLieuconcert(DaoConcert.getLesMembresGroupe(connection, idGroupe));
                //leConcert.setLesTitres(DaoGroupe.getLesTitresGroupe(connection, idGroupe));

            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return leConcert;
    }
    

}