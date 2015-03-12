
$(function(){
	/**
	 * 根据id获取会员等级信息
	 */
	findMemberGradeTById=function(){
		var id=$.query.get("id");
	    if(id==""){
	        return false;
	    }
	    $.post("findMemberGradeTById.action",{"id":id},function(data){
	        if(data.sucflag){
	            $("#hid").val(data.bean.id);
	            $("#type").val(data.bean.type);
	            $("#name").val(data.bean.name);
	            $("#start").val(data.bean.start);
	            $("#end").val(data.bean.end);
	            $("#increment").val(data.bean.increment);
	            $("#multiplypower").val(data.bean.multiplypower);
	            $("#mpchangepower").val(data.bean.mpchangepower);
	            if(data.bean.mpstate=="1"){
					$("input[name='mpstate']").get(0).checked=true;
				}else{
					$("input[name='mpstate']").get(1).checked=true;
				}
	            $("#discount").val(data.bean.discount);
	            $("#update").show();
	            $("#submit").hide();
	        }
	    });
	},
	/**
	 * 更新会员等级信息
	 */
	updateMemberGradeTById=function(){
		var id=$("#hid").val();
		var type = $("#type").val();
        var name = $("#name").val();
        if(""==name){
        	forminfo("#alertinfo", "请填写等级名称");
            return false;
        }
        var start=$("#start").val();
        if(""==start){
        	forminfo("#alertinfo", "请填写等级范围开始值");
            return false;
        }
        var end=$("#end").val();
        if(""==end){
        	forminfo("#alertinfo", "请填写等级范围结束值");
            return false;
        }
        var increment=$("#increment").val();
        if(""==increment){
        	forminfo("#alertinfo", "请填写增量");
            return false;
        }
        var multiplypower=$("#multiplypower").val();
        var mpchangepower=$("#mpchangepower").val();
        var discount = $("#discount").val();
        var mpstate=$("input[name='mpstate']:checked").val();
        $.post("updateMemberGradeTById.action",{
        	"id":id,
            "type":type,
            "name":name,
            "start":start,
            "end":end,
            "increment":increment,
            "multiplypower":multiplypower,
            "discount":discount,
            "mpstate":mpstate
        },function(data){
            if(data.sucflag){
                window.location.href="membergradement.jsp?operate=find&folder=member";
            }
        });
	},
	/**
	 * 增加会员等级信息
	 */
	addMemberGradeT=function(){
		var type = $("#type").val();
        var name = $("#name").val();
        if(""==name){
        	forminfo("#alertinfo", "请填写等级名称");
            return false;
        }
        var start=$("#start").val();
        if(""==start){
        	forminfo("#alertinfo", "请填写等级范围开始值");
            return false;
        }
        var end=$("#end").val();
        if(""==end){
        	forminfo("#alertinfo", "请填写等级范围结束值");
            return false;
        }
        var increment=$("#increment").val();
        if(""==increment){
        	forminfo("#alertinfo", "请填写增量");
            return false;
        }
        var multiplypower=$("#multiplypower").val();
        var mpchangepower=$("#mpchangepower").val();
        var discount = $("#discount").val();
        var mpstate=$("input[name='mpstate']:checked").val();
        $.post("addMemberGradeT.action",{
            "type":type,
            "name":name,
            "start":start,
            "end":end,
            "increment":increment,
            "multiplypower":multiplypower,
            "mpchangepower":mpchangepower,
            "discount":discount,
            "mpstate":mpstate
        },function(data){
            if(data.sucflag){
                window.location.href="membergradement.jsp?operate=find&folder=member";
            }
        });
	},

	
	/**
	 * 查询所有会员等级
	 */
	findAllMemberGradeT=function(){
		$("#membergrademanagement").flexigrid( {
			url : 'findAllMemberGradeT.action',
			dataType : 'json',
			cache : false,
			colModel : [ {
				display : '等级类型',
				name : 'type',
				width : 100,
				sortable : true,
				align : 'center'
			}, {
				display : '等级名称',
				name : 'name',
				width : 100,
				sortable : true,
				align : 'center'
			}, {
				display : '折扣',
				name : 'discount',
				width : 100,
				sortable : true,
				align : 'center'
			}, {
				display : '该等级开始值',
				name : 'start',
				width : 100,
				sortable : true,
				align : 'center'

			},{
				display : '该等级结束值',
				name : 'end',
				width : 100,
				sortable : true,
				align : 'center'

			},{
				display : '增量',
				name : 'increment',
				width : 100,
				sortable : true,
				align : 'center'

			},{
				display : '倍率',
				name : 'multiplypower',
				width : 100,
				sortable : true,
				align : 'center'
			},{
				display : '积分兑换比率(1:x)',
				name : 'mpchangepower',
				width : 150,
				sortable : true,
				align : 'center'
			},{
				display : '倍率状态',
				name : 'mpstate',
				width : 100,
				sortable : true,
				align : 'center'
			},{
				display : '创建时间',
				name : 'createtime',
				width : 150,
				sortable : true,
				align : 'center'
			},{
				display : '创建人',
				name : 'creatorid',
				width : 100,
				sortable : true,
				align : 'center'
			},{
				display : '操作',
				name : 'operate',
				width : 100,
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
			title : '',
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
				var str =$('.trSelected', grid)[0].id.substr(3);
				window.location.href="membergrade.jsp?operate=edit&folder=member&id="+str;
                return;
				} else {
					forminfo("#alertinfo", "请选择一条信息");
	                return false;
				}
			}else if(com=="添加"){
	            window.location.href="membergrade.jsp?operate=add&folder=member";
	            return;
	        }else if(com=="删除"){
	        	var str="";
				$(".trSelected td:nth-child(2) div", $('#membergrademanagement')).each(function(i){
					str+=this.innerHTML+"  ";
				});
				$("#contentp").text(str);
				$("#delModal").modal({
					keyboard:true,
					show:true,
				});
				$("#btnok").click(function(){
					var str = "";
					$('.trSelected', grid).each(function() {
						str += this.id.substr(3) + ",";
					});
					$.post("delMemberGradeT.action", {
						"id" : str
					}, function(data) {
						if (data.sucflag) {
							$("#delModal").modal('hide');
							$('#membergrademanagement').flexReload();
							forminfo("#alertinfo", "删除成功");
						}
					});
				});
				$("#btnclose").click(function(){
					$("#delModal").modal('hide');
				});
				
	            } else {
	            	formwarning("#alerterror", "请选择要删除的信息");
					return false;
	            }
	        }
		}
	
	
	$("#submit").click(function(){
		addMemberGradeT();
	});
	$("#update").click(function(){
		updateMemberGradeTById();
	});
	
	
	var operate= $.query.get("operate");
	if(operate=="add"){
		
	}else if(operate=="edit"){
		findMemberGradeTById();
	}else if(operate=="find"){
		findAllMemberGradeT();
	}
	
});

