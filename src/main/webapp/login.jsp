<%-- 
    Document   : login
    Created on : 29/05/2014, 13:52:40
    Author     : Elis
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html>
    <head>
        <title>Login</title>
        
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta charset="UTF-8">  
        <link rel="stylesheet" type="text/css" href="css/estilo-login.css">
        <link href='http://fonts.googleapis.com/css?family=Lato:100,300' rel='stylesheet' type='text/css'>
    </head>
    
    <body>
        <div class="form">
            <div class="login">
                <h2>RMI Fakebook</h2>                                           
            </div>

            <form action="LoginServlet" method="POST">
                <input type="text" id="username" name="user" placeholder="Username"><br />
                <input type="password" id="password" name="pass" placeholder="Password">
                <input class="botao submit" type="submit" value="login">
            </form>
        </div>
    </body>
</html>