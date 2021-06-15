/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function send() {
        var categoria = {
            nombre: document.getElementById("nombre").value,
            descripcion:document.getElementById("descripcion").value,
            
        }
        
        
        $.ajax({
            url: 'http://localhost:8080/Tienda/webresources/categoria/',
            type: 'post',
            dataType: 'json',
            contentType: 'application/json',
            success: function (data) {            	
            	console.log(data);
                message(data);
            	               
            },
            data: JSON.stringify(categoria),
            failure: function(errMsg) {
                alert(errMsg);
                message(data);
            }
        });
        
        
}
function message(me){
    console.log(me)
    windows.window.alert(me); alert(me);
}

