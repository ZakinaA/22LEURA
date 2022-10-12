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
        if ( Password != null && Password.length() <10  ) {
            throw new Exception( "le mot de passe est trop faible" );
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
