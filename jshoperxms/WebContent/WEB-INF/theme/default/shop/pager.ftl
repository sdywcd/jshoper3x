<#macro isDisabled comparePage>
    <#if "${comparePage}"  == "${goods.pageNo}"><#t>
        disabled="disabled" href="#"<#t>
    <#else>
        href="searchGoodsByGoodsName.action?topKeywords=${topKeywords}&page=${comparePage}"<#t>
    </#if>
</#macro>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
	.button_myway3{
	background:#ffffff;
    border: 1px solid #fb7510;
    color: #000;
    font-size: 12px;
    font-weight: lighter;
    height: 20px;
	}
		.button_myway4{
	background:#ffffff;
    border: 1px solid #fb7510;
    color: #000;
    font-size: 12px;
    font-weight: lighter;
    height: 20px;
    width:20px;
	}
</style>
 <body>
 <center>
<a <@isDisabled comparePage="1" />>首页</a> <#t>
<a <@isDisabled comparePage="${goods.previousPageNo}" />>上一页</a> <#t>
<a <@isDisabled comparePage="${goods.nextPageNo}" />>下一页</a> <#t>
<a <@isDisabled comparePage="${goods.bottomPages}" />>尾页</a> <#t>
${goods.pageNo}/${totalpage} <#t>
共${totalgoods}条记录


 </body>
</html>