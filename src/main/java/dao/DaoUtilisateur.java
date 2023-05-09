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
import model.Categorie;
import model.Utilisateur;
import model.Membre;

/**
 *
 * @author sio2
 */
public class DaoUtilisateur {
    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;

    public static ArrayList<Utilisateur> getLesUtilisateurs (Connection connection){
        
        ArrayList<Utilisateur> lesUtilisateurs  = new ArrayList<Utilisateur>();
        try{
            requete=connection.prepareStatement("select * from utilisateur,membre");
            /*System.out.println("Requete" + requete);*/
        
            rs = requete.executeQuery();
        
            while (rs.next()){
            
                Utilisateur leUtilisateur = new Utilisateur();
                leUtilisateur.setUsername(rs.getString("Utilisateur.username"));
                leUtilisateur.setPassword(rs.getString("Utilisateur.password"));
                leUtilisateur.setMail(rs.getString("Utilisateur.mail"));
                leUtilisateur.setTel(rs.getString("Utilisateur.tel"));
                leUtilisateur.setRue(rs.getString("Utilisateur.rue"));
                leUtilisateur.setVille(rs.getString("Utilisateur.ville"));
                leUtilisateur.setCp(rs.getString("Utilisateur.cp"));
                
            
                Membre leMembre = new Membre();
                leMembre.setId(rs.getInt("membre.idMembre"));
                leMembre.setNom(rs.getString("membre.nom"));
                leMembre.setPrenom(rs.getString("membre.prenom"));
                
                leUtilisateur.setMembre(leMembre);
                
                lesUtilisateurs.add(leUtilisateur);
            
            }
        
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return lesUtilisateurs;
    }

    public static Utilisateur ajouterUtilisateur (Connection connection, Utilisateur unUtilisateur){
        int idGenere = -1;
        try{
            requete=connection.prepareStatement("INSERT INTO utilisateur ( utilisateur.username, utilisateur.password,utilisateur.mail,utilisateur.tel,utilisateur.rue,utilisateur.ville,utilisateur.cp, utilisateur.categorie) VALUES (?,?,?,?,?,?,?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setString(1, unUtilisateur.getUsername());
            requete.setString(2, unUtilisateur.getPassword());
            requete.setString(3, unUtilisateur.getMail());
            requete.setString(4, unUtilisateur.getTel());
            requete.setString(5, unUtilisateur.getRue());
            requete.setString(6, unUtilisateur.getVille());
            requete.setString(7, unUtilisateur.getCp());
            requete.setInt(8, 2);
            
            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unUtilisateur.setIdUtilisateur(idGenere);
            }
            
            if (resultatRequete != 1){
                unUtilisateur= null;
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        } 
        return unUtilisateur;
    }
    
    public static Utilisateur getUtilisateur (Connection connection, Utilisateur unUtilisateur){
        int idGenere = -1;
        try{
            requete=connection.prepareStatement("SELECT * FROM utilisateur WHERE ( utilisateur.username, utilisateur.password) VALUES(?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setString(1, unUtilisateur.getUsername());
            requete.setString(2, unUtilisateur.getPassword());
            requete.setString(3, unUtilisateur.getMail());
            requete.setString(4, unUtilisateur.getTel());
            requete.setString(5, unUtilisateur.getRue());
            requete.setString(6, unUtilisateur.getVille());
            requete.setString(7, unUtilisateur.getCp());
            requete.setInt(8, 2);
 
            
            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unUtilisateur.setIdUtilisateur(idGenere);
            }
            
            if (resultatRequete != 1){
                unUtilisateur= null;
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        } 
        return unUtilisateur;
    }

public static Utilisateur getLeUtilisateur(Connection connection, Utilisateur util ){
            System.out.println("avant try ");
        Utilisateur leUtilisateur = new Utilisateur();
        try
        {
             System.out.println("avant requete");
               System.out.println("connection" + connection.getSchema());
            //preparation de la requete
            requete=connection.prepareStatement("select * from utilisateur where username = ? AND password = ?");
            requete.setString(1, util.getUsername());
            requete.setString(2, util.getPassword());
            System.out.println("RequetegetleUtilisateur" + requete); 

            //executer la requete
            rs=requete.executeQuery();

            //On hydrate l'objet métier Groupe et sa relation Genre avec les résultats de la requête
            while ( rs.next() ) {

                leUtilisateur.setUsername(rs.getString("utilisateur.username"));
                leUtilisateur.setPassword(rs.getString("utilisateur.password"));

            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Erreur lors de l’établissement de la connexion");
        }
        return leUtilisateur ;
    }







}
