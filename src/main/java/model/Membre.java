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
public class Membre {
    
    private int id;
    private String nom;
    private String prenom;
    private ArrayList<Groupe> lesGroupes;
    private ArrayList<Groupe> contactGroupe;
    private Instrument instrumentPrefere;
    private Statut statut;
    private ArrayList<Jouer> jouer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public ArrayList<Groupe> getLesGroupes() {
        return lesGroupes;
    }

    public void setLesGroupes(ArrayList<Groupe> lesGroupes) {
        this.lesGroupes = lesGroupes;
    }

    public ArrayList<Groupe> getContactGroupe() {
        return contactGroupe;
    }

    public void setContactGroupe(ArrayList<Groupe> contactGroupe) {
        this.contactGroupe = contactGroupe;
    }

    public Instrument getInstrumentPrefere() {
        return instrumentPrefere;
    }

    public void setInstrumentPrefere(Instrument instrumentPrefere) {
        this.instrumentPrefere = instrumentPrefere;
    }
    
    
    
    public void addGroupe (Groupe unGroupe){
        if (lesGroupes == null){
            lesGroupes = new ArrayList<>();
        }
        lesGroupes.add(unGroupe);
    }
        
    
    public void addContactGroupe (Groupe unGroupe){
        if ( contactGroupe == null){
            contactGroupe = new ArrayList<>();
        }
        contactGroupe.add(unGroupe);
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
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
