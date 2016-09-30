<%-- 
    Document   : lista_estudiantes
    Created on : 20/09/2016, 12:29:24 PM
    Author     : Irbing
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista "Old Passwords"</title>
    </head>
    <body>
        <table>
            <thead> 
            <tr>
                <th>P_uuid </th>
                <th>Password </th>
                <th>Changed timestamp</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach var="oldPassword" items="${oldPasswords}">
                    <tr>
                        <td>${oldPassword.idP_uuid}</td>
                        <td>${oldPassword.password}</td>
                        <td>${oldPassword.changed_timestamp}</td>
                        <td><a href="OldPasswordController?action=cambiar&idP_uuid=${oldPassword.idP_uuid}">Cambiar</a></td>
                        <td><a href="OldPasswordController?action=borrar&idP_uuid=${oldPassword.idP_uuid}">Borrar</a></td>
                    </tr>                    
                </c:forEach>
            </tbody>
            
        </table>
        <p>
            <a href="OldPasswordController?action=agregar">
                Agregar 
            </a>
        </p>
    </body>
</html>
