package form;

import model.Genre;
import model.Groupe;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class FormGroupe {

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
    private void validationNom( String nom ) throws Exception {
        if ( nom != null && nom.length() < 3 ) {
            throw new Exception( "Le nom de groupe doit contenir au moins 3 caractères." );
        }
    }

    private void validationDateCreation( String dateCreation) throws Exception {
        if ( dateCreation != null && dateCreation.length() <10  ) {
            throw new Exception( "la date de création est erronnée" );
        }
    }
    
    private void validationTelephone( String telephone) throws Exception {
        if ( telephone != null && telephone.length() <10  ) {
            throw new Exception( "Le numéro de téléphone n'est pas valide" );
        }
    }
    
    private void setErreur( String champ, String message ) {
        erreurs.put(champ, message );
    }
    
    private void validationMelSiteWeb( String melSiteWeb) throws Exception {
        if ( melSiteWeb != null && melSiteWeb.length() <4  ) {
            throw new Exception( "Erreur sur ce champ" );
        }
    }
    
    private void validationLieuRepetition( String lieuRepetition) throws Exception {
        if ( lieuRepetition != null && lieuRepetition.length() <3  ) {
            throw new Exception( "Erreur sur ce champ" );
        }
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
    public Groupe ajouterGroupe(HttpServletRequest request ) {

        Groupe unGroupe  = new Groupe();

        //récupération dans des variables des données saisies dans les champs de formulaire
        String nom = getDataForm( request, "nom" );
        String dateCreation = getDataForm( request, "dateCreation");
        int idGenre = Integer.parseInt(getDataForm( request, "idGenre" ));
        String telephone = getDataForm(request, "telephone");
        String melSiteWeb = getDataForm(request, "melSiteWeb");
        String lieuRepetition = getDataForm(request, "lieuRepetition");

        try {
            validationNom( nom );
        } catch ( Exception e ) {
            setErreur( "nom", e.getMessage() );
        }
         unGroupe.setNom(nom);
         
        try {
            validationDateCreation( dateCreation );
        } catch ( Exception e ) {
            setErreur( "dateCreation", e.getMessage() );
        }
        unGroupe.setDateCreation(dateCreation);
       
        try {
            validationTelephone( telephone );
        } catch ( Exception e ) {
            setErreur( "telephone", e.getMessage() );
        }
        unGroupe.setTelephone(telephone);
        
        try {
            validationMelSiteWeb( melSiteWeb );
        } catch ( Exception e ) {
            setErreur( "melSiteWeb", e.getMessage() );
        }
        unGroupe.setMelSiteWeb(melSiteWeb);
        
        try {
            validationLieuRepetition( lieuRepetition );
        } catch ( Exception e ) {
            setErreur( "lieuRepetition", e.getMessage() );
        }
        unGroupe.setLieurepetition(lieuRepetition);

        if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'ajout.";
        } else {
            resultat = "Échec de l'ajout.";
        }
        System.out.println("resultat erreurs="+resultat);

        // hydratation de l'objet groupe avec les variables valorisées ci-dessus

        Genre leGenre = new Genre();
        leGenre.setId(idGenre);
        unGroupe.setGenre(leGenre);
        return unGroupe ;
    }
}
