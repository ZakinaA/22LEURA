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
import form.FormConnexion;
import form.FormGroupe;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class ServletConnexion extends HttpServlet {

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
            out.println("<title>Servlet ServletGroupe</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletGroupe at " + request.getContextPath() + "</h1>");
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
  
        if(url.equals("/normanzik/ServletConnexion/connexion")){
            this.getServletContext().getRequestDispatcher("/view/connexion/connexion.jsp" ).forward( request, response );
          
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
       
  
        
        FormConnexion form = new FormConnexion();

            System.out.println("do post servletconnexion a");
        Utilisateur leUtilisateurSaisi = form.getUtilisateur(request);
            System.out.println("do post servletconnexion b1");

        request.setAttribute( "form", form );
        request.setAttribute( "pUtilisateur", leUtilisateurSaisi );
            System.out.println("do post servletconnexion c");
        if (form.getErreurs().isEmpty()){
            System.out.println("do post servletconnexion 1");
            Utilisateur UtilisateurSaisie = DaoUtilisateur.getLeUtilisateur(connection, leUtilisateurSaisi);
            System.out.println("do post servletconnexion 2");
            if(UtilisateurSaisie.getUsername() == null && UtilisateurSaisie.getPassword() == null){
                this.getServletContext().getRequestDispatcher("/view/connexion/connexion.jsp").forward( request, response);
            }
            else{
                this.getServletContext().getRequestDispatcher("/index.jsp").forward( request, response);

             } 
            }
        else{
            this.getServletContext().getRequestDispatcher("/view/connexion/connexion.jsp" ).forward( request, response );
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
