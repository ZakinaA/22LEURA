<%-- 
    Document   : inscription
    Created on : 3 oct. 2022, 13:24:45
    Author     : sio2
--%>
<%@page import="form.FormUtilisateur"%>
<link rel ="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"/> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inscription</title>
    </head>
    <body>
          <header class="header">
    <a href="../" class="logo">Normanzik</a>
    <nav class="nav-items">
      <a href="../ServletGroupe/lister">Groupe</a>
      <a href="../ServletGroupe/festival">Festival</a>
      <a href="../ServletConnexion/connexion">Se connecter</a>
    </nav>
  </header>
        

    <body>

    <section class="vh-100" style="background-color: #eee;">
  <div class="container h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-lg-12 col-xl-11">
        <div class="card text-black" style="border-radius: 25px;">
          <div class="card-body p-md-5">
            <div class="row justify-content-center">
              <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Inscription</p>

<%
    //Client client=(Client)request.getAttribute("client");
    FormUtilisateur form = (FormUtilisateur)request.getAttribute("form");
%>


<center>
<form class="form-inline" action="connexion" method="POST">
    <label for="username">Pseudo : </label>
    <br />
    <input id="username" type="text" name="username"  size="30" maxlength="30" placeholder="Entrez votre pseudo">
    <span style="color: blue;">${form.erreurs['username']}</span>
    <br />
    </br>
   

    <label for="password">Mot de passe : </label>
    <br />
    <input id="password"  type="password"  name="password" size="30" maxlength="30" placeholder="Mot de passe">
    <br />
    <small id="password" class="form-text text-muted">Au moins 8 caractères</small>
    <span style="color: blue;">${form.erreurs['password']}</span>
    </br>
    </br>

        <label for="mail">mail : </label>
        <br />
    <input id="mail"  type="mail"  name="mail" size="30" maxlength="50" placeholder="Entrez votre adresse mail">
    <span style="color: blue;">${form.erreurs['mail']}</span>
    </br>
    </br>
    
        <label for="tel">telephone: </label>
        <br />
    <input id="tel"  type="text"  name="tel" size="30" maxlength="30" placeholder="Entrez votre numero de telephone">
    <span style="color: blue;">${form.erreurs['tel']}</span>
    </br>
    </br>
    
        <label for="rue">rue: </label>
        <br />
    <input id="rue"  type="text"  name="rue" size="30" maxlength="50" placeholder="Rue">
    <span style="color: blue;">${form.erreurs['rue']}</span>
    </br>
    </br>
    
        <label for="ville">Ville: </label>
        <br />
    <input id="ville"  type="text"  name="ville" size="30" maxlength="50" placeholder="Ville">
    <span style="color: blue;">${form.erreurs['ville']}</span>
    </br>
    </br>
    
        <label for="cp">Code postal: </label>
        <br />
    <input id="cp"  type="text"  name="cp" size="30" maxlength="7" placeholder="code Postal">
    <span style="color: blue;">${form.erreurs['cp']}</span>
    </br>
    </br>
    
    
       </center>

    <center>
    <input type="submit" name="valider" id="valider" value="Valider"/>
    <center/>
</form>
</body>
</html>