<%-- 
    Document   : consulterFestival
    Created on : 10 oct. 2022, 16:26:46
    Author     : sio2
--%>
<%@page import="model.Groupe"%>
<%@page import="java.util.ArrayList"%>
<link rel ="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"/> 
<%@page import="model.Festival"%>
<%@include  file="../outils/header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Festival</title>
    </head>
<br/>
<br/>
    <center><h1>Consulter Festival</h1><center/>
<br/>
<br/> 

    <table  class="table table-bordered table-striped table-condensed">
        <thead>
            <tr>
                <th>Nom</th>
                <th>date</th>
                <th>Lieu</th>   
            </tr>
        </thead>
        
        <tbody>
        <tr>

    <%
        Festival unFestival = (Festival)request.getAttribute("pFestival");
    %>
    
<%
/*
    out.println("<td>");
    out.println(unFestival.getIdFestival());
    out.println("<br/> <br/>");
    
    out.println("<td>");
    out.println(unFestival.getNom());
    out.println("<br/> <br/>");
    
    out.println("<td>");
    out.println(unFestival.getDateFestival());
    out.println("<br/> <br/>");
    out.println("<td>");
    out.println(unFestival.getLieu());
    out.println("<br/> <br/>");
*/
%>

</tbody>
</table>

<%
    Groupe unGroupe = (Groupe)request.getAttribute("pGroupe");
%>

<br/>
<br/> 
<br/>
<br/> 
<h1>Inscription Groupe</h1>
<br/>
<br/> 
    <table  class="table table-bordered table-striped table-condensed">
        <thead>
            <tr>
                <th>Nom du groupe</th>
                <th>Genre</th>
            </tr>
        </thead>
        <tbody>
        <tr>
        
<%
    /*
    
    out.println("<td>");
    out.println(unGroupe.getNom());
    out.println("<br/> <br/>");
    
    out.println("<td>");
    out.println(unGroupe.getGenre().getLibelle());
    out.println("<br/> <br/>");
    
    */
%>
            

        </tr>
        </tbody>
        
</table>
</body>
<%@include  file="../outils/footer.jsp" %>
</html>