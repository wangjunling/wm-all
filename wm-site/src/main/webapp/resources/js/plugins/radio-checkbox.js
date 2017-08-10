$(document).ready( function () { 
     $("div").cssRadio(); 
     $("div").cssCheckBox(); 
}); 
jQuery.fn.cssRadio = function () { 
    $(":input[type=radio] + label").each( function(){ 
            if ( $(this).prev()[0].checked ) 
                $(this).addClass("checked"); 
            }) 
        .hover( 
            function() { $(this).addClass("over"); }, 
            function() { $(this).removeClass("over"); } 
            ) 
        .click( function() { 
             var contents = $(this).parent().parent();  
            $(":input[type=radio] + label", contents).each( function() { 
                $(this).prev()[0].checked=false; 
                $(this).removeClass("checked");    
            }); 
            $(this).prev()[0].checked=true; 
             $(this).addClass("checked"); 
            }).prev().hide(); 
}; 

jQuery.fn.cssCheckBox = function () { 
    $(":input[type=checkbox] + label").each( function(){ 
            if ( $(this).prev()[0].checked ) 
                {$(this).addClass("checked");}            
            }) 
        .hover( 
            function() { $(this).addClass("over"); }, 
            function() { $(this).removeClass("over"); } 
            ) 
        .toggle( function()   
            {                
                $(this).prev()[0].checked=true; 
                 $(this).addClass("checked"); 
            }, 
            function() 
            { 
                $(this).prev()[0].checked=false; 
                 $(this).removeClass("checked"); 
            }).prev().hide();           
} 