/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function send() {
        var producto = {
            nombre: document.getElementById("nombre").value,
            descripcion:document.getElementById("descripcion").value,
            codigo:document.getElementById("codigo").value,
            ref:document.getElementById("ref").value,
            precio:document.getElementById("precio").value,
            idcategoria:{ id: document.getElementById("selectCat").value}
        };
        console.log(producto);
        console.log(JSON.stringify(producto));
        $('#div_review_response').empty();
        var htmnn = '<div class="alert alert-success" role="alert">';
        htmnn += ' <h4 class="alert-heading">Registro Exitoso!</h4>';
        htmnn += '<p>Se a creado un nuevo producto.</p> ';
        htmnn += '<hr> <p class="mb-0">'+producto.nombre+' '+ producto.precio +'.</p></div>   ';
        
        $.ajax({
            url: 'http://localhost:8080/Tienda/webresources/productos/',
            type: 'post',
            dataType: 'json',
            contentType: 'application/json',
            success: function (data) {            	
            	console.log(data);                
            	$('#div_review_response').append(htmnn);                
            },
            data: JSON.stringify(producto),
            failure: function(errMsg) {
                alert(errMsg);
            }
        });       
        
}

function update() {
        var producto = {
            id:document.getElementById("idP").value,
            nombre: document.getElementById("nombreP").value,
            descripcion:document.getElementById("descripcionP").value,
            codigo:document.getElementById("codigoP").value,
            ref:document.getElementById("refP").value,
            precio:document.getElementById("precioP").value,
            idcategoria:{ id: document.getElementById("selectCatP").value}
        };
        console.log(producto);
        console.log(JSON.stringify(producto));
        $('#div_review_response').empty();
        var htmnn = '<div class="alert alert-success" role="alert">';
        htmnn += ' <h4 class="alert-heading">Actualizacion exitosa</h4>';
        htmnn += '<p>Se ha actualizado un producto</p> ';
        htmnn += '<hr> <p class="mb-0">'+ producto.id + ' '+ producto.nombre +'</p>    </div>   ';
        
        $.ajax({
            url: 'http://localhost:8080/Tienda/webresources/productos/update',
            type: 'put',
            dataType: 'json',
            contentType: 'application/json',
            success: function (data) {            	
            	console.log(data);                
            	$('#div_review_response').append(htmnn);                
            },
            data: JSON.stringify(producto),
            failure: function(errMsg) {
                alert(errMsg);
            }
        });       
        
}

