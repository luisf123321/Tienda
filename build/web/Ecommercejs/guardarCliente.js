/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function send() {
        var cliente = {
            nombre: document.getElementById("nombre").value,
            apellido:document.getElementById("apellido").value,
            tipodocumento:document.getElementById("tipodocumento").value,
            numdocumento:document.getElementById("numdocumento").value,
            telefono:document.getElementById("telefono").value,
            direccion: document.getElementById("direccion").value
        }
        console.log(cliente);
        console.log(JSON.stringify(cliente));
        $('#div_review_response').empty();
        
        $.ajax({
            url: 'http://localhost:8080/Tienda/webresources/clientes/',
            type: 'post',
            dataType: 'json',
            contentType: 'application/json',
            success: function (data) {            	
            	console.log(data);                
            	$('#div_review_response').append(htmnn);                
            },
            data: JSON.stringify(cliente),
            failure: function(errMsg) {
                alert(errMsg);
            }
        });       
        
}

function updateCliente() {
        var cliente = {
            id:document.getElementById("idC").value,
            nombre: document.getElementById("nombreC").value,
            apellido:document.getElementById("apellidoC").value,
            tipodocumento:document.getElementById("tipodocumentoC").value,
            numdocumento:document.getElementById("numdocumentoC").value,
            telefono:document.getElementById("telefonoC").value,
            direccion: document.getElementById("direccionC").value
        }
        console.log(cliente);
        console.log(JSON.stringify(cliente));
        $('#div_review_response').empty();
        var htmnn = '<div class="alert alert-success" role="alert">';
        htmnn += ' <h4 class="alert-heading">Cliente Actualizado!</h4>';
        htmnn += '<p>Se ha actualizado cliente exitosamente</p> ';
        htmnn += '<hr> <p class="mb-0"> '+cliente.nombre+' '+cliente.apellido+'</p>    </div>   ';
        
        $.ajax({
            url: 'http://localhost:8080/Tienda/webresources/clientes/update',
            type: 'put',
            dataType: 'json',
            contentType: 'application/json',
            success: function (data) {            	
            	console.log(data);                
            	$('#div_review_response').append(htmnn);                
            },
            data: JSON.stringify(cliente),
            failure: function(errMsg) {
                alert(errMsg);
            }
        });       
        
}
