<%@page import="model.Concert"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@include  file="../outils/header.jsp" %>
<link rel ="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"/>
<!DOCTYPE html>
<html>
<head>
        <style>  /* CSS for header */
    .header {
      display: flex;
      justify-content: space-between;
      align-items: center;
      background-color: #0074FF;
    }
    .header .logo {
      font-size: 25px;
      font-family: 'Sriracha', cursive;
      color: #fff;
      text-decoration: none;
      margin-left: 30px;
    }
    .nav-items {
      display: flex;
      justify-content: space-around;
      align-items: center;
      background-color: #0074FF;
      margin-right: 20px;
    }
    .nav-items a {
      text-decoration: none;
      color: #fff;
      padding: 35px 20px;
    }</style>
    
    <title>WebZik</title>
  
</head>
<body>
    
    
<br/>
<br/>
<center><h1>Concert</h1><center/>
<br/>
<br/>

<%
    ArrayList<Concert> lesConcerts = (ArrayList)request.getAttribute("pLesConcerts");
%>

<div class="container px-4 px-lg-5">
    <table  class="table table-bordered table-striped table-condensed">
        <thead>
        <tr>
            <th>Nom du Groupe</th>
            <th>Nom</th>
            <th>Ville</th>
            <th>DateConcert</th>

        </tr>
        </thead>
        <tbody>
        <tr>
        
            <%
                
                for (Concert unConcert : lesConcerts){
                
 
                    
                    out.println("<tr><td>");
                    out.println(unConcert.getGroupe().getNom());
                    out.println("</td>");
                    
                    out.println("<td>");
                    out.println(unConcert.getLieuconcert().getNom());
                    out.println("</td>");
                    
                    out.println("<td>");
                    out.println(unConcert.getLieuconcert().getVille());
                    out.println("</td>");
                    
                    out.println("<td>");
                    out.println(unConcert.getDateConcert());
                    out.println("</td>");
                    
                }
            
            %>   
    </tr>
    </tbody>
    </table>
    </div>
    </body>
        <%@include  file="../outils/footer.jsp" %>
</html>
