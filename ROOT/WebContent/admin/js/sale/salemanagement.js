/**
 * ====================split==========================================================================
 * global variables
 * */
var session = "true";
var flag=false;
/**
 * ====================split==========================================================================
 * 查选所有拍卖商品
 * 
 * */
$(function() {
	findAllSalegoodsT=function(){
	$('#salemanagement').flexigrid({
		url : 'findAllSalegoodsT.action',
		dataType : 'json', 
		cache : false,
		colModel : [{
			display : '拍卖商品名称',
			name : 'salegoodsname',
			width : '100',
			sortable : true,
			align : 'center'
		},{
			display:'商品编号',
				name:'salegoodsnumber',
				width:'90',
				sortable:true,
				align:'center'
		},{
			display:'拍卖商品状态',
			width:'80',
			name:'salegoodsstate',
			sortable:true,
			align:'center'
		},{
			display:'开始时间', 
				name:'begingtime',
				width:'100',
				sortable:true,
				align:'center'
		},
		{
			display:'结束时间',
				name:'endingtime',
				width:'100',
				sortable:true,
				align:'center'
		},{
			display:'拍卖者',
			name:'salepeople',
			width:'80',
			sortable:true,
			align:'center'
		},{
			display:'起拍价',
			name:'salestartingprice',
			width:'80',
			sortable:true,
			align:'center'
		},{
			display:'参拍人数',
			name:'salejoinpeople',
			width:'50',
			sortable:true,
			align:'center'
		},{
			display:'拍卖成交价',
			name:'saleprice',
			width:'50',
			sortable:true,
			align:'center'
			
		},{
			display:'图片路径',
			name:'salegoodspictureurl',
			width:'150',
			sortable:true,
			align:'center'
			
		},{
			display:'商城价',
			name:'marketprice',
			width:'50',
			sortable:true,
			align:'center'
			
		},{
			display:'是否新',
			name:'newornot',
			width:'50',
			sortable:true,
			align:'center'
			
		},{
			display:'最低叫价',
			name:'lowprice',
			width:'50',
			sortable:true,
			align:'center'
			
		},{
			display:'产地',
			name:'PLACE',
			width:'50',
			sortable:true,
			align:'center'
			
		},{
			display:'生产厂商',
			name:'manufacturer',
			width:'50',
			sortable:true,
			align:'center'
			
		},
		],searchitems : [ {
			display : '请选择搜索条件',
			name : 'sc',
			isdefault : true
		}, {
			display : '商品编号',
			name : ''
		} ],
			
		buttons:[{
			
			name : '添加',
			bclass : 'add',
			onpress : action
		}, {
			name:'编辑',
			bclass:'edit',
			onpress:action
		},{
			name : '删除',
			bclass : 'delete',
			onpress : action
		},{
			name : '拍买商品记录',
			bclass : 'add',
			onpress : action
		},{
			separator : true		 
		}],
		sortname:"begingtime",
		sortname:"endingtime",
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
		addoredit(com,grid);
		del(com,grid);
		salerecord(com);
	}
	};
	
	$(function(){
		findAllSalegoodsT();
	});
//======================添加和编辑方法===========================================================================
addoredit=function(com,grid){
	if(com=='添加'){
		window.location.href='addsalegoods.jsp?session='+session+"#goods";
		return;
	}else if(com=='编辑'){
		if($('.trSelected',grid).length==1){
			jConfirm('确定编辑此项吗？','信息提示',function(r){
				if(r){
				var str	=$('.trSelected',grid)[0].id.substr(3);
				window.location.href="editsalegoods.jsp?session="+session+"#goods&salegoodsid="+str;
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
},
//======================删除方法===========================================================================

	del=function(com,grid){
	if(com=='删除'){
		if($('.trSelected',grid).length>0){
			jConfirm('确定删除吗？','信息提示',function(r){
				if(r){
					var str="";
					$('.trSelected', grid).each(function() {
						str += this.id.substr(3) + ",";
					});
					$.post("deletesalegoodsT.action",{"salegoodsid":str},function(data){
						if(data.flag){
							jAlert('删除成功','信息提示');
							$('#salemanagement').flexReload();
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
	},
//======================拍卖记录===========================================================================
	salerecord=function(com){
	if(com=='拍买商品记录'){
			window.location.href='salegoodsrecord.jsp?session='+session+"#goods";
			return;
		}
	};
});
/**
 * ====================split==========================================================================
 * salegoods校验数据
 * 
 * */
validatesalegoods=function(){
	var salegoodsname=$('#salegoodsname').val();
	if(""==salegoodsname){
		jAlert('拍卖商品名称不能为空','信息提示');
		return false;
	}
	var salegoodsnumber=$('#salegoodsnumber').val();
	if(""==salegoodsnumber){
		jAlert('拍卖商品编号不能为空','信息提示');
		return false;
	}
	var begingtime=$('#begingtime').val();
	if(""==begingtime){
		jAlert('开始时间不能为空','信息提示');
		return false;
	}
	var endingtime=$('#endingtime').val();
	if(""==endingtime){
		jAlert('结束时间不能为空','信息提示');
		return false;
	}
	var salepeople=$('#salepeople').val();
	if(""==salepeople){
		jAlert('拍卖者或管理员不能为空','信息提示');
		return false;
	}
	var salejoinpeople=$('#salejoinpeople').val();
	if(""==salejoinpeople){
		jAlert('参加拍卖设置最大人数不能为空','信息提示');
		return false;
	}
	var salestartingprice=$('#salestartingprice').val();
	if(""==salestartingprice){
		jAlert('起拍价不能为空','信息提示');
		return false;
	}
	var marketprice=$('#marketprice').val();
	if(""==marketprice){
		jAlert('商场价不能为空','信息提示');
		return false;
	}
	var manufacturer=$('#manufacturer').val();
	if(""==manufacturer){
		jAlert('生产厂商不能为空','信息提示');
		return false;
	}
	var place=$('#place').val();
	if(""==place){
		jAlert('生产地不能为空','信息提示');
		return false;
	}
	var salegoodsinformation=$('#salegoodsinformation').val();
	if(""==salegoodsinformation){
		jAlert('商品详细信息不能为空','信息提示');
		return false;
	}
	var lowprice=$('#lowprice').val();
	if(""==lowprice){
		jAlert('最低叫价不能为空','信息提示');
		return false;
	}
	var salegoodsmessage=$('#salegoodsmessage').val();
	if(""==salegoodsmessage){
		jAlert('请输入商品简介','信息提示');
		return false;
	}
	var salegoodsstate= $("input[name='salegoodsstate']:checked").val();
	if(1==salegoodsstate){
		jAlert('拍卖状态开启','信息提示');
		
	}else{
		jAlert('拍卖状态关闭','信息提示');
	}
	return flag = true;
};
/**
 * ===============================split====================================================================
 *salegoods
 * */
$(function(){
//=======================添加数据==========================================================================
	addSalegoodsT=function(){
		$('#add').click(function(){
			validatesalegoods();
			$('#add').show();
			$('#update').hide();
			if(flag){
				var salegoodsname=$('#salegoodsname').val();
				var salegoodsnumber=$('#salegoodsnumber').val();		
				var salegoodsstate= $("input[name='salegoodsstate']:checked").val();
				var begingtime=$('#begingtime').val();	
				var endingtime=$('#endingtime').val();
				var salepeople=$('#salepeople').val();
				var salejoinpeople=$('#salejoinpeople').val();
				var salestartingprice=$('#salestartingprice').val();
				var salegoodsinformation=$('#salegoodsinformation').val();
				var marketprice=$('#marketprice').val();
				var newornot=$("input[name='newornot']:checked").val();
				var lowprice=$('#lowprice').val();
				var place=$('#place').val();
				var manufacturer=$('#manufacturer').val();
				var salegoodsmessage=$('#salegoodsmessage').val();
				var salegoodspictureurl="";
				$(":checkbox[name='pcpath'][checked=true]").each(function(){
					salegoodspictureurl=this.value;
			});
			$.post("addSalegoodsT.action",{"salegoodsname":salegoodsname,"salegoodsnumber":salegoodsnumber,"salegoodspictureurl":salegoodspictureurl,"salegoodsinformation":salegoodsinformation,"salegoodsstate":salegoodsstate,"begingtime":begingtime,"endingtime":endingtime,"salepeople":salepeople,"salestartingprice":salestartingprice,"salejoinpeople":salejoinpeople,"marketprice":marketprice,"newornot":newornot,"salegoodsmessage":salegoodsmessage,"lowprice":lowprice,"manufacturer":manufacturer,"place":place},function(data){
				if(data.salegoods){
					jAlert('添加成功','信息提示');
					window.location.href='salemanagement.jsp?session'+session+"#goods";
				}else{
					jAlert('添加失败','信息提示');
					return false;
				}
			});
			}else{ return false;}
		});
	};
	
//=================根据ID查询所有数据========================================================================	
	findAllSalegoodsById=function(salegoodsid){
		
		$.post("findAllSalegoodsById.action",{"salegoodsid":salegoodsid},function(data){
			$('#salegoodsname').attr("value",data.salelist.salegoodsname);
			$('#salegoodsnumber').attr("value",data.salelist.salegoodsnumber);
			if("1"==data.salelist.salegoodsstate){
				$('#salegoodsstate').attr("checked","checked");
			}else{
				$('#salegoodsstate').attr("checked","");
			}
		//	$('#salegoodsstate').attr("value",data.salelist.salegoodsstate);
			$('#begingtime').attr("value",data.salelist.begingtime);
			$('#endingtime').attr("value",data.salelist.endingtime);
			$('#salejoinpeople').attr("value",data.salelist.salejoinpeople);
			$('#salestartingprice').attr("value",data.salelist.salestartingprice);
			$('#salepeople').attr("value",data.salelist.salepeople);
			$('#marketprice').attr("value",data.salelist.marketprice);
			if("1"==data.salelist.newornot){
				$('#newornot').attr("checked","checked");
			}else{
				$('#newornot').attr("checked","");
			}
			$('#salegoodsmessage').attr("value",data.salelist.salegoodsmessage);
			$('#lowprice').attr("value",data.salelist.lowprice);
			$('#manufacturer').attr("value",data.salelist.manufacturer);
			$('#place').attr("value",data.salelist.place);
			KE.html("salegoodsinformation",data.salelist.salegoodsinformation);
		  //$('#salegoodspictureurl').attr("value",data.salelist.salelistsalelist);
			
			//图片显示		
			var pcurl=data.salelist.salegoodspictureurl;
			$('#triggers').html("<img src='"+pcurl+"'/>");
			$('#update').show();
		
			return;			
		});
	};
//====================更新数据=============================================================================	
	updatesalegoodsT=function(){
		$('#update').click(function(){
			validatesalegoods();
			/*$('#update').show();
			$('#add').hide();*/
				if(flag){
					var salegoodsid=$.query.get('salegoodsid');
					var salegoodsname=$('#salegoodsname').val();
					var salegoodsnumber=$('#salegoodsnumber').val();		
					var salegoodsstate= $("input[name='salegoodsstate']:checked").val();
					var begingtime=$('#begingtime').val();	
					var endingtime=$('#endingtime').val();
					var salepeople=$('#salepeople').val();
					var salejoinpeople=$('#salejoinpeople').val();
					var salestartingprice=$('#salestartingprice').val();
					var salegoodsinformation=$('#salegoodsinformation').val();
					/*KE.html("salegoodsinformation",data.salelist.salegoodsinformation);*/
					var marketprice=$('#marketprice').val();
					var newornot=$("input[name='newornot']:checked").val();
					
					var lowprice=$('#lowprice').val();
					var place=$('#place').val();
					var manufacturer=$('#manufacturer').val();
					var salegoodsmessage=$('#salegoodsmessage').val();
				
					var salegoodspictureurl="";
					$(":checkbox[name='pcpath'][checked=true]").each(function(){
						salegoodspictureurl=this.value;
				});
					$.post("updatesalegoodsT.action",{"salegoodsid":salegoodsid,"salegoodsname":salegoodsname,"salegoodsnumber":salegoodsnumber,"salegoodspictureurl":salegoodspictureurl,"salegoodsinformation":salegoodsinformation,"salegoodsstate":salegoodsstate,"begingtime":begingtime,"endingtime":endingtime,"salepeople":salepeople,"salestartingprice":salestartingprice,"salejoinpeople":salejoinpeople,"marketprice":marketprice,"newornot":newornot,"salegoodsmessage":salegoodsmessage,"lowprice":lowprice,"manufacturer":manufacturer,"place":place},function(data){
						if(data.salegoods){
							jAlert('修改成功','信息提示');
							window.location.href='salemanagement.jsp?session'+session+"#goods";
						}else{
							jAlert('修改失败','信息提示');
							return false;
						}
					});
					}else{ return false;}
				});
	};
//============================delete=====================================================================
	delsalegoods=function(){
		$("#delpc").click(function() {
			var str = "";
			var sum = 0;
			$(":checkbox[name='pcpath'][checked=true]").each(function() {
				sum++;
				str = this.id;
			});
			if (sum == 0) {
				jAlert('只有在选择图片后才能删除','信息提示');
				return false;
			}
			if (sum > 1) {
				jAlert('不能选择多个图片','信息提示');
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
	var salegoodsid=$.query.get('salegoodsid');
	if(salegoodsid==null){
		return false;		
	}
	addSalegoodsT();
	findAllSalegoodsById(salegoodsid);
	updatesalegoodsT();
	delsalegoods();
	
});
/**$(function(){
	var sd=new Date("2012-9-9".replace("-","/"));
	var ed=new Date("2012-9-9".replace("-","/"));

	for(var i=1;i>0;i++){
	$.post("http://192.168.1.116:8888/addTblproject.action",{"pjName":+i*10,"pjItem1":"sdf","pjItem2":"sdfdsf","pjItem3":"dfdsf","pjItem4":"sdsdd","pjItemWeight1":20.1,"pjItemWeight2":20.21,"pjItemWeight3":52.3,"pjItemWeight4":5215.3,"minItemScore":0,"maxItemScore":5,"startDate":sd,"endDate":ed})
}
})*/

