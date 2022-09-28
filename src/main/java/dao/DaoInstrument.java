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
import model.Instrument;

/**
 *
 * @author sio2
 */
public class DaoInstrument {
    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
    
    public static ArrayList<Instrument> getLesInstruments (Connection connection){
        ArrayList<Instrument> lesInstruments = new ArrayList<Instrument>();
        
        try{
          
            requete = connection.prepareStatement("select * from instrument");
            
            rs=requete.executeQuery();
            
            while (rs.next()){
                
                Instrument unInstrument = new Instrument();
                unInstrument.setIdInstrument(rs.getInt("instrument.idInstrument"));
                unInstrument.setLibelle(rs.getString("instrument.libelle"));
                
                lesInstruments.add(unInstrument);
            }
            
        }
        
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    
        return lesInstruments;
    }
    
}
