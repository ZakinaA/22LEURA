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
import model.Genre;

/**
 *
 * @author Zakina
 */
public class DaoAdmin {

    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;

    public static ArrayList<Genre> getLesGenres(Connection connection){
        ArrayList<Genre> lesGenres = new  ArrayList<Genre>();
        try
        {
            requete=connection.prepareStatement("select * from  genremusical ");
            rs=requete.executeQuery();
            while ( rs.next() ) {

                Genre leGenre = new Genre();
                leGenre.setId(rs.getInt("genremusical.idGenre"));
                leGenre.setLibelle(rs.getString("genremusical.libelle"));
                lesGenres.add(leGenre);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesGenres ;
    }
    
}
