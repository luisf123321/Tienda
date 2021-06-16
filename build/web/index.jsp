<%-- 
    Document   : index
    Created on : 14/06/2021, 08:29:14 PM
    Author     : luis
--%>
<%
	String category_id = request.getParameter("id");
	if (category_id == null){
		category_id = "1";	
	}	
%>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.css" rel="stylesheet">
        <script src="js/bootstrap.js" ></script>
    </head>
    <body>
        
        <nav class="navbar navbar-dark bg-dark">
            <div class="container-fluid">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                      <a class="navbar-brand" href="#">Inicio</a>
                    </li>
                </ul>
                <a type="button" href="cart/cart.jsp" class="btn btn-secondary mr-2">

                  <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-cart-check" viewBox="0 0 16 16">
                      <path d="M11.354 6.354a.5.5 0 0 0-.708-.708L8 8.293 6.854 7.146a.5.5 0 1 0-.708.708l1.5 1.5a.5.5 0 0 0 .708 0l3-3z"/>
                      <path d="M.5 1a.5.5 0 0 0 0 1h1.11l.401 1.607 1.498 7.985A.5.5 0 0 0 4 12h1a2 2 0 1 0 0 4 2 2 0 0 0 0-4h7a2 2 0 1 0 0 4 2 2 0 0 0 0-4h1a.5.5 0 0 0 .491-.408l1.5-8A.5.5 0 0 0 14.5 3H2.89l-.405-1.621A.5.5 0 0 0 2 1H.5zm3.915 10L3.102 4h10.796l-1.313 7h-8.17zM6 14a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm7 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0z"/>
                  </svg>

                  <span id="items" class="badge badge-light"></span>
                </a>
                <a type="button" href='producto/productos.jsp' class="btn btn-primary">Productos</a>
                <a type="button" href="categorias/categoria.jsp" class="btn btn-secondary">Categorias</a>
                <a type="button" href='cliente/cliente.jsp' class="btn btn-success">Clientes</a>
                
            </div>
        </nav>
        
        <!-- Page Content -->
            <div class="container mt-5">

              <div class="row">

                <div class="col-lg-3">

                  <h1 class="my-4">CATEGORIAS</h1>
                  <div class="list-group" id="div_categories">
                  </div>

                </div>
                <!-- /.col-lg-3 -->

                <div class="col-lg-9">



                  <div class="row" id="div_products">

                  </div>
                  <!-- /.row -->

                </div>
                <div>
                    <h1 >item select</h1>
                    <h1 id="items"></h1>
                </div>
                
                <!-- /.col-lg-9 -->

              </div>
              <!-- /.row -->

            </div>
            <!-- /.container -->
        
        <script src="Ecommercejs/categorias.js.js"></script>
        <script src="Ecommercejs/productos.js"></script>
        <script src="Ecommercejs/item/itemAdd.js"></script>
        <script src="jquery/jquery-3.6.0.js"></script>
        <script>
	  	$(document).ready(function(){
	  		var category_id = <%= category_id %>;
			getCategories(category_id);
			getProductos(category_id);
                        getitem();
		});
         </script>
    </body>
</html>
