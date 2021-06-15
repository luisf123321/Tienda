/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function getCategoriasId(id){
    $('#categorialist').empty();
    $.getJSON("http://localhost:8080/Tienda/webresources/categoria/"+id, function(result){
	var table = '<table class="table table-striped table-bordered border-primary"><thead><tr><th scope="col">#</th><th scope="col"> Nombre </th><th scope="col">Descripcion</th>';
	
        table = table +'<th scope="col"> Accion </th></tr></thead><tbody id="data"></tbody></table>';
	$("#categorialist").append(table);
    	console.log(result);
    	
        var id = result.id;
        var name = result.nombre;
        var descripcion = result.descripcion;
            
            //console.log(id +" "+name+" "+precio+" "+cantidad);
        var fac='<tr><th scope="row">'+id+'</th> <td> '+name+'</td>';
        fac = fac+' <td> '+descripcion+'</td> <td> '+'<button data-bs-toggle="modal" data-bs-target="#updatecategoria" type="button" onclick="getCategoriaUpdate('+id+')"  class="btn btn-success">Editar</button> <button type="button" onclick="getEliminarProducto('+id+');location.reload();" class="btn btn-danger">Eliminar</button>'+'</td></tr>';    		
        $("#data").append(fac);
    	
    });
}

function getEliminarCategoria(id){
    $.ajax({
        url: 'http://localhost:8080/Tienda/webresources/categoria/'+id,
        type: 'DELETE',
        success: function(result) {
            alert(result);
        }
    });
}