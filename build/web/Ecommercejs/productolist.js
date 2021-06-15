/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function getProductosList(){
    $.getJSON("http://localhost:8080/Tienda/webresources/productos/", function(result){
	var table = '<table class="table table-striped table-bordered border-primary"><thead><tr><th scope="col">#</th><th scope="col"> Nombre </th><th scope="col"> Precio </th><th scope="col">Cantidad</th><th scope="col">Referencia</th>';
	
        table = table +'<th scope="col">Categoria</th><th scope="col"> Accion </th></tr></thead><tbody id="data"></tbody></table>';
	$("#productoslist").append(table);
    	console.log(result);
    	for(var row=0; row<result.length; row=row+1){
            var id = result[row].id;
            var name = result[row].nombre;
            var precio = result[row].precio;
            var codigo = result[row].codigo;
            var ref = result[row].ref;
            var categoria = result[row].idcategoria.nombre;
            //console.log(id +" "+name+" "+precio+" "+cantidad);
            var fac='<tr><th scope="row">'+id+'</th> <td> '+name+'</td><td>';
            fac = fac+ precio +'</td> <td> '+codigo+'</td><td>'+ref+'</td> <td> '+categoria+'</td> <td> '+'<button type="button" data-bs-toggle="modal" data-bs-target="#updateproducto" onclick="getProductosUpdate('+id+')" class="btn btn-success">Editar</button> <button type="button" onclick="getEliminarProducto('+id+');location.reload();" class="btn btn-danger">Eliminar</button>'+'</td></tr>';    		
            $("#data").append(fac);
    	}
    });
}
function getProductosCount(){
    $.getJSON("http://localhost:8080/Tienda/webresources/productos/count", function(result){
	console.log(result);
        $("#cantidadproducto").append(result)
    });
}
function getProductosUpdate(id){
    $.getJSON("http://localhost:8080/Tienda/webresources/productos/"+id, function(result){
        console.log(result);
        $("#idP").val(result.id);
	$("#nombreP").val(result.nombre);
        $("#codigoP").val(result.codigo);
        $("#refP").val(result.ref);
        $("#descripcionP").val(result.descripcion);
        $("#precioP").val(result.precio);
        $("#selectP").val(result.idcategoria.id);
    });
}