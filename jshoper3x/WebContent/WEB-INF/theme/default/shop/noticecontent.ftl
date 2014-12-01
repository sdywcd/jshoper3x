<!DOCTYPE HTML>
<html>
<head>
    <title>${(jshopbasicinfo.jshopname)}</title>
    <meta name="Author" content="jshoper3x">
    <meta name="Copyright" content="jshoper3x">
    <meta http-equiv="expires" content="0">
    <#if (jshopbasicinfo.metaKeywords)! != "">
    <meta name="keywords" content="${jshopbasicinfo.metaKeywords}"/>
</#if>
<#if (jshopbasicinfo.metaDes)! != "">
<meta name="description" content="${jshopbasicinfo.metaDes}"/>
</#if>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<!--载入公共头文件-->
<#include "/WEB-INF/theme/default/shop/header.ftl">

  <section id="main">
    <div class="container_12">
 <div id="sidebar" class="grid_3">
      <#if (footcategory??)&&(footcategory?size>0) >
        <aside id="categories_nav">
         <h3>分类</h3>

         <nav class="left_menu">
          <ul>
           <#list footcategory as f>
           <#if f.position=="1">
           <li><a href="${basepath}/${f.htmlpath}">${f.name}</a></li>
           </#if>
           </#list>
          </ul>
         </nav><!-- .left_menu -->
        </aside><!-- #categories_nav -->
      </#if>
        <!-- <aside id="manufacturers">
         <h3>Archives</h3>

         <nav class="left_menu">
          <ul>
           <li><a href="#">August 2012</a></li>
           <li><a href="#">September 2012</a></li>
           <li><a href="#">October 2012</a></li>
           <li><a href="#">November 2012</a></li>
           <li class="last"><a href="#">December 2012</a></li>
          </ul>
         </nav>
        </aside>-->
 <#if (footcategory??)&&(footcategory?size>0) >
 
 <#if (footerarticle??)&&(footerarticle?size>0) >
       <aside id="tags">
         <h3>标签</h3>
          <#list footcategory as f>
          <#list footerarticle as fa>
          <#if (f.articleCategoryTid==fa.navid)&&fa.isnotice=="1">
            <a class="t${fa_index}" href="${basepath}/${fa.htmlPath}" target="_blank">${fa.title}</a>
          </#if>
          </#list>
 </#list>
        </aside><!-- #tags -->
        </#if>
       
        </#if>
       </div><!-- .sidebar -->
   
    <div id="content" class="grid_9">
 <article class="post view_post">
  <#if (article??)>

        <h1 class="post_title">${article.title}</h1>
        <cite>${article.createtime} 来源：${article.author}</cite> 
      <div class="content_article">
        ${article.contentvalue}
      </div>

  <div class="clear"></div>
  </#if>
</article>
</div>
    </div>

  </section>
  

  <div class="clear"></div>

<#include "/WEB-INF/theme/default/shop/footer.ftl">

</body>

</html>