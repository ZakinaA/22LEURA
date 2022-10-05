<%-- 
    Document   : login
    Created on : 5 oct. 2022, 09:33:12
    Author     : sio2
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            String User = request.getParameter("username");
            String Pass = request.getParameter("password");
          
            System.out.println("Identifiants : +" + User + "et le mot de passe est : "+ Pass);
            %>
    </body>
</html>
