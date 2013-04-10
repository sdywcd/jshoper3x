


var leftmenui="";

function getleftmenu(ltypeid){
	$.ajax({
		url:'GetLeftMenu.action',
		type:"post",
		data:{"ltypeid":ltypeid},
		dataType:'json',
		async:false,
		success:function(data){
		if(data.leftmenu!=null){
			$.each(data.leftmenu,function(index,item){
				leftmenui+="<i ><a target='_blank' href=\"findGoodsByLtypeid.action?ltypeid="+ltypeid+"\">"+item.sname+"</a></i>";
			});
		}
		}
	});
}

$(function(){
	$.ajax({
		url:'GetLeftMainMenuAjax.action',
		type:"post",
		dataType:'json',
		async: false,
		success:function(data){
			if(data.leftmainmenu!=null){
			var menustr=""
			$.each(data.leftmainmenu,function(index,value){
				if(value.ltypeid!=""){
					getleftmenu(value.ltypeid);
					menustr+="<li class='l"+value.ltypeid+"'><a target='_blank' href='findGoodsByLtypeid.action?ltypeid="+value.ltypeid+"'>"+value.lname+"</a>"
							+"<div class='cms_submenu'>"
							+"<div class='cmsmenuleft'>"
							+"<dl class='menu_recommend'>"
							+"<dt id='1r'+'"+value.ltypeid+"'>热门类目</dt>"
							+"<dd id='1f'+'"+value.ltypeid+"'>"+leftmenui+"</dd>"
							
							+"<div class='clear'></div></dl><dl class='menu_price'><div class='clear'></div></dl><dl class='menu_new'></d></div><div class='cmsnmenuright'><dl></dl></div></div></li>";
							
					}
				leftmenui="";
				});
					menustr+="<li><a href='findAllSaleGoods.action?goodsname='>所有商品</a></li>";
					$('#categoryvalue').append(menustr);
			}
		}
	});

});
