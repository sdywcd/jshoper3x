<html>
    <body>
        <footer>
            <div class="f_navigation">
                <div class="container_12">
                 <#if (footcategory??)&&(footcategory?size>0) >
                        <#list footcategory as f>
                    <div class="grid_3">
                       
                        <#if f.position=="1">
                        <h3 class="t${f_index+1}">${f.name}</h3>
                        <nav class="f_menu">
                            <#if (footerarticle??)&&(footerarticle?size>0) >
                            <ul>
                                <#list footerarticle as fa>
                                <#if (f.articleCategoryTid==fa.navid)&&fa.isnotice=="1">
                                <li><a href="${basepath}/${fa.htmlPath}" target="_blank">${fa.title}</a></li>
                                </#if>
                                </#list>
                            </ul>
                            </#if>
                            </nav><!-- .f_contact -->
                            </#if>
                            </div><!-- .grid_3 -->
                            </#list>
                            </#if>
                            <div class="clear"></div>
                            </div><!-- .container_12 -->
                            </div><!-- .f_navigation -->
                            <div class="f_info">
                                <div class="container_12">
                                    <div class="grid_12">
                                        <ul class="copyright_menu">
                                            <li><a href="">关于我们</a></li>|
                                            <li><a href="">联系我们</a></li>|
                                            <li><a href="">人才招聘</a></li>|
                                            <li><a href="">广告服务</a></li>|
                                            <li><a href="">手机Yooxi</a></li>|
                                            <li><a href="">友情链接</a></li>|
                                            <li><a href="">优系社区</a></li>
                                        </ul>
                                        <ul class="brand_menu">
                                            <li><a href="">旗下网站：</a></li>
                                            <li><a href="">优系商城</a></li>|
                                            <li><a href="">chevsite</a></li>|
                                            <li><a href="">jshoper</a></li>
                                        </ul>
                                        <div class="authentication">
                                        </div>
                                        </div><!-- .grid_6 -->
                                        <div class="clear"></div>
                                        </div><!-- .container_12 -->
                                        </div><!-- .f_info -->
                                    </footer>
                                </body>
                            </html>