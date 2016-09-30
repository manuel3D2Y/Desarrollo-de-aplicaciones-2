<%-- 
    Document   : estudiante
    Created on : 20/09/2016, 12:24:43 PM
    Author     : Irbing
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Old Passwords</title>
    </head>
    <body>
        <form action="OldPasswordController" method="post">
            <fieldset>
                <legend>Formulario de registro</legend>

                <div> 
                    <label for="idPassword"> Id Pasword: </label>
                    <input type="text" name="idPassword" value="${oldPassword.idPassword}"
                           readonly="readonly" placeholder="Id " />
                </div>

                <div> 
                    <label for="password"> Password: </label>
                    <input type="text" name="password" value="${oldPassword.password}"
                           placeholder="Password" />
                </div>

                <div> 
                    <label for="changed"> changed : </label>
                    <input type="text" name="changed" value="${oldPassword.changed}"
                           placeholder="changed" />
                </div>

                <div> 
                    <input type="submit" value="Guardar"/>
                </div>

            </fieldset>
        </form>
    </body>
</html>
