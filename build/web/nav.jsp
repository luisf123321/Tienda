<%-- 
    Document   : nav
    Created on : 15/06/2021, 01:15:53 PM
    Author     : luis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav class="navbar navbar-dark bg-dark">
            <div class="container-fluid">
              <a class="navbar-brand" href="#">Navbar</a>
              <a type="button" href='../producto/productos.jsp' class="btn btn-primary">Productos</a>
              <a type="button" href="../categorias/categoria.jsp" class="btn btn-secondary">Categorias</a>
              <a type="button" href='../cliente/cliente.jsp' class="btn btn-success">Clientes</a>
              <a type="button" href="../cart/cart.jsp" class="btn btn-secondary">Cart 
                <span id="items" class="badge badge-light"></span>
              </a>              
            </div>
</nav>
