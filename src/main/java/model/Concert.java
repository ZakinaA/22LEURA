/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import model.Groupe;

import java.util.ArrayList;

/**
 *
 * @author sio2
 */
public class Concert {
    
    private String dateConcert;
    private ArrayList<Groupe> lesGroupes;
    private Groupe groupe;
    private ArrayList<LieuConcert> lesLieuConcerts;
    private LieuConcert lieuconcert;
    
    
    public Concert() {
    }
    
    public Concert(String dateConcert, ArrayList<Groupe> lesGroupes, Groupe groupe, ArrayList<LieuConcert> lesLieuConcerts, LieuConcert lieuconcert) {
        this.dateConcert = dateConcert;
        this.lesGroupes = lesGroupes;
        this.groupe = groupe;
        this.lesLieuConcerts = lesLieuConcerts;
        this.lieuconcert = lieuconcert;
    }

    public String getDateConcert() {
        return dateConcert;
    }

    public void setDateConcert(String dateConcert) {
        this.dateConcert = dateConcert;
    }

    public ArrayList<Groupe> getLesGroupes() {
        return lesGroupes;
    }

    public void setLesGroupes(ArrayList<Groupe> lesGroupes) {
        this.lesGroupes = lesGroupes;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public ArrayList<LieuConcert> getLesLieuConcerts() {
        return lesLieuConcerts;
    }

    public void setLesLieuConcerts(ArrayList<LieuConcert> lesLieuConcerts) {
        this.lesLieuConcerts = lesLieuConcerts;
    }

    public LieuConcert getLieuconcert() {
        return lieuconcert;
    }

    public void setLieuconcert(LieuConcert lieuconcert) {
        this.lieuconcert = lieuconcert;
    }
    
    /*
    public void addGroupe (Groupe unGroupe){
        if (Groupe == null){
            Groupe = new ArrayList<>();
        }
        Groupe.add(unGroupe);
    }
    
    
    public void addLieuConcert (LieuConcert unLieuConcert){
        if (lieuconcert == null){
            lieuconcert = new ArrayList<>();
        }
        lieuconcert.add(unLieuConcert);
    }
    */
}