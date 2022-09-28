/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Zakina
 */
public class Groupe {
    
    private int id;
    private String nom;
    private String dateCreation;
    private String telephone;
    private String melSiteWeb;
    private String lieurepetition;
    private String estSelectionne;
    private Genre genre ;
    private Membre contact;
    private ArrayList<Membre> lesMembres;
    private ArrayList<Titre> lesTitres;
    private Dispositif leDispositif;
    private ArrayList<Jouer> jouer;
    
    

    public Groupe() {
    }

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

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMelSiteWeb() {
        return melSiteWeb;
    }

    public void setMelSiteWeb(String melSiteWeb) {
        this.melSiteWeb = melSiteWeb;
    }

    public String getLieurepetition() {
        return lieurepetition;
    }

    public void setLieurepetition(String lieurepetition) {
        this.lieurepetition = lieurepetition;
    }

    public String getEstSelectionne() {
        return estSelectionne;
    }

    public void setEstSelectionne(String estSelectionne) {
        this.estSelectionne = estSelectionne;
    }
    
    
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Membre getContact() {
        return contact;
    }

    public void setContact(Membre contact) {
        this.contact = contact;
    }

    public ArrayList<Membre> getLesMembres() {
        return lesMembres;
    }

    public void setLesMembres(ArrayList<Membre> lesMembres) {
        this.lesMembres = lesMembres;
    }

    public void addMembre (Membre unMembre){
        if ( lesMembres == null){
            lesMembres = new ArrayList<>();
        }
        lesMembres.add(unMembre);
    }

    public ArrayList<Titre> getLesTitres() {
        return lesTitres;
    }

    public void setLesTitres(ArrayList<Titre> lesTitres) {
        this.lesTitres = lesTitres;
    }
    
    public void addTitre (Titre unTitre){
        if ( lesTitres == null){
            lesTitres = new ArrayList<>();
        }
        lesTitres.add(unTitre);
    }

    public Dispositif getLeDispositif() {
        return leDispositif;
    }

    public void setLeDispositif(Dispositif leDispositif) {
        this.leDispositif = leDispositif;
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
