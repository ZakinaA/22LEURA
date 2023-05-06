<%-- 
    Document   : Membre
    Created on : 3 oct. 2022, 10:53:09
    Author     : sio2
--%>

<%@page import="model.Membre"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include  file="../outils/header.jsp" %>
<link rel ="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"/> 

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Page membre</title>
    </head>
    <body>
    <br/>
    <br/>
    <center><h1>Page du membre</h1></center>
    <br/>
    <br/>
    
            <table  class="table table-bordered table-striped table-condensed">
        <thead>
            <tr>
                <th>Numéro de membre</th>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Instrument préféré</th>
                <th>Statut</th>
                
            </tr>
        </thead>
        
        <tbody>
        <tr>

    
        <%
    Membre unMembre = (Membre)request.getAttribute("pMembre");
%>
<%

 out.println("<td>");
    out.println(unMembre.getId());
    out.println("<br/> <br/>");
    
    out.println("<td>");
    out.println(unMembre.getNom());
    out.println("<br/> <br/>");
    
    out.println("<td>");
    out.println(unMembre.getPrenom());
    out.println("<br/> <br/>");

    out.println("<td>");
    out.println(unMembre.getInstrumentPrefere().getLibelle());
    out.println("<br/> <br/>");
    
    out.println("<td>");
    out.println(unMembre.getStatut().getLibelle());
    out.println("<br/> <br/>");


%>
        </tr>
        </tbody>
    </table>
        
</body>
    <%@include  file="../outils/footer.jsp" %> <!-- footer à régler pour qu'il s'affiche bien en bas de page -->
</html>

