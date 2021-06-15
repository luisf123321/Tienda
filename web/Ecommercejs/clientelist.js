/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function getClienteList(){
   
    $.getJSON("http://localhost:8080/Tienda/webresources/clientes/", function(result){
	var table = '<table class="table table-striped table-bordered border-primary"><thead><tr><th scope="col">#</th><th scope="col"> Nombre </th><th scope="col">Apellido</th><th scope="col">Numero Documento</th> <th scope="col">Direcion</th><th scope="col">telefono</th>';
	
        table = table +'<th scope="col"> Accion </th></tr></thead><tbody id="data"></tbody></table>';
	$("#clientelist").append(table);
    	console.log(result);
    	for(var row=0; row<result.length; row=row+1){
            var id = result[row].id;
            var name = result[row].nombre;
            var apellido = result[row].apellido;
            var direccion = result[row].direccion;
            var telefono = result[row].telefono;
            var numero = result[row].numdocumento;
            
            //console.log(id +" "+name+" "+precio+" "+cantidad);
            var fac='<tr><th scope="row">'+id+'</th> <td> '+name+'</th> <td> '+apellido+'</th> <td> '+numero+'</th> <td> '+direccion+'</td>';
            fac = fac+' <td> '+telefono+'</td> <td> '+'<button type="button" class="btn btn-success">Editar</button> <button type="button" onclick="getEliminarCliente('+id+');location.reload();" class="btn btn-danger">Eliminar</button>'+'</td></tr>';    		
            $("#data").append(fac);
    	}
    });
}
function getClienteCount(){
    $.getJSON("http://localhost:8080/Tienda/webresources/clientes", function(result){
	console.log(result);
        $("#cantidadcliente").append(result.length)
    });
}


