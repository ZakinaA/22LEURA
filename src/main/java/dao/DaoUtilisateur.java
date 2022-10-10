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
import model.Utilisateur;
import model.Groupe;
import model.Membre;

/**
 *
 * @author sio2
 */
public class DaoUtilisateur {
    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;

    /*a faire getUtilisateur*/

    public static Utilisateur ajouterUtilisateur (Connection connection, Utilisateur unUtilisateur){
        int idGenere = -1;
        try{
                       requete=connection.prepareStatement("INSERT INTO UTILISATEUR ( utilisateur.username, utilisateur.password VALUES (?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setString(1, unUtilisateur.getUsername());
            requete.setString(2, unUtilisateur.getPassword());
            
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
