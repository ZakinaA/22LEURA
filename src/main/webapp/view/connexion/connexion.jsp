<%-- 
    Document   : connexion
    Created on : 28 sept. 2022, 09:53:47
    Author     : sio2
--%>
<link rel ="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"/> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include  file="../outils/header.jsp" %>
<!DOCTYPE html>
<html>
    
    
        <head>
            
            
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Connexion</title>
    </head>
    <body>
        

        <div align="center" class="body">

    <section class="vh-100">
  <div class="container-fluid h-custom">
    <div class="row d-flex justify-content-center align-items-center h-100">
     
      <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
      
            <center>
          <div class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start">
            <p class="lead fw-normal mb-0 me-3">Connexion</p>
            <button type="button" class="btn btn-primary btn-floating mx-1">
              <i class="fab fa-facebook-f"></i>
            </button>
            
          

            <button type="button" class="btn btn-primary btn-floating mx-1">
              <i class="fab fa-twitter"></i>
            </button>

            <button type="button" class="btn btn-primary btn-floating mx-1">
              <i class="fab fa-linkedin-in"></i>
            </button>
          </div>
            <br/>

       <form action ="login.jsp" method="POST">

          <!-- Email input -->
          <div class="form-outline mb-4">
            <input type="text" name="username" class="form-control form-control-lg"
              placeholder="Entrez le Pseudo" />
            
          </div>

          <!-- Password input -->
          <div class="form-outline mb-3">
              
            
            <input type="password" name="password" class="form-control form-control-lg"
              placeholder="Entrez le mot de passe" />
            
          </div>

          <div class="d-flex justify-content-between align-items-center">
            <!-- Checkbox -->
            <a href="inscription" class="text-body">Inscription?</a>
          </div>

          <div class="text-center text-lg-start mt-4 pt-2">
            <button type="button" class="btn btn-primary btn-lg"
              style="padding-left: 2.5rem; padding-right: 2.5rem;">Login</button>
          </div>

        </form>
      </div>
    </div>
  </div>

</section>
    
</div>

</body>
<%@include  file="../outils/footer.jsp" %>

</html>
