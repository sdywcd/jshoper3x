/*
 * 全局变量
 * */
var strvalue="";
var session ="true";
var rid="";
var gloabdata;
var specificationsid="";
/*===========================================Gorgeous split-line==============================================*/
/**
 * 删除重复数组
 */
function killrepeat(arr){
	
	for(var i=0;i<arr.length;i++)
		for(var j=i+1;j<arr.length;j++)
			if(arr[i]===arr[j]){arr.splice(j,1);j--;}          
    return arr.sort(function(a,b){return a-b});
}
/*===========================================Gorgeous split-line==============================================*/
/**
 * 获取随机id
 */
function getIdforradom(){
	var myDate=new Date();
	rid=myDate.getSeconds().toString()+myDate.getMilliseconds().toString();
}
/**
 * 删除节点
 * @param rid
 */
function delParamPChild(rid){
	$('#'+rid).remove();
	delProductByproductid(rid);
}
/**
 * 删除产品表中的数据
 */
function delProductByproductid(rid){
	
	$.post("delProductTByproductid.action",{"productid":rid},function(data){
		if(data.sucflag){
			return true;
		}else{
			alert("删除货品异常");
			return false; 
		}
	});
}
/**
 * 获取关联商品
 */
function getbelinkedGoods(){
    var belinkedgoodsid=$("#linkedgoodsselect").val();
    if(null!=belinkedgoodsid){
        return belinkedgoodsid;
    }
    return "";
}

/**
 * 再获取一次商品，绑定商品参数和属性。
 * @param goodsid
 */
function bindgoodsattrparam(goodsid){
	$.post("findGoodsById.action",{"goodsid":goodsid},function(data){
		
		//设置商品属性
		$('#goodsAttrVal0').val(data.bean.goodsAttrVal0);
		$('#goodsAttrVal1').val(data.bean.goodsAttrVal1);
		$('#goodsAttrVal2').val(data.bean.goodsAttrVal2);
		$('#goodsAttrVal3').val(data.bean.goodsAttrVal3);
		$('#goodsAttrVal4').val(data.bean.goodsAttrVal4);
		$('#goodsAttrVal5').val(data.bean.goodsAttrVal5);
		$('#goodsAttrVal6').val(data.bean.goodsAttrVal6);
		$('#goodsAttrVal7').val(data.bean.goodsAttrVal7);
		$('#goodsAttrVal8').val(data.bean.goodsAttrVal8);
		$('#goodsAttrVal9').val(data.bean.goodsAttrVal9);
		$('#goodsAttrVal10').val(data.bean.goodsAttrVal10);
		$('#goodsAttrVal11').val(data.bean.goodsAttrVal11);
		$('#goodsAttrVal12').val(data.bean.goodsAttrVal12);
		$('#goodsAttrVal13').val(data.bean.goodsAttrVal13);
		$('#goodsAttrVal14').val(data.bean.goodsAttrVal14);
		$('#goodsAttrVal15').val(data.bean.goodsAttrVal15);
		$('#goodsAttrVal16').val(data.bean.goodsAttrVal16);
		$('#goodsAttrVal17').val(data.bean.goodsAttrVal17);
		$('#goodsAttrVal18').val(data.bean.goodsAttrVal18);
		$('#goodsAttrVal19').val(data.bean.goodsAttrVal19);
		$('#goodsAttrVal20').val(data.bean.goodsAttrVal20);
		$('#goodsAttrVal21').val(data.bean.goodsAttrVal21);
		$('#goodsAttrVal22').val(data.bean.goodsAttrVal22);
		$('#goodsAttrVal23').val(data.bean.goodsAttrVal23);
		$('#goodsAttrVal24').val(data.bean.goodsAttrVal24);
		$('#goodsAttrVal25').val(data.bean.goodsAttrVal25);
		$('#goodsAttrVal26').val(data.bean.goodsAttrVal26);
		$('#goodsAttrVal27').val(data.bean.goodsAttrVal27);
		$('#goodsAttrVal28').val(data.bean.goodsAttrVal28);
		$('#goodsAttrVal29').val(data.bean.goodsAttrVal29);
		bindgoodsparams(data.bean.goodsParameterValue);
	});
} 
function bindgoodsparams(params){
	//设置商品参数的值
	var jsonstr1=$.parseJSON("["+params+"]");
	$.each(jsonstr1,function(k,s){
		$('#'+s.id).val(s.value);
	});
}
/*===========================================Gorgeous split-line==============================================*/

/**
 * 检测只能选择一个默认货品
 * @return
 */
var checkisdefault=false;
function checkisDefault(){
	var sum=0;
	var strisDefault="isDefault";
	$("#addproductlistarea tbody tr td input").each(function(){
		if(this.name.substring(0,strisDefault.length)==strisDefault){
			if(this.checked){
				isDefault="1";
				sum=sum+1;
			}else{
				isDefault="0";
			}
		}
	});
	if(sum>1){
		
		jAlert('不能选择多个默认货品', '信息提示');
		return false;
	}
	if(sum==0){
		jAlert('请选择一个默认货品', '信息提示');
		return false;
	}
	$('#submit').attr("disabled",false);
	checkisdefault=true;
}

//商品参数全局变量
var flag=false;

//验证商品传递的参数
function  validatethenpostinfotoaddgoods(){
	var navid=$('#navid').val();
	var nname=$('#navid').find("option:selected").text();
	var ltypeid=$('#ltypeid').val();
	var lname=$('#ltypeid').find("option:selected").text();
	var stypeid=$('#stypeid').val();
	var sname=$('#stypeid').find("option:selected").text();
	var brandid=$('#brandname').val();
	var brandname=$('#brandname').find("option:selected").text();
	var goodsname=$('#goodsname').val();
	var usersetnum=$('#usersetnum').val();
	var saleprice=$('#saleprice').val();
	var weight=$('#weight').val();
	var weightselect=$('#weightselect').val();
	var quantity=$('#quantity').val();
	
	//获取商品图片路径集合
	var pictureurl="";
	$(":checkbox[name='pcpath'][checked=true]").each(function(){
		pictureurl+=this.value+",";
	});
	var detail=$('#detail').val();

	if("0"==navid&&"0"==ltypeid&&"0"==stypeid){
		jAlert('商品所属分类必须选择', '信息提示');
		return false;
	}
	if("0"==brandid){
		jAlert('商品品牌必须选择', '信息提示');
		return false;
	}

	if(""==usersetnum){
		jAlert('商品编码必须填写', '信息提示');
		return false;
	}
	if(""==goodsname){
		jAlert('商品名称必须填写', '信息提示');
		return false;
	}
	if(""==saleprice){
		jAlert('商品销售价格必须填写', '信息提示');
		return false;
	}
	if(""==weight){
		jAlert('商品毛重必须填写', '信息提示');
		return false;	
	}
	if(""==quantity||quantity<=0){
		jAlert('商品库存必须填写', '信息提示');
		return false;		
	}
	if(""==pictureurl){
		jAlert('商品主图片必须填写', '信息提示');
		return false;
	}
	if(""==weightselect){
		jAlert('商品单位必须选择', '信息提示');
		return false;	
	}
	if(""==detail){
		jAlert('商品详细必须填写', '信息提示');
		return false;
	}
	flag=true;
}
/*===========================================Gorgeous split-line==============================================*/

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


/**
 * 获取商品类型
 */
$(function(){
	$.post("findGoodsTypeTNForSelect.action",function(data){
		if(data.goodstypetnlist!=""){
			$('#goodsTypeId').html(data.goodstypetnlist);
		}
	});
});
$(function(){	
	$('#goodsTypeId').change(function(){
		var goodsid=$.query.get('goodsid');
		if(goodsid==""){
			return false;
		}
		var goodsTypeId=$('#goodsTypeId').val();
		$('#gat').text("");
		$('#gatattr').text("");
		$.ajax({
			url:'findGoodsAttributeTBygoodsTypeId.action',
			type:"post",
			data:{"goodsTypeId":goodsTypeId},
			dataType:'json',
			async:false,
			success:function(data){
				if(data.sucflag){
					var gathtml="";
					var option="";
					var myoptionarray=new Array();
					if(data.gatbeanlist!=null){
						$.each(data.gatbeanlist,function(i,item){
							myoptionarray=item.attributelist.split(",");
							option="<option value='0'>---请选择---</option>";
							for(var j=0;j<myoptionarray.length;j++){
								option+="<option value='"+myoptionarray[j]+"'>"+myoptionarray[j]+"</option>";
							}
							gathtml+="<div class='field'>"+
							"<div class='label'>"+
							"<label for='select'>"+item.goodsattributename+"</label>"+
							"</div>"+
							"<div class='select'>"+
							"<select id='goodsAttrVal"+i+"' name='goodsAttrVal"+i+"'>"+option+"</select>" +
							"</div>"+
							"</div>";
							option="";
						});
						$('#gat').append(gathtml);
					}
				}
			}
			});
		$.ajax({
			url:'findGoodsParameter.action',
			type:"post",
			data:{"goodsTypeId":goodsTypeId},
			dataType:'json',
			async:false,
			success:function(data){
			if(data.sucflag){
				var gatattrhtml="";
				var jsonstr=$.parseJSON(data.bean.goodsParameter);
				$.each(jsonstr,function(k,s){
					gatattrhtml+="<div class='field'>"+
									"<div class='label'>"+
										"<label for='input-small'>"+s.name+"</label>"+
									"</div>"+
									"<div class='input'>"+
									"<input id='"+s.id+"' name='"+s.id+"' value='' class='small' type='text'></input>"+
									"</div>"+
								"</div>";
				});
				$('#gatattr').append(gatattrhtml);
			}
			}
		});	

		//再获取一次商品，绑定商品参数和属性。
		bindgoodsattrparam(goodsid);
	
		
});
});
//获取商品导航菜单
$(function(){
	$.post("findGoodscategoryNavid.action",function(data){
		$("#navid").append(data.navidlist);
        //向关联商品tab中注入商品导航
        $("#navidbelinked").append(data.navidlist);
		return;
	});
});
//获取商品二级菜单
$(function(){
	$("#navid").change(function(){
		var parentId=$("#navid").val();
		if("0"==parentId){
			return;
		}
		$.post("findGoodscategoryLtypeid.action",{"parentId":parentId},function(data){
			$("#ltypeid option").remove();
			if(data.ltypeidlist==""){
				$("#ltypeid").hide();
			}else{
				$("#ltypeid").append(data.ltypeidlist); 
				$("#ltypeid").show();
			}
		});
        
	});
    
    //向关联商品tab中注入商品二级菜单
    $("#navidbelinked").change(function(){
        var parentId=$("#navidbelinked").val();
        if("0"==parentId){
            return;
        }
        $.post("findGoodscategoryLtypeid.action",{"parentId":parentId},function(data){
            $("#ltypeidbelinked option").remove();
            if(data.ltypeidlist==""){
                $("#ltypeidbelinked").hide();
            }else{
                $("#ltypeidbelinked").append(data.ltypeidlist); 
                $("#ltypeidbelinked").show();
            }
        });
    });
});
//获取商品三级菜单
$(function(){
	$("#ltypeid").change(function(){
		var parentId=$("#ltypeid").val();
		if("0"==parentId){
			return;
		}
		$.post("findGoodscategoryStypeid.action",{"parentId":parentId},function(data){
			$("#stypeid option").remove();
			if(data.stypeidlist==""){
				$("#stypeid").hide();
			}else{
				$("#stypeid").append(data.stypeidlist);
				$("#stypeid").show();
			}
		});
	});
	//向关联商品tab中注入商品二级菜单
    $("#ltypeidbelinked").change(function(){
        var parentId=$("#ltypeid").val();
        if("0"==parentId){
            return;
        }
        $.post("findGoodscategoryStypeid.action",{"parentId":parentId},function(data){
            $("#stypeidbelinked option").remove();
            if(data.stypeidlist==""){
                $("#stypeidbelinked").hide();
            }else{
                $("#stypeidbelinked").append(data.stypeidlist);
                $("#stypeidbelinked").show();
            }
            
        });
    });
});

//获取商品品牌json
$(function(){
	$.post("findAllBrandtjson.action",function(data){
		$("#brandname").append(data.brandjson);
		return;
	});
	
});
//获取商品产地json
$(function(){
	$.post("findAllPlaceoforigintjson.action",function(data){
		$("#productplace").append(data.placeoforigintjson);
		return;
	});
	
});
//获取商品单位json
$(function(){
	$.post("findAllGoodsunitjson.action",function(data){
		$("#weightselect").append(data.unitjson);
		return;
		
	});
	
});
//获取商品关键字json
$(function(){
	$.post("findAllKeywordTjson.action",function(data){
		$("#keywordname").append(data.keywordjson); ;
		return;
	});
});
/*===========================================Gorgeous split-line==============================================*/
/**
 * 更新商品
 */
$(function(){
	$('#submit').click(function(){
		//开始数据验证
		validatethenpostinfotoaddgoods();
		if(flag){
			var goodsid=$('#goodsid').val();
			var navid=$('#navid').val();
			var nname=$('#navid').find("option:selected").text();
			if(navid==null||navid==0){
				navid=0;
				nname="";
			}
			var ltypeid=$('#ltypeid').val();
			var lname=$('#ltypeid').find("option:selected").text();
			if(ltypeid==null||ltypeid==0){
				ltypeid=0;
				lname="";
			}
			var stypeid=$('#stypeid').val();
			var sname=$('#stypeid').find("option:selected").text();
			if(stypeid==null||stypeid==0){
				stypeid=0;
				sname="";
			}
			var fname="";
			var goodsname=$('#goodsname').val();
			var model="";
			var usersetnum=$('#usersetnum').val();
			var productSn=$('#productSn').val();
			var brandid=$('#brandname').val();
			var brandname=$('#brandname').find("option:selected").text();
			var saleprice=$('#saleprice').val();
			var memberprice=$('#memberprice').val();
			var price=$('#price').val();
			var cost=$('#cost').val();
			var weight=$('#weight').val();
			var unitnameid=$('#weightselect').val();
			var unitname=$('#weightselect').find("option:selected").text();
			var quantity=$('#quantity').val();
			var salestate="0";
			var freezeStore=$('#freezeStore').val();
			var placeStore=$('#placeStore').val();
			var points=$('#points').val();
			var isNew=$('#isNew').val();
			var recommended=$("input[name='recommended']:checked").val(); 
			var hotsale=$("input[name='hotsale']:checked").val(); 
			var bargainprice=$("input[name='bargainprice']:checked").val(); 
			var salestate=$("input[name='salestate']:checked").val(); 
			var ismobileplatformgoods=$("input[name='ismobileplatformgoods']:checked").val();
			var keywordid=$('#keywordname').val();
			var keywordname=$('#keywordname').find("option:selected").text();
			var metaKeywords=$('#metaKeywords').val();
			var metaDescription=$('#metaDescription').val();
			var detail=$('#detail').val();
			//获取商品图片路径集合
			var pictureurl="";
			$(":checkbox[name='pcpath'][checked=true]").each(function(){
				pictureurl+=this.value+",";
			});
			var isSpecificationsOpen=$('#isSpecificationsOpen').val();
			var goodsTypeId=$('#goodsTypeId').val();
			var commoditylist=$('#commoditylist').val();
			 //获取关联商品列表
            var belinkedgoodsid=getbelinkedGoods().toString();
            //虚拟商品标记
            var isvirtual=$("input[name='isvirtual']:checked").val();
            var virtualresults=$("#virtualresults").val();//虚拟商品反馈结果，例如给出链接地址和密码
            if((goodsTypeId=="0"&&isSpecificationsOpen=="0")||(goodsTypeId=="0"&&isSpecificationsOpen=="2")){
				//如果规格和属性都没起启用，增加的类似充值卡
				$.post("updateGoods.action",{"virtualresults":virtualresults,"isvirtual":isvirtual,"belinkedgoodsid":belinkedgoodsid,"ismobileplatformgoods":ismobileplatformgoods,"goodsid":goodsid,"goodsname":goodsname,"nname":nname,"lname":lname,"sname":sname,"navid":navid,"ltypeid":ltypeid,"stypeid":stypeid,"price":price,"memberprice":memberprice,"points":points,"pictureurl":pictureurl,"quantity":quantity,"detail":detail,"unitname":unitname,"keywordname":keywordname,"weight":weight,"recommended":recommended,"hotsale":hotsale,"bargainprice":bargainprice,"salestate":salestate,"brandid":brandid,"brandname":brandname,"placeStore":placeStore,"metaKeywords":metaKeywords,"metaDescription":metaDescription,"cost":cost,"saleprice":saleprice,"isNew":isNew,"productSn":productSn,"keywordid":keywordid,"unitnameid":unitnameid,"usersetnum":usersetnum,"isSpecificationsOpen":isSpecificationsOpen,"goodsTypeId":goodsTypeId,"freezeStore":freezeStore,"commoditylist":commoditylist},function(data){
					if(data.sucflag){
						jAlert('更新商品成功', '信息提示');
						window.location.href='goodsmanagement.jsp?session='+session+"#goods";
					}
					return;
				});
			}else{
				if(goodsTypeId!="0"&&isSpecificationsOpen=="0"||isSpecificationsOpen=="2"){
					//获取商品属性
					var goodsTypeName=$('#goodsTypeId').find("option:selected").text();
					var goodsAttrVal0=$('#goodsAttrVal0').find("option:selected").text();
					var goodsAttrVal1=$('#goodsAttrVal1').find("option:selected").text();
					var goodsAttrVal2=$('#goodsAttrVal2').find("option:selected").text();
					var goodsAttrVal3=$('#goodsAttrVal3').find("option:selected").text();
					var goodsAttrVal4=$('#goodsAttrVal4').find("option:selected").text();
					var goodsAttrVal5=$('#goodsAttrVal5').find("option:selected").text();
					var goodsAttrVal6=$('#goodsAttrVal6').find("option:selected").text();
					var goodsAttrVal7=$('#goodsAttrVal7').find("option:selected").text();
					var goodsAttrVal8=$('#goodsAttrVal8').find("option:selected").text();
					var goodsAttrVal9=$('#goodsAttrVal9').find("option:selected").text();
					var goodsAttrVal10=$('#goodsAttrVal10').find("option:selected").text();
					var goodsAttrVal11=$('#goodsAttrVal11').find("option:selected").text();
					var goodsAttrVal12=$('#goodsAttrVal12').find("option:selected").text();
					var goodsAttrVal13=$('#goodsAttrVal13').find("option:selected").text();
					var goodsAttrVal14=$('#goodsAttrVal14').find("option:selected").text();
					var goodsAttrVal15=$('#goodsAttrVal15').find("option:selected").text();
					var goodsAttrVal16=$('#goodsAttrVal16').find("option:selected").text();
					var goodsAttrVal17=$('#goodsAttrVal17').find("option:selected").text();
					var goodsAttrVal18=$('#goodsAttrVal18').find("option:selected").text();
					var goodsAttrVal19=$('#goodsAttrVal19').find("option:selected").text();
					var goodsAttrVal20=$('#goodsAttrVal20').find("option:selected").text();
					var goodsAttrVal21=$('#goodsAttrVal21').find("option:selected").text();
					var goodsAttrVal22=$('#goodsAttrVal22').find("option:selected").text();
					var goodsAttrVal23=$('#goodsAttrVal23').find("option:selected").text();
					var goodsAttrVal24=$('#goodsAttrVal24').find("option:selected").text();
					var goodsAttrVal25=$('#goodsAttrVal25').find("option:selected").text();
					var goodsAttrVal26=$('#goodsAttrVal26').find("option:selected").text();
					var goodsAttrVal27=$('#goodsAttrVal27').find("option:selected").text();
					var goodsAttrVal28=$('#goodsAttrVal28').find("option:selected").text();
					var goodsAttrVal29=$('#goodsAttrVal29').find("option:selected").text();
					var goodsParameterValue="";
					$("#gatattr input").each(function(){
						goodsParameterValue+="{\"id\":\""+this.name+"\",\"value\":\""+this.value+"\"},"
					});
					goodsParameterValue=goodsParameterValue.toString().substring(0,goodsParameterValue.length-1);
					$.post("updateGoods.action",{"virtualresults":virtualresults,"isvirtual":isvirtual,"belinkedgoodsid":belinkedgoodsid,"ismobileplatformgoods":ismobileplatformgoods,"goodsid":goodsid,"goodsAttrVal0":goodsAttrVal0,"goodsAttrVal1":goodsAttrVal1,"goodsAttrVal2":goodsAttrVal2,"goodsAttrVal3":goodsAttrVal3,"goodsAttrVal4":goodsAttrVal4,"goodsAttrVal5":goodsAttrVal5,"goodsAttrVal6":goodsAttrVal6,"goodsAttrVal7":goodsAttrVal7,"goodsAttrVal8":goodsAttrVal8,"goodsAttrVal9":goodsAttrVal9,"goodsAttrVal10":goodsAttrVal10,"goodsAttrVal11":goodsAttrVal11,"goodsAttrVal12":goodsAttrVal12,"goodsAttrVal13":goodsAttrVal13,"goodsAttrVal14":goodsAttrVal14,"goodsAttrVal15":goodsAttrVal15,"goodsAttrVal16":goodsAttrVal16,"goodsAttrVal17":goodsAttrVal17,"goodsAttrVal18":goodsAttrVal18,"goodsAttrVal19":goodsAttrVal19,"goodsAttrVal20":goodsAttrVal20,"goodsAttrVal21":goodsAttrVal21,"goodsAttrVal22":goodsAttrVal22,"goodsAttrVal23":goodsAttrVal23,"goodsAttrVal24":goodsAttrVal24,"goodsAttrVal25":goodsAttrVal25,"goodsAttrVal26":goodsAttrVal26,"goodsAttrVal27":goodsAttrVal27,"goodsAttrVal28":goodsAttrVal28,"goodsAttrVal29":goodsAttrVal29,"goodsParameterValue":goodsParameterValue,"goodsTypeName":goodsTypeName,"goodsTypeId":goodsTypeId,"goodsname":goodsname,"nname":nname,"lname":lname,"sname":sname,"navid":navid,"ltypeid":ltypeid,"stypeid":stypeid,"price":price,"memberprice":memberprice,"points":points,"pictureurl":pictureurl,"quantity":quantity,"detail":detail,"unitname":unitname,"keywordname":keywordname,"weight":weight,"recommended":recommended,"hotsale":hotsale,"bargainprice":bargainprice,"salestate":salestate,"brandid":brandid,"brandname":brandname,"placeStore":placeStore,"metaKeywords":metaKeywords,"metaDescription":metaDescription,"cost":cost,"saleprice":saleprice,"isNew":isNew,"productSn":productSn,"keywordid":keywordid,"unitnameid":unitnameid,"usersetnum":usersetnum,"isSpecificationsOpen":isSpecificationsOpen,"freezeStore":freezeStore,"commoditylist":commoditylist},function(data){
						if(data.sucflag){
							jAlert('更新商品成功', '信息提示');
							window.location.href='goodsmanagement.jsp?session='+session+"#goods";
						}
						return;
					});
				}	
			}
			//如果规格开启而属性没开启
			if(isSpecificationsOpen=="1"&&goodsTypeId=="0"){
				var strproductSn="productSn";
				var strsaleprice="saleprice";
				var strmemberprice="memberprice";
				var strprice="price";
				var strcost="cost";
				var strweight="weight";
				var strstore="store";
				var strfreezeStore="freezeStore";
				var strwarehouseLocation="warehouseLocation";
				var strplaceStore="placeStore";
				var strisDefault="isDefault";
				var strisSalestate="isSalestate";
				var strdelbutton="delbutton";
				var strpst="pst";
				var _productSn;
				var _price;
				var _memberprice;
				var _cost;
				var _saleprice;
				var _freezeStore;
				var _store;
				var _isDefault;
				var _isSalestate;
				var _warehouseLocation;
				var _placeStore;
				var _weight;
				var addflag=0;
				var _productid;
				var sub="";
				var rejson="";
				//获取select货品参数
				var pjson="";
				var selectvalue="";
				var array=new Array();
				var _specificationsValue="";
				var selecttext="";
				var selectid="";//连续规格值id
				var selectsname="";//连续规格值名称
				var temparray=new Array();//计算规格值是否重复
				var tempcount=0;
				$("#addproductlistarea tbody tr td .productv").each(function(){
						if(this.name.substring(0,strproductSn.length)==strproductSn){
							if(this.value==""){
								jAlert('货号必须填写', '信息提示');
								return false;
							}
							_productSn=this.value;
							addflag=1;
							return true;
						}
						if(this.name.substring(0,strsaleprice.length)==strsaleprice){
							if(this.value==""){
								jAlert('销售价必须填写', '信息提示');
								return false;
							}
							_saleprice=this.value;
							addflag=2;
							return true;
						}
						if(this.name.substring(0,strmemberprice.length)==strmemberprice){
							if(this.value==""){
								jAlert('会员价必须填写', '信息提示');
								return false;
							}
							_memberprice=this.value;
							addflag=3;
							return true;
						}
						if(this.name.substring(0,strprice.length)==strprice){
							if(this.value==""){
								jAlert('市场价必须填写', '信息提示');
								return false;
							}
							_price=this.value;
							addflag=4;
							return true;
						}
						if(this.name.substring(0,strcost.length)==strcost){
							if(this.value==""){
								jAlert('成本价必须填写', '信息提示');
								return false;
							}
							_cost=this.value;
							addflag=5;
							return true;
						}
						if(this.name.substring(0,strweight.length)==strweight){
							if(this.value==""){
								jAlert('重量必须填写', '信息提示');
								return false;
							}
							_weight=this.value;
							addflag=6;
							return true;
						}
						if(this.name.substring(0,strstore.length)==strstore){
							if(this.value==""){
								jAlert('库存必须填写', '信息提示');
								return false;
							}
							_store=this.value;
							addflag=7;
							return true;
						}
						if(this.name.substring(0,strfreezeStore.length)==strfreezeStore){
							if(this.value==""){
								jAlert('预警库存必须填写', '信息提示');
								return false;
							}
							_freezeStore=this.value;
							addflag=8;
							return true;
						}
						
						if(this.name.substring(0,strplaceStore.length)==strplaceStore){
							if(this.value==""){
								jAlert('货位必须填写', '信息提示');
								return false;
							}
							_placeStore=this.value;
							addflag=9;
							return true;
						}
						if(this.name.substring(0,strwarehouseLocation.length)==strwarehouseLocation){
							if(this.value==""){
								jAlert('仓库位置必须填写', '信息提示');
								return false;
							}
							_warehouseLocation=this.value;
							addflag=10;
							return true;
						}
						if(this.name.substring(0,strisDefault.length)==strisDefault){
							if(this.checked){
								_isDefault="1";
								addflag=11;
								return true;
							}
							_isDefault="0";
							addflag=11;
							return true;
						}
						if(this.name.substring(0,strisSalestate.length)==strisSalestate){
							if(this.checked){
								_isSalestate="1";
								addflag=12;
								return true;
							}
							_isSalestate="0";
							addflag=12;
							return true;
						}
						if(this.name.substring(0,strpst.length)==strpst){
							selectvalue=this.value;
							var selectarray=this.options;
							for(var i=0;i<selectarray.length;i++){
								if(selectarray[i].selected==true){
									selecttext=selectarray[i].text;//赋值规格值名称
									temparray.push(selectarray[i].text);//把值赋予比较对象
								}
							}
							array=selectvalue.split(",");
							_specificationsValue+="{\"id\":\"" + array[0] + "\",\"goodsattributename\":\"" + selecttext + "\",\"attributelist\":\"" + array[1] + "\",\"sort\":\"" + array[2] + "\",\"specificationsid\":\""+array[3]+"\"}=";
							selectid+=array[3]+",";//注入多个规格值id
							selectsname+=selecttext+",";//注入多个规格值名称
						}
					
						if(this.name.substring(0,strdelbutton.length)==strdelbutton){
							if(addflag==12)
							{
								_productid=this.parentNode.parentNode.id;
								sub+="{\"productid\":\""+_productid+"\",\"productSn\":\""+_productSn+"\",\"saleprice\":\""+_saleprice+"\",\"memberprice\":\""+_memberprice+"\",\"price\":\""+_price+"\",\"cost\":\""+_cost+"\",\"weight\":\""+_weight+"\",\"store\":\""+_store+"\",\"freezeStore\":\""+_freezeStore+"\",\"placeStore\":\""+_placeStore+"\",\"warehouseLocation\":\""+_warehouseLocation+"\",\"isDefault\":\""+_isDefault+"\",\"isSalestate\":\""+_isSalestate+"\",}-";
								addflag=0;
								_productSn="";
								_price="";
								_memberprice="";
								_cost="";
								_saleprice="";
								_freezeStore="";
								_store="";
								_isDefault="";
								_isSalestate="";
								_warehouseLocation="";
								_placeStore="";
								_weight="";
								_productid="";
								_specificationsValue+="-";
							}
						}					
				});
				for(var i=0;i<temparray.length;i++){
					if(temparray[i]==selecttext){
						tempcount++;
						if(tempcount>1){
							alert("一种规格值能对应一批货品");
							return false;
						}
						
					}
				}
				
				rejson = sub.toString().substring(0,sub.length-1);
				_specificationsValue=_specificationsValue.toString().substring(0,_specificationsValue.length-1);
				
				/**
				 * 检测是否选择了多个默认货品
				 */
				checkisDefault();
				if(checkisdefault){
				    /**
				     * 组织商品规格的id
				     */
					$('option[name="specificationsid"]').each(function(){
						var tempstr = $(this).val();
						specificationsid += tempstr.replace(/([^,]*,){3}([\S]+)/g,"$2")+",";
					});
					specificationsid =specificationsid.substring(0,specificationsid.length-1); 
					var temparr = specificationsid.split(',');
					temparr = killrepeat(temparr);
					specificationsid = temparr.join(",");
					$.post("updateGoods.action",{"belinkedgoodsid":belinkedgoodsid,"specificationsid":selectid,"specificationsName":selectsname,"specificationsValue":_specificationsValue,"ismobileplatformgoods":ismobileplatformgoods,"goodsid":goodsid,"goodsTypeId":goodsTypeId,"rejson":rejson,"goodsname":goodsname,"nname":nname,"lname":lname,"sname":sname,"navid":navid,"ltypeid":ltypeid,"stypeid":stypeid,"price":price,"memberprice":memberprice,"points":points,"pictureurl":pictureurl,"quantity":quantity,"detail":detail,"unitname":unitname,"keywordname":keywordname,"weight":weight,"recommended":recommended,"hotsale":hotsale,"bargainprice":bargainprice,"salestate":salestate,"brandid":brandid,"brandname":brandname,"placeStore":placeStore,"metaKeywords":metaKeywords,"metaDescription":metaDescription,"cost":cost,"saleprice":saleprice,"isNew":isNew,"productSn":productSn,"keywordid":keywordid,"unitnameid":unitnameid,"usersetnum":usersetnum,"isSpecificationsOpen":isSpecificationsOpen,"freezeStore":freezeStore,"specificationsId":specificationsid,"commoditylist":commoditylist},function(data){
						if(data.sucflag){
							jAlert('更新商品成功', '信息提示');
							window.location.href="goodsmanagement.jsp?session="+session+"#goods";
						}
						return;
					});
				}
			}
			
			//规格和属性都开启
			if(isSpecificationsOpen=="1"&&goodsTypeId!="0"){
				var strproductSn="productSn";
				var strsaleprice="saleprice";
				var strmemberprice="memberprice";
				var strprice="price";
				var strcost="cost";
				var strweight="weight";
				var strstore="store";
				var strfreezeStore="freezeStore";
				var strwarehouseLocation="warehouseLocation";
				var strplaceStore="placeStore";
				var strisDefault="isDefault";
				var strisSalestate="isSalestate";
				var strdelbutton="delbutton";
				var strpst="pst";
				var _productSn;
				var _price;
				var _memberprice;
				var _cost;
				var _saleprice;
				var _freezeStore;
				var _store;
				var _isDefault;
				var _isSalestate;
				var _warehouseLocation;
				var _placeStore;
				var _weight;
				var addflag=0;
				var _productid;
				var sub="";
				var rejson="";
				//获取select货品参数
				var pjson="";
				var selectvalue="";
				var array=new Array();
				var _specificationsValue="";
				var selecttext="";
				var selectid="";//连续规格值id
				var selectsname="";//连续规格值名称
				var temparray=new Array();//计算规格值是否重复
				var tempcount=0;
				$("#addproductlistarea tbody tr td .productv").each(function(){
						if(this.name.substring(0,strproductSn.length)==strproductSn){
							if(this.value==""){
								jAlert('货号必须填写', '信息提示');
								return false;
							}
							_productSn=this.value;
							addflag=1;
							return true;
						}
						if(this.name.substring(0,strsaleprice.length)==strsaleprice){
							if(this.value==""){
								jAlert('销售价必须填写', '信息提示');
								return false;
							}
							_saleprice=this.value;
							addflag=2;
							return true;
						}
						if(this.name.substring(0,strmemberprice.length)==strmemberprice){
							if(this.value==""){
								jAlert('会员价必须填写', '信息提示');
								return false;
							}
							_memberprice=this.value;
							addflag=3;
							return true;
						}
						if(this.name.substring(0,strprice.length)==strprice){
							if(this.value==""){
								jAlert('市场价必须填写', '信息提示');
								return false;
							}
							_price=this.value;
							addflag=4;
							return true;
						}
						if(this.name.substring(0,strcost.length)==strcost){
							if(this.value==""){
								jAlert('成本价必须填写', '信息提示');
								return false;
							}
							_cost=this.value;
							addflag=5;
							return true;
						}
						if(this.name.substring(0,strweight.length)==strweight){
							if(this.value==""){
								jAlert('重量必须填写', '信息提示');
								return false;
							}
							_weight=this.value;
							addflag=6;
							return true;
						}
						if(this.name.substring(0,strstore.length)==strstore){
							if(this.value==""){
								jAlert('库存必须填写', '信息提示');
								return false;
							}
							_store=this.value;
							addflag=7;
							return true;
						}
						if(this.name.substring(0,strfreezeStore.length)==strfreezeStore){
							if(this.value==""){
								jAlert('预警库存必须填写', '信息提示');
								return false;
							}
							_freezeStore=this.value;
							addflag=8;
							return true;
						}
						
						if(this.name.substring(0,strplaceStore.length)==strplaceStore){
							if(this.value==""){
								jAlert('货位必须填写', '信息提示');
								return false;
							}
							_placeStore=this.value;
							addflag=9;
							return true;
						}
						if(this.name.substring(0,strwarehouseLocation.length)==strwarehouseLocation){
							if(this.value==""){
								jAlert('仓库位置必须填写', '信息提示');
								return false;
							}
							_warehouseLocation=this.value;
							addflag=10;							
							return true;
						}
						if(this.name.substring(0,strisDefault.length)==strisDefault){
							if(this.checked){
								_isDefault="1";
								addflag=11;
								return true;
							}
							_isDefault="0";
							addflag=11;
							return true;
						}
						if(this.name.substring(0,strisSalestate.length)==strisSalestate){
							if(this.checked){
								_isSalestate="1";
								addflag=12;
								return true;
							}
							_isSalestate="0";
							addflag=12;
							return true;
						}
						if(this.name.substring(0,strpst.length)==strpst){
							selectvalue=this.value;
							var selectarray=this.options;
							for(var i=0;i<selectarray.length;i++){
								if(selectarray[i].selected==true){
									selecttext=selectarray[i].text;//赋值规格值名称
									temparray.push(selectarray[i].text);//把值赋予比较对象
								}
							}
							array=selectvalue.split(",");
							_specificationsValue+="{\"id\":\"" + array[0] + "\",\"goodsattributename\":\"" + selecttext + "\",\"attributelist\":\"" + array[1] + "\",\"sort\":\"" + array[2] + "\",\"specificationsid\":\""+array[3]+"\"}=";
							selectid+=array[3]+",";//注入多个规格值id
							selectsname+=selecttext+",";//注入多个规格值名称
						}
						if(this.name.substring(0,strdelbutton.length)==strdelbutton){
							if(addflag==12)
							{
								_productid=this.parentNode.parentNode.id;
								sub+="{\"productid\":\""+_productid+"\",\"productSn\":\""+_productSn+"\",\"saleprice\":\""+_saleprice+"\",\"memberprice\":\""+_memberprice+"\",\"price\":\""+_price+"\",\"cost\":\""+_cost+"\",\"weight\":\""+_weight+"\",\"store\":\""+_store+"\",\"freezeStore\":\""+_freezeStore+"\",\"placeStore\":\""+_placeStore+"\",\"warehouseLocation\":\""+_warehouseLocation+"\",\"isDefault\":\""+_isDefault+"\",\"isSalestate\":\""+_isSalestate+"\"}-";
								addflag=0;
								_productSn="";
								_price="";
								_memberprice="";
								_cost="";
								_saleprice="";
								_freezeStore="";
								_store="";
								_isDefault="";
								_isSalestate="";
								_warehouseLocation="";
								_placeStore="";
								_weight="";
								_productid="";
								_specificationsValue+="-";
							}
						}					
				});
				for(var i=0;i<temparray.length;i++){
					if(temparray[i]==selecttext){
						tempcount++;
						if(tempcount>1){
							alert("一种规格值能对应一批货品");
							return false;
						}
						
					}
				}
				rejson = sub.toString().substring(0,sub.length-1);
				_specificationsValue=_specificationsValue.toString().substring(0,_specificationsValue.length-1);
				
				/**
				 * 检测是否选择了多个默认货品
				 */
				checkisDefault();
				if(checkisdefault){
					//获取商品属性
					var goodsTypeName=$('#goodsTypeId').find("option:selected").text();
					var goodsAttrVal0=$('#goodsAttrVal0').find("option:selected").text();
					var goodsAttrVal1=$('#goodsAttrVal1').find("option:selected").text();
					var goodsAttrVal2=$('#goodsAttrVal2').find("option:selected").text();
					var goodsAttrVal3=$('#goodsAttrVal3').find("option:selected").text();
					var goodsAttrVal4=$('#goodsAttrVal4').find("option:selected").text();
					var goodsAttrVal5=$('#goodsAttrVal5').find("option:selected").text();
					var goodsAttrVal6=$('#goodsAttrVal6').find("option:selected").text();
					var goodsAttrVal7=$('#goodsAttrVal7').find("option:selected").text();
					var goodsAttrVal8=$('#goodsAttrVal8').find("option:selected").text();
					var goodsAttrVal9=$('#goodsAttrVal9').find("option:selected").text();
					var goodsAttrVal10=$('#goodsAttrVal10').find("option:selected").text();
					var goodsAttrVal11=$('#goodsAttrVal11').find("option:selected").text();
					var goodsAttrVal12=$('#goodsAttrVal12').find("option:selected").text();
					var goodsAttrVal13=$('#goodsAttrVal13').find("option:selected").text();
					var goodsAttrVal14=$('#goodsAttrVal14').find("option:selected").text();
					var goodsAttrVal15=$('#goodsAttrVal15').find("option:selected").text();
					var goodsAttrVal16=$('#goodsAttrVal16').find("option:selected").text();
					var goodsAttrVal17=$('#goodsAttrVal17').find("option:selected").text();
					var goodsAttrVal18=$('#goodsAttrVal18').find("option:selected").text();
					var goodsAttrVal19=$('#goodsAttrVal19').find("option:selected").text();
					var goodsAttrVal20=$('#goodsAttrVal20').find("option:selected").text();
					var goodsAttrVal21=$('#goodsAttrVal21').find("option:selected").text();
					var goodsAttrVal22=$('#goodsAttrVal22').find("option:selected").text();
					var goodsAttrVal23=$('#goodsAttrVal23').find("option:selected").text();
					var goodsAttrVal24=$('#goodsAttrVal24').find("option:selected").text();
					var goodsAttrVal25=$('#goodsAttrVal25').find("option:selected").text();
					var goodsAttrVal26=$('#goodsAttrVal26').find("option:selected").text();
					var goodsAttrVal27=$('#goodsAttrVal27').find("option:selected").text();
					var goodsAttrVal28=$('#goodsAttrVal28').find("option:selected").text();
					var goodsAttrVal29=$('#goodsAttrVal29').find("option:selected").text();
					var goodsParameterValue="";
					$("#gatattr input").each(function(){
						goodsParameterValue+="{\"id\":\""+this.name+"\",\"value\":\""+this.value+"\"},"
					});
					goodsParameterValue=goodsParameterValue.toString().substring(0,goodsParameterValue.length-1);
				    /**
				     * 组织商品规格的id
				     */
					$('option[name="specificationsid"]').each(function(){
						var tempstr = $(this).val();
						specificationsid += tempstr.replace(/([^,]*,){3}([\S]+)/g,"$2")+",";
					});
					specificationsid =specificationsid.substring(0,specificationsid.length-1); 
					var temparr = specificationsid.split(',');
					temparr = killrepeat(temparr);
					specificationsid = temparr.join(",");
					$.post("updateGoods.action",{"belinkedgoodsid":belinkedgoodsid,"specificationsid":selectid,"specificationsName":selectsname,"specificationsValue":_specificationsValue,"ismobileplatformgoods":ismobileplatformgoods,"goodsAttrVal0":goodsAttrVal0,"goodsAttrVal1":goodsAttrVal1,"goodsAttrVal2":goodsAttrVal2,"goodsAttrVal3":goodsAttrVal3,"goodsAttrVal4":goodsAttrVal4,"goodsAttrVal5":goodsAttrVal5,"goodsAttrVal6":goodsAttrVal6,"goodsAttrVal7":goodsAttrVal7,"goodsAttrVal8":goodsAttrVal8,"goodsAttrVal9":goodsAttrVal9,"goodsAttrVal10":goodsAttrVal10,"goodsAttrVal11":goodsAttrVal11,"goodsAttrVal12":goodsAttrVal12,"goodsAttrVal13":goodsAttrVal13,"goodsAttrVal14":goodsAttrVal14,"goodsAttrVal15":goodsAttrVal15,"goodsAttrVal16":goodsAttrVal16,"goodsAttrVal17":goodsAttrVal17,"goodsAttrVal18":goodsAttrVal18,"goodsAttrVal19":goodsAttrVal19,"goodsAttrVal20":goodsAttrVal20,"goodsAttrVal21":goodsAttrVal21,"goodsAttrVal22":goodsAttrVal22,"goodsAttrVal23":goodsAttrVal23,"goodsAttrVal24":goodsAttrVal24,"goodsAttrVal25":goodsAttrVal25,"goodsAttrVal26":goodsAttrVal26,"goodsAttrVal27":goodsAttrVal27,"goodsAttrVal28":goodsAttrVal28,"goodsAttrVal29":goodsAttrVal29,"goodsid":goodsid,"goodsParameterValue":goodsParameterValue,"goodsTypeName":goodsTypeName,"goodsTypeId":goodsTypeId,"rejson":rejson,"goodsname":goodsname,"nname":nname,"lname":lname,"sname":sname,"navid":navid,"ltypeid":ltypeid,"stypeid":stypeid,"price":price,"memberprice":memberprice,"points":points,"pictureurl":pictureurl,"quantity":quantity,"detail":detail,"unitname":unitname,"keywordname":keywordname,"weight":weight,"recommended":recommended,"hotsale":hotsale,"bargainprice":bargainprice,"salestate":salestate,"brandid":brandid,"brandname":brandname,"placeStore":placeStore,"metaKeywords":metaKeywords,"metaDescription":metaDescription,"cost":cost,"saleprice":saleprice,"isNew":isNew,"productSn":productSn,"keywordid":keywordid,"unitnameid":unitnameid,"usersetnum":usersetnum,"isSpecificationsOpen":isSpecificationsOpen,"freezeStore":freezeStore,"specificationsId":specificationsid,"commoditylist":commoditylist},function(data){
						if(data.sucflag){
							jAlert('更新商品成功', '信息提示');
							window.location.href="goodsmanagement.jsp?session="+session+"#goods"
						}
						return;
					});
				}
			}
			
			
			
		}else{
			return false;
		}
	});
});

/*===========================================Gorgeous split-line==============================================*/


/**
 * 获取商品信息
*/
function findgoodsbyid(){
	var goodsid=$.query.get('goodsid');
	if(goodsid==""){
		return false;
	}
	$.post("findGoodsById.action",{"goodsid":goodsid},function(data){
		if(data.sucflag){
			$('#goodsid').attr("value",data.bean.goodsid);
			$('#navid').val(data.bean.navid);
			if(data.bean.ltypeid != 0){
				$('#ltypeid').append("<option value='"+data.bean.ltypeid+"'>"+data.bean.lname+"</option>");
			}
			$('#ltypeid').val(data.bean.ltypeid);
			if(data.bean.stypeid != 0){
				$('#stypeid').append("<option value='"+data.bean.stypeid+"'>"+data.bean.sname+"</option>");
			}
			$('#stypeid').val(data.bean.stypeid);
			$('#shownname').text(data.bean.nname);
			$('#showlname').text(data.bean.lname);
			$('#showsname').text(data.bean.sname);
			$('#shownavid').text(data.bean.navid);
			$('#showltypeid').text(data.bean.ltypeid);
			$('#showstypeid').text(data.bean.stypeid);
			$('#goodsname').val(data.bean.goodsname);
			$('#usersetnum').val(data.bean.usersetnum);
			$('#productSn').val(data.bean.productSn);
			$('#brandname').val(data.bean.brandid);
			$('#productplace').val(data.bean.productplaceid);
			$('#saleprice').val(data.bean.saleprice);
			$('#memberprice').val(data.bean.memberprice);
			$('#price').val(data.bean.price);
			$('#cost').val(data.bean.cost);
			$('#weight').val(data.bean.weight);
			$('#weightselect').val(data.bean.unitnameid);  
			$('#quantity').val(data.bean.quantity);
			$('#freezeStore').val(data.bean.freezeStore);
			$('#placeStore').val(data.bean.placeStore);
			$('#points').val(data.bean.points);
			KE.html("commoditylist", data.bean.commoditylist);
			if("1"==data.bean.isNew){
				$('#isNew').attr("checked","checked");
			}else{
				$('#isNew').attr("checked","");
			}
			if("1"==data.bean.recommended){
				$('#recommended').attr("checked","checked");
			}else{
				$('#recommended').attr("checked","");
			}
			if("1"==data.bean.hotsale){
				$('#hotsale').attr("checked","checked");
			}else{
				$('#hotsale').attr("checked","");
			}
			if("1"==data.bean.bargainprice){
				$('#bargainprice').attr("checked","checked");
			}else{
				$('#bargainprice').attr("checked","");
			}
			if("1"==data.bean.salestate){
				$('#salestate').attr("checked","checked");
			}else{
				$('#salestate').attr("checked","");
			}
			if("1"==data.bean.ismobileplatformgoods){
				$('#ismobileplatformgoods').attr("checked","checked");
			}else{
				$('#ismobileplatformgoods').attr("checked","");
			}
            //填充虚拟标记
            if("1"==data.bean.isvirtual){
                $('#isvirtual').attr("checked","checked");
            }else{
                $('#isvirtual').attr("checked","");
            }
            $("#virtualresults").val(data.bean.virtualresults);
			$('#keywordname').val(data.bean.keywordid);
			$('#metaKeywords').val(data.bean.metaKeywords);
			$('#metaDescription').val(data.bean.metaDescription);
			KE.html("detail", data.bean.detail);
			//图片显示
			var pcpath="";
			var pcurl=data.bean.pictureurl;
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
			$('#isSpecificationsOpen').val(data.bean.isSpecificationsOpen);
			if("1"==data.bean.isSpecificationsOpen){
				$.post("findAllProductTByGoodsid.action",{"goodsid":data.bean.goodsid},function(data){
					if(data.sucflag){
						getIdforradom();
						var html="";
						var sarray=new Array();
						$.each(data.beanlist,function(index,value){
							if(value.isDefault=="1"){
								var str="<td><input id='isDefault' name='isDefault' value='1' type='checkbox' checked='true' onclick='checkisDefault()' class='productv'/></td>";
							}else{
								var str="<td><input id='isDefault' name='isDefault' value='0' type='checkbox' onclick='checkisDefault()' class='productv'/></td>";	
							}
							if(value.isSalestate){
								var str1="<td><input id='isSalestate"+rid+"' name='isSalestate"+rid+"' value='1' checked='true'  class='productv' type='checkbox' checked/></td>";
							}else{
								var str1="<td><input id='isSalestate"+rid+"' name='isSalestate"+rid+"' value='0' class='productv'  type='checkbox' checked/></td>";	
							}
							sarray=value.specificationsValue.split("=");
							var temp="<select class='productv' id='pst' name='pst'>";
		           			var temp1="</select>";
		           			var htmlselect="";
		           			var strvalue1="";
							for(var i=0;i<sarray.length-1;i++){
								 var htmlJson=$.parseJSON(sarray[i]);
		           				 htmlselect="<option name='specificationsid' value='"+htmlJson.id+","+htmlJson.attributelist+","+htmlJson.sort+","+htmlJson.specificationsid+"'>"+htmlJson.goodsattributename+"</option>";
		           				 strvalue1+=temp+htmlselect+temp1;	
							}
							
							
							html+="<tr id='"+value.productid+"'>"+
							"<td><input id='productSn"+rid+"' name='productSn"+rid+"' value='"+value.productSn+"' type='text' class='productv'/></td>"+
							"<td>"+strvalue1+"</td>"+
							"<td><input id='saleprice"+rid+"' name='saleprice"+rid+"' value='"+value.saleprice+"' type='text' class='productv'/></td>"+
							"<td><input id='memberprice"+rid+"' name='memberprice"+rid+"' value='"+value.memberprice+"' type='text' class='productv'/></td>"+
							"<td><input id='price"+rid+"' name='price"+rid+"' value='"+value.price+"' type='text' class='productv'/></td>"+
							"<td><input id='cost"+rid+"' name='cost"+rid+"' value='"+value.cost+"' type='text' class='productv'/></td>"+
							"<td><input id='weight"+rid+"' name='weight"+rid+"' value='"+value.weight+"' type='text' class='productv'/></td>"+
							"<td><input id='store"+rid+"' name='store"+rid+"' value='"+value.store+"' type='text' class='productv'/></td>"+
							"<td><input id='freezeStore"+rid+"' name='freezeStore"+rid+"' value='"+value.freezeStore+"' type='text' class='productv'/></td>"+
							"<td><input id='placeStore"+rid+"' name='placeStore"+rid+"' value='"+value.placeStore+"'  type='text' class='productv'/></td>"+
							"<td><input id='warehouseLocation"+rid+"' name='warehouseLocation"+rid+"' value='"+value.warehouseLocation+"' type='text' class='productv' /></td>"+
							str+
							str1+
							"<td><input id='delbutton"+rid+"' name='delbutton"+rid+"' value='删除' type='button' class='productv' onClick='delParamPChild("+value.productid+")'/></td>"+
							"</tr>";
						});
						$('#addproductlistarea').append(html);
					}else{
						jAlert('读取货品失败', '信息提示');
						return false;
					}
				});	
			}
			if("0"!=data.bean.goodsTypeId){
				$('#goodsTypeId').val(data.bean.goodsTypeId);
				$.post("findGoodsAttributeTBygoodsTypeId.action",{"goodsTypeId":data.bean.goodsTypeId},function(data1){
					if(data1.sucflag){
						var gathtml="";
						var option="";
						var myoptionarray=new Array();
						if(data1.gatbeanlist!=null){
							$.each(data1.gatbeanlist,function(i,item){
								myoptionarray=item.attributelist.split(",");
								option="<option value='0'>---请选择---</option>";
								for(var j=0;j<myoptionarray.length;j++){
									option+="<option value='"+myoptionarray[j]+"'>"+myoptionarray[j]+"</option>";
								}
								gathtml+="<div class='field'>"+
								"<div class='label'>"+
								"<label for='select'>"+item.goodsattributename+"</label>"+
								"</div>"+
								"<div class='select'>"+
								"<select id='goodsAttrVal"+i+"' name='goodsAttrVal"+i+"'>"+option+"</select>" +
								"</div>"+
								"</div>";
								option="";
							});
							$('#gat').append(gathtml);
							//设置商品属性
							$('#goodsAttrVal0').val(data.bean.goodsAttrVal0);
							$('#goodsAttrVal1').val(data.bean.goodsAttrVal1);
							$('#goodsAttrVal2').val(data.bean.goodsAttrVal2);
							$('#goodsAttrVal3').val(data.bean.goodsAttrVal3);
							$('#goodsAttrVal4').val(data.bean.goodsAttrVal4);
							$('#goodsAttrVal5').val(data.bean.goodsAttrVal5);
							$('#goodsAttrVal6').val(data.bean.goodsAttrVal6);
							$('#goodsAttrVal7').val(data.bean.goodsAttrVal7);
							$('#goodsAttrVal8').val(data.bean.goodsAttrVal8);
							$('#goodsAttrVal9').val(data.bean.goodsAttrVal9);
							$('#goodsAttrVal10').val(data.bean.goodsAttrVal10);
							$('#goodsAttrVal11').val(data.bean.goodsAttrVal11);
							$('#goodsAttrVal12').val(data.bean.goodsAttrVal12);
							$('#goodsAttrVal13').val(data.bean.goodsAttrVal13);
							$('#goodsAttrVal14').val(data.bean.goodsAttrVal14);
							$('#goodsAttrVal15').val(data.bean.goodsAttrVal15);
							$('#goodsAttrVal16').val(data.bean.goodsAttrVal16);
							$('#goodsAttrVal17').val(data.bean.goodsAttrVal17);
							$('#goodsAttrVal18').val(data.bean.goodsAttrVal18);
							$('#goodsAttrVal19').val(data.bean.goodsAttrVal19);
							$('#goodsAttrVal20').val(data.bean.goodsAttrVal20);
							$('#goodsAttrVal21').val(data.bean.goodsAttrVal21);
							$('#goodsAttrVal22').val(data.bean.goodsAttrVal22);
							$('#goodsAttrVal23').val(data.bean.goodsAttrVal23);
							$('#goodsAttrVal24').val(data.bean.goodsAttrVal24);
							$('#goodsAttrVal25').val(data.bean.goodsAttrVal25);
							$('#goodsAttrVal26').val(data.bean.goodsAttrVal26);
							$('#goodsAttrVal27').val(data.bean.goodsAttrVal27);
							$('#goodsAttrVal28').val(data.bean.goodsAttrVal28);
							$('#goodsAttrVal29').val(data.bean.goodsAttrVal29);
						}
						$.post("findGoodsParameter.action",{"goodsTypeId":data.bean.goodsTypeId},function(data2){
							if(data2.sucflag){
								var gatattrhtml="";
								var jsonstr=$.parseJSON(data2.bean.goodsParameter);
								$.each(jsonstr,function(k,s){
									gatattrhtml+="<div class='field'>"+
													"<div class='label'>"+
														"<label for='input-small'>"+s.name+"</label>"+
													"</div>"+
													"<div class='input'>"+
														"<input id='"+s.id+"' name='"+s.id+"' value='' class='small' type='text'></input>"+
													"</div>"+
												"</div>";
								});
								$('#gatattr').append(gatattrhtml);
								//var jsonstr=data.bean.goodsParameterValue.trim();
								//设置商品参数的值
								var jsonstr1=$.parseJSON("["+data.bean.goodsParameterValue.trim()+"]");
								$.each(jsonstr1,function(k,s){
									$('#'+s.id).val(s.value);
								});
							}
						});
					}
				});

			}
            //同步读取关联商品信息
            $.ajax({
                url:"findGoodsBelinkedBymaingoodsid.action",
                type:"post",
                data:{"maingoodsid":data.bean.goodsid},
                dataType:"json",
                async:false,
                success:function(data){
                    if(data.sucflag){
                        var jsonstr=$.parseJSON(data.bean.belinkedgoods);
                        var temp="";
                        $.each(jsonstr,function(i,v){
                            temp+="<option selected value='"+v.goodsid+"'>"+v.goodsname+"</option>"; 
                        });
                        $("#linkedgoodsselect").html(temp);
                    }
                }
            });
		}
		});
}


$(function(){
	$('#editcategory').toggle(function(){
		$('#categoryarea').show();
	},function(){
		$('#categoryarea').hide();
	}
	);
});
//当启用规格值时获取规格值列表

$(function(){
	$('#Specificationslistarea').hide();
	$('#addproductarea').hide();
	$('#isSpecificationsOpen').change(function(){
		var isSpecificationsOpen=$('#isSpecificationsOpen').val();
		if(isSpecificationsOpen=="1"){
			
			$.post("findAllSpecificationsforjson.action",function(data){
				if(data.specificationslist!=null){
					var sp=data.specificationslist;
					$("#Specificationslistarea").html(sp);
					sp="";
					return;
				}
			});
			$('#Specificationslistarea').show();
			$('#addproductarea').show();
		}else{
			$('#Specificationslistarea p').text("");
			$('#Specificationslistarea').hide();
			$('#addproductarea').hide();
		}
	});
	/**
	 * 增加货品异步获取规格参数形成table
	 */
	$('#addproduct').click(function(){
		getIdforradom();
		var html="<tr id='"+rid+"'>" +
				"<td><input id='productSn"+rid+"' name='productSn"+rid+"' value='' type='text' class='productv'/></td>"+
				"<td>"+strvalue+"</td>"+
				"<td><input id='saleprice"+rid+"' name='saleprice"+rid+"' value='' type='text' class='productv'/></td>"+
				"<td><input id='memberprice"+rid+"' name='memberprice"+rid+"' value='' type='text' class='productv'/></td>"+
				"<td><input id='price"+rid+"' name='price"+rid+"' value='' type='text' class='productv'/></td>"+
				"<td><input id='cost"+rid+"' name='cost"+rid+"' value='' type='text' class='productv'/></td>"+
				"<td><input id='weight"+rid+"' name='weight"+rid+"' value='' type='text' class='productv'/></td>"+
				"<td><input id='store"+rid+"' name='store"+rid+"' value='' type='text' class='productv'/></td>"+
				"<td><input id='freezeStore"+rid+"' name='freezeStore"+rid+"' value='' type='text' class='productv'/></td>"+
				"<td><input id='placeStore"+rid+"' name='placeStore"+rid+"' value=''  type='text' class='productv'/></td>"+
				"<td><input id='warehouseLocation"+rid+"' name='warehouseLocation"+rid+"' value='' type='text' class='productv'/></td>"+
				"<td><input id='isDefault' name='isDefault' value='1' type='checkbox'  class='productv' onclick='checkisDefault()'/></td>"+
				"<td><input id='isSalestate"+rid+"' name='isSalestate"+rid+"' value='1' class='productv'  type='checkbox' checked/></td>"+
				"<td><input id='delbutton"+rid+"' name='delbutton"+rid+"' value='删除' class='productv' type='button' onClick='delParamPChild("+rid+")'/></td>"+
				"</tr>";
		$('#addproductlistarea tbody').append(html);
	});
});
/**
 * 选择规格值增加表单数据
 */

function checkpstspecificationsid(){
	var $selectedspecifications= $("input[name='pstspecificationsid']");
	 $('#tempkey').text("");
	 var sum=0;
	 var tempkeyvalue="";
	 var strvalue1="";
	 var strvalue0="";
     strvalue="";
	 $selectedspecifications.each( function() {
		 if ($(this).attr("checked")){
        	 tempkeyvalue+=this.value;
        	 $('#tempkey').html(tempkeyvalue);
        	 $.ajax({
        		url:'findProductSpecificationsTByspecificationsid.action', 
        		type:"post",
        		data:{"specificationsid":this.id},
        		dataType:'json',
        		async:false,
        		success:function(data){
        			if(data.bean.specificationsType=='1'){
           			 var myspecarray=new Array();
           			 myspecarray=data.bean.specificationsValue.split("-");
           			 var temp="<select class='productv' id='pst' name='pst'>";
           			 var temp1="</select>";           			 
           			 var htmlselect="";
           			 
           			 for(var i=0;i<myspecarray.length;i++){
           				 var htmlJson=$.parseJSON(myspecarray[i]);
           				htmlselect+="<option name='specificationsid' value='"+htmlJson.id+","+htmlJson.attributelist+","+htmlJson.sort+","+data.bean.specificationsid+"'>"+htmlJson.goodsattributename+"</option>";
           			 }
           			 strvalue1=temp+htmlselect+temp1;
           		 }else{
           			 var myspecarray=new Array();
           			 myspecarray=data.bean.specificationsValue.split("-");
           			 var temp="<select  class='productv' id='pst' name='pst'>";
           			 var temp1="</select>";
           			 var htmlselect="";
           			 for(var i=0;i<myspecarray.length;i++){
           				 var htmlJson=$.parseJSON(myspecarray[i]);
           				htmlselect+="<option name='specificationsid' value='"+htmlJson.id+","+htmlJson.attributelist+","+htmlJson.sort+","+data.bean.specificationsid+"'>"+htmlJson.goodsattributename+"</option>";
           			 }
           			 strvalue0=temp+htmlselect+temp1;
           		 }
        			
        			  strvalue=strvalue1+strvalue0;
        		}
        	 });

         }
     });
}


/**
 * 关联商品处理部分
 */
$("#searchbelinkedgoods").click(function(){
    var navid= $('#navidbelinked').val();
    var ltypeid = $('#ltypeidbelinked').val();
    var stypeid = $('#stypeidbelinked').val();
    if("0"==navid&&"0"==ltypeid&&"0"==stypeid){
        jAlert('请选择分类后搜索', '信息提示');
        return false;
    }else{
        $.post("findAllGoodsBelinkedGoods.action",{"navid":navid,"ltypeid":ltypeid,"stypeid":stypeid},function(data){
            if(data.sucflag){
                //填充数据到页面
                var temp="";
                $.each(data.beanlist,function(i,v){
                    temp+="<option value='"+v.goodsid+"'>"+v.goodsname+"</option>";
                });
                $("#canbelinkedgoodsselect").html(temp);
            }else{
                jAlert('搜索异常','信息提示');
            }
        });
        
    }
    
});



