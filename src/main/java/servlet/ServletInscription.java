/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.DaoAdmin;
import dao.DaoGroupe;
import dao.DaoMembre;
import dao.DaoUtilisateur;
import dao.Utilitaire;
import form.FormGroupe;
import form.FormUtilisateur;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Genre;
import model.Groupe;
import model.Membre;
import model.Utilisateur;

/**
 *
 * @author Zakina
 */
public class ServletInscription extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
     *  Connection connection ;
    static PreparedStatement requete=null;
    static ResultSet rs=null;

     */
    
    Connection connection ;
    static PreparedStatement requete=null;
    static ResultSet rs=null;
    
     @Override
    public void init()
    {
        
        ServletContext servletContext=getServletContext();
        connection=(Connection)servletContext.getAttribute("connection");
        
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletInscription</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletInscription at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         // récupération de l url saisie dans le navigateur
        String url = request.getRequestURI();
        
        System.out.println("servlergroupe url="+url);

        //Affichage de tous les groupes (en indiquant le libellé du genre musical)


        // Affichage du groupe selectionné (depuis la fonctionnalité lister)
        
    
        
        if(url.equals("/normanzik/ServletInscription/inscription")){            
            System.out.println("servletinscription Inscription");
            ArrayList<Utilisateur> lesUtilisateurs = DaoUtilisateur.getLesUtilisateurs(connection);
            request.setAttribute("pLesUtilisateurs", lesUtilisateurs);
            this.getServletContext().getRequestDispatcher("/view/connexion/inscription.jsp" ).forward( request, response );
        } 
        
               
  
        
        

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        FormUtilisateur form = new FormUtilisateur();

        /* Appel au traitement et à la validation de la requête, et récupération de l'objet en résultant */
        Utilisateur leUtilisateurSaisi = form.ajouterUtilisateur(request);

        /* Stockage du formulaire et de l'objet dans l'objet request */
        request.setAttribute( "form", form );
        request.setAttribute( "pUtilisateur", leUtilisateurSaisi );

        if (form.getErreurs().isEmpty()){
            // Il n'y a pas eu d'erreurs de saisie, donc on renvoie la vue affichant les infos du groupe
            Utilisateur utilisateurAjoute = DaoUtilisateur.ajouterUtilisateur(connection, leUtilisateurSaisi);
            
            if (utilisateurAjoute != null ){
                request.setAttribute("pUtilisateur", utilisateurAjoute);

                this.getServletContext().getRequestDispatcher("/index.jsp" ).forward( request, response );
            }
            else
            {
                // Cas où l'insertion en bdd a échoué
                //On renvoie vers le formulaire

                System.out.println("le groupe est null en bdd- echec en bdd");
                this.getServletContext().getRequestDispatcher("/index.jsp" ).forward( request, response );
            }
        }
        else
        {

            // il y a des erreurs de saisie. On réaffiche le formulaire avec des messages d'erreurs
         
            this.getServletContext().getRequestDispatcher("/view/connexion/inscription.jsp" ).forward( request, response );
        }
    }

    //fermeture des ressources
    public void destroy(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
        try
        {
            //fermeture
            System.out.println("Connexion fermée");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("Erreur lors de l’établissement de la connexion");
        }
        finally
        {
            //Utilitaire.fermerConnexion(rs);
            //Utilitaire.fermerConnexion(requete);
            Utilitaire.fermerConnexion(connection);
        }
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
