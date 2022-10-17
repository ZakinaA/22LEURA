<%@page import="model.Membre"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="model.Groupe"%>
<%@page import="model.Titre"%>
<%@include  file="../outils/header.jsp" %>
<link rel ="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"/> 

<!DOCTYPE html>
<html>
<head>
    <title>WebZik</title>
</head>
<body>
<br/>
<br/>
<center><h1>Consulter Groupe</h1><center/>
<br/>
<br/> 

    <table  class="table table-bordered table-striped table-condensed">
        <thead>
            <tr>
                <th>NumeroGroupe</th>
                <th>Nom du groupe</th>
                <th>Genre</th>
                <th>Date de création</th>
                <th>Numéro de téléphone</th>
                <th>Mail </th>
                <th>Lieu de répétition</th>
                <th>Dispositif </th>
                <th>Membre Contact </th>
                
            </tr>
        </thead>
        
        <tbody>
        <tr>

<%
    Groupe unGroupe = (Groupe)request.getAttribute("pGroupe");
%>

<%

    out.println("<td>");
    out.println(unGroupe.getId());
    out.println("<br/> <br/>");
    
    out.println("<td>");
    out.println(unGroupe.getNom());
    out.println("<br/> <br/>");
    
    out.println("<td>");
    out.println(unGroupe.getGenre().getLibelle());
    out.println("<br/> <br/>");

    out.println("<td>");
    out.println(unGroupe.getDateCreation());
    out.println("<br/> <br/>");
    
    out.println("<td>");
    out.println(unGroupe.getTelephone());
    out.println("<br/> <br/>");

    out.println("<td>");
    out.println(unGroupe.getMelSiteWeb());
    out.println("<br/> <br/>");
    
    out.println("<td>");
    out.println(unGroupe.getLieurepetition());
    out.println("<br/> <br/>");
  
    out.println("<td>");
    out.println(unGroupe.getLeDispositif().getLibelle());
    out.println("<br/> <br/>");

    out.println("<td>");
    out.println(unGroupe.getContact().getNom() + " " + unGroupe.getContact().getPrenom());
    out.println("</p> <br/>");
    

%>

    </table>
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
                out.println("<a href ='../ServletGroupe/Membre?idMembre=" + unMembre.getId() + "'>");
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
<br/>
<%@include  file="../outils/footer.jsp" %>
</html>
