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
import model.Membre;

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
}