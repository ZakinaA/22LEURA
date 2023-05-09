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
import model.Dispositif;
import model.Genre;
import model.Groupe;
import model.Instrument;
import model.Jouer;
import model.Membre;
import model.Titre;
import model.Statut;
//import sun.tools.tree.ThisExpression;
import test.ConnexionBdd;

/**
 *
 * @author Zakina
 */
public class DaoGroupe {
    Connection connection=null;
    static PreparedStatement requete=null;
    static ResultSet rs=null;

    
    
        public static ArrayList<Groupe> getLesGroupesByDispositif (Connection connection , int unDispositif){
        
        ArrayList<Groupe> lesGroupes = new ArrayList<Groupe>();
        try{
            
            requete=connection.prepareStatement("select * from groupe, dispositif where groupe.idDispositif = dispositif.idDispositif AND groupe.idDispositif = ?");
            requete.setInt(1, unDispositif);

           /* System.out.println("requete " + requete); */
            
            rs=requete.executeQuery();
            
            while (rs.next()){
                
                Groupe leGroupe = new Groupe();
                leGroupe.setId(rs.getInt("groupe.idGroupe"));
                leGroupe.setNom(rs.getString("groupe.nom"));               
                
                Dispositif leDispositif = new Dispositif();
                leDispositif.setId(rs.getInt("dispositif.idDispositif"));
                leDispositif.setLibelle(rs.getString("dispositif.libelle"));
                
                leGroupe.setLeDispositif(leDispositif);
                lesGroupes.add(leGroupe);
            }
            
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesGroupes ;
    }
    
    
    public static ArrayList<Groupe> getLesGroupes(Connection connection){
        ArrayList<Groupe> lesGroupes = new  ArrayList<Groupe>();
        try
        {
            //preparation de la requete
            requete=connection.prepareStatement("select * from groupe left join membre on groupe.idMembre = membre.idMembre inner join genremusical on groupe.idGenre = genremusical.idGenre");
            System.out.println("Requete" + requete); 

            //executer la requete
            rs=requete.executeQuery();

            //On hydrate l'objet métier Groupe et sa relation Genre avec les résultats de la requête
            while ( rs.next() ) {


                Groupe leGroupe = new Groupe();
                leGroupe.setId(rs.getInt("groupe.idGroupe"));
                leGroupe.setNom(rs.getString("groupe.nom"));
                leGroupe.setDateCreation(rs.getString("groupe.dateCreation"));
                leGroupe.setTelephone(rs.getString("groupe.telephone"));
                leGroupe.setMelSiteWeb(rs.getString("groupe.melSiteWeb"));
                leGroupe.setLieurepetition(rs.getString("groupe.lieuRepetition"));
                
                Membre leContact = new Membre();
                leContact.setNom(rs.getString("membre.nom"));
                leContact.setPrenom(rs.getString("membre.prenom"));
                leContact.setId(rs.getInt("groupe.idMembre"));

                Genre leGenre = new Genre();
                leGenre.setId(rs.getInt("genremusical.idGenre"));
                leGenre.setLibelle(rs.getString("genremusical.libelle"));

                leGroupe.setGenre(leGenre);
                leGroupe.setContact(leContact);
                lesGroupes.add(leGroupe);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return lesGroupes ;
    }


    public static Groupe getLeGroupe(Connection connection, int idGroupe){

        Groupe leGroupe = new Groupe();
        try
        {
            //preparation de la requete
            requete=connection.prepareStatement("select * from groupe left join membre on groupe.idMembre = membre.idMembre left join genremusical on groupe.idGenre = genremusical.idGenre left join dispositif on groupe.idDispositif = dispositif.idDispositif where groupe.idGroupe = ?");
            requete.setInt(1, idGroupe);
           /* System.out.println("Requete" + requete); */

            //executer la requete
            rs=requete.executeQuery();

            //On hydrate l'objet métier Groupe et sa relation Genre avec les résultats de la requête
            while ( rs.next() ) {

                leGroupe.setId(rs.getInt("groupe.idGroupe"));
                leGroupe.setNom(rs.getString("groupe.nom"));
                leGroupe.setDateCreation(rs.getString("groupe.dateCreation"));
                leGroupe.setTelephone(rs.getString("groupe.telephone"));
                leGroupe.setMelSiteWeb(rs.getString("groupe.melSiteWeb"));
                leGroupe.setLieurepetition(rs.getString("groupe.lieuRepetition"));
                

                Membre membreContact = new Membre();
                membreContact.setId(rs.getInt("membre.idMembre"));
                membreContact.setNom(rs.getString("membre.nom"));
                membreContact.setPrenom(rs.getString("membre.prenom"));

                
                Genre leGenre = new Genre();
                leGenre.setId(rs.getInt("genremusical.idGenre"));
                leGenre.setLibelle(rs.getString("genremusical.libelle"));
                
                Dispositif leDispositif = new Dispositif();
                leDispositif.setId(rs.getInt("dispositif.idDispositif"));
                leDispositif.setLibelle(rs.getString("dispositif.libelle"));

                leGroupe.setContact(membreContact);                
                leGroupe.setGenre(leGenre);
                leGroupe.setLeDispositif(leDispositif);
                
                leGroupe.setLesMembres(DaoGroupe.getLesMembresGroupe(connection, idGroupe));
                leGroupe.setLesTitres(DaoGroupe.getLesTitresGroupe(connection, idGroupe));

            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
        }
        return leGroupe ;
    }

    
    
    public static ArrayList<Membre> getLesMembresGroupe (Connection connection, int idGroupe){
        
        ArrayList<Membre> lesMembres = new ArrayList<Membre>();
        try{
            requete=connection.prepareStatement("select * from membre, jouer, groupe where jouer.idMembre = membre.idMembre and jouer.idGroupe = groupe.idGroupe and groupe.idGroupe =?");
            requete.setInt(1, idGroupe);
            System.out.println("Requete" + requete);
            
            rs = requete.executeQuery();
            
            while (rs.next()){
                
                Membre leMembre = new Membre();
                leMembre.setId(rs.getInt("membre.idMembre"));
                leMembre.setNom(rs.getString("membre.nom"));
                leMembre.setPrenom(rs.getString("membre.prenom"));
                
                Groupe leGroupe = new Groupe();
                leGroupe.setId(rs.getInt("groupe.idGroupe"));
                leGroupe.setNom(rs.getString("groupe.nom"));
                
                
                leMembre.addContactGroupe(leGroupe);
                lesMembres.add(leMembre);
                
            }
        }
     
        catch (SQLException e)
        {
            e.printStackTrace();
        } 
        return lesMembres;
    }
    
    
    public static ArrayList<Instrument> getLesInstrumentByMembre (Connection connection, int idMembre){
        ArrayList<Instrument> lesInstruments = new ArrayList<Instrument>();
        
        try{
            requete = connection.prepareStatement("select instrument.idInstrument, instrument.libelle, membre.idMembre, membre.nom from membre, instrument, jouer where jouer.idMembre = membre.idMembre and jouer.idInstrument = instrument.idInstrument and jouer.idMembre=? ");
            requete.setInt(1, idMembre);
            
            rs = requete.executeQuery();
            
            while (rs.next()){
                Instrument unInstrument = new Instrument();
                unInstrument.setIdInstrument(rs.getInt("instrument.idInstrument"));
                unInstrument.setLibelle(rs.getString("instrument.libelle"));
                
                Membre leMembre = new Membre();
                leMembre.setNom(rs.getString("membre.nom"));
                leMembre.setId(idMembre);
                
                Jouer jouerGroupe = new Jouer();
                jouerGroupe.setMembre(leMembre);
                jouerGroupe.setInstrument(unInstrument);
                
                lesInstruments.add(unInstrument);
            }
            
        }
        
        catch (SQLException e)
        {
            e.printStackTrace();
        } 
        return lesInstruments;
    }
    
    
    public static ArrayList<Titre> getLesTitresGroupe (Connection connection, int idGroupe){
        
        ArrayList<Titre> lesTitres = new ArrayList<Titre>();
        try{
            requete=connection.prepareStatement("select * from titre, groupe where titre.idGroupe = groupe.idGroupe and groupe.idGroupe=?");
            requete.setInt(1, idGroupe);
            System.out.println("Requete" + requete);
            
            rs = requete.executeQuery();
            
            while (rs.next()){
                
                Titre leTitre = new Titre();
                leTitre.setNumero(rs.getInt("titre.numero"));
                leTitre.setIntitule(rs.getString("titre.intitule"));
                leTitre.setDuree(rs.getString("titre.duree"));
                
                Groupe leGroupe = new Groupe();
                leGroupe.setId(rs.getInt("groupe.idGroupe"));
                leGroupe.setNom(rs.getString("groupe.nom"));
                
                leTitre.setGroupe(leGroupe);
                lesTitres.add(leTitre);
            }
            
        }
    
        catch (SQLException e){
        e.printStackTrace();
        }
        return lesTitres;
    }
  
    
    public static int  updateGroupe (Connection connection, Groupe leGroupe){
    int resultatUpdate = -1;
    try{
        
        requete = connection.prepareStatement("UPDATE groupe SET groupe.nom=?, groupe.dateCreation=?, groupe.telephone=?,groupe.melSiteWeb=?,groupe.lieuRepetition=?,groupe.estSelectionne=?,groupe.idGenre=?, groupe.idMembre=? WHERE groupe.idGroupe=?");
        
        requete.setString(1, leGroupe.getNom());
        requete.setString(2, leGroupe.getDateCreation());
        requete.setString(3, leGroupe.getTelephone());
        requete.setString(4, leGroupe.getMelSiteWeb());
        requete.setString(5, leGroupe.getLieurepetition());
        requete.setString(6, leGroupe.getEstSelectionne());
        requete.setString(7, leGroupe.getGenre().getLibelle());
        requete.setString(9, leGroupe.getContact().getNom());

        
        resultatUpdate = requete.executeUpdate();
        
        ConnexionBdd.fermerConnexion(rs);
        ConnexionBdd.fermerConnexion(requete);
        
    }
    
    catch(SQLException e){
        e.printStackTrace();
    }
    return resultatUpdate;
    
}
    
    
    public static Groupe ajouterGroupe(Connection connection, Groupe unGroupe){
        int idGenere = -1;
        try
        {
            //preparation de la requete
            // groupe.idGroupe (clé primaire de la table groupe) est en auto_increment,donc on ne renseigne pas cette valeur
            // le paramètre RETURN_GENERATED_KEYS est ajouté à la requête afin de pouvoir récupérer l'id généré par la bdd (voir ci-dessous)
            // supprimer ce paramètre en cas de requête sans auto_increment.
            requete=connection.prepareStatement("INSERT INTO GROUPE ( groupe.nom, groupe.dateCreation, groupe.idGenre, groupe.telephone, groupe.melSiteWeb, groupe.lieuRepetition)\n" +
                    "VALUES (?,?,?,?,?,?)", requete.RETURN_GENERATED_KEYS );
            requete.setString(1, unGroupe.getNom());
            requete.setString(2, unGroupe.getDateCreation());
            requete.setInt(3, unGroupe.getGenre().getId());
            requete.setString(4, unGroupe.getTelephone());
            requete.setString(5, unGroupe.getMelSiteWeb());
            requete.setString(6, unGroupe.getLieurepetition());

            System.out.println("requeteInsertion=" + requete);
            /* Exécution de la requête */
            int resultatRequete = requete.executeUpdate();
            System.out.println("resultatrequete=" + resultatRequete);

            // Récupération de id auto-généré par la bdd dans la table groupe
            rs = requete.getGeneratedKeys();
            while ( rs.next() ) {
                idGenere = rs.getInt( 1 );
                unGroupe.setId(idGenere);
            }

            // si le résultat de la requete est différent de 1, c'est que la requête a échoué.
            // Dans ce cas, on remet l'objet groupe à null
            if (resultatRequete != 1){
                unGroupe= null;
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
            //out.println("Erreur lors de l’établissement de la connexion");
            unGroupe= null;
        }
        return unGroupe ;
    }

public static int  supprimerGroupe (Connection connection, Groupe leGroupe){
    int resultatDelete = -1;
    try{
        
        requete = connection.prepareStatement("DELETE FROM groupe WHERE groupe.idGroupe=?");
        
        requete.setString(1, leGroupe.getNom());

        resultatDelete = requete.executeUpdate();
        
        ConnexionBdd.fermerConnexion(rs);
        ConnexionBdd.fermerConnexion(requete);
        
    }
    
    catch(SQLException e){
        e.printStackTrace();
    }
    return resultatDelete;
    
}
}
