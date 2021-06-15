<%-- 
    Document   : cliente
    Created on : 15/06/2021, 12:35:53 AM
    Author     : luis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/bootstrap.css" rel="stylesheet">
        <script src="../js/bootstrap.js" ></script>
        <title>Ecommerce clientes</title>
    </head>
    <body>
        <nav class="navbar navbar-dark bg-dark">
            <div class="container-fluid">
              <a class="navbar-brand" href="#">Navbar</a>
            </div>
        </nav>
        
        <div class="container">
            
            <div class="row mt-3">
                <div class="row mt-3 mb-2">
                    <div id="div_review_response">
                    </div>
                    
                    <div class="mt-3">
                        <h3> Catidad Clientes</h3>
                        <h3 id="cantidadcliente"></h3>
                    </div>
                    <div>
                        <div class="col-5 mt-2 flex-row">
                             <input type="number" class="form-control" id="idcliente" placeholder="id">                             
                        </div>                                      
                    </div>
                    <div class="mt-3">
                        <button type="button" id="buscar" class="btn btn-danger">Buscar cliente </button>
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">Agregar Producto</button>                        
                        <button type="button" id="eliminar" class="btn btn-danger">Eliminar cliente</button>
                        
                       
                    </div> 
                </div>
                <div id="clientelist" class="col-12 mt-3 mb-5">            
                </div>    
            </div>                  
        </div>
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-scrollable">
              <div class="modal-content">
                <div class="modal-header">
                  <h5 class="modal-title" id="exampleModalLabel">Agregar cliente</h5>
                  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                  <div class="mb-3">
                    <label for="nombre" class="form-label">Nombre</label>
                    <input type="text" class="form-control" id="nombre" placeholder="Nombre">
                  </div>
                  <div class="mb-3">
                    <label for="apellido" class="form-label">Apellido</label>
                    <input type="text" class="form-control" id="apellido" placeholder="Apellido">
                  </div>
                    <div class="mb-3">
                    <label for="tipodocumento" class="form-label"> Tipo Documento</label>
                    <input type="text" class="form-control" id="tipodocumento" placeholder="cc - ti">
                  </div>
                    <div class="mb-3">
                    <label for="numdocumento" class="form-label">Numero Documento</label>
                    <input type="number" class="form-control" id="numdocumento" placeholder="0">
                  </div>
                  <div class="mb-3">
                    <label for="telefono" class="form-label">Telefono</label>
                    <input type="number" class="form-control" id="telefono" placeholder="Telefono">
                  </div>
                  <div class="mb-3">
                    <label for="direccion" class="form-label">Direccion</label>
                    <input type="text" class="form-control" id="direccion" placeholder="Direccion">
                  </div>
                                  

                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                  <button type="button" class="btn btn-primary" onclick="send()" data-bs-dismiss="modal" >Save changes</button>
                </div>
                
              </div>
            </div>
          </div>
        
        <script src="../Ecommercejs/clientelist.js"></script>
        <script src="../Ecommercejs/BuscarCliente.js"></script>
        <script src="../Ecommercejs/guardarCliente.js"></script>
        <script src="../jquery/jquery-3.6.0.js"></script>
        <script>
	  	$(document).ready(function(){  		
			getClienteList();
                        getClienteCount();
                        
		});
                $("#eliminar").click(function(){
                        getEliminarCliente(document.getElementById("idcliente").value);
                        location.reload();
                 });
                 $("#buscar").click(function(){
                        getClienteId(document.getElementById("idcliente").value);
                        
                 });
        </script>
    </body>
</html>
