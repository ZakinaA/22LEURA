<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="model.Groupe"%>
<%@ page import="form.FormGroupe" %>
<%@ page import="model.Genre" %>
<%@ page import="java.util.ArrayList" %>
<%@include  file="../outils/header.jsp" %>

<link rel ="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"/> 

<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modifier Groupe</title>
    </head>
    <body>

    <section class="vh-100" style="background-color: #eee;">
  <div class="container h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-lg-12 col-xl-11">
        <div class="card text-black" style="border-radius: 25px;">
          <div class="card-body p-md-5">
            <div class="row justify-content-center">
              <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
                  
<%
    Groupe unGroupe = (Groupe)request.getAttribute("pGroupe");
%>

                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Modifier le Groupe: <%out.println(unGroupe.getNom());%></p>

<%
    //Client client=(Client)request.getAttribute("client");
    FormGroupe form = (FormGroupe)request.getAttribute("form");
%>


<form class="form-inline" action="../" method="POST">
    <center>
    <label for="nom">Nom : </label>
    </br>
    <input id="nom" type="text" name="nom"  size="30" maxlength="10" value="<%out.println(unGroupe.getNom()); %>">
    <span style="color: blue;">${form.erreurs['nom']}</span>
    <br />
    </br>
    
    <label for="dateCreation">Date de création : </label>
    </br>
    <input id="dateCreation"  type="text"  name="dateCreation" size="30" maxlength="10" value="<%out.println(unGroupe.getDateCreation()); %>">
    <span style="color: blue;">${form.erreurs['dateCreation']}</span>
    </br>
    </br>

    <%-- Champ Liste des genres --%>
    <label for="genre">Genre : </label>
    </br>
    <select name="idGenre">
        <%
            ArrayList<Genre> lesGenres = (ArrayList)request.getAttribute("pLesGenres");
            for (int i=0; i<lesGenres.size();i++){
                Genre g = lesGenres.get(i);
                out.println("<option value='" + g.getId()+"'>" + g.getLibelle()+"</option>" );
            }
        %>
    </select>
    </br>
    </br>
    
    <label for="telephone"> Telephone : </label>
    </br>
    <input id="telephone" type="text" name="telephone" size="30" maxlength="10" value="<%out.println(unGroupe.getTelephone()); %>"/> 
    <span style="color: blue;">${form.erreurs['telephone']}</span>
    </br>
    </br>
    
    <label for="melSiteWeb"> Mail ou site web : </label>
    </br>
    <input id="melSiteWeb" type="text" name="melSiteWeb" size="30" maxlength="25" value="<%out.println(unGroupe.getMelSiteWeb()); %>" /> 
    <span style="color: blue;">${form.erreurs['melSiteWeb']}</span>
    </br>
    </br>

    <label for="lieuRepetition"> Lieu de répétition : </label>
    </br>
    <input id="lieuRepetition" type="text" name="lieuRepetition" size="30" maxlength="30" value="<%out.println(unGroupe.getLieurepetition()); %>" /> 
    <span style="color: blue;">${form.erreurs['lieuRepetition']}</span>
    
    
  
    </br>
    </br>
    </br>
   
    <input type="submit" name="valider" id="valider" value="Valider"/>
    <center/>
</form>
</body>
<%@include  file="../outils/footer.jsp" %>
</html>