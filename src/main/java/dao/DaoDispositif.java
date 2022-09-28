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
import model.Dispositif;

/**
 *
 * @author sio2
 */
public class DaoDispositif {
    
    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
    
    public static ArrayList<Dispositif> getLesDispositifs (Connection connection){
        
        ArrayList<Dispositif> lesDispositifs  = new ArrayList<Dispositif>();
        try{
            requete=connection.prepareStatement("select * from dispositif");
            /*System.out.println("Requete" + requete);*/
        
            rs = requete.executeQuery();
        
            while (rs.next()){
            
                Dispositif leDispositif = new Dispositif();
                leDispositif.setId(rs.getInt("dispositif.idDispositif"));
                leDispositif.setLibelle(rs.getString("dispositif.libelle"));
                leDispositif.setAnnee(rs.getString("dispositif.annee"));
            
                lesDispositifs.add(leDispositif);
            
            }
        
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return lesDispositifs;
    }


    public static Dispositif ajouterDispositif (Connection connection, Dispositif unDispositif){
        int idGenere = -1;
        try{
            requete=connection.prepareStatement("insert into dispositif (dispositif.annee, dispositif.libelle) values (?,?)", requete.RETURN_GENERATED_KEYS);
            requete.setString(1, unDispositif.getAnnee());
            requete.setString(2, unDispositif.getLibelle());
             
            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);
            
            rs=requete.getGeneratedKeys();
            while (rs.next()){
                idGenere = rs.getInt(1);
                unDispositif.setId(idGenere);
            }
            
            if (resultatRequete != 1){
                unDispositif = null;
            }
    
        }
        
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return unDispositif ;
    }
}
