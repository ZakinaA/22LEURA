<%-- 
    Document   : InscritFestival
    Created on : 10 oct. 2022, 15:46:45
    Author     : sio2
--%>

<%@page import="model.Groupe"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include  file="../outils/header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <center><h1>Groupe inscrit au Festival</h1><center/>
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

</html>
