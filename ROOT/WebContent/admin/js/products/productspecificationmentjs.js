/**
 * Global variables
 */
var session ="true";
var rid = "";
var globalrjson = "";//post json data to backstage server
/*===========================================Gorgeous split-line==============================================*/
/**
 * Function
 */

/*
 * To obtain random rid
 */
function getIdforradom() {
	var myDate = new Date();
	rid = myDate.getSeconds().toString() + myDate.getMilliseconds().toString();
}
/*
 * Delete Page elements According to rid 
 */
function delParamPChild(rid) {
	$('#add' + rid).remove();

}

function createUploader(rid){ 
    var uploader = new qq.FileUploader({
        element: document.getElementById("uploadguigepc"+rid),
        action: 'ajaxFileUploads.action',
        debug: true,
        minSizeLimit:1024,
        sizeLimit: 1073741824,
        allowedExtensions: ['jpeg','jpg','gif','png'],
        onComplete: function(id, fileName, responseJSON){
		var pcpath=responseJSON.success;
		var htm="<img class='attribute' style='width:100px;height:100px' name='showguigepc"+rid+"' id='"+id+"' src='../../.."+pcpath+"' rel='#"+fileName+"'/>"
		$("#showguigepc"+rid).html(htm);
        },
      
    });           
}

/*===========================================Gorgeous split-line==============================================*/


/**
 * Required to initialize the page data
 */
/**
 * 切换规格值类型
 */
$(function() {
	$('#selectcolordiv').hide();
	$('#specificationsType').change(function() {
		var specificationsType = $('#specificationsType').val();
		if (specificationsType == "1") {
			var attributelists = "attributelists";
			$('#selectcolordiv').hide();
			$(".attribute").each(function() {
				if (this.name.substring(0, 14) == attributelists) {
					this.disabled = true;
				}
			});
		} else {
			var attributelists = "attributelists";
			$('#selectcolordiv').show();
			$(".attribute").each(function() {
				if (this.name.substring(0, 14) == attributelists) {
					this.disabled = false;
				}
			});
		}
	});
});
/*===========================================Gorgeous split-line==============================================*/

/**
 * flexigrid list 
 */
$(function() {
	$("#productspecificationmanagement").flexigrid( {
		url : 'findAllProductSpecificationsT.action',
		dataType : 'json',
		colModel : [{
			display : '规格名称',
			name : 'name',
			width : 315,
			sortable : true,
			align : 'center'
		}, {
			display : '规格类型',
			name : 'specificationsType',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '规格值列表',
			name : 'specificationsValue',
			width : 415,
			sortable : true,
			align : 'center'
		}, {
			display : '排序',
			name : 'sort',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '创建时间',
			name : 'createtime',
			width : 300,
			sortable : true,
			align : 'center'
		} ],
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
			bclass : 'delete',
			onpress : action
		}, {
			separator : true
		} ],
		searchitems : [ {
			display : '请选择搜索条件',
			name : 'sc',
			isdefault : true
		} ],
		sortname : "createtime",
		sortorder : "desc",
		usepager : true,
		title : '商品规格列表',
		useRp : true,
		rp : 20,
		rpOptions : [ 5, 20, 40, 100 ],
		showTableToggleBtn : true,
		width : 'auto',
		height : 'auto',
		pagestat : '显示{from}到{to}条，共{total}条记录',
		procmsg : '正在获取数据，请稍候...',
		checkbox : true
	});

	function action(com, grid) {
		if (com == '添加') {
			window.location.href = "addproductspecification.jsp?session="+session+"#goods";
			return;
		} else if (com == '编辑') {
			if ($('.trSelected', grid).length == 1) {
				jConfirm('确定编辑此项吗?', '信息提示', function(r) {
					if (r) {
						var str = $('.trSelected', grid)[0].id.substr(3);
						window.location.href = "addproductspecification.jsp?session="+session+"#goods&specificationsid=" + str;
						return;
					}
				});
			} else {
				jAlert('请选择一条信息', '信息提示');
				return false;
			}
		} else if (com = '删除') {
			if ($('.trSelected', grid).length > 0) {
				jConfirm('确定删除此项吗?', '信息提示', function(r) {
					if (r) {
						var str = "";
						$('.trSelected', grid).each(function() {
							str += this.id.substr(3) + ",";
						});
						$.post("delProductSpecification.action", {
							"specificationsid" : str
						}, function(data) {
							$('#productspecificationmanagement').flexReload();
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
/*
 * 增加产品规格值
 */
$(function() {
	$('#addparam').click(function() {
		getIdforradom();
		var html = "<tr id='add"+rid+"'>"
		+ "<td class='title'><div class='form'><div class='fields'><div class='field field-first'><div class='typeinput'><input class='attribute' id='paramlistname"+rid+"' name='paramlistname"+rid+"' value='' type='text'/></div></div></div></div></td>" 
		+ "<td class='paraminput'><div class='form'><div class='fields'><div class='field field-first'><div class='typeinput'><div style='display:none;' id='uploadguigepc"+rid+"'></div><input class='attribute' id='attributelists"+rid+"' name='attributelists"+rid+"' type='text' value=''/></div></div></div></div></td>"
		+ "<td class='paraminput'><div class='form'><div class='fields'><div class='field field-first'><div class='typeinput'><div id='showguigepc"+rid+"' style='width:100px;height:100px;'></div></div></div></div></div></td>"
		+ "<td class='paraminput'><div class='form'><div class='fields'><div class='field field-first'><div class='typeinput'><input class='attribute' id='paramlistsort"+rid+"' name='paramlistsort"+rid+"' type='text' value='' /></div></div></div></div></td>"
		+ "<td class='paraminput'><div class='form'><div class='fields'><div class='field field-first'><div class='typeinput'><input  class='attribute' id='delbutton"+rid+"' name='delbutton"+rid+"' type='button' value='删除' onClick='delParamPChild("+rid+")'/></div></div></div></div></td>" + "</tr>";
		$('.table tbody').append(html);

		var specificationsType = $('#specificationsType').val();
		if (specificationsType == "1") {
			var attributelists = "attributelists";
			$('#selectcolordiv').hide();
			$(".attribute").each(function() {
				if (this.name.substring(0, 14) == attributelists) {
					this.disabled = true;
				}
			});
		} else if(specificationsType=="2"){
			var attributelists = "attributelists";
			$('#selectcolordiv').show();
			$(".attribute").each(function() {
				if (this.name.substring(0, 14) == attributelists) {
					this.disabled = false;
					this.style.display="none";//隐藏显示上传组件
					$("#uploadguigepc"+rid).show();
					createUploader(rid);
					
					
				}
			});
		}

	});

	$('#submit').click(function() {
		var name = $('#name').val();
		if (name == "") {
			jAlert('规格名称必须填写', '信息提示');
			return false;
		}
		var note = $('#note').val();
		var sort1 = $('#sort').val();
		var specificationsType = $('#specificationsType').val();
		var paramlistname = "paramlistname";
		var attributetype = "attributetype";
		var attributelists = "attributelists";
		var paramlistsort = "paramlistsort";
		var showguigepc="showguigepc";
		var delbutton = "delbutton";
		var goodsattributename;
		var attributeType;
		var attributelist;
		var sort;
		var attributeIndex = 1;
		var addflag = 0;
		var sucflag = false;
		var sub = "";
		var rjson = "";
		var id = "";
		var disflag=false;
		$(".attribute").each(function() {
			if (this.name.substring(0, 13) == paramlistname) {
				if (this.value == "") {
					jAlert('规格值名称必须填写', '信息提示');
					return false;
				}
				id = this.name.substring(13, this.name.length);
				goodsattributename = this.value;
				addflag = 1;
			}
			if (this.name.substring(0, 14) == attributelists) {
				if (this.disabled) {
					disflag=true;
					attributelist = this.value;
					addflag = 3;
				} else {
					disflag=false;
					attributelist = this.value;
					addflag = 3;
				}

			}
			if(this.name.substring(0,11)==showguigepc){
				if(!disflag){
					attributelist = this.src;
					addflag = 3;
				}
			}
			if (this.name.substring(0, 13) == paramlistsort) {
				if (this.value == "") {
					this.value=0;
					//jAlert('商品属性排序必须填写', '信息提示');
					addflag = 4;
				}
				sort = this.value;
				addflag = 4;
			}
			if (this.name.substring(0, 9) == delbutton) {
				if (addflag == 4) {
					sub += "{\"id\":\"" + id + "\",\"goodsattributename\":\"" + goodsattributename + "\",\"attributelist\":\"" + attributelist + "\",\"sort\":\"" + sort + "\"}-";
					addflag = 0;
					goodsattributename = "";
					attributeType = "";
					attributelist = "";
					id = "";
					sort = "";
				}
			}
		});
		rjson = sub.toString().substring(0, sub.length - 1);

		$.post("addProductSpecification.action", {
			"name" : name,
			"sort" : sort1,
			"specificationsType" : specificationsType,
			"specificationsValue" : rjson,
			"note" : note
		}, function(data) {
			if (data.sucflag) {
				sucflag = true;
				window.location.href = "productspecificationmanagement.jsp?session=" + session + "#goods";

			} else {
				sucflag = false;
			}
		});

	});
});

/**
 * Update Function
 */
/**
 * 根据id获取商品规格信息
 */
$(function() {
	var specificationsid = $.query.get('specificationsid');
	if (specificationsid == "") {
		return false;
	}
	$.post("findProductSpecificationsTByspecificationsid.action", {
		"specificationsid" : specificationsid
	}, function(data) {
		if (data.bean != null) {
			var html = "";
			var rid = "";
			$('#name').val(data.bean.name);
			$('#note').val(data.bean.note);
			$('#sort').val(data.bean.sort);
			$('#specificationsType').val(data.bean.specificationsType);
			$('#hidspecificationsid').val(data.bean.specificationsid);
			var jsonstr;
			var myarray = new Array();
			myarray = data.bean.specificationsValue.split('-');
			for ( var i = 0; i < myarray.length; i++) {
				jsonstr = $.parseJSON(myarray[i]);
				if(jsonstr!=null){
					if (data.bean.specificationsType == "1") {
						rid = jsonstr.id;
						html += "<tr id='add" + rid + "'>" 
						+ "<td class='title'><div class='form'><div class='fields'><div class='field field-first'><div class='typeinput'><input class='attribute' id='paramlistname" + rid + "' name='paramlistname" + rid + "' value='" + jsonstr.goodsattributename + "' class='small' type='text'/></div></div></div></div></td>" 
						+ "<td><div class='form'><div class='fields'><div class='field field-first'><div class='typeinput'><input class='attribute' id='attributelists" + rid + "' name='attributelists'" + rid + "' value='" + jsonstr.attributelist + "' type='text' disabled></input></div></div></div></div></td>"
						+ "<td><div class='form'><div class='fields'><div class='field field-first'><div class='typeinput'><input class='attribute' id='paramlistsort" + rid + "' name='paramlistsort" + rid + "' value='" + jsonstr.sort + "' type='text'/></div></div></div></div></td>"
						+ "<input type='hidden' class='attribute' id='paramattributeid' name='paramattributeid' value='" + jsonstr.goodsattributeid + "'></input>" 
						+ "<td><div class='form'><div class='fields'><div class='field field-first'><div class='typeinput'><input  class='attribute' id='delbutton" + rid+ "' name='delbutton" + rid + "' type='button' value='删除' onClick='delParamPChild(" + rid + ")'/></div></div></div></div></td>" + "</tr>";
					} else if(data.bean.specificationsType=="2"){
						rid = jsonstr.id;
						html += "<tr id='add" + rid + "'>" 
						+ "<td class='title'><div class='form'><div class='fields'><div class='field field-first'><div class='typeinput'><input class='attribute' id='paramlistname" + rid + "' name='paramlistname" + rid + "' value='" + jsonstr.goodsattributename + "' class='small' type='text'/></div></div></div></div></td>" 
						+ "<td><div class='form'><div class='fields'><div class='field field-first'><div class='typeinput'><div style='display:none;' id='uploadguigepc"+rid+"'></div><input style='display:none;' class='attribute' id='attributelists" + rid + "' name='attributelists'" + rid + "' value='" + jsonstr.attributelist + "' type='text'></input></div></div></div></div></td>"
						+ "<td class='paraminput'><div class='form'><div class='fields'><div class='field field-first'><div class='typeinput'><div id='showguigepc"+rid+"' style='width:100px;height:100px;'><img name='showguigepc"+rid+"' src='"+jsonstr.attributelist+"' class='attribute' style='width:100px;height:100px'/></div></div></div></div></div></td>"
						+ "<td><div class='form'><div class='fields'><div class='field field-first'><div class='typeinput'><input class='attribute' id='paramlistsort" + rid + "' name='paramlistsort" + rid + "' value='" + jsonstr.sort + "' type='text'/></div></div></div></div></td>"
						+ "<input type='hidden' class='attribute' id='paramattributeid' name='paramattributeid' value='" + jsonstr.goodsattributeid + "'></input>" 
						+ "<td><div class='form'><div class='fields'><div class='field field-first'><div class='typeinput'><input  class='attribute' id='delbutton" + rid+ "' name='delbutton" + rid + "' type='button' value='删除' onClick='delParamPChild(" + rid + ")'/></div></div></div></div></td>" + "</tr>";
						$("#uploadguigepc"+rid).show();
						//createUploader(rid);
					}
				}
			}
			var specificationsType = $('#specificationsType').val();
			if (specificationsType == "1") {
				$('#selectcolordiv').hide();
			} else {
				$('#selectcolordiv').show();
			}
			$('.table tbody').append(html);
			
		}
		// 显示修改按钮
		$('#modify').show();
		// $('#modifyparam').show();
		// 隐藏增加按钮
		$('#submit').hide();
		// $('#submitparam').hide();

	});

	// 更新商品属性，完善商品品牌处理
	/**
	 * 修改商品规格数据
	 */

	$('#modify').click(function() {
		var name = $('#name').val();
		if (name == "") {
			jAlert('规格名称必须填写', '信息提示');
			return false;
		}
		var specificationsid = $('#hidspecificationsid').val();
		var note = $('#note').val();
		var sort1 = $('#sort').val();
		var specificationsType = $('#specificationsType').val();
		var paramlistname = "paramlistname";
		var attributetype = "attributetype";
		var attributelists = "attributelists";
		var paramlistsort = "paramlistsort";
		var showguigepc="showguigepc";
		var delbutton = "delbutton";
		var goodsattributename;
		var attributeType;
		var attributelist;
		var sort;
		var attributeIndex = 1;
		var addflag = 0;
		var sucflag = true;
		var sub = "";
		var rjson = "";
		var id = "";
		var disflag=false;
		$(".attribute").each(function() {
			if (this.name.substring(0, 13) == paramlistname) {
				if (this.value == "") {
					jAlert('规格值名称必须填写', '信息提示');
					return false;
				}
				id = this.name.substring(13, this.name.length);
				goodsattributename = this.value;
				addflag = 1;
			}
			if (this.name.substring(0, 14) == attributelists) {
				if (this.disabled) {
					disflag=true;
					attributelist = this.value;
					addflag = 3;
				} else {
					disflag=false;
					attributelist = this.value;
					addflag = 3;
				}

			}
			if(this.name.substring(0,11)==showguigepc){
				if(!disflag){
					attributelist = this.src;
					addflag = 3;
				}
			}
			if (this.name.substring(0, 13) == paramlistsort) {
				if (this.value == "") {
					this.value=0;
					//jAlert('商品属性排序必须填写', '信息提示');
					addflag = 4;
				}
				sort = this.value;
				addflag = 4;
			}
			if (this.name.substring(0, 9) == delbutton) {
				if (addflag == 4) {
					sub += "{\"id\":\"" + id + "\",\"goodsattributename\":\"" + goodsattributename + "\",\"attributelist\":\"" + attributelist + "\",\"sort\":\"" + sort + "\"}-";
					addflag = 0;
					goodsattributename = "";
					attributeType = "";
					attributelist = "";
					id = "";
					sort = "";
				}
			}
		});

		if (sucflag == true) {
			rjson = sub.toString().substring(0, sub.length - 1);
			$.post("updateProductSpecification.action", {
				"specificationsid" : specificationsid,
				"name" : name,
				"sort" : sort1,
				"specificationsType" : specificationsType,
				"specificationsValue" : rjson,
				"note" : note
			}, function(data) {
				if (data.sucflag) {
					sucflag = true;
					window.location.href = "productspecificationmanagement.jsp?session=" + session+"#goods";
				} else {
					sucflag = false;
				}
			});
		} else {
			return false;
		}

	});
});




