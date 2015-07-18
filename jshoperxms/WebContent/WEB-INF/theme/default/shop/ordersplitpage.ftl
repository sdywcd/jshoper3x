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
  
    <div class="pagin pagin-m"><span class="text"><i>${goods.pageNo}</i>/${goods.bottomPages} <#t></span>
   <a <@isDisabled comparePage="${goods.previousPageNo}" />>上一页</a><#t>
       <a <@isDisabled comparePage="${goods.nextPageNo}" />>下一页</a> <#t>
    </div>
    <div class="total"><span>共<strong>${goods.totalRecord}</strong>个待处理</span></div>
    <span class="clr"></span>
</div>
</div>