<%-- 
    Document   : productos
    Created on : 14/06/2021, 08:33:40 PM
    Author     : luis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/bootstrap.css" rel="stylesheet">
        <script src="../js/bootstrap.js" ></script>
        <title>Ecommerces Productos</title>
    </head>
    <body>
        <jsp:include page="../nav.jsp"></jsp:include>
                
        <div class="container">
            
            <div class="row mt-3">
                <div class="row mt-3 mb-2">
                    <div id="div_review_response">
                    </div>
                    
                    <div class="mt-3">
                        <h3> Catidad Productos</h3>
                        <h3 id="cantidadproducto"></h3>
                    </div>
                    <div>
                        <div class="col-5 mt-2 flex-row">
                             <input type="number" class="form-control" id="idProducto" placeholder="id">                             
                        </div>                                      
                    </div>
                    <div class="mt-3">
                        <button type="button" id="buscar" class="btn btn-danger">Buscar Producto </button>
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">Agregar Producto</button>                        
                        <button type="button" id="eliminar" class="btn btn-danger">Eliminar Producto</button>
                        
                       
                    </div> 
                </div>
                <div id="productoslist" class="col-12 mt-3 mb-5">            
                </div>    
            </div>                  
        </div>
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-scrollable">
              <div class="modal-content">
                <div class="modal-header">
                  <h5 class="modal-title" id="exampleModalLabel">Agregar Producto</h5>
                  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                  <div class="mb-3">
                    <label for="nombre" class="form-label">Nombre</label>
                    <input type="text" class="form-control" id="nombre" placeholder="Nombre">
                  </div>
                    <div class="mb-3">
                    <label for="precio" class="form-label">Precio</label>
                    <input type="number" class="form-control" id="precio" placeholder="0.0">
                  </div>
                  <div class="mb-3">
                    <label for="codigo" class="form-label">Codigo</label>
                    <input type="text" class="form-control" id="codigo" placeholder="Codigo">
                  </div>
                  <div class="mb-3">
                    <label for="descripcion" class="form-label">Descripcion</label>
                    <input type="text" class="form-control" id="descripcion" placeholder="Descripcion">
                  </div>
                  <div class="mb-3">
                    <label for="ref" class="form-label">Ref</label>
                    <input type="text" class="form-control" id="ref" placeholder="Ref">
                  </div>
                  <div class="mb-3">
                    <label for="ref" class="form-label">Categoria</label>
                    <select id="selectCat" class="form-select" aria-label="Default select example">
                        
                    </select>
                  </div>                    

                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                  <button type="button" class="btn btn-primary" onclick="send()" data-bs-dismiss="modal" >Save changes</button>
                </div>
                
              </div>
            </div>
          </div>
          <div class="modal fade" id="updateproducto" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-scrollable">
              <div class="modal-content">
                <div class="modal-header">
                  <h5 class="modal-title" id="exampleModalLabel">Agregar Producto</h5>
                  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="mb-3">
                    <label for="precio" class="form-label">Id</label>
                    <input type="number" class="form-control" id="idP" placeholder="0.0">
                  </div>
                  <div class="mb-3">
                    <label for="nombre" class="form-label">Nombre</label>
                    <input type="text" class="form-control" id="nombreP" placeholder="Nombre">
                  </div>
                    <div class="mb-3">
                    <label for="precio" class="form-label">Precio</label>
                    <input type="number" class="form-control" id="precioP" placeholder="0.0">
                  </div>
                  <div class="mb-3">
                    <label for="codigo" class="form-label">Codigo</label>
                    <input type="text" class="form-control" id="codigoP" placeholder="Codigo">
                  </div>
                  <div class="mb-3">
                    <label for="descripcion" class="form-label">Descripcion</label>
                    <input type="text" class="form-control" id="descripcionP" placeholder="Descripcion">
                  </div>
                  <div class="mb-3">
                    <label for="ref" class="form-label">Ref</label>
                    <input type="text" class="form-control" id="refP" placeholder="Ref">
                  </div>
                  <div class="mb-3">
                    <label for="ref" class="form-label">Categoria</label>
                    <select id="selectCatP" class="form-select" aria-label="Default select example">
                        
                    </select>
                  </div>                    

                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                  <button type="button" class="btn btn-primary" onclick="update()" data-bs-dismiss="modal" >Save changes</button>
                </div>
                
              </div>
            </div>
          </div>
        <script src="../Ecommercejs/productolist.js"></script>
        <script src="../Ecommercejs/guardarProducto.js"></script>
        <script src="../Ecommercejs/categorias.js.js"></script>
        <script src="../Ecommercejs/BuscarProducto.js"></script>
        <script src="../jquery/jquery-3.6.0.js"></script>
        <script>
	  	$(document).ready(function(){  		
			getProductosList();
                        getProductosCount();
                        getCategoriesSelect();
		});
                $("#eliminar").click(function(){
                        getEliminarProducto(document.getElementById("idProducto").value);
                        location.reload();
                 });
                 $("#buscar").click(function(){
                        getProductoId(document.getElementById("idProducto").value);
                        
                 });
        </script>
    </body>
</html>
