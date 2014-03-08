<td width="202" valign="top"><table width="198" border="0" cellpadding="0" cellspacing="0">
    <tbody>
      <tr>
        <td width="202" height="110" background="${basepath}/ui/default/images/bz_3.jpg">&nbsp;</td>
      </tr>
	  <#if (footcategory??)&&(footcategory?size>0) >
	    <#list footcategory as f> 
      <tr>
        <td width="202" height="33" background="${basepath}/ui/default/images/daohangt.jpg">　　　<span class="STYLE15">${f_index+1} . ${f.name}</span></td>
      </tr>
	  <#if (footerarticle??)&&(footerarticle?size>0) >
      <tr>
        <td width="202" style="background:url(${basepath}/ui/default/images/bz_15.gif) repeat-y;padding:5px 0;">
		 <#list footerarticle as fa>
			<#if f.articleCategoryTid==fa.articleCategoryTid>
			<p align="left" class="STYLE2" style="padding:6px 0 6px 36px;"><a href="${basepath}/${fa.htmlPath}">${fa.title}</a></p>
			</#if>
		</#list>
		</td>
      </tr>
	  </#if>
    	</#list>
      </#if>
   
      <tr>
        <td width="202" height="13" valign="top"><img src="${basepath}/ui/default/images/bzb_9.jpg" width="202" height="13"></td>
      </tr>
    </tbody>
  </table></td>
