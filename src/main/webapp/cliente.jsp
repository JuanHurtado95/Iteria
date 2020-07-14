

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
            <input type="hidden" name="opcion" value="eliminar_cliente">
            <table>
                <tr>
                    <td>id</td>
                    <td>Nombre</td>
                    <td>segundo nombre</td>
                    <td>apellido</td>
                    <td>segundo apellido</td>
                    <td>numero</td>
                <tr>
                <c:forEach var="cliente" items="${lista}">
                <tr>
                    <td><c:out value="${cliente.id}"></c:out></td>
                    <td><c:out value="${cliente.primer_nombre}"></c:out></td>
                    <td><c:out value="${cliente.segundo_nombre}"></c:out></td>
                    <td><c:out value="${cliente.primer_apellido}"></c:out></td>
                    <td><c:out value="${cliente.segundo_apellido}"></c:out></td>
                    <td><c:out value="${cliente.num_contact}"></c:out></td>
                    <td><a href="producto?opcion=delete_cliente?id=${cliente.id}">Eliminar</a></td>
                </tr>
                </c:forEach>
            </table>
        </form>
        <table>
            <tr>
                <td><a href="producto?opcion=menu_cliente_crear">CREAR</a></td>
            </tr>
        </table>
    </body>
</html>
