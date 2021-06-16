<%-- 
    Document   : cart
    Created on : 15/06/2021, 06:42:39 PM
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
                        <h1> Cart Compra</h1>
                        
                    </div>
                    <div>
                        <div class="col-5 mt-2 flex-row">
                             <input type="number" class="form-control" id="idCategoria" placeholder="id">                             
                        </div>                                      
                    </div>
                    
                </div>
                <div  class="col-10 mt-3 "> 
                    <h2>Detalle Factura</h2>
                    <h2>Articulos Agregados:  <span id="cantidadCat" ></span>   </h2>
                </div>
                <div id="cartlist" class="col-10 mt-3">            
                </div>
                <div  class="col-10 mt-3 "> 
                    <h2>Total <span id="valortotal" ></span>   </h2>
                </div>
                <div class="mt-3 mb-5">
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">Confirmar Compra</button>                        
                    <button type="button" id="eliminar" class="btn btn-danger">Cancelar Cancelar</button>                       
                </div> 
            </div>                  
        </div>      
       
        <script src="../Ecommercejs/item/itemAdd.js"></script>
        <script src="../Ecommercejs/Cart/cart.js"></script>
        <script src="../jquery/jquery-3.6.0.js"></script>
        <script>
	  	$(document).ready(function(){			
                    getitem();
                    getitemCart();
		});              
                
        </script>
    </body>
</html>
