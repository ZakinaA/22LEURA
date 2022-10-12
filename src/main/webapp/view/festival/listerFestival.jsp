<%@page import="model.Groupe"%>
<%@page import="model.Festival"%>
<%@page import="dao.DaoFestival"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
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
              <header class="header">
    <a href="../" class="logo">Norman'zik</a>
    <nav class="nav-items">
      <a href="../ServletGroupe/lister">Groupe</a>
      <a href="../ServletConnexion/connexion">Se connecter</a>
    </nav>
  </header>
    
    
<br/>
<br/>
<center><h1>Festival</h1><center/>
<br/>
<br/>

<%
    ArrayList<Festival> lesFestivals = (ArrayList)request.getAttribute("pLesFestivals");
%>

<div class="container px-4 px-lg-5">
    <table  class="table table-bordered table-striped table-condensed">
        <thead>
        <tr>
            <th>Id</th>
            <th>Nom</th>
            <th>Date</th>
            <th>Lieu</th>
            
        </tr>
        </thead>
        <tbody>
        <tr>

            <%
                
                for (Festival unFestival : lesFestivals) {
                
                out.println("<tr><td>");
                out.println(unFestival.getIdFestival());
                out.println("</td>");
    
                out.println("<td>");
                out.println("<a href ='../ServletFestival/consulterFestival?idFestival=" + unFestival.getIdFestival() + "'>");
                out.println(unFestival.getNom());
                out.println("</td>");
    
                out.println("<td>");
                out.println(unFestival.getDateFestival());
                out.println("</td>");
                
                
                out.println("<td>");
                out.println(unFestival.getLieu());
                out.println("</td>");

                }

%>
        </tr>
        </tbody>
    </table>      
     
