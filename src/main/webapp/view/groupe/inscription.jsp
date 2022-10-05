<%-- 
    Document   : inscription
    Created on : 3 oct. 2022, 13:24:45
    Author     : sio2
--%>
<link rel ="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"/> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inscription</title>
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

                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Inscription</p>

                <form class="mx-1 mx-md-4">

                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <label class="form-label" for="form3Example1c">Pseudo :</label>
                      <input type="text" id="form3Example1c" class="form-control" />
                      
                    </div>
                  </div>

                  

                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <label class="form-label" for="form3Example4c">Mot de Passe :</label>
                      <input type="password" id="form3Example4c" class="form-control" />
                      
                    </div>
                  </div>

                  <div class="d-flex flex-row align-items-center mb-4">
                    <i class="fas fa-key fa-lg me-3 fa-fw"></i>
                    <div class="form-outline flex-fill mb-0">
                      <label class="form-label" for="form3Example4cd">Répétez votre mot de passe :</label>
                      <input type="password" id="form3Example4cd" class="form-control" />
                      
                    </div>
                  </div>

                  <div class="form-check d-flex justify-content-center mb-5">
                    
                    <label class="form-check-label" for="form2Example3">
                      <a href="connexion">Se connecter</a>
                    </label>
                  </div>

                  <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                    <button type="button" class="btn btn-primary btn-lg">S'inscrire</button>
                  </div>

                </form>

              </div>
             
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

    

</section>
    
</div>

</body>
</html>
