
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CLIENTE</title>
        <!--<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">-->
    </head>
    <body>
        <h1>Prueba Iteria</h1>
        <table>
            <tr>
                <td><a href="producto?opcion=menu_cliente">CLIENTES</a></td>
                <td><a href="producto?opcion=menu_producto">PRODUCTOS</a></td>
               
            </tr>
        </table>
        <form action="producto" method="post">
        <input type="hidden" name="opcion" value="guardar_cliente">
        <table>
            <tr>
                <td>Nombre</td>
                <td><input type="text" name="nombre"></td>
            </tr>
            <tr>
                <td>Segundo Nombre</td>
                <td><input type="text" name="snombre"></td>
            </tr>
            <tr>
                <td>Apellido</td>
                <td><input type="text" name="apellido"></td>
            </tr>
            <tr>
                <td>Segundo apellido</td>
                <td><input type="text" name="sapellido"></td>
            </tr>
            <tr>
                <td>Numero Contacto</td>
                <td><input type="text" name="contacto"></td>
            </tr>
            <tr>
                <td><input type="submit" value="guardar"></td>
            </tr>
        </table>
    </form>
    </body>
</html>
