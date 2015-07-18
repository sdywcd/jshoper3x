$(function() {
	/**
	 * 删除sitelogo
	 */
	$("#delpc").click(function(){
		var str="";
		var sum=0;
		$(":checkbox[name='pcpath']").each(function(){
			if($(this).attr("checked")){
				sum++;
				str+=this.id+",";
			}
		});
		if(sum==0){
			alert('只有在选择图片后才能删除');
			return false;
		}
		var array=new Array();
		array=str.split(",");
		$(array).each(function(k,v){
			$("#triggers img").remove("img[id="+v+"]");
			$("#triggers input[name='pcpath']").remove("input[id="+v+"]");
		});  
	});
	/**
	 * 查询当前商店信息
	 */
	findShopById=function(id){
		$.post("findShopById.action",{"basicinfoid":id},function(data){
			if(data.sucflag){
				$("#submit").hide();
				$("#update").show();
				$("#jshopname").attr("value",data.beanlist.jshopname);
				$("#jshopslogan").attr("value",data.beanlist.jshopslogan);
				$("#metaKeywords").attr("value",data.beanlist.metaKeywords);
				$("#metaDes").attr("value",data.beanlist.metaDes);
				$("#country").val(data.beanlist.country);
				$("#province").val(data.beanlist.province);
				$("#city").val(data.beanlist.city);
				$("#district").val(data.beanlist.district);
				$("#street").attr("value",data.beanlist.street);
				$("#qqservice").attr("value",data.beanlist.qqservice);
				$("#skypeservice").attr("value",data.beanlist.skypeservice);
				$("#weixinservice").attr("value",data.beanlist.weixinservice);
				$("#skypeservice").attr("value",data.beanlist.skypeservice);
				$("#sinaweiboservice").attr("value",data.beanlist.sinaweiboservice);
				$("#emailservice").attr("value",data.beanlist.emailservice);
				$("#phoneservice").attr("value",data.beanlist.phoneservice);
				$("#openstate").val(data.beanlist.openstate);
				$("#siteclosenotes").attr("value",data.beanlist.siteclosenotes);
				$("#licensed").val(data.beanlist.licensed);
				$("#icpnum").attr("value",data.beanlist.icpnum);
				$("#state").val(data.beanlist.state);
				$("#hidbasicinfoid").attr("value",data.beanlist.basicinfoid);
				// 图片显示
				var pcpath="";
				var pcurl=data.beanlist.sitelogo;
				var htm="";
				var checkpc="";
				var temp=pcurl.split(',');
				var allpcpath="";
				$.each(temp,function(n,value){
					if(""==value){
						return;
					}
					pcpath=value;
					htm="<img id='"+value+"' src='"+data.basepath+pcpath+"'></img>";
					checkpc="<input id='"+value+"' name='pcpath' type='checkbox' value='"+value+"' checked/>";
					allpcpath=htm+checkpc;
					$('#triggers').append(allpcpath);
				});
				return;
			}
		});
	}
	
	findAllShop=function(qtype,param){
		$("#shopmanagement").flexigrid({
			url : 'findAllShop.action',
			qtype:qtype,
			dataType : 'json',
			cache : false,
			colModel : [ {
				display : '店铺名称',
				name : 'jshopname',
				width : 200,
				sortable : true,
				align : 'center'
			}, {
				display : '关键字',
				name : 'metaKeywords',
				width : 200,
				sortable : true,
				align : 'center'
			}, {
				display : '运营状态',
				name : 'openstate',
				width : 150,
				sortable : true,
				align : 'center'
			}, {
				display : '记录状态',
				name : 'state',
				width : 80,
				sortable : true,
				align : 'center'
			}, {
				display : '创建时间',
				name : 'createtime',
				width : 150,
				sortable : true,
				align : 'center'
			}],
			buttons : [ {
				name : '添加',
				bclass : 'add',
				onpress : action
			}, {
				name : '编辑',
				bclass : 'edit',
				onpress : action
			}, {
				name : '删除',
				bclass : 'del',
				onpress : action
			},{
				name:'绑定店铺掌柜',
				bclass:'edit',
				onpress:action
			},{
				name:'解绑店铺掌柜',
				bclass:'edit',
				onpress:action
			}, {
				separator : true
			} ],

			searchitems : [ {
				display : '请选择搜索条件',
				name : 'sc',
				isdefault : true
			}],
			sortname : "createtime",
			sortorder : "desc",
			usepager : true,
			title : '',
			useRp : true,
			rp : 20,
			rpOptions : [ 5, 20, 40, 100 ],
			showTableToggleBtn : true,
			showToggleBtn : true,
			width : 'auto',
			height : 'auto',
			pagestat : '显示{from}到{to}条，共{total}条记录',
			procmsg : '正在获取数据，请稍候...',
			checkbox : true
		});
		function action(com, grid) {
			if (com == '添加') {
				window.location.href = "basicinfo.jsp?operate=add&folder=shop";
			} else if (com == '编辑') {
				if ($('.trSelected', grid).length == 1) {
					var str = "";
					$('.trSelected', grid).each(function() {
						str = this.id.substr(3);
					});
					window.location.href = "basicinfo.jsp?operate=edit&folder=shop&id="
							+ str;
					return;
				} else {
					formwarning("#alerterror", "请选择一条信息");
					return false;
				}
			} else if (com == '删除') {
				if ($('.trSelected', grid).length > 0) {
					var str = "";
					$('.trSelected', grid).each(function() {
						str += this.id.substr(3) + ",";
					});
					$.post("delJshopbasicInfo.action", {
						"basicinfoid" : str
					}, function(data) {
						if (data.sucflag) {
							$('#shopmanagement').flexReload();
							forminfo("#alertinfo", "删除成功");
						}
					});
				} else {
					formwarning("#alerterror", "请选择要删除的信息");
					return false;
				}
			}else if(com=='绑定店铺掌柜'){
				bindShopAdmin(com,grid);
			}else if(com=='解绑店铺掌柜'){
				unbindShopAdmin(com,grid);
			}
		}
	};
	/**
	 * 解绑商铺掌柜
	 * @param com
	 * @param grid
	 */
	unbindShopAdmin=function(com,grid){
		$("#modaltitle").text(com)
		if ($('.trSelected', grid).length== 0) {
			formwarning("#alerterror", "请选择一条信息");
			return false;
		}
		$("#defaultmodal").modal({
			keyboard:true,
			show:true,
		});
		var basicinfoid="";
		$('.trSelected', grid).each(function() {
			basicinfoid= this.id.substr(3);
		});
		findShopAdmin(basicinfoid);
		$("#defaultsubmit").click(function(){
			$.post("unBindShopAdmin.action",{
				"basicinfoid":basicinfoid
			},function(data){
				if(data.sucflag){
					$("#defaultmodal").modal('hide');
					forminfo("#alertinfo", "解绑掌柜成功，请及时绑定新的掌柜");
				}
			});
		});
		$("#defaultcancel").click(function(){
			$("#defaultmodal").modal('hide');
		});
	},
	/**
	 * 查询店铺掌柜
	 * @param basicinfoid
	 */
	findShopAdmin=function(basicinfoid){
		$.post("findShopAdmin.action",{"basicinfoid":basicinfoid},function(data){
			if(data.sucflag){
				$('#contentp').html(data.userbean.username+"("+data.userbean.realname+")");
			}else{
				$('#contentp').html("暂无可解绑的掌柜");
			}
		})
	}
	/**
	 * 绑定店铺管理员
	 */
	bindShopAdmin=function(com,grid){
		$("#modaltitle").text(com)
		if ($('.trSelected', grid).length== 0) {
			formwarning("#alerterror", "请选择一条信息");
			return false;
		}
		$("#defaultmodal").modal({
			keyboard:true,
			show:true,
		});
		//获取可用店铺管理员数据
		findShopAdminUser();
		$("#defaultsubmit").click(function(){
			var str = "";
			$('.trSelected', grid).each(function() {
				str= this.id.substr(3);
			});
			var userid=$("#adminuser").val();
			$.post("bindShopAdmin.action",{
				"userid":userid,
				"basicinfoid":str
			},function(data){
				if(data.sucflag){
					$("#defaultmodal").modal('hide');
					forminfo("#alertinfo", "绑定掌柜成功");
				}
			});
		});
		$("#defaultcancel").click(function(){
			$("#defaultmodal").modal('hide');
		});
	};
	
	/**
	 * 查询所有可用的店铺管理员
	 */
	findShopAdminUser = function() {
		$.ajax({
			url : "findShopAdminUser.action",
			type : "post",
			dataType : 'json',
			async : false,
			success : function(data) {
				if (data.sucflag) {
					var header="<select id='adminuser' name='adminuser'><option value='0'>--请选择--</option>";
					var footer="</select>";
					var html="";
					$.each(data.user,function(i,v){
						html+="<option value='"+v.userid+"'>"+v.username+"</option>";
					});
					$('#contentp').html(header+html+footer);
				}
			}
		});
	},
	
	/**
	 * 增加商户基本信息
	 */
	$('#submit').click(function(){
		var jshopname=$('#jshopname').val();
		if(jshopname==""){
			formwarning("#alerterror","请填写商店名称");
			return false;
		}
		var jshopslogan=$('#jshopslogan').val();
		if(jshopslogan==""){
			formwarning("#alerterror","请填写商店标语");
			return false;
		}
		var metaKeywords=$('#metaKeywords').val();
		if(metaKeywords==""){
			formwarning("#alerterror","请填写商店关键字");
			return false;
		}
		var metaDes=$('#metaDes').val();
		if(metaDes==""){
			formwarning("#alerterror","请填写商店描述");
			return false;
		}
		var country=$("#country").val();
		if(country==""){
			formwarning("#alerterror","请填写所在国家");
			return false;
		}
		var province=$('#province').val();
		if(province==""){
			formwarning("#alerterror","请填写所在省份");
			return false;
		}
		var city=$('#city').val();
		if(city==""){
			formwarning("#alerterror","请填写所在城市");
			return false;
		}
		var district=$('#district').val();
		if(district==""){
			formwarning("#alerterror","请填写所在区/县");
			return false;
		}
		var street=$('#street').val();
		if(street==""){
			formwarning("#alerterror","请填写详细地址");
			return false;
		}
		var sitelogo="";
		var sum=0;
		$(":checkbox[name='pcpath']").each(function(){
			if($(this).attr("checked")){
				sum++;
				sitelogo=this.value;
			}
		});
		if(sum==0){
			formwarning("#alerterror","请选择一个商店LOGO");
			return false;
		}
		var qqservice=$('#qqservice').val();
		var skypeservice=$("#skypeservice").val();
		var weixinservice=$('#weixinservice').val();
		var sinaweiboservice=$('#sinaweiboservice').val();
		var emailservice=$('#emailservice').val();
		var phoneservice=$('#phoneservice').val();
		var openstate=$('#openstate').val();
		var siteclosenotes=$('#siteclosenotes').val();
		var licensed=$('#licensed').val();
		var icpnum=$('#icpnum').val();
		var state=$('#state').val();
		this.value="提交中";
		this.disabled=true;
		$.post("addJshopbasicInfoT.action",{"jshopname":jshopname,"jshopslogan":jshopslogan,"metaKeywords":metaKeywords,"metaDes":metaDes,"country":country,"province":province,"city":city,"street":street,"qqservice":qqservice,"skypeservice":skypeservice,"weixinservice":weixinservice,"sinaweiboservice":sinaweiboservice,"emailservice":emailservice,"phoneservice":phoneservice,"openstate":openstate,"siteclosenotes":siteclosenotes,"sitelogo":sitelogo,"licensed":licensed,"icpnum":icpnum,"state":state,"district":district},function(data){
			if(data.sucflag){
				window.location.href="shopment.jsp?operate=find&folder=shop";
			}else{
				formwarning("#alerterror","商店基本信息增加失败");
				return false;
			}
		});
	});
	
	$('#update').click(function(){
		var basicinfoid=$('#hidbasicinfoid').val();
		var jshopname=$('#jshopname').val();
		if(jshopname==""){
			formwarning("#alerterror","请填写商店名称");
			return false;
		}
		var jshopslogan=$('#jshopslogan').val();
		if(jshopslogan==""){
			formwarning("#alerterror","请填写商店标语");
			return false;
		}
		var metaKeywords=$('#metaKeywords').val();
		if(metaKeywords==""){
			formwarning("#alerterror","请填写商店关键字");
			return false;
		}
		var metaDes=$('#metaDes').val();
		if(metaDes==""){
			formwarning("#alerterror","请填写商店描述");
			return false;
		}
		var country=$("#country").val();
		if(country==""){
			formwarning("#alerterror","请填写所在国家");
			return false;
		}
		var province=$('#province').val();
		if(province==""){
			formwarning("#alerterror","请填写所在省份");
			return false;
		}
		var city=$('#city').val();
		if(city==""){
			formwarning("#alerterror","请填写所在城市");
			return false;
		}
		var district=$('#district').val();
		if(district==""){
			formwarning("#alerterror","请填写所在区/县");
			return false;
		}
		var street=$('#street').val();
		if(street==""){
			formwarning("#alerterror","请填写详细地址");
			return false;
		}
		var sitelogo="";
		var sum=0;
		$(":checkbox[name='pcpath']").each(function(){
			if($(this).attr("checked")){
				sum++;
				sitelogo=this.value;
			}
		});
		if(sum==0){
			formwarning("#alerterror","请选择一个商店LOGO");
			return false;
		}
		var qqservice=$('#qqservice').val();
		var skypeservice=$("#skypeservice").val();
		var weixinservice=$('#weixinservice').val();
		var sinaweiboservice=$('#sinaweiboservice').val();
		var emailservice=$('#emailservice').val();
		var phoneservice=$('#phoneservice').val();
		var openstate=$('#openstate').val();
		var siteclosenotes=$('#siteclosenotes').val();
		var licensed=$('#licensed').val();
		var icpnum=$('#icpnum').val();
		var state=$('#state').val();
		this.value="更新提交中";
		this.disabled=true;
		$.post("updateJshopbasicInfo.action",{"basicinfoid":basicinfoid,"jshopname":jshopname,"jshopslogan":jshopslogan,"metaKeywords":metaKeywords,"metaDes":metaDes,"country":country,"province":province,"city":city,"street":street,"qqservice":qqservice,"skypeservice":skypeservice,"weixinservice":weixinservice,"sinaweiboservice":sinaweiboservice,"emailservice":emailservice,"phoneservice":phoneservice,"openstate":openstate,"siteclosenotes":siteclosenotes,"sitelogo":sitelogo,"licensed":licensed,"icpnum":icpnum,"state":state,"district":district},function(data){
			if(data.sucflag){
				window.location.href="shopment.jsp?operate=find&folder=shop";
			}else{
				formwarning("#alerterror","商店基本信息更新失败");
				return false;
			}
		});
	});
	/**
	 * main logic
	 */
	var operate = $.query.get("operate");
	if (operate == "add") {
		
	}else if(operate=="edit"){
		var id=$.query.get("id");
		if(id!=""){
			findShopById(id);
		}
		return;
	}else if(operate=="find"){
		findAllShop();
		return;
	}
});

