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
public class Festival {
    private int idFestival;
    private String nom;
    private String dateFestival;
    private String lieu;
    private ArrayList<Groupe> lesGroupes;

    public Festival(int idFestival, String nom, String dateFestival, String lieu, ArrayList<Groupe> lesGroupes) {
        this.idFestival = idFestival;
        this.nom = nom;
        this.dateFestival = dateFestival;
        this.lieu = lieu;
        this.lesGroupes = lesGroupes;
    }

    public int getIdFestival() {
        return idFestival;
    }

    public void setIdFestival(int idFestival) {
        this.idFestival = idFestival;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDateFestival() {
        return dateFestival;
    }

    public void setDateFestival(String dateFestival) {
        this.dateFestival = dateFestival;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public ArrayList<Groupe> getLesGroupes() {
        return lesGroupes;
    }

    public void setLesGroupes(ArrayList<Groupe> lesGroupes) {
        this.lesGroupes = lesGroupes;
    }
    
    
    
    
    public Festival() {
    }

    
    
    public void addGroupe (Groupe unGroupe){
        if (lesGroupes == null){
            lesGroupes = new ArrayList<>();
        }
        lesGroupes.add(unGroupe);
    }

    
}
