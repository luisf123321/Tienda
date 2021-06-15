<%-- 
    Document   : catgoria
    Created on : 14/06/2021, 10:57:52 PM
    Author     : luis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/bootstrap.css" rel="stylesheet">
        <script src="../js/bootstrap.js" ></script>
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="../nav.jsp"></jsp:include>
        
        <div class="container">
            
            <div class="row mt-3">
                <div class="row mt-3 mb-2">
                    <div id="div_review_response">
                    </div>
                    
                    <div class="mt-3">
                        <h3> Cantidad Categorias</h3>
                        <h3 id="cantidadCat"></h3>
                    </div>
                    <div>
                        <div class="col-5 mt-2 flex-row">
                             <input type="number" class="form-control" id="idCategoria" placeholder="id">                             
                        </div>                                      
                    </div>
                    <div class="mt-3">
                        <button type="button" id="buscar" class="btn btn-danger">Buscar Categoria </button>
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">Agregar Categoria</button>                        
                        <button type="button" id="eliminar" class="btn btn-danger">Eliminar Categoria</button>
                        
                       
                    </div> 
                </div>
                <div id="categorialist" class="col-12 mt-3 mb-5">            
                </div>    
            </div>                  
        </div>
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-scrollable">
              <div class="modal-content">
                <div class="modal-header">
                  <h5 class="modal-title" id="exampleModalLabel">Agregar Categoria</h5>
                  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                  
                  <div class="mb-3">
                    <label for="nombre" class="form-label">Nombre</label>
                    <input type="text" class="form-control" id="nombre" placeholder="Nombre">
                  </div>
                  <div class="mb-3">
                    <label for="descripcion" class="form-label">Descripcion</label>
                    <input type="text" class="form-control" id="descripcion" placeholder="Descripcion">
                  </div>          
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                  <button type="button" class="btn btn-primary" onclick="send()" data-bs-dismiss="modal" >Save changes</button>
                </div>
                
              </div>
            </div>
          </div>
        <div class="modal fade" id="updatecategoria" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-scrollable">
              <div class="modal-content">
                <div class="modal-header">
                  <h5 class="modal-title" id="exampleModalLabel">Agregar Categoria</h5>
                  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                  <div class="mb-3">
                    <label for="idca" class="form-label">Id</label>
                    <input type="number" class="form-control" id="idCa" placeholder="0">
                  </div>
                  <div class="mb-3">
                    <label for="nombre" class="form-label">Nombre</label>
                    <input type="text" class="form-control" id="nombreCa" placeholder="Nombre">
                  </div>
                  <div class="mb-3">
                    <label for="descripcion" class="form-label">Descripcion</label>
                    <input type="text" class="form-control" id="descripcionCa" placeholder="Descripcion">
                  </div>          
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                  <button type="button" class="btn btn-primary" onclick="updatecategoria()" data-bs-dismiss="modal" >Save changes</button>
                </div>
                
              </div>
            </div>
          </div>
        <script src="../Ecommercejs/categorialist.js"></script>
        <script src="../Ecommercejs/guardarCategoria.js"></script>
        <script src="../Ecommercejs/BuscarCategoria.js"></script>
        <script src="../jquery/jquery-3.6.0.js"></script>
        <script>
	  	$(document).ready(function(){  		
			getCategoriasList();                  
                        getCategoriaCount();
                        console.log(document.getElementById("idCategoria").value)
		});
                $("#buscar").click(function(){
                    if(document.getElementById("idCategoria").value !== undefined){
                        getCategoriasId(document.getElementById("idCategoria").value);
                    }else{
                        getCategoriasId("");
                    }// action goes here!!
                });
                $("#eliminar").click(function(){
                        getEliminarCategoria(document.getElementById("idCategoria").value);
                        location.reload();
                 })
                
        </script>
    </body>
</html>