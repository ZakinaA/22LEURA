/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import dao.DaoInstrument;
import java.sql.Connection;
import java.util.ArrayList;
import model.Instrument;

/**
 *
 * @author sio2
 */
public class TestDaoInstrument {
    
    public static void main(String[] args){
        Connection con = ConnexionBdd.ouvrirConnexion();
        
        ArrayList<Instrument> lesInstruments = DaoInstrument.getLesInstruments(con);
        for (int i=0; i<lesInstruments.size(); i++){
            Instrument instru = lesInstruments.get(i);
            System.out.println("Instruments n° " + instru.getIdInstrument() + " : " + instru.getLibelle());
        }
        

    
        ConnexionBdd.fermerConnexion(con);
    }

}
