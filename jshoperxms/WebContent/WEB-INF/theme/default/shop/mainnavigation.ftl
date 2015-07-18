<div id="block_nav_primary">
            <div class="container_12">
                <div class="grid_12">
                    <nav class="primary">
                        <ul>
                            <li class="all">
                                <#if goodscategorytreefirstcount?exists>
                                <a href="#">${goodscategorytreefirstcount}</a>
                                </#if>
                                <ul class="sub">
                                <#if goodscategorytree?exists>
                                <#list goodscategorytree as firstGoodsCategory>
                                <#if firstGoodsCategory.grade=='0'>
                                    <li><a href="${basepath}/findFirstCategoryTGoods.action?navid=${firstGoodsCategory.goodsCategoryTid}">${firstGoodsCategory.name}</a>
                                        <!--<div class="popup top1">
                                            ${firstGoodsCategory.name}
                                        </div>-->
                                    </li>
                                    </#if>
                                    </#list>
                                    </#if>
                                  
                                </ul>
                            </li>
                            <#if sitenavigationlist?exists>
                            <#list sitenavigationlist?sort_by("sort") as snl>
                            <#if snl.position="2">
                            <li class="curent">
                            <a href="${basepath}/<@snl.htmlPath?interpret/>"
                            <#if snl.isTargetBlank="1"></#if> >${snl.name}
                            </a>
                            </li>
                            </#if>
                            </#list>
                            </#if>
                        </ul>
                        </nav><!-- .primary -->
                        </div><!-- .grid_12 -->
                        </div><!-- .container_12 -->
                        </div><!-- .block_nav_primary -->