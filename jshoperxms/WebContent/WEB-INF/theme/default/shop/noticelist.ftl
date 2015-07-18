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
        <div class="clear"></div>
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
                            <!-- #categories_nav -->
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
                                <!-- #banners -->
                            </div>
                            <!-- .sidebar -->
                            <div id="content" class="grid_9">
                                <#if article?exists>
                                <#list article.getList() as a>
                                <article class="post">
                                <h2 class="title_article">
                                <a href="${basepath}/${a.htmlPath}">${a.title}</a>
                                </h2>
                                <div class="content_article">
                                    <p>
                                 
                                    ${a.tipcontent}
                                    </p>
                                </div>
                                <!-- .content_article -->
                                <div class="footer_article">
                                    <div class="number_c"></div>
                                    <span>
                                    ${a.author}
                                    <time datetime="{a.createtime}">${a.createtime}</time>
                                    </span>
                                    |
                                    <span>
                                    来自
                                   ${a.nname}
                                    </span>
                                </div>
                                </article>
                                </#list>
                                </#if>
                               <!--  <div class="pagination">
                                    <ul>
                                        <li class="prev">
                                            <span>&#8592;</span>
                                        </li>
                                        <li class="curent">
                                            <a href="#">1</a>
                                        </li>
                                        <li>
                                            <a href="#">2</a>
                                        </li>
                                        <li>
                                            <a href="#">3</a>
                                        </li>
                                        <li>
                                            <a href="#">4</a>
                                        </li>
                                        <li>
                                            <a href="#">5</a>
                                        </li>
                                        <li>
                                            <span>...</span>
                                        </li>
                                        <li>
                                            <a href="#">100</a>
                                        </li>
                                        <li class="next">
                                            <a href="#">&#8594;</a>
                                        </li>
                                    </ul>
                                </div> -->
                                <!-- .pagination -->
                            </div>
                            <!-- #content -->
                            <div class="clear"></div>
                        </div>
                        <!-- .container_12 -->
                    </section>
                    <!-- #main -->
                    <!-- #main -->
                    <div class="clear"></div>
                <#include "/WEB-INF/theme/default/shop/footer.ftl"></body>
            </html>