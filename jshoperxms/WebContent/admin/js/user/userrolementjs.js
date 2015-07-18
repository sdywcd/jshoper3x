
$(function(){

	/**
	 * 获取角色列表
	 */
	findUserRole=function(){
		
		var userid=$.query.get('userid');
		if(userid==""){
			return false;
		}
		$.post("findAllRoleForSelect.action", function(data) {
			if (data.sucflag) {
				$('#roleid').append(data.rolestr);	
			}
		});
	},
	/**
	 * 设置会员角色
	 */
	addUserRoleM=function(){
		var userid=$.query.get('userid');
		if(userid==""){
			return false;
		}
		var roleid=$("#roleid").val();
		if(roleid=="0"){
			formwarning("#alerterror", "请选择角色");
			return false;
		}
        var rolemname=$('#roleid').find("option:selected").text();
		
		$.post("addUserRoleM.action",{"userid":userid,"roleid":roleid},function(data){
			if(data.sucflag){
                $.post("updateUserRoleMByuserid.action",{"userid":userid,"roleid":roleid,"rolemname":rolemname},function(data){
                    if(data.sucflag){
                    	formwarning("#alertinfo", "角色设置成功");
            			return true;
                    }         
                });
				
			}
		});
	},
	$("#submit").click(function(){
		addUserRoleM();
	});
	
	
  	/**
	 * main logic
	 */
	var operate = $.query.get("operate");
	if (operate == "add") {
		findUserRole();
	}else if(operate=="edit"){
		findUserRole();
	}else if(operate=="find"){
		
	}
});
