
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PRODUCTO</title>
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
            <input type="hidden" name="opcion" value="eliminar_producto">
            <table>
                <tr>
                    <td>id</td>
                    <td>Nombre</td>
                    <td>Descripcion</td>
                    <td>Valor</td>    
                <tr>
                <c:forEach var="producto" items="${lista}">
                <tr>
                    <td><c:out value="${producto.id}"></c:out></td>
                    <td><c:out value="${producto.nom_prod}"></c:out></td>
                    <td><c:out value="${producto.des_prod}"></c:out></td>
                    <td><c:out value="${producto.valor_prod}"></c:out></td>
                    <td><a href="producto?opcion=delete_producto?id=${producto.id}">Eliminar</a></td>
                </tr>
                </c:forEach>
            </table>
        </form>
        <table>
            <tr>
                <td><a href="producto?opcion=menu_producto_crear">CREAR</a></td>
            </tr>
        </table>
    </body>
</html>
