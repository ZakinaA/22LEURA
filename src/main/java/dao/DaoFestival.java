/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Festival;
import model.Groupe;



/**
 *
 * @author sio2
 */
public class DaoFestival {
    
    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
    
    public static ArrayList<Festival> getlesFestivals(Connection connection){
        ArrayList<Festival> lesFestivals = new  ArrayList<Festival>();
        try
        {
            //preparation de la requete
            requete=connection.prepareStatement("select * from festival");
            System.out.println("Requete" + requete); 

            //executer la requete
            rs=requete.executeQuery();

            //On hydrate l'objet métier Groupe et sa relation Genre avec les résultats de la requête
            while ( rs.next() ) {


                Festival leFestival = new Festival();
                
                leFestival.setIdFestival(rs.getInt("festival.idFestival"));
                leFestival.setNom(rs.getString("festival.nom"));
                leFestival.setDateFestival(rs.getString("festival.date"));
                leFestival.setLieu(rs.getString("festival.lieu"));
                
                
                lesFestivals.add(leFestival);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesFestivals ;
    }
    
    public static Festival getLeFestival(Connection connection, int idFestival){

        Festival leFestival = new Festival();
        try
        {
            //preparation de la requete
            requete=connection.prepareStatement("select * from festival left join groupe on groupe.idGroupe = groupe.idGroupe where groupe.idGroupe = ?");
            requete.setInt(1, idFestival);
           /* System.out.println("Requete" + requete); */

            //executer la requete
            rs=requete.executeQuery();

            //On hydrate l'objet métier Groupe et sa relation Genre avec les résultats de la requête
            if ( rs.next() ) {

                

                leFestival.setIdFestival(rs.getInt("festival.idFestival"));
                leFestival.setNom(rs.getString("festival.nom"));
                leFestival.setDateFestival(rs.getString("festival.date"));
                leFestival.setLieu(rs.getString("festival.lieu"));

                Groupe leGroupe = new Groupe();
                leGroupe.setId(rs.getInt("groupe.idGroupe"));
                leGroupe.setNom(rs.getString("groupe.nom"));
                leGroupe.setDateCreation(rs.getString("groupe.dateCreation"));
                leGroupe.setTelephone(rs.getString("groupe.telephone"));
                leGroupe.setMelSiteWeb(rs.getString("groupe.melSiteWeb"));
                leGroupe.setLieurepetition(rs.getString("groupe.lieuRepetition"));


                //leFestival.setGroupe(leGroupe);

            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return leFestival ;
    }
    
    
    public static ArrayList<Festival> getLesFestivalsByGroupe (Connection connection, int idFestival){
        
        ArrayList<Festival> lesFestivals = new ArrayList<Festival>();
        
        try{
            requete = connection.prepareStatement("select * from festival left join groupe on festival.idGroupe = groupe.idGroupe");
            requete.setInt(1, idFestival);
            
            rs = requete.executeQuery();
            
            while (rs.next()){
                
                Festival leFestival = new Festival();
                
                leFestival.setIdFestival(rs.getInt("Festival.idFestival"));
                leFestival.setNom(rs.getString("Festival.nom"));
                leFestival.setLieu(rs.getString("Festival.Lieu"));
                leFestival.setDateFestival(rs.getString("lieuconcert.dateFestival"));
                
                Groupe leGroupe = new Groupe();
                leGroupe.setId(rs.getInt("groupe.idGroupe"));
                leGroupe.setNom(rs.getString("groupe.nom"));
                leGroupe.setDateCreation(rs.getString("groupe.dateCreation"));
                leGroupe.setTelephone(rs.getString("groupe.telephone"));
                leGroupe.setMelSiteWeb(rs.getString("groupe.melSiteWeb"));
                leGroupe.setLieurepetition(rs.getString("groupe.lieuRepetition"));
                
               
                //leFestival.setGroupe(leGroupe);
                leFestival.addGroupe(leGroupe);
            }
            
        }
        
        catch (SQLException e)
        {
            e.printStackTrace();
        } 
        return lesFestivals;
    }
    
}

