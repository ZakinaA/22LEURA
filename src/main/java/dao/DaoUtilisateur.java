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
            requete=connection.prepareStatement("select * from utilisateur");
            /*System.out.println("Requete" + requete);*/
        
            rs = requete.executeQuery();
        
            while (rs.next()){
            
                Utilisateur leUtilisateur = new Utilisateur();
                leUtilisateur.setUsername(rs.getString("Utilisateur.username"));
                leUtilisateur.setPassword(rs.getString("Utilisateur.password"));
                
            
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
                       requete=connection.prepareStatement("INSERT INTO UTILISATEUR ( utilisateur.username, utilisateur.password, utilisateur.categorie) VALUES (?,?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setString(1, unUtilisateur.getUsername());
            requete.setString(2, unUtilisateur.getPassword());
            requete.setInt(3, 2);
            
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
}
