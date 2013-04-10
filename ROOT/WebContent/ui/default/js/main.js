
	function addfavorite(){
		if (document.all){
		  window.external.addFavorite('http://www.tao3c.com/','高鸿商城');
		}else if (window.sidebar){
		  window.sidebar.addPanel('高鸿商城', 'http://www.tao3c.com/', "");
		}
	}

	function showSuggest(){
		jQuery.ajaxSettings['contentType'] = "application/x-www-form-urlencoded; charset=utf-8";
		jQuery("#topKeywords").suggest("/AutoComplete",{minchars:1});
    }
    
    function trim(str){ return str.replace(/(^\s*)|(\s*$)/g, "");
	}

    function onSelectComplete(responseText){
	    return;
   	}
	
   var flag2 = 0;
   function delay(){
   	setTimeout(delay,30000);
   }
   function timedCount()
	{
		c=c+1;
		setTimeout("timedCount()",50);
	}
   function displayCategory(id,index){
		var params = new Object();
		params["cid"] = id;
		params["mid"]=0;
		
		if(index==0){
			jQuery("#sub_top_menus").addClass("menus_wrap menus_topline");
			params["divSeq"] = 1;// 控制TopSort_New.jsp中菜单显示样式
			// $("#sub_menus").addClass("top:3px;left:4px;display:none;");
			if(flag2==id){
			  document.getElementById("sub_top_menus").style.display = "block";
			}else{
			  jQuery.ajaxSettings['contentType'] = "application/x-www-form-urlencoded; charset=utf-8";
			  jQuery("#sub_top_menus").load("/Default/IndexInclude/TopSort_New.do?positionFlag='topIndex'",params,onSelectComplete);
			  document.getElementById("sub_top_menus").style.display = "block";
			  document.getElementById("sub_top_menus").style.top = "3px";
			  document.getElementById("sub_top_menus").style.left = "4px";
			  
			  flag2 = id;
			}   
		}else if(index==1){
			jQuery("#sub_top_menus").addClass("menus_wrap");
			params["divSeq"] = 2;
			if(flag2==id){
			  document.getElementById("sub_top_menus").style.display = "block";
			}else{
			  jQuery.ajaxSettings['contentType'] = "application/x-www-form-urlencoded; charset=utf-8";
			  jQuery("#sub_top_menus").load("/Default/IndexInclude/TopSort_New.do?positionFlag='topIndex'",params,onSelectComplete)
			  document.getElementById("sub_top_menus").style.display = "block";
			  document.getElementById("sub_top_menus").style.top = "38px";
			  document.getElementById("sub_top_menus").style.left = "4px";
			  flag2 = id;
			}   
		}else if(index==2){
			jQuery("#sub_top_menus").addClass("menus_wrap");
			params["divSeq"] = 3;
			if(flag2==id){
			  document.getElementById("sub_top_menus").style.display = "block";
			}else{
			  jQuery.ajaxSettings['contentType'] = "application/x-www-form-urlencoded; charset=utf-8";
			  jQuery("#sub_top_menus").load("/Default/IndexInclude/TopSort_New.do?positionFlag='topIndex'",params,onSelectComplete);
			  document.getElementById("sub_top_menus").style.display = "block";
			  document.getElementById("sub_top_menus").style.top = "71px";
			  document.getElementById("sub_top_menus").style.left = "4px";
			  flag2 = id;
			}   
		}else if(index==3){
			jQuery("#sub_top_menus").addClass("menus_wrap");
			params["divSeq"] = 4;
			if(flag2==id){
			  document.getElementById("sub_top_menus").style.display = "block";
			}else{
			  jQuery.ajaxSettings['contentType'] = "application/x-www-form-urlencoded; charset=utf-8";
			  jQuery("#sub_top_menus").load("/Default/IndexInclude/TopSort_New.do?positionFlag='topIndex'",params,onSelectComplete);
			  document.getElementById("sub_top_menus").style.display = "block";
			  document.getElementById("sub_top_menus").style.top = "105px";
			  document.getElementById("sub_top_menus").style.left = "4px";
			  flag2 = id;
			}   
		}else if(index==4){
			jQuery("#sub_top_menus").addClass("menus_wrap");
			params["divSeq"] = 5;
			if(flag2==id){
			  document.getElementById("sub_top_menus").style.display = "block";
			}else{
			  jQuery.ajaxSettings['contentType'] = "application/x-www-form-urlencoded; charset=utf-8";
			  jQuery("#sub_top_menus").load("/Default/IndexInclude/TopSort_New.do?positionFlag='topIndex'",params,onSelectComplete);
			  document.getElementById("sub_top_menus").style.display = "block";
			  document.getElementById("sub_top_menus").style.top = "139px";
			  document.getElementById("sub_top_menus").style.left = "4px";
			  flag2 = id;
			}   
		}else if(index==5){
	
		}
  }
  
  function hideCategory(){
		 var block=document.getElementById("sub_top_menus");
		 block.style.display="none";
  }

  function hideCategoryy(){
		 var block=document.getElementById("sub_top_menus");
		 block.style.display="block";
  }
  
  function showMenu(id){// 首页不设置，其他页面设置
 		 var block=document.getElementById("indexMenu");
		 if(id==0){
		 	block.style.display="none";
		 }else if(id==1){
		 	block.style.display="block";
		 }
  }
  
  function disappear(obj, e) {
  	var block=document.getElementById("indexMenu");
	if (e.currentTarget) {
	   if (e.relatedTarget != obj) {
	    if (obj != e.relatedTarget.parentNode) {
	     	block.style.display="none";
	    }
	   }
	} else {
	   if (e.toElement != obj) {
	    if (obj != e.toElement.parentNode) {
	    	block.style.display="none";
	    }
	   }
	}
	}
  
  function fun(e,o) {
       	var block=document.getElementById("indexMenu");
        if(window.navigator.userAgent.indexOf("Firefox")>=1) {
            var x = e.clientX + document.body.scrollLeft;
            var y = e.clientY + document.body.scrollTop ;
            var left = o.offsetLeft;
            var top = o.offsetTop;
            var w = o.offsetWidth;
            var h = o.offsetHeight;
           
            if(y < top || y > (h + top) || x > left + w || x<left ) {
                block.style.display="none";
            }
        }
       
        if(o.contains(event.toElement ) == false)
 			block.style.display="none";
       
    }
  
  function hideCart(){
		document.getElementById("shopcar_New").style.display="none";
  }
  
 function checkTopSearchForm(){
	var keyword=jQuery("#topKeywords").val();
	if(keyword!=""&& trim(keyword)!=""){
	  keyword+=",title,keyword";
	}else{
	     window.location = '/search/fail.do';
	    return false;
	}
	jQuery("#thKeywords").val(jQuery.trim(keyword));
	jQuery("#searchform").submit();   
}

function keyDown(e){
	var ev =window.event||e; //
 	if (ev.keyCode==13) {
   		ev.returnValue=false;
   		ev.cancel = true;
   		checkTopSearchForm();
 }
}

function GetArgsFromHref(sHref, sArgName) 
{ 
	var args = sHref.split("?"); 
	var retval = "";
	if(args[0] == sHref) 
	{ 
	return retval; 
	} 
	var str = args[1]; 
	args = str.split("&"); 
	for(var i = 0; i < args.length; i ++) 
	{ 
	str = args[i]; 
	var arg = str.split("="); 
	if(arg.length <= 1) continue; 
	if(arg[0] == sArgName) 
	retval = arg[1]; 
	} 
	return retval; 
}

var name = "#menuMove"; 
var menuYloc = null; 
/*
 * jQuery(document).ready(function() { menuYloc =
 * parseInt(jQuery(name).css("top").substring(0,
 * jQuery(name).css("top").indexOf("px"))) jQuery(window).scroll(function() {
 * 
 * var scrollOffset = jQuery(document).scrollTop(); offset = menuYloc +
 * scrollOffset; if(scrollOffset<173){ jQuery(name).css("position","absolute");
 * jQuery(name).animate({ top: 105+"px" }, {duration: 0.1, queue: false });
 * }else{ jQuery(name).css("position","fixed"); jQuery(name).animate({ top:
 * 0+"px" }, {duration: 0.1, queue: false }); } }); });
 */

	function delayRun(code,time) {
	  var t=setTimeout(code,time);
	}
	
	function getLocalUrl(){
		var the_url=document.location.href;
		var args = the_url.split("?"); 
		
		var patrn=/[\w+\W+]*(tao3c.com\/index.jsp|tao3c.cn\/index.jsp|tao3c.com|tao3c.cn)$/gi;
	    if (patrn.exec(args[0])){
	        return 'index';
	    }
	    patrn=/[\w+\W+]*(RunningTeamBuy.do)$/gi;
	    if (patrn.exec(args[0])){
	        return 'teamBuy';
	    }
	    patrn=/[\w+\W+]*(DefineActivity7.do)$/gi;
	    if (patrn.exec(args[0])){
	        return 'outlets';
	    }
	    patrn=/[\w+\W+]*(sellAuction.do|historyList.do)$/gi;
	    if (patrn.exec(args[0])){
	        return 'auction';
	    }
		return 'other';
	}	

function makeCartItemNumber( htmldata ) {	
	try {
		var fromindex = htmldata.indexOf('<span id=\"totalitemcount\">');  
		if( fromindex < 0 ) {
			// alert( htmldata ) ;
			return ;
		}         
	    var endindex  = htmldata.indexOf( '</span>', fromindex);
	    if( endindex < 0 ) {
		    // alert( htmldata ) ;
		    return ;
	    }
	    var itemnumber = htmldata.substring( fromindex+26, endindex ) ;  
	    document.getElementById( "cartcount" ).innerHTML = itemnumber ;
	} catch( e ) {
		document.getElementById( "cartcount" ).innerHTML = "0" ;
	}
    
}
	
jQuery( document ).ready( function() {
	jQuery.ajaxSettings['contentType'] = "application/x-www-form-urlencoded; charset=utf-8";
    jQuery.post("/Default/FInclude/TopLogin.do", {mid:0}, function(data){
        document.getElementById("id_temp").innerHTML = data ;
    });
    
    jQuery.post("/Default/FInclude/includeShowCart.do", {mid:0}, makeCartItemNumber );
} ) ;

function loadPrice(commendtype,id,mid){
    loadPrice1(commendtype,id,mid,1);
  }
  function loadPrice1(commendtype,id,mid,showName){
    var data = new Object();
    data["style"] = '';
    data["id"] = id;
    data["mid"] = mid;
    jQuery.ajaxSettings['contentType'] = "application/x-www-form-urlencoded; charset=utf-8";
    jQuery("#priceDiv"+commendtype+id).load("/ProductPrice2.do",data);
  }



var currImg=0;
function selectImg(id){
if(currImg!=id){
jQuery("#midImg_"+currImg).css("display","none");
jQuery("#midImg_"+id).removeAttr("style");
jQuery("#img60_"+id).attr("class","current");
jQuery("#img60_"+currImg).attr("class","other");
currImg=id;
}
}
function showcommend(commendId,id){
a=commendId+'a';
b=commendId+'b';
x = '#pc'+id+'b';
y = '#pc'+id+'a';

if($.browser.msie){	// Can't get div object by tag name in IE.
	// alert('fuck IE !');
	var alldivtag = getElementsByNameIE('div',a);
	for(t=0;t<alldivtag.length;t++ ){
		 alldivtag[t].style.display='none';
	}
	var alldivtag2 = getElementsByNameIE('div',b);
	for(t=0;t<alldivtag2.length;t++ ){
		 alldivtag2[t].style.display='block';
	}
}else{
	jQuery($("[name="+a+"]")).hide();
	jQuery($("[name="+b+"]")).show();
}
jQuery($(x)).hide();
jQuery($(y)).show();			
}


var getElementsByNameIE = function(tag, name){
var returns = new Array();
var e = document.getElementsByTagName(tag);
for(var i = 0; i < e.length; i++){
    if(e[i].getAttribute("name") == name){
        returns[returns.length] = e[i];
    }
}
return returns;
}