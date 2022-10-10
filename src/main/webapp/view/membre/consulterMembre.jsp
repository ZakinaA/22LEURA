<%-- 
    Document   : Membre
    Created on : 3 oct. 2022, 10:53:09
    Author     : sio2
--%>

<%@page import="model.Membre"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
    <%
    Membre unMembre = (Membre)request.getAttribute("pMembre");
%>
<%

    out.println("<p> ID du Membre => ");
    out.println(unMembre.getId());
    out.println("<br/> <br/>");
    
    out.println("Nom du groupe => ");
    out.println(unMembre.getNom());
    out.println("<br/> <br/>");


%>
    
</html>
