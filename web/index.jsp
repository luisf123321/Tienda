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
              <a class="navbar-brand" href="#">Navbar</a>
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
                <!-- /.col-lg-9 -->

              </div>
              <!-- /.row -->

            </div>
            <!-- /.container -->
        
        <script src="Ecommercejs/categorias.js.js"></script>
        <script src="Ecommercejs/productos.js"></script>
        <script src="jquery/jquery-3.6.0.js"></script>
        <script>
	  	$(document).ready(function(){
	  		var category_id = <%= category_id %>;
			getCategories(category_id);
			getProductos(category_id);
		});
         </script>
    </body>
</html>
