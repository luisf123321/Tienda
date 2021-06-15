/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function getCategoriasList(){
   
    $.getJSON("http://localhost:8080/Tienda/webresources/categoria/", function(result){
	var table = '<table class="table table-striped table-bordered border-primary"><thead><tr><th scope="col">#</th><th scope="col"> Nombre </th><th scope="col">Descripcion</th>';
	
        table = table +'<th scope="col"> Accion </th></tr></thead><tbody id="data"></tbody></table>';
	$("#categorialist").append(table);
    	console.log(result);
    	for(var row=0; row<result.length; row=row+1){
            var id = result[row].id;
            var name = result[row].nombre;
            var descripcion = result[row].descripcion;
            
            //console.log(id +" "+name+" "+precio+" "+cantidad);
            var fac='<tr><th scope="row">'+id+'</th> <td> '+name+'</td>';
            fac = fac+' <td> '+descripcion+'</td> <td> '+'<button type="button" class="btn btn-success">Editar</button> <button type="button" onclick="getEliminarProducto('+id+');location.reload();" class="btn btn-danger">Eliminar</button>'+'</td></tr>';    		
            $("#data").append(fac);
    	}
    });
}
function getCategoriaCount(){
    $.getJSON("http://localhost:8080/Tienda/webresources/categoria", function(result){
	console.log(result);
        $("#cantidadCat").append(result.length)
    });
}
