/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function getProductoId(id){
    $('#productoslist').empty();
    $.getJSON("http://localhost:8080/Tienda/webresources/productos/"+id, function(result){
	var table = '<table class="table table-striped table-bordered border-primary"><thead><tr><th scope="col">#</th><th scope="col"> Nombre </th><th scope="col"> Precio </th><th scope="col">Cantidad</th><th scope="col">Valor</th>';
	
        table = table +'<th scope="col">Categoria</th><th scope="col"> Accion </th></tr></thead><tbody id="data"></tbody></table>';
	$("#productoslist").append(table);
    	console.log(result);
    	
        var id = result.id;
        var name = result.nombre;
        var precio = result.precio;
        var codigo = result.codigo;
        var ref = result.ref;
        var categoria = result.idcategoria.nombre;
        //console.log(id +" "+name+" "+precio+" "+cantidad);
        var fac='<tr><th scope="row">'+id+'</th> <td> '+name+'</td><td>';
        fac = fac+ precio +'</td> <td> '+codigo+'</td><td>'+ref+'</td> <td> '+categoria+'</td> <td> '+'<button type="button" data-bs-toggle="modal" data-bs-target="#updateproducto" onclick="getProductosUpdate('+id+')" class="btn btn-success">Editar</button> <button type="button" onclick="getEliminarProducto('+id+');location.reload();" class="btn btn-danger">Eliminar</button>'+'</td></tr>';    		
        $("#data").append(fac);
    	
    });
}

function getEliminarProducto(id){
    $.ajax({
        url: 'http://localhost:8080/Tienda/webresources/productos/'+id,
        type: 'DELETE',
        success: function(result) {
            alert(result);
        }
    });
}