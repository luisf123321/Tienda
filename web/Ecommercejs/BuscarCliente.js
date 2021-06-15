/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function getClienteId(id){
    $('#clientelist').empty();
    $.getJSON("http://localhost:8080/Tienda/webresources/clientes/"+id, function(result){
	var table = '<table class="table table-striped table-bordered border-primary"><thead><tr><th scope="col">#</th><th scope="col"> Nombre </th><th scope="col">Apellido</th><th scope="col">Numero Documento</th> <th scope="col">Direcion</th><th scope="col">telefono</th>';
	
        table = table +'<th scope="col"> Accion </th></tr></thead><tbody id="data"></tbody></table>';
	$("#clientelist").append(table);
    	console.log(result);
    	
        var id = result.id;
        var name = result.nombre;
        var apellido = result.apellido;
        var direccion = result.direccion;
        var telefono = result.telefono;
        var numero = result.numdocumento;
            
            //console.log(id +" "+name+" "+precio+" "+cantidad);
        var fac='<tr><th scope="row">'+id+'</th> <td> '+name+'</th> <td> '+apellido+'</th> <td> '+numero+'</th> <td> '+direccion+'</td>';
        fac = fac+' <td> '+telefono+'</td> <td> '+'<button type="button" class="btn btn-success">Editar</button> <button type="button" onclick="getEliminarCliente('+id+');location.reload();" class="btn btn-danger">Eliminar</button>'+'</td></tr>';    		
        $("#data").append(fac);
    	
    });
}

function getEliminarCliente(id){
    $.ajax({
        url: 'http://localhost:8080/Tienda/webresources/clientes/'+id,
        type: 'DELETE',
        success: function(result) {
            alert(result);
        }
    });
}