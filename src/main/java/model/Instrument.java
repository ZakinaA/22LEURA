/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author sio2
 */
public class Instrument {
    
private int idInstrument;
private String libelle;
private ArrayList<Membre> lesMembres;
private ArrayList<Jouer> jouer;

    public int getIdInstrument() {
        return idInstrument;
    }

    public void setIdInstrument(int idInstrument) {
        this.idInstrument = idInstrument;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public ArrayList<Membre> getLesMembres() {
        return lesMembres;
    }

    public void setLesMembres(ArrayList<Membre> lesMembres) {
        this.lesMembres = lesMembres;
    }


    public void addUnMembre (Membre unMembre){
        if (lesMembres == null){
            lesMembres = new ArrayList<>(); 
        }
        lesMembres.add(unMembre); 
    }

    public ArrayList<Jouer> getJouer() {
        return jouer;
    }

    public void setJouer(ArrayList<Jouer> jouer) {
        this.jouer = jouer;
    }

    public void addJouer (Jouer unJouer){
        if (jouer == null){
            jouer = new ArrayList<>();
        }
        jouer.add(unJouer);
    }

}
