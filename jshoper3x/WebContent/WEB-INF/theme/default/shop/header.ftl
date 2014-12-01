<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>优系商城</title>
        <link rel="shortcut icon" href="${basepath}/favicon.png" />
        <link href="${basepath}/ui/default/css/style.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="${basepath}/ui/default/css/grid.css" media="screen" rel="stylesheet" type="text/css" />
        <script src="${basepath}/ui/default/js/jquery-1.7.2.min.js"></script>
        <script src="${basepath}/ui/default/js/html5.js"></script>
        <script src="${basepath}/ui/default/js/jflow.plus.js"></script>
        <script src="${basepath}/ui/default/js/jquery.carouFredSel-5.2.2-packed.js"></script>
        <script src="${basepath}/ui/default/js/jquery.jqzoom-core.js" ></script>
        <script type="text/javascript" src="${basepath}/ui/default/js/jquery.query.js"></script>
        <script type="text/javascript" src="${basepath}/ui/default/js/jshoper.js"></script>
  <script>
  $(document).ready(function() {
    $('#wrapper_tab a').click(function() {
      if ($(this).attr('class') != $('#wrapper_tab').attr('class') ) {
        $('#wrapper_tab').attr('class',$(this).attr('class'));
      }
      return false;
    });
  });
    $(function() {
      $('#list_product').carouFredSel({
        prev: '#prev_c1',
        next: '#next_c1',
        auto: false
      });
          $('#list_banners').carouFredSel({
        prev: '#ban_prev',
        next: '#ban_next',
        scroll: 1,
        auto: false
      });
      $('#thumblist').carouFredSel({
        prev: '#img_prev',
        next: '#img_next',
        scroll: 1,
        auto: false,
        circular: false,
      });
      $(window).resize();
    });
  </script>
    </head>
    <body>
        <div class="container_12">
            <header id="branding">
                <div class="grid_3">
                    <hgroup>
                    <h1 id="site_logo" ><a href="${basepath}/index.html" title=""><img src="${basepath}/ui/default/images/logo.png" alt="Online Store Theme Logo"/></a></h1>
                    <h2 id="site_description">latest data update 2013.12.21</h2>
                    </hgroup>
                    </div><!-- .grid_3 -->
                    <div class="grid_6">
                        <form id="topKeywords" name="topsearch" action="${basepath}/searchGoodsByGoodsName.action" method="post" class="search">
                            <input id="topKeywords" name="topKeywords" type="text" class="entry_form" value="" placeholder="输入您要搜索的信息..."/>
                        </form>
                        <ul class="search_keywords">
                            <li><a href="index.html" title="">这只是一个初稿功能和业务会陆续加上，设计师在持续改进中，程序员在coding</a></li>
                        </ul>
                        </div><!-- .grid_3 -->
                        <div class="grid_3">
                            <ul class="cart_nav">
                                <li>
                                    <a class="cart_li" href="javascript:void();" id="mycartlink" name="mycartlink" onclick="javascript:void();">我的购物车</a>
                                </li>
                            </ul>
                            <ul class="cart_nav">
                                <li>
                              
                                    <a id="islogin" name="islogin" class="cart_li" href="${basepath}/initMcIndex.action">我的优系</a>
                                    
                                
                                 
                                    <!-- <ul class="cart_cont">
                                        <li class="no_border_top userinfo">
                                            <div class="username">mark@markpage.org<br>
                                                五星用户
                                            </div>
                                            <a href="product_page.html" class="prev_cart"><div class="cart_vert"><img src="${basepath}/ui/default/images/produkt_slid1.png" alt="" title="" /></div></a>
                                        </li>
                                        <li class="mylist"><a href="">未完成的订单（12）</a></li>
                                        <li class="mylist"><a href="">我的收藏（122）</a></li>
                                        <li class="mylist"><a href="">咨询 / 回复（1）</a></li>
                                        <li class="mylist"><a href="">未使用的优惠券（3）</a></li>
                                        <li class="mylist"><a href="">关注的降价商品（6）</a></li>
                                        <li class="no_border_bottom">
                                            <a href="shopping_cart.html" class="view_cart">进入主页</a>
                                            <a href="checkout.html" class="checkout">注销登录</a>
                                        </li>
                                    </ul> -->
                                </li>
                            </ul>
                            </div><!-- .grid_6 -->
                            </header><!-- #branding -->
                            </div><!-- .container_12 -->
<!--hidden params area-->
<!--隐藏的项目路径-->
<input type="hidden" id="hidbasepath" name="hidbasepath" value="${basepath}"/>
                        </body>
                    </html>