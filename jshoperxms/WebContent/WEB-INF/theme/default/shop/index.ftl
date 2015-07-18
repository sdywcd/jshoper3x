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
        <script>
        $(document).ready(function(){
            $("#myController").jFlow({
        controller: ".control", // must be class, use . sign
        slideWrapper : "#jFlowSlider", // must be id, use # sign
        slides: "#slider",  // the div where all your sliding divs are nested in
        selectedWrapper: "jFlowSelected",  // just pure text, no sign
        width: "1176px",  // this is the width for the content-slider
        height: "480px",  // this is the height for the content-slider
        duration: 400,  // time in miliseconds to transition one slide
        prev: ".slidprev", // must be class, use . sign
        next: ".slidnext", // must be class, use . sign
        auto: true
            });
        });
        </script>
        <script>
        $(function() {
        $('#list_product').carouFredSel({
        prev: '#prev_c1',
        next: '#next_c1',
        auto: false
        });
                $('#list_product2').carouFredSel({
        prev: '#prev_c2',
        next: '#next_c2',
        auto: false
        });
        $(window).resize();
        });
        </script>
        <script>
            $(document).ready(function(){
            $("button").click(function(){
            $(this).addClass('click')
            });
            })
        </script>
    </head>
    <body>
        <!--载入公共头文件-->
        <#include "/WEB-INF/theme/default/shop/header.ftl">
        <div class="clear"></div>
        <!--载入主导航文件-->
        <#include "/WEB-INF/theme/default/shop/mainnavigation.ftl">
        <div class="clear"></div>
        <div class="container_12">
            <div class="grid_12">
                <div class="slidprev">
                    <span>Prev</span>
                </div>
                <div class="slidnext">
                    <span>Next</span>
                </div>
                <div id="slider" class="slidebgc1">
                    <div id="slide1">
                        <img src="${basepath}/ui/default/images/content/slide1.jpg" alt="" title="" />
                        <div class="slid_text">
                            <h3 class="slid_title">
                            <span>0987Breeze Theme</span>
                            </h3>
                            <p>
                            <span>Breeze is the 14 stylish HTML templates,</span>
                            </p>
                            <p>
                            <span>which will helps you boost sales</span>
                            </p>
                            <p>
                            <span>and receive good feedback from your clients.</span>
                            </p>
                        </div>
                    </div>
                    <div id="slide2">
                        <img src="${basepath}/ui/default/images/content/slide2.jpg" alt="" title="" />
                        <div class="slid_text">
                            <h3 class="slid_title">
                            <span>Flexi099百变提包</span>
                            </h3>
                            <p>
                            <span>Every product, which you are selling,</span>
                            </p>
                            <p>
                            <span>will look great with Breeze theme.</span>
                            </p>
                        </div>
                    </div>
                    <div id="slide3">
                        <img src="${basepath}/ui/default/images/content/slide3.jpg" alt="" title="" />
                        <div class="slid_text">
                            <h3 class="slid_title">
                            <span>Accuracy and Easiness</span>
                            </h3>
                            <p>
                            <span>Breeze design is mere and accurate,</span>
                            </p>
                            <p>
                            <span>so it will satisfy everybody.</span>
                            </p>
                        </div>
                    </div>
                </div>
                <!-- .slider -->
                <div id="myController">
                    <div class="control">
                        <span>1</span>
                    </div>
                    <div class="control">
                        <span>2</span>
                    </div>
                    <div class="control">
                        <span>3</span>
                    </div>
                </div>
            </div>
            <!-- .grid_12 -->
        </div>
        <!-- .container_12 -->
        <div class="clear"></div>
        <section id="main" class="home">
            <div class="container_12">
                <div id="top_button">
                    <div class="grid_4">
                        <a href="#" class="button_block best_price">
                        <img src="${basepath}/ui/default/images/banner1.png" alt="Banner 1"/>
                        </a>
                        <!-- .best_price -->
                    </div>
                    <!-- .grid_4 -->
                    <div class="grid_4">
                        <a href="#" class="button_block new_smells">
                        <img src="${basepath}/ui/default/images/banner2.png" alt="Banner 2"/>
                        </a>
                        <!-- .new smells -->
                    </div>
                    <!-- .grid_4 -->
                    <div class="grid_4">
                        <a href="#" class="button_block only_natural">
                        <img src="${basepath}/ui/default/images/banner3.png" alt="Banner 3"/>
                        </a>
                        <!-- .only_natural -->
                    </div>
                    <!-- .grid_4 -->
                    <div class="clear"></div>
                </div>
                <!-- #top_button -->
                <div class="clear"></div>
                <div class="carousel">
                    <div class="c_header">
                        <div class="grid_10">
                            <h2>热卖商品</h2>
                        </div>
                        <!-- .grid_10 -->
                        <div class="grid_2">
                            <a id="next_c1" class="next arows" href="#">
                            <span>Next</span>
                            </a>
                            <a id="prev_c1" class="prev arows" href="#">
                            <span>Prev</span>
                            </a>
                        </div>
                        <!-- .grid_2 -->
                    </div>
                    <!-- .c_header -->
                    <div class="list_carousel">
                     <#if (recommendgoodslist??)&&(recommendgoodslist?size>0)>
                        <ul id="list_product" class="list_product">
                         <#list recommendgoodslist as g>
                            <li class="">
                                <div class="grid_3 product">
                                    <img class="sale" src="${basepath}/ui/default/images/sale.png" alt="Sale"/>
                                    <div class="title">
                                        <span class="maintitle">${g.brandname}</span>
                                        ${g.goodsname}
                                    </div>
                                    <div class="prev">
                                     <#list g.pictureurl?split(",") as img>
                                        <#if img_index=0>
                                         <a href="${basepath}/<@g.htmlPath?interpret />">
                                        <img src="${basepath}${img}" alt="${g.goodsname}" title="${g.goodsname}" />
                                        </a>
                                        </#if>
                                        </#list>
                                    </div>
                                    <div class="cart">
                                        <a href="#" class="like">收藏</a>
                                        |
                                        <a href="#" class="obn">对比</a>
                                    </div>
                                    <!-- .cart -->
                                </div>
                                <!-- .grid_3 -->
                            </li>
                            </#list>
                        </ul>
                        </#if>
                        <!-- #list_product -->
                    </div>
                    <!-- .list_carousel -->
                </div>
                <!-- .carousel -->
                <div class="carousel">
                    <div class="c_header">
                        <div class="grid_10">
                            <h2>优系推荐</h2>
                        </div>
                        <!-- .grid_10 -->
                        <div class="grid_2">
                            <a id="next_c2" class="next arows" href="#">
                            <span>Next</span>
                            </a>
                            <a id="prev_c2" class="prev arows" href="#">
                            <span>Prev</span>
                            </a>
                        </div>
                        <!-- .grid_2 -->
                    </div>
                    <!-- .c_header -->
                    <#if (recommendgoodslist??)&&(recommendgoodslist?size>0)>
                    <div class="list_carousel">
                        <ul id="list_product2" class="list_product">
                            <#list recommendgoodslist as g>
                            <li class="">
                                <div class="grid_3 product">
                                    <img class="sale" src="${basepath}/ui/default/images/sale.png" alt="Sale"/>
                                    <div class="title">
                                        <span class="maintitle">${g.brandname}</span>
                                        ${g.goodsname}
                                    </div>
                                    <div class="prev">
                                     <#list g.pictureurl?split(",") as img>
                                        <#if img_index=0>
                                         <a href="${basepath}/<@g.htmlPath?interpret />">
                                        <img src="${basepath}${img}" alt="${g.goodsname}" title="${g.goodsname}" />
                                        </a>
                                        </#if>
                                        </#list>
                                    </div>
                                    <div class="cart">
                                        <a href="#" class="like">收藏</a>
                                        |
                                        <a href="#" class="obn">对比</a>
                                    </div>
                                    <!-- .cart -->
                                </div>
                                <!-- .grid_3 -->
                            </li>
                            </#list>
                        </ul>
                        <!-- #list_product2 -->
                    </div>
                    </#if>
                    <!-- .list_carousel -->
                </div>
                <!-- .carousel -->
                <!-- #content_bottom -->
                <div class="clear"></div>
            </div>
            <!-- .container_12 -->
        </section>
        <!-- #main -->
        <div class="clear"></div>
    <#include "/WEB-INF/theme/default/shop/footer.ftl"></body>
</html>