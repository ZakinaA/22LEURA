package form;



import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import model.Utilisateur;

public class FormUtilisateur {

    private String resultat;
    private Map<String, String> erreurs      = new HashMap<String, String>();

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
    private void validationUsername( String Username ) throws Exception {
        if ( Username != null && Username.length() < 3 ) {
            throw new Exception( "Le pseudo doit contenir au moins 3 caractères." );
        }
    }

    private void validationPassword( String Password) throws Exception {
        if ( Password != null && Password.length() <8   ) {
            throw new Exception( "le mot de passe est trop faible" );
        }
    }
    
        private void validationMail( String Mail) throws Exception {
        if ( Mail != null && Mail.length() <5   ) {
            throw new Exception( "le mail n'est pas bon" );
        }
    }
            private void validationTel( String Tel) throws Exception {
        if ( Tel != null && Tel.length() <10   ) {
            throw new Exception( "le numéro n'est pas valide" );
        }
    }
                private void validationRue( String Rue) throws Exception {
        if (  Rue != null && Rue.length() <1    ) {
            throw new Exception( "champ obligatoire" );
        }
    }
                private void validationVille( String Ville) throws Exception {
        if (  Ville != null && Ville.length() <1    ) {
            throw new Exception( "champ obligatoire" );
        }
    }
                private void validationCp( String Cp) throws Exception {
        if (  Cp != null && Cp.length() <5  ) {
            throw new Exception( "Le code postal n'est pas bon" );
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
    public Utilisateur ajouterUtilisateur(HttpServletRequest request ) {

        Utilisateur unUtilisateur  = new Utilisateur();

        //récupération dans des variables des données saisies dans les champs de formulaire
        String username = getDataForm( request, "username" );
        String password = getDataForm( request, "password");
        String mail = getDataForm( request, "mail");
        String tel = getDataForm( request, "tel");
        String rue = getDataForm( request, "rue");
        String ville = getDataForm( request, "ville");
        String cp = getDataForm( request, "cp");
        
        try {
            validationUsername(username );
        } catch ( Exception e ) {
            setErreur( "username", e.getMessage() );
        }
         unUtilisateur.setUsername(username);
         
        try {
            validationPassword(password);
        } catch ( Exception e ) {
            setErreur( "password", e.getMessage() );
        }
        unUtilisateur.setPassword(password);
        
        try {
            validationMail(mail);
        } catch ( Exception e ) {
            setErreur( "mail", e.getMessage() );
        }
        unUtilisateur.setMail(mail);
        
        try {
            validationTel(tel);
        } catch ( Exception e ) {
            setErreur( "tel", e.getMessage() );
        }
        unUtilisateur.setTel(tel);
        
        try {
            validationRue(rue);
        } catch ( Exception e ) {
            setErreur( "rue", e.getMessage() );
        }
        unUtilisateur.setRue(rue);
       
        try {
            validationVille(ville);
        } catch ( Exception e ) {
            setErreur( "ville", e.getMessage() );
        }
        unUtilisateur.setVille(ville);
        
        try {
            validationCp(cp);
        } catch ( Exception e ) {
            setErreur( "cp", e.getMessage() );
        }
        unUtilisateur.setCp(cp);
   

        if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'ajout.";
        } else {
            resultat = "Échec de l'ajout.";
        }
        System.out.println("resultat erreurs="+resultat);

        // hydratation de l'objet groupe avec les variables valorisées ci-dessus

        
        return unUtilisateur;
    }
}

