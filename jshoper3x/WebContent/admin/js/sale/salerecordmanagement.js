var session = "true";
var flag = false;
/**
 * ===================split================================================================================
 * 查询所有数据
 * 
 * */
$(function() {
	findallSaleGoodsrecord=function(){
	$('#salerecordmanagement').flexigrid({
		url : 'findallSaleGoodsrecord.action',
		dataType : 'json', 
		cache : false,
		colModel : [{
			display : '拍买用户',
			name : 'username',
			width : '100',
			sortable : true,
			align : 'center'
		},{
			display:'拍买用户姓名',
				name:'realname',
				width:'90',
				sortable:true,
				align:'center'
		},{
			display:'商品编号',
			name:'salegoodsnumber',
			width:'90',
			sortable:true,
			align:'center'
			
		},{
			display:'商品名称',
			width:'80',
			name:'salegoodsname',
			sortable:true,
			align:'center'
		},{
			display:'起拍价',
			width:'60',
			name:'salestartingprice',
			sortable:true,
			align:'center',
		},{
			display:'成交时间',
			width:'100',
			name:'saletradetime',
			sortable:true,
			align:'center'
		},{
			display:'成交价',
			name:'saleprice',
			width:'60',
			sortable:true,
			align:'center'
		},{
			display:'拍卖者',
			name:'salepeople',
			width:'80',
			sortable:true,
			align:'center'
		},{
			display:'固定电话',
			name:'telno',
			width:'100',
			sortable:true,
			align:'center'
		},{
			display:'手机号',
			name:'mobile',
			width:'100',
			sortable:true,
			align:'center'
		},{
			display:'性别',
			name:'sex',
			width:'30',
			sortable:true,
			align:'center'
		},{
			display:'邮箱',
			name:'email',
			width:'120',
			sortable:true,
			align:'center'
		},{
			display:'积分',
			name:'points',
			width:'60',
			sortable:true,
			align:'center'
		},{
			display:'当前最高价',
			name:'hiprice',
			width:'60',
			sortable:true,
			align:'center'
		},{
			display:'参加拍买人数',
			name:'joinnumber',
			width:'60',
			sortable:true,
			align:'center'
		},{
			display:'商城价',
			name:'marketprice',
			width:'60',
			sortable:true,
			align:'center'
		},{
			display:'图片路径',
			name:'salegoodspictureurl',
			width:'60',
			sortable:true,
			align:'center'
		},{
			display:'拍卖开始时间',
			name:'begingtime',
			width:'100',
			sortable:true,
			align:'center'
		},{
			display:'拍卖结束时间',
			name:'endingtime',
			width:'100',
			sortable:true,
			align:'center'
		},{
			display:'拍卖商品简介',
			name:'salegoodsmessage',
			width:'100',
			sortable:true,
			align:'center'
		},{
			display:'最低叫价',
			name:'lowprice',
			width:'80',
			sortable:true,
			align:'center'
		},{
			display:'产地',
			name:'place',
			width:'60',
			sortable:true,
			align:'center'
		},{
			display:'生产厂商',
			name:'manufacturer',
			width:'80',
			sortable:true,
			align:'center'
			
		}],searchitems : [ {
			display : '请选择搜索条件',
			name : 'sc',
			isdefault : true
		}, {
			display : '商品编号',
			name : ''
		} ],
			
		buttons:[/*{
			
			name : '添加',
			bclass : 'add',
			onpress : action
		},*/ {
			name:'编辑',
			bclass:'edit',
			onpress:action
		},{
			name : '删除',
			bclass : 'delete',
			onpress : action
		},{
			separator : true		 
		}],
		sortname:"saletradetime",
		sortorder:"desc",
		userpager:true,
		title:'拍卖管理',
		userRp:true,
		rp:20,
		rpOptions:[5,20,40,100],
		showTableToggleBtn:true,
		//showToggleBtn:true,
		width:'auto',
		height:'auto',
		pagestat : '显示{from}到{to}条，共{total}条记录',
		procmsg : '正在获取数据，请稍候...',                                                                                                                                                                                                                                                                                                                                                              
		checkbox:true,
	});function action(com,grid){
		
		
		
		addoreditrecord(com,grid);
		deletesalegoodsrecordt(com,grid);
	}
};
$(function(){
	findallSaleGoodsrecord();
});

//===================================添加和编辑===========================================================
addoreditrecord=function(com,grid){
if(com=='添加'){
	window.location.href="addsalegoodsrecord.jsp?session="+session+"#goods";
}
if(com=='编辑'){
	if($('.trSelected',grid).length==1){
		jConfirm('确定编辑此项吗？','信息提示',function(r){
			if(r){
			var str	=$('.trSelected',grid)[0].id.substr(3);
			window.location.href="editsalegoodsrecord.jsp?session="+session+"#goods&salerecordid="+str;
			return;
			}
		});
	}else if($('.trSelected').length>1){
		jAlert('请不要选择多个','信息提示');
	}else {
		jAlert('请选择一条信息','信息提示');
		return false;
	}
}
};
//========删除=========================================================================================
deletesalegoodsrecordt=function(com,grid){
 if(com=='删除'){
	if($('.trSelected',grid).length>0){
		jConfirm('确定删除吗？','信息提示',function(r){
			if(r){
				var str="";
				$('.trSelected', grid).each(function() {
					str += this.id.substr(3) + ",";
				});
				$.post("deletesalegoodsrecordt.action",{"salerecordid":str},function(data){
					if(data.flag){
						jAlert('删除成功','信息提示');
						$('#salerecordmanagement').flexReload();
					}
				});
			}
		});
		return ;				
	}else{
		jAlert('请选择要删除的信息!', '信息提示');
		return false;
	}
}
};
});
/**
 * ===================split================================================================================
 * 查询所有数据
 * 
 * */
$(function(){
//=============================================校验========================================================
validatesalegoodsrecord=function() {
	var username = $('#username').val();
	var realname = $('#realname').val();
	var saleprice = $('#saleprice').val();
	var telno = $('#telno').val();
	var findAllSaleGoodsrecordByid = $('#mobile').val();
	var email = $('#email').val();
	var point = $('#point').val();
	var salegoodsnumber = $('#salegoodsnumber').val();
	if(""==salegoodsnumber){
		jAlert('商品编号不能为空','信息提示');
		return false;
	}
	var salegoodsname = $().val('#salegoodsname');
	if(""==salegoodsname){
		jAlert('商品名称不能为空','信息提示');
		return false;
	}
	var salepeople = $('#salepeople').val();
	if(""==salepeople){
		jAlert('拍卖者不能为空','信息提示');
		return false;
	}
	var hiprice = $('#hiprice').val();
	if(""==hiprice){
		jAlert('当前最高价不能为空','信息提示');
		return false;
	}
	var salestartingprice = $('#salestartingprice').val();
	if(""==salestartingprice){
		jAlert('起拍价不能为空','信息提示');
		return false;
	}
	var marketprice=$('#marketprice').val();
	if(""==marketprice){
		jAlert('商城价不能为空','信息提示');
		return false;
	}
	var salegoodsmessage=$('#salegoodsmessage').val();
	if(""==salegoodsmessage){
		jAlert('商品简介不能为空','信息提示');
		return false;
	}
	var lowprice=$('#lowprice').val();
	if(""==lowprice){
		jAlert('最低叫价不能为空','信息提示');
		return false;
	}
	var place=$('#place').val();
	if(""==place){
		jAlert('生产地不能为空','信息提示');
		return false;
	}
	var manufacturer=$('#manufacturer').val();
	if(""==manufacturer){
		jAlert('生产厂商不能为空','信息提示');
		return false;
	}
	var salegoodsinformation=$('#salegoodsinformation').val();
	if(""==salegoodsinformation){
		jAlert('详细信息不能为空','信息提示');
		return false;
	}
	return flag = true;
};
//========================查询所有数据====================================================================
findAllSaleGoodsrecordByid=function(salerecordid){
$.post("findAllSaleGoodsrecordByid.action", {"salerecordid" : salerecordid}, function(data) {
	$('#username').attr("value", data.recordlist.username);
	$('#realname').attr("value", data.recordlist.realname);
	$('#salegoodsnumber').attr("value", data.recordlist.salegoodsnumber);
	$('#salegoodsname').attr("value", data.recordlist.salegoodsname);
	$('#salestartingprice').attr("value", data.recordlist.salestartingprice);
	$('#saleprice').attr("value", data.recordlist.saleprice);
	$('#salepeople').attr("value", data.recordlist.salepeople);
	$('#telno').attr("value", data.recordlist.telno);
	$('#mobile').attr("value", data.recordlist.mobile);
	$('#email').attr("value", data.recordlist.email);
	$('#points').attr("value", data.recordlist.points);
	$('#saletradetime').attr("value", data.recordlist.saletradetime);
	$('#hiprice').attr("value",data.recordlist.hiprice);
	$('#joinnumber').attr("value",data.recordlist.joinnumber);
	$('#marketprice').attr("value",data.recordlist.marketprice);
	var pcurl=data.recordlist.salegoodspictureurl;
	$('#triggers').html("<img src='"+pcurl+"'/>");
	$('#begingtime').attr("value",data.recordlist.begingtime);
	$('#endingtime').attr("value",data.recordlist.endingtime);
	$('#salegoodsmessage').attr("value",data.recordlist.salegoodsmessage);
	$('#lowprice').attr("value",data.recordlist.lowprice);
	$('#place').attr("value",data.recordlist.place);
	$('#manufacturer').attr("value",data.recordlist.manufacturer);
	$('#salegoodsid').attr("value",data.recordlist.salegoodsid);
	if ("1" == data.recordlist.sex) {
		$("input[name='sex'][value=1]").attr("checked", 'checked');
	} else {
		$("input[name='sex'][value=0]").attr("checked", 'checked');
	}
	KE.html("salegoodsinformation",data.recordlist.salegoodsinformation);
	
	return;
});
};
//=====================================================更新salegoodsrecord==============================
updateSalegoodsrecord=function(){
$('#update').click(function() {
	validatesalegoodsrecord();
	if (flag) {
		
		var salerecordid = $.query.get('salerecordid');
		var username = $('#username').val();
		var realname = $('#realname').val();
		var salegoodsnumber = $('#salegoodsnumber').val();
		var salegoodsname = $('#salegoodsname').val();
		var salestartingprice = $('#salestartingprice').val();
		var saletradetime = $('#saletradetime').val();
		var saleprice = $('#saleprice').val();
		var salepeople = $('#salepeople').val();
		var telno = $('#telno').val();
		var mobile = $('#mobile').val();
		var sex = $("input[name='sex']:checked").val();
		var email = $("#email").val();
		var points = $('#points').val();
		var hiprice = $('#hiprice').val(); 
		var joinnumber=$('#joinnumber').val();
		var marketprice=$('#marketprice').val();
		var salegoodspictureurl="";
		$(":checkbox[name='pcpath'][checked=true]").each(function(){
			salegoodspictureurl=this.value;
	});
		var begingtime=$('#begingtime').val();
		var endingtime=$('#endingtime').val();
		var salegoodsmessage=$('#salegoodsmessage').val();
		var lowprice=$('#lowprice').val();
		var place=$('#place').val();
		var manufacturer=$('#manufacturer').val();
		var salegoodsid=$('#salegoodsid').val();
		var salegoodsinformation=$('#salegoodsinformation').val();
		$.post("updatesalegoodsrecordt.action",{
							"salerecordid" : salerecordid,
							"username" : username,
							"realname" : realname,
							"salegoodsnumber" : salegoodsnumber,
							"salegoodsname" : salegoodsname,
							"salestartingprice" : salestartingprice,
							"saletradetime" : saletradetime,
							"saleprice" : saleprice,
							"salepeople" : salepeople,
							"telno" : telno,
							"mobile" : mobile,
							"sex" : sex,
							"email" : email,
							"points" : points,
						"hiprice" : hiprice,
						"joinnumber":joinnumber,
						 "marketprice":marketprice,
						 "salegoodspictureurl":salegoodspictureurl,
						 "begingtime":begingtime,
						 "endingtime":endingtime,
						 "salegoodsmessage":salegoodsmessage,
						 "lowprice":lowprice,
						 "place":place,
						 "manufacturer":manufacturer,
						 "salegoodsid":salegoodsid,
						 "salegoodsinformation":salegoodsinformation},
						 function(data) {
								if (data.recordgoods) {
									jAlert('修改成功', '信息提示');
									window.location.href = 'salegoodsrecord.jsp?session'
											+ session
											+ "#goods";
								} else {
									jAlert('修改失败', '信息提示');
									return false;
								}
							});
		} else {
			return false;
		}
	});
};
delrecord=function(){
	$("#delpc").click(function() {
		var str = "";
		var sum = 0;
		$(":checkbox[name='pcpath'][checked=true]").each(function() {
			sum++;
			str = this.id;
		});
		if (sum == 0) {
			jAlert('只有在选择图片后才能删除', '信息提示');
			return false;
		}
		if (sum > 1) {
			jAlert('不能选择多个图片', '信息提示');
			return false;
		}
		$('#triggers img').each(function() {
			if (this.id == str) {
				this.style.display = "none";
				$(":checkbox[name='pcpath'][checked=true]").each(function() {
					if (this.id == str) {
						this.style.display = "none";
						this.name = "dispcpath";
					}
				});
			}
		});
	});
};
});

$(function(){
	var salerecordid = $.query.get('salerecordid');
	if (salerecordid == null) {
		return false;
	}
	findAllSaleGoodsrecordByid(salerecordid);
	updateSalegoodsrecord();
	delrecord();
});
























