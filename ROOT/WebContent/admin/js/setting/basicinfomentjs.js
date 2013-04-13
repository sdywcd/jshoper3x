/**
 * Global variables
 */
var session = "true";
var flag=false;
/*
 * ===========================================Gorgeous
 * split-line==============================================
 */
/**
 * ui
 */
$(function(){
	
	$("h6").each(function(){
		$(this).removeClass("selected"); 
	});
	$("ul").each(function(){
		$(this).removeClass("opened"); 
		$(this).addClass("closed"); 
	});
	$("#h-menu-settings").addClass("selected");
	$("#menu-settings").removeClass("closed"); 
	$("#menu-settings").addClass("opened");
});
/*
 * ===========================================Gorgeous
 * split-line==============================================
 */
/**
 * Function
 */
function validatelogo(){
	// 获取商品图片路径集合
	var sitelogo="";
	$(":checkbox[name='pcpath'][checked=true]").each(function(){
		sitelogo+=this.value+",";
	});
	if(""==sitelogo){
		jAlert('商城logo必须选择', '信息提示');
		return false;
	}
	flag=true;
}

/**
 * Required to initialize the page data
 */
//获取图片删除按钮并删除图片
$(function(){
	$("#delpc").click(function(){
		var str="";
		var sum=0;
		$(":checkbox[name='pcpath'][checked=true]").each(function(){
			sum++;
			str=this.value;
		});
		if(sum==0){
			jAlert('只有在选择图片后才能删除', '信息提示');
			return false;
		}
		if(sum>1){
			jAlert('不能选择多个图片', '信息提示');
			return false;
		}
		$('#triggers img').each(function(){
			if(this.id==str){
				this.style.display="none";
				$(":checkbox[name='pcpath'][checked=true]").each(function(){
					if(this.value==str){
						this.style.display="none";
						this.name="dispcpath";
					}
				});
			}
		});  

	});
});

/*
 * ===========================================Gorgeous
 * split-line==============================================
 */
/**
 * flexigrid list
 */
$(function() {
	$("#jshopbasicinfomanagement").flexigrid( {
		url : 'findAllJshopbasicInfo.action',
		dataType : 'json',
		cache : false,
		colModel : [{ 
			display:'商城名称',
			name:'jshopname',
			width:315,
			sortable:true,
			align:'center'
		}, {
			display : '商城关键字',
			name : 'metaKeywords',
			width : 214,
			sortable : true,
			align : 'center'
				
		},{ display:'商城是否运作',
			name:'openstate',
			width:200,
			sortable:true,
			align:'center'
		},{ display:'商城状态',
			name:'state',
			width:200,
			sortable:true,
			align:'center'
		}],
		buttons : [ {
			name : '添加',
			bclass : 'add',
			onpress : action
		}, {
			name : '编辑',
			bclass : 'edit',
			onpress : action
		},{
			separator : true
		} ],

		searchitems : [  {
			display:'请选择搜索条件',
			name:'sc',
			isdefault : true
		},{
			display : '商城名称',
			name : 'jshopname',
			
		} ],
		sortname : "createtime",
		sortorder : "desc",
		usepager : true,
		title : '商城基本信息列表',
		useRp : true,
		rp : 20,
		rpOptions : [ 5, 20, 40, 100 ],
		showTableToggleBtn : true,
		width :'auto',
		height :'auto',
		pagestat : '显示{from}到{to}条，共{total}条记录',
		procmsg : '正在获取数据，请稍候...',
		checkbox:true
	});
	function action(com, grid) {
		if (com == '添加') {
			$("#submit").show();
			$("#modify").hide();
			return;
		}else if(com=='编辑'){
			if ($('.trSelected', grid).length ==1) {
				jConfirm('确定编辑此项吗?', '信息提示', function(r) {
					if (r) {
						var str = "";
						$('.trSelected', grid).each(function() {
							str = this.id.substr(3);
						});
						$.post("findJshopbasicInfoTById.action",{"basicinfoid":str},function(data){
							$("#submit").hide();
							$("#modify").show();
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
							$("#taobaowwservice").attr("value",data.beanlist.taobaowwservice);
							$("#skypeservice").attr("value",data.beanlist.skypeservice);
							$("#yahooservice").attr("value",data.beanlist.yahooservice);
							$("#msnservice").attr("value",data.beanlist.msnservice);
							$("#emailservice").attr("value",data.beanlist.emailservice);
							$("#phoneservice").attr("value",data.beanlist.phoneservice);
							$("#openstate").val(data.beanlist.openstate);
							$("#siteclosenotes").attr("value",data.beanlist.siteclosenotes);
							$("#licensed").val(data.beanlist.licensed);
							$("#usercenternote").attr("value",data.beanlist.usercenternote);
							$("#jshopnotice").attr("value",data.beanlist.jshopnotice);
							$("#registerclose").val(data.beanlist.registerclose);
							$("#icpnum").attr("value",data.beanlist.icpnum);
							$("#sendName").attr("value",data.beanlist.sendName);
							$("#sendCountry").attr("value",data.beanlist.sendCountry);
							$("#sendProvince").attr("value",data.beanlist.sendProvince);
							$("#sendCity").attr("value",data.beanlist.sendCity);
							$("#sendDistrict").attr("value",data.beanlist.sendDistrict);
							$("#sendStreet").attr("value",data.beanlist.sendStreet);
							$("#sendTelno").attr("value",data.beanlist.sendTelno);
							$("#sendMobile").attr("value",data.beanlist.sendMobile);
							$("#sendContactor").attr("value",data.beanlist.sendContactor);
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
						});
					}
				});
				return;
			} else {
				jAlert('请选择要删除的信息!', '信息提示');
				return false;
			}
		}
	}
});
/*===========================================Gorgeous split-line==============================================*/



/**
 * Add Function
 */
$(function(){
	
		$('#submit').click(function(){
			// 增加商城基本信息
			validatelogo();
			if(flag){
			var jshopname=$('#jshopname').val();
			var jshopslogan=$('#jshopslogan').val();
			var metaKeywords=$('#metaKeywords').val();
			var metaDes=$('#metaDes').val();
			var country=$('#country').val();
			var province=$('#province').val();
			var city=$('#city').val();
			var district=$('#district').val();
			var street=$('#street').val();
			var qqservice=$('#qqservice').val();
			var taobaowwservice=$('#taobaowwservice').val();
			var skypeservice=$('#skypeservice').val();
			var yahooservice=$('#yahooservice').val();
			var msnservice=$('#msnservice').val();
			var emailservice=$('#emailservice').val();
			var phoneservice=$('#phoneservice').val();
			var openstate=$('#openstate').val();
			var siteclosenotes=$('#siteclosenotes').val();
			var licensed=$('#licensed').val();
			var usercenternote=$('#usercenternote').val();
			var jshopnotice=$('#jshopnotice').val();
			var registerclose=$('#registerclose').val();
			var icpnum=$('#icpnum').val();
			var sendName=$('#sendName').val();
			var sendCountry=$('#sendCountry').val();
			var sendProvince=$('#sendProvince').val();
			var sendCity=$('#sendCity').val();
			var sendDistrict=$('#sendDistrict').val();
			var sendStreet=$('#sendStreet').val();
			var sendTelno=$('#sendTelno').val();
			var sendMobile=$('#sendMobile').val();
			var sendContactor=$('#sendContactor').val();
			var state=$('#state').val();
			// 获取商品图片路径集合
			var sitelogo="";
			$(":checkbox[name='pcpath'][checked=true]").each(function(){
				sitelogo+=this.value+",";
			});
			$.post("addJshopbasicInfoT.action",{"jshopname":jshopname,"jshopslogan":jshopslogan,"metaKeywords":metaKeywords,"metaDes":metaDes,"country":country,"province":province,"city":city,"street":street,"qqservice":qqservice,"taobaowwservice":taobaowwservice,"skypeservice":skypeservice,"yahooservice":yahooservice,"msnservice":msnservice,"emailservice":emailservice,"phoneservice":phoneservice,"openstate":openstate,"siteclosenotes":siteclosenotes,"sitelogo":sitelogo,"licensed":licensed,"usercenternote":usercenternote,"jshopnotice":jshopnotice,"registerclose":registerclose,"icpnum":icpnum,"sendName":sendName,"sendCountry":sendCountry,"sendProvince":sendProvince,"sendCity":sendCity,"sendDistrict":sendDistrict,"sendStreet":sendStreet,"sendTelno":sendTelno,"sendMobile":sendMobile,"sendContactor":sendContactor,"state":state,"district":district},function(data){
				if(data.sucflag){
					jAlert('增加商城信息成功', '信息提示');
					window.location.href="addjshopbasicinfo.jsp?session="+session+"#settings";
				}
				if(data.sucflag==undefined){
					window.location.href="../error/adminerror.jsp?session="+session+"#settings";
				}
			});
			}
		});
});



/*===========================================Gorgeous split-line==============================================*/


/**
 * Update Function
 */
$(function(){
	
		$('#modify').click(function(){
			validatelogo();
			if(flag){
			var basicinfoid=$('#hidbasicinfoid').val();
			var jshopname=$('#jshopname').val();
			var jshopslogan=$('#jshopslogan').val();
			var metaKeywords=$('#metaKeywords').val();
			var metaDes=$('#metaDes').val();
			var country=$('#country').val();
			var province=$('#province').val();
			var city=$('#city').val();
			var district=$('#district').val();
			var street=$('#street').val();
			var qqservice=$('#qqservice').val();
			var taobaowwservice=$('#taobaowwservice').val();
			var skypeservice=$('#skypeservice').val();
			var yahooservice=$('#yahooservice').val();
			var msnservice=$('#msnservice').val();
			var emailservice=$('#emailservice').val();
			var phoneservice=$('#phoneservice').val();
			var openstate=$('#openstate').val();
			var siteclosenotes=$('#siteclosenotes').val();
			var licensed=$('#licensed').val();
			var usercenternote=$('#usercenternote').val();
			var jshopnotice=$('#jshopnotice').val();
			var registerclose=$('#registerclose').val();
			var icpnum=$('#icpnum').val();
			var sendName=$('#sendName').val();
			var sendCountry=$('#sendCountry').val();
			var sendProvince=$('#sendProvince').val();
			var sendCity=$('#sendCity').val();
			var sendDistrict=$('#sendDistrict').val();
			var sendStreet=$('#sendStreet').val();
			var sendTelno=$('#sendTelno').val();
			var sendMobile=$('#sendMobile').val();
			var sendContactor=$('#sendContactor').val();
			var state=$('#state').val();
			// 获取商品图片路径集合
			var sitelogo="";
			$(":checkbox[name='pcpath'][checked=true]").each(function(){
				sitelogo+=this.value+",";
			});
			$.post("UpdateJshopbasicInfo.action",{"basicinfoid":basicinfoid,"jshopname":jshopname,"jshopslogan":jshopslogan,"metaKeywords":metaKeywords,"metaDes":metaDes,"country":country,"province":province,"city":city,"district":district,"street":street,"qqservice":qqservice,"taobaowwservice":taobaowwservice,"skypeservice":skypeservice,"yahooservice":yahooservice,"msnservice":msnservice,"emailservice":emailservice,"phoneservice":phoneservice,"openstate":openstate,"siteclosenotes":siteclosenotes,"licensed":licensed,"usercenternote":usercenternote,"jshopnotice":jshopnotice,"registerclose":registerclose,"icpnum":icpnum,"sendName":sendName,"sendCountry":sendCountry,"sendProvince":sendProvince,"sendCity":sendCity,"sendDistrict":sendDistrict,"sendStreet":sendStreet,"sendTelno":sendTelno,"sendMobile":sendMobile,"sendContactor":sendContactor,"state":state,"sitelogo":sitelogo},function(data){
				if(data.sucflag){
					$('#jshopbasicinfomanagement').flexReload();
				}
			
			});
			}
		});
});



