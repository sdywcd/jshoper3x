<#macro isDisabled comparePage>
<#if "${comparePage}"  == "${goods.pageNo}"><#t>
disabled="disabled" href="#"<#t>
<#else>
<#if "${sign}"=="disstatic">
    <#if "${comparePage}"  == "${goods.pageNo}"><#t>
    disabled="disabled" href="#"<#t>
    <#else>
    href="${actionlink}&page=${comparePage}" <#t>
    </#if>
<#else>

href="${sign}_${comparePage}.html"<#t>

</#if>

</#if>
</#macro>



<div id="filter">
    <div class="cls"></div>
    <div class="fore1">
        <dl class="order"><dt>排序：</dt>
        <dd class="curr"><a href="#">销量</a><b></b></dd>
        <dd><b></b><a href="#" rel="nofollow">价格</a><b></b></dd>
        <dd><a href="#" rel="nofollow">评论数</a><b></b></dd>
        <dd><a href="#" rel="nofollow">上架时间</a><b></b></dd>
    </dl>
    <div class="pagin pagin-m"><span class="text"><i>${goods.pageNo}</i>/${goods.bottomPages} <#t></span>
   <a <@isDisabled comparePage="${goods.previousPageNo}" />>上一页</a><#t>
       <a <@isDisabled comparePage="${goods.nextPageNo}" />>下一页</a> <#t>
    </div>
    <div class="total"><span>共<strong>${goods.totalRecord}</strong>个商品</span></div>
    <span class="clr"></span>
</div>
</div>