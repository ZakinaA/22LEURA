<%-- 
    Document   : supprimerGroupe
    Created on : 17 oct. 2022, 14:53:12
    Author     : sio2
--%>

<%@page import="model.Groupe"%>
<%@page import="model.Genre"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include  file="../outils/header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<%
    Groupe unGroupe = (Groupe)request.getAttribute("pGroupe");
%>
        <%
        out.println("<h1>Etes vous vraiment sur de vouloir supprimer le groupe : <u>" + unGroupe.getNom() + "</u></h1>");

        %>
        <br><br><br><br><br><!-- comment -->
        <form class="form-inline" action="groupe" method="POST">
    <center>
    <input type="submit" name="supprimer" id="supprimer" value="Supprimer"/>
    <center/>
    <center>
        <input type="submit" name="annuler" id="annuler" value="Annuler"/></form>
    <center/>
        
    </body>
    <%@include  file="../outils/footer.jsp" %>
</html>
