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
public class Categorie {
    
    private int idCategorie;
    private String libelle;
    private ArrayList<Utilisateur> lesUtilisateurs;

    public Categorie() {
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public ArrayList<Utilisateur> getLesUtilisateurs() {
        return lesUtilisateurs;
    }

    public void setLesUtilisateurs(ArrayList<Utilisateur> lesUtilisateurs) {
        this.lesUtilisateurs = lesUtilisateurs;
    }
    
    
        public void addUtilisateur (Utilisateur unUtilisateur){
        if (lesUtilisateurs == null){
            lesUtilisateurs = new ArrayList<>();
        }
        lesUtilisateurs.add(unUtilisateur);
    }
    
    
    
}

