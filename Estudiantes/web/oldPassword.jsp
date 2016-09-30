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
                    <label for="idP_uuid"> Id "P_uuid":</label>
                    <input type="text" name="idP_uuid" value="${oldPassword.idP_uuid}"
                           readonly="readonly" placeholder="Id " />
                </div>

                <div> 
                    <label for="password"> Password:</label>
                    <input type="text" name="password" value="${oldPassword.password}"
                           placeholder="Password" />
                </div>

                <div> 
                    <label for="changed_timestamp"> changed timestamp:</label>
                    <input type="text" name="changed_timestamp" value="${oldPassword.changed_timestamp}"
                           placeholder="changed_timestamp" />
                </div>

                <div> 
                    <input type="submit" value="Guardar"/>
                </div>

            </fieldset>
        </form>
    </body>
</html>
