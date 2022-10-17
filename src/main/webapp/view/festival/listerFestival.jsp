<%@page import="model.Groupe"%>
<%@page import="model.Festival"%>
<%@page import="dao.DaoFestival"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
                out.println("</a></td>");
    
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
</div>
</body>
<%@include  file="../outils/footer.jsp" %>

</html>
     
