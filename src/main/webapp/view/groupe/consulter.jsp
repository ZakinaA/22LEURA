<%@page import="model.Membre"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="model.Groupe"%>
<%@page import="model.Titre"%>
<link rel ="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"/> 

<!DOCTYPE html>
<html>
<head>
    <title>WebZik</title>
</head>
<body>
<h1>Consulter Groupe</h1>
<br/>
<br/>     


<%
    Groupe unGroupe = (Groupe)request.getAttribute("pGroupe");
%>
<%

    out.println("<p> ID du groupe => ");
    out.println(unGroupe.getId());
    out.println("<br/> <br/>");
    
    out.println("Nom du groupe => ");
    out.println(unGroupe.getNom());
    out.println("<br/> <br/>");
    
    out.println("Genre => ");
    out.println(unGroupe.getGenre().getLibelle());
    out.println("<br/> <br/>");

    out.println("Date de création => ");
    out.println(unGroupe.getDateCreation());
    out.println("<br/> <br/>");
    
    out.println("Numéro de téléphone => ");
    out.println(unGroupe.getTelephone());
    out.println("<br/> <br/>");

    out.println("Mail => ");
    out.println(unGroupe.getMelSiteWeb());
    out.println("<br/> <br/>");
    
    out.println("Lieu de répétition => ");
    out.println(unGroupe.getLieurepetition());
    out.println("<br/> <br/>");
  
    out.println("Dispositif => ");
    out.println(unGroupe.getLeDispositif().getLibelle());
    out.println("<br/> <br/>");

    out.println("Membre Contact => ");
    out.println(unGroupe.getContact().getNom() + " " + unGroupe.getContact().getPrenom());
    out.println("</p> <br/>");
    

%>


<%
ArrayList<Membre> lesMembres = (ArrayList)request.getAttribute("pMembre");
%>

<h2>Membre(s) du groupe</h2>
    <table  class="table table-bordered table-striped table-condensed">
        <thead>
            <tr>
                <th>Nom</th>
                <th>Prenom</th>
            </tr>
        </thead>
        <tbody>
        <tr>
<%

            for (Membre unMembre : lesMembres){

                out.println("<tr><td>");
                out.println("<a href ='../ServletGroupe/consulterMembre?idGroupe=" + unGroupe.getId() + "'>");
                out.println(unMembre.getNom());
                out.println("</a></td>");
                                
                out.println("<td>");
                out.println(unMembre.getPrenom());
                out.println("</td>");

            }
            out.println("</p>");

%>
        </tr>
        </tbody>
    </table>
<h2> Titres </h2>


    <table  class="table table-bordered table-striped table-condensed">
        <thead>
            <tr>
                <th>numéro</th>
                <th>Intitulé</th>
                <th>Durée</th>
            </tr>
        </thead>
        <tbody>
        <tr>
<%

   ArrayList<Titre> lesTitres = unGroupe.getLesTitres();

    for (int i=0; i<lesTitres.size(); i++){
    
        Titre leTitre = lesTitres.get(i);
        
        out.println("<tr><td>");
        out.println(leTitre.getNumero());
        out.println("</td>");
        
        out.println("<td>");
        out.println(leTitre.getIntitule());
        out.println("</td>");
      
        out.println("<td>");
        out.println(leTitre.getDuree());
        out.println("</td>");
    
    }


%>
        </tr>
        </tbody>
    </table>
    

</body>
</html>