$(function(){
	/**
	 * 读取所有全局参数设置
	 */
	findAllGlobalParam=function(){
		$.post("findAllGlobalParam.action",function(data){
			if(data.beanlist!=null){
				$.each(data.beanlist,function(k,v){ 
					if(v.gkey=="language"){
						if($("input[name='language']").length>0){
							if(v.gvalue=="1"){
								$("input[name='language']").get(0).checked=true;
							}else{
								$("input[name='language']").get(1).checked=true;
							}
						}
					}else if(v.gkey=="isstockment"){
						if($("input[name='isstockment']").length>0){
							if(v.gvalue=="1"){
								$("input[name='isstockment']").get(0).checked=true;
							}else{
								$("input[name='isstockment']").get(1).checked=true;
							}
						}
					}else if(v.gkey=="ispurchaseplan"){
						if($("input[name='ispurchaseplan']").length>0){
							if(v.gvalue=="1"){
								$("input[name='ispurchaseplan']").get(0).checked=true;
							}else{
								$("input[name='ispurchaseplan']").get(1).checked=true;
							}
						}
					}else if(v.gkey=="isfinancement"){
						if($("input[name='isfinancement']").length>0){
							if(v.gvalue=="1"){
								$("input[name='isfinancement']").get(0).checked=true;
							}else{
								$("input[name='isfinancement']").get(1).checked=true;
							}
						}
					}else if(v.gkey=="isworkflowengine"){
						if($("input[name='isworkflowengine']").length>0){
							if(v.gvalue=="1"){
								$("input[name='isworkflowengine']").get(0).checked=true;
							}else{
								$("input[name='isworkflowengine']").get(1).checked=true;
							}
						}
					}else if(v.gkey=="istaskschedule"){
						if($("input[name='istaskschedule']").length>0){
							if(v.gvalue=="1"){
								$("input[name='istaskschedule']").get(0).checked=true;
							}else{
								$("input[name='istaskschedule']").get(1).checked=true;
							}
						}
					}else if(v.gkey=="isvisitcount"){
						if($("input[name='isvisitcount']").length>0){
							if(v.gvalue=="1"){
								$("input[name='isvisitcount']").get(0).checked=true;
							}else{
								$("input[name='isvisitcount']").get(1).checked=true;
							}
						}
					}else if(v.gkey=="isusercanregister"){
						if($("input[name='isusercanregister']").length>0){
							if(v.gvalue=="1"){
								$("input[name='isusercanregister']").get(0).checked=true;
							}else{
								$("input[name='isusercanregister']").get(1).checked=true;
							}
						}
					}else if(v.gkey=="issendactivatemail"){
						if($("input[name='issendactivatemail']").length>0){
							if(v.gvalue=="1"){
								$("input[name='issendactivatemail']").get(0).checked=true;
							}else{
								$("input[name='issendactivatemail']").get(1).checked=true;
							}
						}
					}else if(v.gkey=="isqueuemail"){
						if($("input[name='isqueuemail']").length>0){
							if(v.gvalue=="1"){
								$("input[name='isqueuemail']").get(0).checked=true;
							}else{
								$("input[name='isqueuemail']").get(1).checked=true;
							}
						}
					}else if(v.gkey=="isshoppinghelp"){
						if($("input[name='isshoppinghelp']").length>0){
							if(v.gvalue=="1"){
								$("input[name='isshoppinghelp']").get(0).checked=true;
							}else{
								$("input[name='isshoppinghelp']").get(1).checked=true;
							}
						}
					}else if(v.gkey=="iswebsitehelp"){
						if($("input[name='iswebsitehelp']").length>0){
							if(v.gvalue=="1"){
								$("input[name='iswebsitehelp']").get(0).checked=true;
							}else{
								$("input[name='iswebsitehelp']").get(1).checked=true;
							}
						}
					}else if(v.gkey=="islog"){
						if($("input[name='islog']").length>0){
							if(v.gvalue=="1"){
								$("input[name='islog']").get(0).checked=true;
							}else{
								$("input[name='islog']").get(1).checked=true;
							}
						}
					}else if(v.gkey=="isauthoritycontrol"){
						if($("input[name='isauthoritycontrol']").length>0){
							if(v.gvalue=="1"){
								$("input[name='isauthoritycontrol']").get(0).checked=true;
							}else{
								$("input[name='isauthoritycontrol']").get(1).checked=true;
							}
						}
					}else if(v.gkey=="iscommentmoderation"){
						if($("input[name='iscommentmoderation']").length>0){
							if(v.gvalue=="1"){
								$("input[name='iscommentmoderation']").get(0).checked=true;
							}else{
								$("input[name='iscommentmoderation']").get(1).checked=true;
							}
						}
					}else if(v.gkey=="commenttarget"){
						if($("input[name='commenttarget']").length>0){
							if(v.gvalue=="1"){
								$("input[name='commenttarget']").get(0).checked=true;
							}else if(v.gvalue=="2"){
								$("input[name='commenttarget']").get(1).checked=true;
							}else if(v.gvalue=="3"){
								$("input[name='commenttarget']").get(2).checked=true;
							}else if(v.gvalue=="4"){
								$("input[name='commenttarget']").get(3).checked=true;
							}else{
								$("input[name='commenttarget']").get(4).checked=true;
							}
						}
						
					}else if(v.gkey=="isautosharecomment"){
						if($("input[name='isautosharecomment']").length>0){
							if(v.gvalue=="1"){
								$("input[name='isautosharecomment']").get(0).checked=true;
							}else{
								$("input[name='isautosharecomment']").get(1).checked=true;
							}
						}
					}else if(v.gkey=="isinvoice"){
						if($("input[name='isinvoice']").length>0){
							if(v.gvalue=="1"){
								$("input[name='isinvoice']").get(0).checked=true;
							}else{
								$("input[name='isinvoice']").get(1).checked=true;
							}
						}
					}else if(v.gkey=="isusepoint"){
						if($("input[name='isusepoint']").length>0){
							if(v.gvalue=="1"){
								$("input[name='isusepoint']").get(0).checked=true;
							}else{
								$("input[name='isusepoint']").get(1).checked=true;
							}
						}
					}else if(v.gkey=="isdiscountcoupon"){
						if($("input[name='isdiscountcoupon']").length>0){
							if(v.gvalue=="1"){
								$("input[name='isdiscountcoupon']").get(0).checked=true;
							}else{
								$("input[name='isdiscountcoupon']").get(1).checked=true;
							}
						}
					}else if(v.gkey=="isstockoutprocess"){
						if($("input[name='isstockoutprocess']").length>0){
							if(v.gvalue=="1"){
								$("input[name='isstockoutprocess']").get(0).checked=true;
							}else{
								$("input[name='isstockoutprocess']").get(1).checked=true;
							}
						}
					}else if(v.gkey=="isconfirmtomail"){
						if($("input[name='isconfirmtomail']").length>0){
							if(v.gvalue=="1"){
								$("input[name='isconfirmtomail']").get(0).checked=true;
							}else{
								$("input[name='isconfirmtomail']").get(1).checked=true;
							}
						}
					}else if(v.gkey=="ispaymail"){
						if($("input[name='ispaymail']").length>0){
							if(v.gvalue=="1"){
								$("input[name='ispaymail']").get(0).checked=true;
							}else{
								$("input[name='ispaymail']").get(1).checked=true;
							}
						}
					}else if(v.gkey=="isdelivergoodsmail"){
						if($("input[name='isdelivergoodsmail']").length>0){
							if(v.gvalue=="1"){
								$("input[name='isdelivergoodsmail']").get(0).checked=true;
							}else{
								$("input[name='isdelivergoodsmail']").get(1).checked=true;
							}
						}
					}else if(v.gkey=="iscancelordermail"){
						if($("input[name='iscancelordermail']").length>0){
							if(v.gvalue=="1"){
								$("input[name='iscancelordermail']").get(0).checked=true;
							}else{
								$("input[name='iscancelordermail']").get(1).checked=true;
							}
						}
					}else if(v.gkey=="isnoticeservice"){
						if($("input[name='isnoticeservice']").length>0){
							if(v.gvalue=="1"){
								$("input[name='isnoticeservice']").get(0).checked=true;
							}else{
								$("input[name='isnoticeservice']").get(1).checked=true;
							}
						}
					}else if(v.gkey=="isnoticeneworder"){
						if($("input[name='isnoticeneworder']").length>0){
							if(v.gvalue=="1"){
								$("input[name='isnoticeneworder']").get(0).checked=true;
							}else{
								$("input[name='isnoticeneworder']").get(1).checked=true;
							}
						}
					}else if(v.gkey=="iscashondelivery"){
						if($("input[name='iscashondelivery']").length>0){
							if(v.gvalue=="1"){
								$("input[name='iscashondelivery']").get(0).checked=true;
							}else{
								$("input[name='iscashondelivery']").get(1).checked=true;
							}
						}
					}else if(v.gkey=="freeshoppinglines"){
						$("#freeshoppinglines").attr("value",v.gvalue);
					}else if(v.gkey=="salemobile"){
						$("#salemobile").attr("value",v.gvalue);
					}else if(v.gkey=="isordermsg"){
						if($("input[name='isordermsg']").length>0){
							if(v.gvalue=="1"){
								$("input[name='isordermsg']").get(0).checked=true;
							}else{
								$("input[name='isordermsg']").get(1).checked=true;
							}
						}
					}else if(v.gkey=="ispaymsg"){
						if($("input[name='ispaymsg']").length>0){
							if(v.gvalue=="1"){
								$("input[name='ispaymsg']").get(0).checked=true;
							}else{
								$("input[name='ispaymsg']").get(1).checked=true;
							}
						}
					}else if(v.gkey=="isdelivermsg"){
						if($("input[name='isdelivermsg']").length>0){
							if(v.gvalue=="1"){
								$("input[name='isdelivermsg']").get(0).checked=true;
							}else{
								$("input[name='isdelivermsg']").get(1).checked=true;
							}
						}
					}else if(v.gkey=="issyncmobileplatform"){
						if($("input[name='issyncmobileplatform']").length>0){
							if(v.gvalue=="1"){
								$("input[name='issyncmobileplatform']").get(0).checked=true;
							}else{
								$("input[name='issyncmobileplatform']").get(1).checked=true;
							}
						}
					}else if(v.gkey=="issyncgoodsdata"){
						if($("input[name='issyncgoodsdata']").length>0){
							if(v.gvalue=="1"){
								$("input[name='issyncgoodsdata']").get(0).checked=true;
							}else{
								$("input[name='issyncgoodsdata']").get(1).checked=true;
							}
						}
					}else if(v.gkey=="issynccontentdata"){
						if($("input[name='issynccontentdata']").length>0){
							if(v.gvalue=="1"){
								$("input[name='issynccontentdata']").get(0).checked=true;
							}else{
								$("input[name='issynccontentdata']").get(1).checked=true;
							}
						}
					}else if(v.gkey=="issynccartdata"){
						if($("input[name='issynccartdata']").length>0){
							if(v.gvalue=="1"){
								$("input[name='issynccartdata']").get(0).checked=true;
							}else{
								$("input[name='issynccartdata']").get(1).checked=true;
							}
						}
					}else if(v.gkey=="issyncorderdata"){
						if($("input[name='issyncorderdata']").length>0){
							if(v.gvalue=="1"){
								$("input[name='issyncorderdata']").get(0).checked=true;
							}else{
								$("input[name='issyncorderdata']").get(1).checked=true;
							}
						}
					}else if(v.gkey=="freepoint"){
						$("#freepoint").attr("value",v.gvalue);
					}else if(v.gkey=="stockreduce"){
						if($("input[name='stockreduce']").length>0){
							if(v.gvalue=="1"){
								$("input[name='stockreduce']").get(0).checked=true;
							}else if(v.gkey=="2"){
								$("input[name='stockreduce']").get(1).checked=true;
							}else{
								$("input[name='stockreduce']").get(2).checked=true;
							}
						}
					}else if(v.gkey=="defaultstock"){
						$("#defaultstock").attr("value",v.gvalue);
					}else if(v.gkey=="inventorywarning"){
						$("#inventorywarning").attr("value",v.gvalue);
					}else if(v.gkey=="watermarkfile"){
						$("#showwatermarkfileimg").attr("src","../.."+v.gvalue);//注入的值的id域有些不同
					}else if(v.gkey=="watermarkclarity"){
						$("#watermarkclarity").attr("value",v.gvalue);
					}else if(v.gkey=="issaveoriginalbitmap"){
						if($("input[name='issaveoriginalbitmap']").length>0){
							if(v.gvalue=="1"){
								$("input[name='issaveoriginalbitmap']").get(0).checked=true;
							}else{
								$("input[name='issaveoriginalbitmap']").get(1).checked=true;
							}
						}
					}else if(v.gkey=="issaveimgtocloud"){
						if($("input[name='issaveimgtocloud']").length>0){
							if(v.gvalue=="1"){
								$("input[name='issaveimgtocloud']").get(0).checked=true;
							}else{
								$("input[name='issaveimgtocloud']").get(1).checked=true;
							}
						}
					}else if(v.gkey=="thumbnailwidth"){
						$("#thumbnailwidth").attr("value",v.gvalue);
					}else if(v.gkey=="thumbnailheight"){
						$("#thumbnailheight").attr("value",v.gvalue);
					}else if(v.gkey=="defaultwidth"){
						$("#defaultwidth").attr("value",v.gvalue);
					}else if(v.gkey=="defaultheight"){
						$("#defaultheight").attr("value",v.gvalue);
					}else if(v.gkey=="isimagecompression"){
						if($("input[name='isimagecompression']").length>0){
							if(v.gvalue=="1"){
								$("input[name='isimagecompression']").get(0).checked=true;
							}else{
								$("input[name='isimagecompression']").get(1).checked=true;
							}
						}
					}else if(v.gkey=="pointrename"){
						$("#pointrename").attr("value",v.gvalue);
					}else if(v.gkey=="integralconversionration"){
						$("#integralconversionration").attr("value",v.gvalue);
					}else if(v.gkey=="proportionintegralpayment"){
						$("#proportionintegralpayment").attr("value",v.gvalue);
					}else if(v.gkey=="isvirtualitemsupport"){
						if($("input[name='isvirtualitemsupport']").length>0){
							if(v.gvalue=="1"){
								$("input[name='isvirtualitemsupport']").get(0).checked=true;
							}else{
								$("input[name='isvirtualitemsupport']").get(1).checked=true;
							}
						}
					}else if(v.gkey=="isspecificationsupport"){
						if($("input[name='isspecificationsupport']").length>0){
							if(v.gvalue=="1"){
								$("input[name='isspecificationsupport']").get(0).checked=true;
							}else{
								$("input[name='isspecificationsupport']").get(1).checked=true;
							}
						}
					}else if(v.gkey=="goodscommentcondition"){
						if($("input[name='goodscommentcondition']").length>0){
							if(v.gvalue=="1"){
								$("input[name='goodscommentcondition']").get(0).checked=true;
							}else if(v.gvalue=="2"){
								$("input[name='goodscommentcondition']").get(1).checked=true;
							}else{
								$("input[name='goodscommentcondition']").get(2).checked=true;
							}
						}
					}else if(v.gkey=="isintelligentproductnamed"){
						if($("input[name='isintelligentproductnamed']").length>0){
							if(v.gvalue=="1"){
								$("input[name='isintelligentproductnamed']").get(0).checked=true;
							}else{
								$("input[name='isintelligentproductnamed']").get(1).checked=true;
							}
						}
					}else if(v.gkey=="associateattributecount"){
						$("#associateattributecount").attr("value",v.gvalue);
					}else if(v.gkey=="icp"){
						$("#icp").attr("value",v.gvalue);
					}
			    }); 
			}
		});
	},
	/**
	 * 上传水印图片
	 */
	uploadwatermarkfile=function(formfileid,fileType,sourceType){
		$.ajaxFileUpload
		({
				url:"../tools/ajaxfileupload/fileuploads.jsp?formfileid="+formfileid+"&fileType="+fileType+"&sourceType="+sourceType+"&dir=source",
				secureuri:true,
				fileElementId:formfileid,
				dataType: 'json',
				success: function (data)
				{
					if(data.fileSrc!=""){
						//显示图片绝对路径
						$("#showwatermarkfileimg").attr("src",data.fileSrc);
						 //注入删除使用的图片url，相对路径
						$("#watermarkfileimg").attr("value",data.filesavehref);
						return true;
					}
					return false;
					
				},
			});	
	};
	
/**
 * main logic
 */
	var operate=$.query.get("operate");
	if(operate=="find"){
		findAllGlobalParam();
	}
	
	/**
	 * 点击上传水印图片
	 */
	
	
	/**
	 * 更新基础相关设置
	 */
	$("#basicupdate").click(function(data){
		var language=$("input[name='language']:checked").val();
		var isstockment=$("input[name='isstockment']:checked").val();
		var ispurchaseplan=$("input[name='ispurchaseplan']:checked").val();
		var isfinancement=$("input[name='isfinancement']:checked").val();
		var isworkflowengine=$("input[name='isworkflowengine']:checked").val();
		var istaskschedule=$("input[name='istaskschedule']:checked").val();
		var isvisitcount=$("input[name='isvisitcount']:checked").val();
		var isusercanregister=$("input[name='isusercanregister']:checked").val();
		var issendactivatemail=$("input[name='issendactivatemail']:checked").val();
		var isqueuemail=$("input[name='isqueuemail']:checked").val();
		var isshoppinghelp=$("input[name='isshoppinghelp']:checked").val();
		var iswebsitehelp=$("input[name='iswebsitehelp']:checked").val();
		var islog=$("input[name='islog']:checked").val();
		var isauthoritycontrol=$("input[name='isauthoritycontrol']:checked").val();
		this.value="更新提交中";
		this.disabled=true;
		$.post("updateGolbalParambygkey.action",{
			"language":language,
			"isstockment":isstockment,
			"ispurchaseplan":ispurchaseplan,
			"isfinancement":isfinancement,
			"isworkflowengine":isworkflowengine,
			"istaskschedule":istaskschedule,
			"isvisitcount":isvisitcount,
			"isusercanregister":isusercanregister,
			"issendactivatemail":issendactivatemail,
			"isqueuemail":isqueuemail,
			"isshoppinghelp":isshoppinghelp,
			"iswebsitehelp":iswebsitehelp,
			"islog":islog,
			"isauthoritycontrol":isauthoritycontrol
		},function(data){
			if(data.sucflag){
				$("#basicupdate").attr("value","更新");
				$("#basicupdate").attr("disabled",false);
				forminfo("#alertinfo","更新基础相关设置成功");
				return;
			}else{
				formwarning("#alerterror","更新基础相关设置失败");
				return;
			}
		});
	});
	
	
	/**
	 * 更新内容相关设置
	 */
	$("#contentupdate").click(function(data){
		var iscommentmoderation=$("input[name='iscommentmoderation']:checked").val();
		var commenttarget=$("input[name='commenttarget']:checked").val();
		var isautosharecomment=$("input[name='isautosharecomment']:checked").val();
		this.value="更新提交中";
		this.disabled=true;
		$.post("updateGolbalParambygkey.action",{
			"iscommentmoderation":iscommentmoderation,
			"commenttarget":commenttarget,
			"isautosharecomment":isautosharecomment
		},function(data){
			if(data.sucflag){
				$("#contentupdate").attr("value","更新");
				$("#contentupdate").attr("disabled",false);
				forminfo("#alertinfo","更新内容相关设置成功");
				return;
			}else{
				formwarning("#alerterror","更新内容相关设置失败");
				return;
			}
		});
	});
	
	
	/**
	 * 更新订单相关设置
	 */
	$("#orderupdate").click(function(data){
		var isinvoice=$("input[name='isinvoice']:checked").val();
		var isusepoint=$("input[name='isusepoint']:checked").val();
		var isdiscountcoupon=$("input[name='isdiscountcoupon']:checked").val();
		var isstockoutprocess=$("input[name='isstockoutprocess']:checked").val();
		var isconfirmtomail=$("input[name='isconfirmtomail']:checked").val();
		var ispaymail=$("input[name='ispaymail']:checked").val();
		var isdelivergoodsmail=$("input[name='isdelivergoodsmail']:checked").val();
		var iscancelordermail=$("input[name='iscancelordermail']:checked").val();
		var isnoticeservice=$("input[name='isnoticeservice']:checked").val();
		var isnoticeneworder=$("input[name='isnoticeneworder']:checked").val();
		var iscashondelivery=$("input[name='iscashondelivery']:checked").val();
		var freeshoppinglines=$("#freeshoppinglines").val();
		this.value="更新提交中";
		this.disabled=true;
		$.post("updateGolbalParambygkey.action",{
			"isinvoice":isinvoice,
			"isusepoint":isusepoint,
			"isdiscountcoupon":isdiscountcoupon,
			"isstockoutprocess":isstockoutprocess,
			"isconfirmtomail":isconfirmtomail,
			"ispaymail":ispaymail,
			"isdelivergoodsmail":isdelivergoodsmail,
			"iscancelordermail":iscancelordermail,
			"isnoticeservice":isnoticeservice,
			"isnoticeneworder":isnoticeneworder,
			"iscashondelivery":iscashondelivery,
			"freeshoppinglines":freeshoppinglines
		},function(data){
			if(data.sucflag){
				$("#orderupdate").attr("value","更新");
				$("#orderupdate").attr("disabled",false);
				forminfo("#alertinfo","更新订单相关设置成功");
				return;
			}else{
				formwarning("#alerterror","更新订单相关设置失败");
				return;
			}
		});
	});
	
	/**
	 * 更新短信相关设置
	 */
	$("#msgupdate").click(function(data){
		var salemobile=$("#salemobile").val();
		var isordermsg=$("input[name='isordermsg']:checked").val();
		var ispaymsg=$("input[name='ispaymsg']:checked").val();
		var isdelivermsg=$("input[name='isdelivermsg']:checked").val();
		this.value="更新提交中";
		this.disabled=true;
		$.post("updateGolbalParambygkey.action",{
			"salemobile":salemobile,
			"isordermsg":isordermsg,
			"ispaymsg":ispaymsg,
			"isdelivermsg":isdelivermsg
		},function(data){
			if(data.sucflag){
				$("#msgupdate").attr("value","更新");
				$("#msgupdate").attr("disabled",false);
				forminfo("#alertinfo","更新短信相关设置成功");
				return;
			}else{
				formwarning("#alerterror","更新短信相关设置失败");
				return;
			}
		});
	});
	
	/**
	 *  更新移动平台相关设置
	 */
	$("#mobileupdate").click(function(data){
		var issyncmobileplatform=$("input[name='issyncmobileplatform']:checked").val();
		var issyncgoodsdata=$("input[name='issyncgoodsdata']:checked").val();
		var issynccontentdata=$("input[name='issynccontentdata']:checked").val();
		var issynccartdata=$("input[name='issynccartdata']:checked").val();
		var issyncorderdata=$("input[name='issyncorderdata']:checked").val();
		this.value="更新提交中";
		this.disabled=true;
		$.post("updateGolbalParambygkey.action",{
			"issyncmobileplatform":issyncmobileplatform,
			"issyncgoodsdata":issyncgoodsdata,
			"issynccontentdata":issynccontentdata,
			"issynccartdata":issynccartdata,
			"issyncorderdata":issyncorderdata
		},function(data){
			if(data.sucflag){
				$("#mobileupdate").attr("value","更新");
				$("#mobileupdate").attr("disabled",false);
				forminfo("#alertinfo","更新移动平台相关设置成功");
				return;
			}else{
				formwarning("#alerterror","更新移动平台相关设置失败");
				return;
			}
		});
	});
	
	/**
	 * 更新会员相关设置
	 */
	$("#memberupdate").click(function(data){
		var freepoint=$("#freepoint").val();
		this.value="更新提交中";
		this.disabled=true;
		$.post("updateGolbalParambygkey.action",{
			"freepoint":freepoint
		},function(data){
			if(data.sucflag){
				$("#memberupdate").attr("value","更新");
				$("#memberupdate").attr("disabled",false);
				forminfo("#alertinfo","更新会员相关设置成功");
				return;
			}else{
				formwarning("#alerterror","更新会员相关设置失败");
				return;
			}
		});
	});
	
	/**
	 * 更新库存相关设置
	 */
	$("#stockupdate").click(function(data){
		var stockreduce=$("input[name='stockreduce']:checked").val();
		var defaultstock=$("#defaultstock").val();
		var inventorywarning=$("#inventorywarning").val();
		this.value="更新提交中";
		this.disabled=true;
		$.post("updateGolbalParambygkey.action",{
			"stockreduce":stockreduce,
			"defaultstock":defaultstock,
			"inventorywarning":inventorywarning
		},function(data){
			if(data.sucflag){
				$("#stockupdate").attr("value","更新");
				$("#stockupdate").attr("disabled",false);
				forminfo("#alertinfo","更新库存相关设置成功");
				return;
			}else{
				formwarning("#alerterror","更新库存相关设置失败");
				return;
			}
		});
	});
	
	/**
	 * 更新图片相关设置
	 */
	$("#imgupdate").click(function(data){
		var issaveimgtocloud=$("input[name='issaveimgtocloud']:checked").val();
		var watermarkfileimg=$("#watermarkfileimg").val();
		var watermarkclarity=$("#watermarkclarity").val();
		var issaveoriginalbitmap=$("input[name='issaveoriginalbitmap']:checked").val();
		var thumbnailwidth=$("#thumbnailwidth").val();
		var thumbnailheight=$("#thumbnailheight").val();
		var defaultwidth=$("#defaultwidth").val();
		var defaultheight=$("#defaultheight").val();
		var isimagecompression=$("input[name='isimagecompression']:checked").val();
		this.value="更新提交中";
		this.disabled=true;
		$.post("updateGolbalParambygkey.action",{
			"issaveimgtocloud":issaveimgtocloud,
			"watermarkfileimg":watermarkfileimg,
			"watermarkclarity":watermarkclarity,
			"issaveoriginalbitmap":issaveoriginalbitmap,
			"thumbnailwidth":thumbnailwidth,
			"thumbnailheight":thumbnailheight,
			"defaultwidth":defaultwidth,
			"defaultheight":defaultheight,
			"isimagecompression":isimagecompression
		},function(data){
			if(data.sucflag){
				$("#imgupdate").attr("value","更新");
				$("#imgupdate").attr("disabled",false);
				forminfo("#alertinfo","更新图片相关设置成功");
				return;
			}else{
				formwarning("#alerterror","更新图片相关设置失败");
				return;
			}
		});
	});
	
	/**
	 * 更新商品相关设置
	 */
	 $("#goodsupdate").click(function(data){
		 var pointrename=$("#pointrename").val();
		 var integralconversionration=$("#integralconversionration").val();
		 var proportionintegralpayment=$("#proportionintegralpayment").val();
		 var isvirtualitemsupport=$("input[name='isvirtualitemsupport']:checked").val();
		 var isspecificationsupport=$("input[name='isspecificationsupport']:checked").val();
		 var goodscommentcondition=$("input[name='goodscommentcondition']:checked").val();
		 var isintelligentproductnamed=$("input[name='isintelligentproductnamed']:checked").val();
		 var associateattributecount=$("#associateattributecount").val();		
		 this.value="更新提交中";
		 this.disabled=true;
		 $.post("updateGolbalParambygkey.action",{
				"pointrename":pointrename,
				"integralconversionration":integralconversionration,
				"proportionintegralpayment":proportionintegralpayment,
				"isvirtualitemsupport":isvirtualitemsupport,
				"isspecificationsupport":isspecificationsupport,
				"goodscommentcondition":goodscommentcondition,
				"isintelligentproductnamed":isintelligentproductnamed,
				"associateattributecount":associateattributecount
			},function(data){
				if(data.sucflag){
					$("#goodsupdate").attr("value","更新");
					$("#goodsupdate").attr("disabled",false);
					forminfo("#alertinfo","更新商品相关设置成功");
					return;
				}else{
					formwarning("#alerterror","更新商品相关设置失败");
					return;
				}
			});
	 });
	
	 /**
	  * 更新icp备案相关设置
	  */
	 $("#icpupdate").click(function(data){
		 var icp=$("#icp").val();
		 this.value="更新提交中";
		 this.disabled=true;
		 $.post("updateGolbalParambygkey.action",{
				"icp":icp
			},function(data){
				if(data.sucflag){
					$("#icpupdate").attr("value","更新");
					$("#icpupdate").attr("disabled",false);
					forminfo("#alertinfo","更新icp备案相关设置成功");
					return;
				}else{
					formwarning("#alerterror","更新icp备案相关设置失败");
					return;
				}
			});
	 });
	 
	
});

