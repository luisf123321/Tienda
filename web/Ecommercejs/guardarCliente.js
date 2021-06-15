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

