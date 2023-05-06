<%@page import="form.FormConnexion"%>
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
        <title>Connexion</title>
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

                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Connexion</p>

<%
    //Client client=(Client)request.getAttribute("client");
    FormConnexion form = (FormConnexion)request.getAttribute("form");
%>

<form class="form-inline" action="connexion" method="POST">
    <center>
    <label for="username">Nom d'utilisateur : </label>
    </br>
    <input id="username" type="text" name="username"  size="30" maxlength="30">
    <span style="color: blue;">${form.erreurs['username']}</span>
    <br />
    </br>
    <label for="password">Mot de passe : </label>
    </br>
    <input id="password" type="password" name="password"  size="30" maxlength="30">
    <span style="color: blue;">${form.erreurs['password']}</span>
    
    
    
              <div class="d-flex justify-content-between align-items-center">
            <!-- Checkbox -->
            <a href="../ServletInscription/inscription" class="text-body">Inscription?</a>
          </div>
   
    </center>

    </br>
    </br>
    </br>
    <center>
    <input type="submit" name="valider" id="valider" value="Valider"/>
    </center>
</form>
              </div></div></div></div></div></div></div>
</body>

<%@include  file="../outils/footer.jsp" %>
</html>