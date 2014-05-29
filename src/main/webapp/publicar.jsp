<%-- 
    Document   : publicar
    Created on : 29/05/2014, 14:04:45
    Author     : Samuell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/publicar-style.css">
        <title>JSP Page</title>
    </head>
    <body>
        <header>


        </header>


        <div id="main">

            <div id="titulo">
                <img src="images/facebook-logo.png"> 
                <h2> RMI Fakebook <h2>
                        </div>
                        <div id="container-publicar">
                            <form method="POST" action="PublicarServlet" id="form-mensagem"> 

                                <textarea name="texto-mensagem" placeholder="Escreva sua mensagem aqui"></textarea>

                                <input type="submit" value="Eviar mensagem">
                                <div class="clear"> </div>
                            </form>

                        </div>

                        </div>


                        <footer>


                        </footer>

                        </body>
                        </html>
