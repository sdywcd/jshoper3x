<html>
 <body>
 <div id="foot">
   <div class="servicepro1 mt7">
     <div class="servicepro1_t">
       <p> <img src="${basepath}/ui/default/images/servicepro_t_l.gif"> </p>
       <cite><img src="${basepath}/ui/default/images/servicepro_t_r.gif"> </cite> </div>
     <div class="servicepro1_c">
       <div class="servicepro1_l">
 	  <#if (footcategory??)&&(footcategory?size>0) >
 	    <#list footcategory as f> 
         <div class="service_z1">
           <h1>${f_index+1} . ${f.name}</h1>
           <#if (footerarticle??)&&(footerarticle?size>0) >
 		  <ul>
 		  <#list footerarticle as fa>
 			<#if f.articleCategoryTid==fa.articleCategoryTid>
 			
 			<li> <a href="${basepath}/${fa.htmlPath}" target="_blank">${fa.title}</a> </li>
 			<#if fa_index+1==5>
 			<#break/>
 			</#if>
 			</#if>
 		  </#list>
           </ul>
 		  </#if>
         </div>
 		</#list>
       </#if>
    
       </div>
       <div class="servicepro1_r"> <img src="${basepath}/ui/default/images/servicerightpic.gif"> </div>
     </div>
     <div class="servicepro1_b">
       <p> <img src="${basepath}/ui/default/images/servicepro_b_l.gif"> </p>
       <cite><img src="${basepath}/ui/default/images/servicepro_b_r.gif"> </cite> </div>
   </div>
   <div class="servicepro2" style="background: none repeat scroll 0% 0% rgb(248, 248, 248);">
     <div class="servicepro2_l" style="background: none repeat scroll 0% 0% rgb(248, 248, 248);"></div>
     <div class="servicepro2_1" style="background: none repeat scroll 0% 0% rgb(248, 248, 248);"> <img src="${basepath}/ui/default/images/servicepro_11.gif"> </div>
     <div class="servicepro2_2" style="background: none repeat scroll 0% 0% rgb(248, 248, 248);"> <img src="${basepath}/ui/default/images/servicepro_21.gif"> </div>
     <div class="servicepro2_4" style="background: none repeat scroll 0% 0% rgb(248, 248, 248);"> <img src="${basepath}/ui/default/images/servicepro_41.gif"> </div>
     <div class="servicepro2_3" style="background: none repeat scroll 0% 0% rgb(248, 248, 248);"> <img src="${basepath}/ui/default/images/servicepro_31.gif"> </div>
     <div class="servicepro2_r" style="background: none repeat scroll 0% 0% rgb(248, 248, 248);"></div>
   </div>
   <!-- 底部文字菜单 -->
   <div class="copyright">
     <p> <a href="http://www.ostocy.com" target="_blank">关于我们</a> | <a href="#" target="_blank">帮助中心</a> | <a href="#" target="_blank">联系我们</a> | <a href="#" target="_blank">合作伙伴</a> | <a href="#" target="_blank">友情链接</a> | <a href="#" target="_blank">人才招聘</a> </p>
     <span>沪ICP备09069935号<br>
     Copyright&#169;2000-2012 All Rights Reserved 欧斯塔克(上海) 版权所有</span> </div>
   <div class="link"> </div>
 </div>
 </body>
 </html>