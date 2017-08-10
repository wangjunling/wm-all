// JavaScript Document

$(function(){
    $("#goToTop").remove();



//banner
	var curr = 0;
	var imglen = $(".banImgs li").length;
	$(".banImgs li:eq(0)").css("display","block");
	var bannerBtn ='';
	for(var i=0;i<imglen;i++){
	    bannerBtn += '<a href="javascript:void(0)" onfocus="this.blur();" class="trigger"></a>';
	}
	$("#jsNav").html(bannerBtn);
	$(".jsNav .trigger:eq(0)").addClass("current");
	
	
	
	//特殊引导点
	for( var t=0; t<imglen; t++){
	    var fL =418;
	    $(".jsNav .trigger:eq("+t+")").css("left",(418+t*30)+"px");
	    if(t%4==1){
	        $(".jsNav .trigger:eq("+t+")").css("top","0px");
	    }
	    if(t%4==2){
	        $(".jsNav .trigger:eq("+t+")").css("top","0px");
	    }
	}
	
	
	
	$("#jsNav .trigger").each(function(i){
		$(this).click(function(){
		    if(!$(".banImgs li").is(":animated")){
			    this.blur();
			    curr = i;
			    $(".banImgs li").eq(i).css("z-index","10").siblings("li").css("z-index","1");
			    $(".banImgs li").eq(i).fadeIn(1000).siblings("li").fadeOut(1000);
			    $(this).siblings(".trigger").removeClass("current").end().addClass("current");
			}
			else{
			    return false;
			}
		});
	});
	
	var pg = function(flag){
		if (flag) {
			if (curr == 0) {
				todo = (imglen-1);
			} else {
				todo = (curr - 1) % imglen;
			}
		} else {
			
			todo = (curr + 1) % imglen;
		}
		$("#jsNav .trigger").eq(todo).click();
	};
	
	var timer = setInterval(function(){
		todo = (curr + 1) % imglen;
		$("#jsNav .trigger").eq(todo).click();
	},5000);
		
	$("#jsNav a").hover(function(){
			clearInterval(timer);
		},
		function(){
			timer = setInterval(function(){
				todo = (curr + 1) % imglen;
				$("#jsNav .trigger").eq(todo).click();
			},5000);			
		}
	);
	

});