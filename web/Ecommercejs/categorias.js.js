/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function getCategories(category_id){
    $.getJSON("http://localhost:8080/Tienda/webresources/categoria/", function(result){
    	console.log(result);
    	for(var row=0; row<result.length; row=row+1){
    		var id = result[row].id;
    		var name = result[row].nombre;
    		
    		var item_class = "list-group-item";
    		if(id == category_id){
    			item_class = "list-group-item active";	
    		}
    		$("#div_categories").append("<a href='javascript:getProductos(" + id + ");' id='category_" + id + "' class='" + item_class + "'>" + name + "</a>");
    	}
    });
}


function getCategoriesSelect(){
    $.getJSON("http://localhost:8080/Tienda/webresources/categoria/", function(result){
    	console.log(result);
    	for(var row=0; row<result.length; row=row+1){
    		var id = result[row].id;
    		var name = result[row].nombre;    		    		
    		$("#selectCat").append("<option value="+id+">"+name+"</option>");
    	}
    });
}
