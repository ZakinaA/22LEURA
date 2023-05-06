<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="model.Groupe"%>
<%@ page import="java.util.ArrayList" %>
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


<%
    ArrayList<Groupe> lesGroupes = (ArrayList)request.getAttribute("pLesGroupes");
%>


<div class="container px-4 px-lg-5">
    <table  class="table table-bordered table-striped table-condensed">
        <thead>
        <tr>
            <th>Numéro</th>
            <th>Nom</th>
            <th>dateCreation</th>
            <th>Genre</th>
            <th>Téléphone</th>
            <th>Mel</th>
            <th>Lieu de répétition</th>
            <th>Contact</th>

        </tr>
        </thead>
        <tbody>
        <tr>
            <%
                for (Groupe unGroupe : lesGroupes) {
                    out.println("<tr><td>");
                    out.println(unGroupe.getId());
                    out.println("</td>");

                    out.println("<td>");
                    out.println("<a href ='../ServletGroupe/consulter?idGroupe=" + unGroupe.getId() + "'>");
                    out.println(unGroupe.getNom());
                    out.println("</a></td>");

                    out.println("<td>");
                    out.println(unGroupe.getDateCreation());
                    out.println("</td>");

                    out.println("<td>");
                    out.println(unGroupe.getGenre().getLibelle());
                    out.println("</td>");
                    
                    out.println("<td>");
                    out.println(unGroupe.getTelephone());
                    out.println("</td>");
                    
                    out.println("<td>");
                    out.println(unGroupe.getMelSiteWeb());
                    out.println("</td>");
                    
                    out.println("<td>");
                    out.println(unGroupe.getLieurepetition());
                    out.println("</td>");
                    
                    out.println("<td>");
                    out.println(unGroupe.getContact().getNom() + " " + unGroupe.getContact().getPrenom());
                    out.println("</td>");
                    
                    out.println("<td>");
                    out.println("<a href ='../ServletGroupe/modifierGroupe?idGroupe=" + unGroupe.getId() + "'>");
                    out.println("<p>Modifier</p>");
                    out.println("</a></td>");
                    
                    out.println("<td>");
                    out.println("<a href ='../ServletGroupe/supprimerGroupe?idGroupe=" + unGroupe.getId() + "'>");
                    out.println("<p>Supprimer</p>");
                    out.println("</td>");

                }
            %>
        </tr>
        </tbody>
    </table>
        
        <a href ='ajouter' >Créer un groupe</a><br><br>
</div>
</body>
<%@include  file="../outils/footer.jsp" %>
</html>