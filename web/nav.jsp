<%-- 
    Document   : nav
    Created on : 15/06/2021, 01:15:53 PM
    Author     : luis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav class="navbar navbar-dark bg-dark">
            <div class="container-fluid">
              <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                      <a class="navbar-brand" href="../index.jsp">Inicio</a>
                    </li>
              </ul>
               
              <a type="button" href="../cart/cart.jsp" class="btn btn-secondary mr-2">
                
                <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-cart-check" viewBox="0 0 16 16">
                    <path d="M11.354 6.354a.5.5 0 0 0-.708-.708L8 8.293 6.854 7.146a.5.5 0 1 0-.708.708l1.5 1.5a.5.5 0 0 0 .708 0l3-3z"/>
                    <path d="M.5 1a.5.5 0 0 0 0 1h1.11l.401 1.607 1.498 7.985A.5.5 0 0 0 4 12h1a2 2 0 1 0 0 4 2 2 0 0 0 0-4h7a2 2 0 1 0 0 4 2 2 0 0 0 0-4h1a.5.5 0 0 0 .491-.408l1.5-8A.5.5 0 0 0 14.5 3H2.89l-.405-1.621A.5.5 0 0 0 2 1H.5zm3.915 10L3.102 4h10.796l-1.313 7h-8.17zM6 14a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm7 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0z"/>
                </svg>
                
                <span id="items" class="badge badge-light"></span>
              </a>
              <a type="button" href='../producto/productos.jsp' class="btn btn-primary mr-2">Productos</a>
              <a type="button" href="../categorias/categoria.jsp" class="btn btn-secondary mr-2">Categorias</a>
              <a type="button" href='../cliente/cliente.jsp' class="btn btn-success mr-2">Clientes</a>
              
            </div>
</nav>
