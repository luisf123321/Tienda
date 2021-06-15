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
        }
        console.log(producto);
        console.log(JSON.stringify(producto));
        $('#div_review_response').empty();
        var htmnn = '<div class="alert alert-success" role="alert">';
        htmnn += ' <h4 class="alert-heading">Well done!</h4>';
        htmnn += '<p>Aww yeah, you successfully read this important alert message. This example text is going to run a bit longer so that you can see how spacing within an alert works with this kind of content.</p> ';
        htmnn += '<hr> <p class="mb-0">Whenever you need to, be sure to use margin utilities to keep things nice and tidy.</p>    </div>   ';
        
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

