/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function getitemCart(){
    $("#items").empty();
    var table = '<table class="table table-striped table-bordered border-primary"><thead><tr><th scope="col">#</th><th scope="col"> Nombre </th><th scope="col"> Precio </th><th scope="col">Cantidad</th><th scope="col">Valor Unitario</th>';
	
    table = table +'<th scope="col">Categoria</th></tr></thead><tbody id="data"></tbody></table>';
    $("#cartlist").append(table);
    //console.log(result);
    $.ajax({
            url: 'http://localhost:8080/Tienda/webresources/item/',
            type: 'get',
            dataType: 'json',
            contentType: 'application/json',
            success: function (data) {            	
            	console.log(data);
                $("#cantidadCat").append(data.length)
                var valortotal = 0;
                for(var i = 0;i<data.length;i++ ){
                    valot = getProductoIdCart(data[i].idproducto, data[i].cantidad);
                    valortotal = valortotal +valot;
                }
                $("#valortotal").append(valortotal);
            },
            failure: function(errMsg) {
                alert(errMsg);
            }
    });
    
    
}

function getProductoIdCart(id,cantidad){
   
   
   $.getJSON("http://localhost:8080/Tienda/webresources/productos/"+id, function(result){
	    	
        var id = result.id;
        var name = result.nombre;
        var precio = result.precio;
        var valor = cantidad*precio;
        var categoria = result.idcategoria.nombre;
        
        
        var fac='<tr><th scope="row">'+id+'</th> <td> '+name+'</td><td>';
        fac = fac+ precio +'</td> <td> '+cantidad+'</td><td>'+valor+'</td> <td> '+categoria+'</td></tr>';    		
        $("#data").append(fac);
        
    	
    });
    
}