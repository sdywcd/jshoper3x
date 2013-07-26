/*
 * ===========================================Gorgeous
 * split-line==============================================
 */
$(function(){
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
	findJshopbasicInfoTById=function(){
		$.post("findJshopbasicInfoTById.action",function(data){
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
					htm="<img id='"+value+"' src='../.."+pcpath+"'></img>";
					checkpc="<input id='"+value+"' name='pcpath' type='checkbox' value='"+value+"' checked/>";
					allpcpath=htm+checkpc;
					$('#triggers').append(allpcpath);
				});
				return;
			}
		});
	}
});

/*
 * ===========================================Gorgeous
 * split-line==============================================
 */
/**
 * main logic
 */
$(function() {
	var operate = $.query.get("operate");
	if (operate == "find") {
		findJshopbasicInfoTById();
		return;
	}
});
/*===========================================Gorgeous split-line==============================================*/

/**
 * Add Function
 */
$(function(){
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
				window.location.href="basicinfoment.jsp?operate=find&folder=setting";
			}else{
				formwarning("#alerterror","商店基本信息增加失败");
				return false;
			}
		});
	});
});



/*===========================================Gorgeous split-line==============================================*/


/**
 * Update Function
 */
$(function(){
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
				window.location.href="basicinfoment.jsp?operate=find&folder=setting";
			}else{
				formwarning("#alerterror","商店基本信息更新失败");
				return false;
			}
		});
	});
});



