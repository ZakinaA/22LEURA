/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author sio2
 */
public class ParticiperFestival {
    
   private Groupe groupe;
   private Festival festival;
   
   
   public ParticiperFestival() {
    }

    public ParticiperFestival(Groupe groupe, Festival festival) {
        this.groupe = groupe;
        this.festival = festival;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public Festival getFestival() {
        return festival;
    }

    public void setFestival(Festival festival) {
        this.festival = festival;
    }
}