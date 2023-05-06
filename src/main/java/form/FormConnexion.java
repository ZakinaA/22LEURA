/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form;

import java.util.HashMap;
import model.Utilisateur;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author sio2
 */
public class FormConnexion {
    private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();
    
    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public void setErreurs(Map<String, String> erreurs) {
        this.erreurs = erreurs;
    }

    
    
     //méthode de validation du champ de saisie nom
    private void validationUsername( String username ) throws Exception {
        if ( username != null && username.length() < 1 ) {
            throw new Exception( "Le nom d'utilisateur doit au moins contenir un caractère !" );
        }
    }
    
     //méthode de validation du champ de saisie du mot de passe
    private void validationPassword( String password ) throws Exception {
        if ( password != null && password.length() < 1 ) {
            throw new Exception( "Le mot de passe doit au moins contenir un caractère !" );
        }
    }
    
    private void setErreur( String champ, String message ) {
        erreurs.put(champ, message );
    }
    
    private static String getDataForm(HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }
    }
    
        // creation d'un objet groupe (et son genre) à partir des données saisies dans le formulaire
    
    public Utilisateur getUtilisateur(HttpServletRequest request){
        
        Utilisateur unUtilisateur = new Utilisateur();
        
        //récupération dans des variables des données saisies dans les champs de formulaire
        String username = getDataForm( request, "username");
        String password = getDataForm( request, "password");
        
        try {
            validationUsername( username );
        } catch ( Exception e ) {
            setErreur( "username", e.getMessage() );
        }
         unUtilisateur.setUsername(username);
         
        try {
            validationPassword( password );
        } catch ( Exception e ) {
            setErreur( "password", e.getMessage() );
        }
         unUtilisateur.setPassword(password);
        return unUtilisateur;
         
        
        
    }}
         
        /*if ( erreurs.isEmpty() ) {
            resultat = "Succès de la récupération.";
        } else {
            resultat = "Échec de la récupération.";
        }
        System.out.println("resultat erreurs="+resultat);
        return unUtilisateur;*/
    

    
