/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function itemAdd(id){
    $.ajax({
            url: 'http://localhost:8080/Tienda/webresources/item/add/'+id+'/'+1,
            type: 'get',
            dataType: 'json',
            contentType: 'application/json',
            success: function (data) {            	
            	console.log(data);
                getitem();
            },
            failure: function(errMsg) {
                alert(errMsg);
            }
        });  
    
}
function getitem(){
    $("#items").empty();
    $.ajax({
            url: 'http://localhost:8080/Tienda/webresources/item/',
            type: 'get',
            dataType: 'json',
            contentType: 'application/json',
            success: function (data) {            	
            	console.log(data);
                $("#items").append(data.length);
            },
            failure: function(errMsg) {
                alert(errMsg);
            }
        });  
    
}