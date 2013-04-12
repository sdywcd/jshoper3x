/**
 * Global variables
 */
var session = "true";
/*
 * ===========================================Gorgeous
 * split-line==============================================
 */
/**
 * ui
 */
$(function() {

	$("h6").each(function() {
		$(this).removeClass("selected");
	});
	$("ul").each(function() {
		$(this).removeClass("opened");
		$(this).addClass("closed");
	});
	$("#h-menu-member").addClass("selected");
	$("#menu-member").removeClass("closed");
	$("#menu-member").addClass("opened");
});
/*
 * ===========================================Gorgeous
 * split-line==============================================
 */
/**
 * Required to initialize the page data
 */
$(function() {
	$('#gradevalue').change(function() {
		var gradevalue = $("#gradevalue").val();
		if (gradevalue == "0") {
			return false;
		}
		var gradename = $("#gradevalue").find("option:selected").text();
		$('#gradename').attr("value", gradename);

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

	$("#grademanagement").flexigrid( {
		url : 'findAllGrade.action',
		dataType : 'json',
		cache : false,
		colModel : [ {
			display : '等级名称',
			name : 'gradename',
			width : 315,
			sortable : true,
			align : 'center'
		}, {
			display : '购物金额要求',
			name : 'needcost',
			width : 315,
			sortable : true,
			align : 'center'
		}, {
			display : '折扣',
			name : 'discount',
			width : 115,
			sortable : true,
			align : 'center'
		}, {
			display : '创建时间',
			name : 'createtime',
			width : 214,
			sortable : true,
			align : 'center'

		}, {
			display : '创建者编号',
			name : 'creatorid',
			width : 200,
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
		title : '会员等级列表',
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
		if (com == '编辑') {
			if ($('.trSelected', grid).length ==1) {
				jConfirm('确定编辑此项吗?', '信息提示', function(r) {
					if (r) {
						var str =$('.trSelected', grid)[0].id.substr(3);
						window.location.href="addgrade.jsp?session="+session+"#member&gradeid="+str;
                        return;
					}
				});
				return;
			} else {
				jAlert('请选择一条信息', '信息提示');
                return false;
			}

		}else if(com=="添加"){
            window.location.href="addgrade.jsp?session="+session+"#member";
            return;
        }else if(com=="删除"){
            if ($('.trSelected', grid).length > 0) {
                jConfirm('确定删除此项吗?', '信息提示', function(r) {
                    if (r) {
                        var str = "";
                        $('.trSelected', grid).each(function() {
                            str += this.id.substr(3) + ",";
                        });
                        $.post("delGradet.action", {
                            "gradeid" : str
                        }, function(data) {
                            $('#grademanagement').flexReload();
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
/*
 * ===========================================Gorgeous
 * split-line==============================================
 */
/**
 * Add Function
 */
$(function(){
    $("#submit").click(function(){
        var gradename = $("#gradename").val();
        var needcost = $("#needcost").val();
        var discount = $("#discount").val();
        var regnotascii = /^[\x00-\xff]$/g ;  //两个字节的字符
        var regunexpect = /[^a-zA-Z0-9\u4e00-\u9fa5_]/g; //中文英文数字都下划线ok
        var regvalue = /^[1-9][\d]{1,8}\.[\d]{1,2}|(^0\.)[\d]{1,2}/;//匹配积分10位,两位小数
        var regdiscount = /(^0\.)[\d]{1,2}|1\.([0]{1,2})/; //匹配积分10位,两位小数
        if(gradename){
        	if(gradename.match(regunexpect)){
        		jAlert('等级名可以以"中文英文数字下划线的组合"','信息提示');
        		return false;
        	}
        	var gnamelength = 0;
        	for(var i=0;i<gradename.length;i++)
        		{
        			var curcode = gradename.substring(i,1); 
        			if(regnotascii.test(curcode)) 
        				{
        					gnamelength += 2;
        				}
        			else{
        					gnamelength++;
        			}
        		}
        	if(gnamelength > 45){
        		jAlert('字符串不能大于50','信息提示');
        		return false;
        	}
        }else{
        	jAlert('等级名字不能为空','信息提示');
        	return false;
        }
        if(!regvalue.test(needcost)){
        	jAlert('所需积分是10位,两位小数','信息提示');
        	return false;
        }
        if(!regdiscount.test(discount)){
        	jAlert('折扣格式不正确','信息提示');
        	return false;
        }
        
        $.post("addGradet.action",{
            "gradename":gradename,
            "needcost":needcost,
            "discount":discount
        },function(data){
            if(data.sucflag){
                window.location.href="grademanagement.jsp?session="+session+"#member";
            }
        });
    });
});
/*
 * ===========================================Gorgeous
 * split-line==============================================
 */
/**
 * Update Function
 */

// 点击编辑更新内容
$(function() {
    var gradeid=$.query.get("gradeid");
    if(gradeid==""){
        return false;
    }
    $.post("findGradeById.action",{"gradeid":gradeid},function(data){
        if(data.sucflag){
            $("#gradename").val(data.bean.gradename);
            $("#needcost").val(data.bean.needcost);
            $("#discount").val(data.bean.discount);
            $("#gradeid").val(data.bean.gradeid);
            $("#editgrade").show();
            $("#submit").hide();
        }
    });
    
	$("#editgrade").click(function() {
		var gradename = $("#gradename").val();
        var needcost = $("#needcost").val();
        var discount = $("#discount").val();
		var gradeid = $("#gradeid").val();
        var regnotascii = /^[\x00-\xff]$/g ;  //两个字节的字符
        var regunexpect = /[^a-zA-Z0-9\u4e00-\u9fa5_]/g; //中文英文数字都下划线ok
        var regvalue = /^[1-9][\d]{1,8}\.[\d]{1,2}|(^0\.)[\d]{1,2}/;//匹配积分10位,两位小数
        var regdiscount = /(^0\.)[\d]{1,2}|1\.([0]{1,2})/; //匹配积分10位,两位小数
        if(gradename){
        	if(gradename.match(regunexpect)){
        		jAlert('等级名可以以"中文英文数字下划线的组合"','信息提示');
        		return false;
        	}
        	var gnamelength = 0;
        	for(var i=0;i<gradename.length;i++)
        		{
        			var curcode = gradename.substring(i,1); 
        			if(regnotascii.test(curcode)) 
        				{
        					gnamelength += 2;
        				}
        			else{
        					gnamelength++;
        			}
        		}
        	if(gnamelength > 45){
        		jAlert('字符串不能大于50','信息提示');
        		return false;
        	}
        }else{
        	jAlert('等级名字不能为空','信息提示');
        	return false;
        }
        if(!regvalue.test(needcost)){
        	jAlert('所需积分是10位,两位小数','信息提示');
        	return false;
        }
        if(!regdiscount.test(discount)){
        	jAlert('折扣格式不正确','信息提示');
        	return false;
        }
        
		$.post("UpdateGradeById.action", {
			"gradeid" : gradeid,
			"gradename" : gradename,
			"needcost" : needcost,
			"discount" : discount
		}, function(data) {
			 if(data.sucflag){
                window.location.href="grademanagement.jsp?session="+session+"#member";
            }
		});
	});
});
/*
 * ===========================================Gorgeous
 * split-line==============================================
 */
