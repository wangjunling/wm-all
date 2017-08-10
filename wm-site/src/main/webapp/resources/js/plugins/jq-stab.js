/* ========================================================
 * bootstrap-tab.js v2.0.0
 * http://twitter.github.com/bootstrap/javascript.html#tabs
 * ========================================================
 * Copyright 2012 Twitter, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ======================================================== */

$(function() {
	$("ul#tabs > li").click(tab);
		function tab() {
		$(this).addClass("selected").siblings().removeClass("selected");
		var tab = $(this).find("a").attr("title");
		$("#" + tab).show().siblings(".tabcont").hide();
	};
}); 



$(document).ready(function(){
	var intervalID;
	var curLi;
	$(".nav li a").mouseover(function(){
	curLi=$(this);
	intervalID=setInterval(onMouseOver,250);//鼠标移入的时候有一定的延时才会切换到所在项，防止用户不经意的操作
	});
	function onMouseOver(){
	$(".cur-sub-con").removeClass("cur-sub-con");
	$(".sub-con").eq($(".nav li a").index(curLi)).addClass("cur-sub-con");
	$(".curtab").removeClass("curtab");
	curLi.addClass("curtab");
	}
	$(".nav li a").mouseout(function(){
	clearInterval(intervalID);
	});
	
	$(".nav li a").click(function(){//鼠标点击也可以切换
	clearInterval(intervalID);
	$(".cur-sub-con").removeClass("cur-sub-con");
	$(".sub-con").eq($(".nav li a").index(curLi)).addClass("cur-sub-con");
	$(".curtab").removeClass("curtab");
	curLi.addClass("curtab");
	});

});

$(document).ready(function(){
	var tabID;
	var currLi;
	$(".tabs li a").click(function(){
	currLi=$(this);
	tabID=setInterval(onMouseOver,300);//鼠标移入的时候有一定的延时才会切换到所在项，防止用户不经意的操作
	});
	function onMouseOver(){
	$(".cur-con").removeClass("cur-con");
	$(".tab-con").eq($(".tabs li a").index(currLi)).addClass("cur-con");
	$(".curtab").removeClass("curtab");
	currLi.addClass("curtab");
	}
	$(".tabs li a").mouseout(function(){
	clearInterval(tabID);
	});
	
	$(".tabs li a").click(function(){//鼠标点击也可以切换
	clearInterval(tabID);
	$(".cur-con").removeClass("cur-con");
	$(".tab-con").eq($(".tabs li a").index(currLi)).addClass("cur-con");
	$(".curtab").removeClass("curtab");
	currLi.addClass("curtab");
	});

});
