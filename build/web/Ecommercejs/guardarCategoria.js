/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function send() {
        var categoria = {
            nombre: document.getElementById("nombre").value,
            descripcion:document.getElementById("descripcion").value,
            
        };
        $('#div_review_response').empty();
        var htmnn = '<div class="alert alert-success" role="alert">';
        htmnn += ' <h4 class="alert-heading">Actualizacion exitosa!</h4>';
        htmnn += '<p>Se actualizo una categoria.</p> ';
        htmnn += '<hr> <p class="mb-0">'+categoria.nombre+' '+ categoria.descripcion +'.</p></div>   ';
        
        
        
        $.ajax({
            url: 'http://localhost:8080/Tienda/webresources/categoria/',
            type: 'post',
            dataType: 'json',
            contentType: 'application/json',
            success: function (data) {            	
            	console.log(data);
                location.reload();
                $('#div_review_response').append(htmnn);
            	               
            },
            data: JSON.stringify(categoria),
            failure: function(errMsg) {
                alert(errMsg);
                
            }
        });
        
        
}


function updatecategoria() {
        var categoria = {
            id:document.getElementById("idCa").value,
            nombre: document.getElementById("nombreCa").value,
            descripcion:document.getElementById("descripcionCa").value            
        };
        $('#div_review_response').empty();
        var htmnn = '<div class="alert alert-success" role="alert">';
        htmnn += ' <h4 class="alert-heading">Actualizacion exitosa!</h4>';
        htmnn += '<p>Se actualizo una categoria.</p> ';
        htmnn += '<hr> <p class="mb-0">'+categoria.nombre+' '+ categoria.descripcion +'.</p></div>   ';
        
        
        $.ajax({
            url: 'http://localhost:8080/Tienda/webresources/categoria/update',
            type: 'put',
            dataType: 'json',
            contentType: 'application/json',
            success: function (data) {            	
            	console.log(data);
                
                $('#div_review_response').append(htmnn);
            	               
            },
            data: JSON.stringify(categoria),
            failure: function(errMsg) {
                alert(errMsg);
                
            }
        });
        
        
}

