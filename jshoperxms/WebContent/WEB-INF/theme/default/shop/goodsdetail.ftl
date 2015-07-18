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
<!--载入主导航文件-->
<#include "/WEB-INF/theme/default/shop/mainnavigation.ftl">
  <div class="clear"></div>

  <div class="container_12">
    <div class="grid_12">
       <div class="breadcrumbs">
        <#if goodscategorypath?exists>
        <#list goodscategorypath as gp>
        <span class="current">
            <a href="${basepath}/<@gp.url?interpret/>">${gp.name}</a>
        </span>
        </#list>
        </#if>
       </div><!-- .breadcrumbs -->
    </div><!-- .grid_12 -->
  </div><!-- .container_12 -->

  <div class="clear"></div>

  <section id="main">
    <div class="container_12">
       <div id="sidebar" class="grid_3">
        <aside id="categories_nav">
         <nav class="left_menu">
          <ul>
         <h3>返回二级类目</h3>
           <#if secondgoodscategory?exists>
                    <#list secondgoodscategory as sct>
                    <li>
                        <a href="#">
                            ${sct.name}
                        </a>
                    </li>
                    </#list>
                    </#if>
          </ul>
         </nav>
        </aside>
        <#if hotsalegoodslist?exists>
        <aside id="specials" class="specials">

         <div class="left_recommend">

         <h3>热销商品</h3>
         <ul>
         <#list hotsalegoodslist as g>
          <li>
           <div class="prev">
           <#list g.pictureurl?split(",") as img>
                <#if img_index=0>
            <a href="${basepath}/<@g.htmlPath?interpret />">
                <img src="${basepath}${img}" alt="" title="${g.goodsname}" />
            </a>
            </#if>
            </#list>
           </div>
           <div class="cont">
             <a href="${basepath}/<@g.htmlPath?interpret />">${g.goodsname}</a>
                            <div class="prise">￥${g.memberprice}</div>
           </div>   
          </li>
          </#list>
         </ul>
           </div>  
        </aside>
        </#if>


        <aside id="banners">
         <div class="left_banners">
    <a id="ban_next" class="next arows" href="#"><span>Next</span></a>
    <a id="ban_prev" class="prev arows" href="#"><span>Prev</span></a>

    <h3>特别推荐</h3>

    <div class="list_carousel">
    <#if recommendgoodslist?exists>
      <ul id="list_banners">
      <#list hotsalegoodslist as g>
      <#list g.pictureurl?split(",") as img>
       <#if img_index=0>
        <li class="banner"><a href="${basepath}/<@g.htmlPath?interpret />">
          <div class="prev">
            <img src="${basepath}${img}" alt="${g.goodsname}" title="${g.goodsname}" />
          </div>
        </li>
        </#if>
        </#list>
      </#list>
      </ul>
    </#if>
    </div>
    </div>
        </aside><!-- #banners -->

       </div><!-- .sidebar -->
       <#if goodsdetail?exists>
       <div id="content" class="grid_9">
        <h1 class="page_title">${goodsdetail.goodsname}</h1>

    <div class="product_page">
      <div class="grid_4 img_slid" id="products">
        <img class="sale" src="${basepath}/ui/default/images/sale.png" alt="Sale"/>
        <div class="preview slides_container">
          <div class="prev_bg">
          <#list goodsdetail.pictureurl?split(",") as img>
                <#if img_index=0>
            <a href="${basepath}${img}" class="jqzoom" rel='gal1' title="">
              <img src="${basepath}${img}"  title="" alt="" style="width:300px;height:300px;" />
            </a>
            </#if>
            </#list>
          </div>
        </div><!-- .prev -->
      
        <ul class="pagination clearfix" id="thumblist">
          <#list goodsdetail.pictureurl?split(",") as img> 
          <li><a class="zoomThumbActive" href='javascript:void(0);' rel="{gallery: 'gal1', smallimage: '${basepath}${img}',largeimage: '${basepath}${img}'}"><img src='${basepath}${img}' alt=""></a></li>
          </#list>
        
        </ul>

        <div class="next_prev">
          <a id="img_prev" class="arows" href="#"><span>Prev</span></a>
          <a id="img_next" class="arows" href="#"><span>Next</span></a>
        </div><!-- . -->
      </div><!-- .grid_4 -->

      <div class="grid_5">
        <div class="entry_content">
          <div class="review">
            <a class="plus" href="#"></a>
            <a class="plus" href="#"></a>
            <a class="plus" href="#"></a>
            <a href="#"></a>
            <a href="#"></a>
            <span>1 个评论</span>
            <a class="add_review" href="#">降价提醒</a>
          </div>
          <p>可获得积分：${goodsdetail.points}</p>
          <div class="ava_price">
            <div class="availability_sku">
              <div class="availability">
                编号: <span>${goodsdetail.usersetnum}</span>
              </div>
              <div class="availability">
                状态: <span>有现货</span>
              </div>
           
            </div><!-- .availability_sku -->

            <div class="price">
              ￥ ${goodsdetail.memberprice}
            </div><!-- .price -->
          </div><!-- .ava_price -->

          <div class="block_cart">
            <div class="obn_like">
              <div class="obn"><a href="#" class="obn">加入对比</a></div>
              <div class="like"><a href="javascript:void();" id="addtofavorite" name="addtofavorite"  class="like">加入收藏</a></div>
              <div class="obn"><span id="savefavoritemsg"></span></div>
            </div>

            <div class="cart">
              <a href="javascript:void();" class="bay" id="addtocartlink" name="addtocartlink">加入购物车</a>
              <input type="text" name="" class="number" value="1" id="needquantity" name="needquantity" />
              <span>购买数量:</span>
            </div>
            <div class="clear"></div>
          </div><!-- .block_cart -->
          <div class="soc">
            <img src="${basepath}/ui/default/images/soc.png" alt="Soc"/>
          </div><!-- .soc -->
        </div><!-- .entry_content -->

      </div><!-- .grid_5 -->

      <div class="clear"></div>

      <div class="grid_9" >
        <div id="wrapper_tab" class="tab1">
          <a href="#" class="tab1 tab_link">商品描述</a>
          <a href="#" class="tab2 tab_link">规格参数</a>
          <a href="#" class="tab3 tab_link">产品包装</a>
          <a href="#" class="tab4 tab_link">用户评价(121)</a>
          <a href="#" class="tab5 tab_link">售后服务</a>

          <div class="clear"></div>
          <!--商品描述信息-->
          <#if goodsdes?exists>
            <div class="tab1 tab_body">
           
              ${goodsdes.detail}
            <div class="clear"></div>
            </div><!-- .tab1 .tab_body -->
          </#if>
          <div class="tab2 tab_body">
          <#if goodsparameters?exists>
            <h4>规格参数</h4>
            <table>
              <tbody>
              <#list goodsparameters as gp>
         
              <#if (gp.paramValue?length>0) >
              <tr>
                <td class="bg">${gp.paramName}</td><td>${gp.paramValue}</td>

              </tr> 
              </#if>
              </#list>
            </tbody></table>
            <#else>
             <h4>规格参数服务尚未开通</h4>
          </#if>
          <div class="clear"></div>
          </div>

          <div class="tab3 tab_body">
            <!--产品包装-->
            ${goodsdetail.commoditylist}
          <div class="clear"></div>
          </div>

          <div class="tab4 tab_body">
            <h4>评论服务尚未开通</h4>
            <!-- <ul class="comments">
             <!--  <li>
                <div class="autor">梁家辉</div>, <time datetime="2012-11-03">2014年4月21日0:54:21</time>

                <div class="evaluation">
                  <div class="quality">
                    <strong>商品质量</strong>
                    <a class="plus" href="#"></a>
                    <a class="plus" href="#"></a>
                    <a class="plus" href="#"></a>
                    <a href="#"></a>
                    <a href="#"></a>
                  </div>
                  <div class="price">
                    <strong>价格优势</strong>
                    <a class="plus" href="#"></a>
                    <a class="plus" href="#"></a>
                    <a class="plus" href="#"></a>
                    <a class="plus_minus" href="#"></a>
                    <a href="#"></a>
                  </div>
                  <div class="clear"></div>
                </div><!-- .evaluation -->

               <!--  <p>Suspendisse at placerat turpis. Duis luctus erat vel magna pharetra aliquet. Maecenas tincidunt feugiat ultricies. Phasellus et dui risus. Vestibulum adipiscing, eros quis lobortis dictum.</p> -->
             <!--  </li>  -->

              <!-- <li>
                <div class="autor">Mike Example</div>, <time datetime="2012-11-03">2014年4月21日0:56:13</time>

                <div class="evaluation">
                  <div class="quality">
                    <strong>商品质量</strong>
                    <a class="plus" href="#"></a>
                    <a class="plus" href="#"></a>
                    <a class="plus" href="#"></a>
                    <a class="plus" href="#"></a>
                    <a class="plus_minus" href="#"></a>
                  </div>
                  <div class="price">
                    <strong>价格优势</strong>
                    <a class="plus" href="#"></a>
                    <a class="plus" href="#"></a>
                    <a class="plus" href="#"></a>
                    <a class="plus" href="#"></a>
                    <a href="#"></a>
                  </div>
                  <div class="clear"></div>
                </div><!-- .evaluation -->

               <!--  <p>Etiam mollis volutpat odio, id euismod justo gravida a. Aliquam erat volutpat. Phasellus faucibus venenatis lorem, vitae commodo elit pretium et. Duis rhoncus lobortis congue. Vestibulum et purus dui, vel porta lectus. Sed vulputate pulvinar adipiscing.</p>
              </li> -->
           <!-- </ul> --><!-- .comments --> 

          <!--   <form class="add_comments">
              <h4>发表您的评论</h4>

              <div class="evaluation">
                <div class="quality">
                  <strong>商品质量</strong><sup class="surely">*</sup>
                  <input class="niceRadio" type="radio" name="quality" value="1" /><span class="eva_num">1</span>
                  <input class="niceRadio" type="radio" name="quality" value="2" /><span class="eva_num">2</span>
                  <input class="niceRadio" type="radio" name="quality" value="3" /><span class="eva_num">3</span>
                  <input class="niceRadio" type="radio" name="quality" value="4" /><span class="eva_num">4</span>
                  <input class="niceRadio" type="radio" name="quality" value="5" /><span class="eva_num">5</span>
                </div>
                <div class="price">
                  <strong>价格优势</strong><sup class="surely">*</sup>
                  <input class="niceRadio" type="radio" name="price" value="1" /><span class="eva_num">1</span>
                  <input class="niceRadio" type="radio" name="price" value="2" /><span class="eva_num">2</span>
                  <input class="niceRadio" type="radio" name="price" value="3" /><span class="eva_num">3</span>
                  <input class="niceRadio" type="radio" name="price" value="4" /><span class="eva_num">4</span>
                  <input class="niceRadio" type="radio" name="price" value="5" /><span class="eva_num">5</span>
                </div>
                <div class="clear"></div>
              </div><!-- .evaluation -->


             <!--  <div class="text_review">
                <strong>评论内容</strong><sup class="surely">*</sup><br/>
                <textarea name="text"></textarea>
                <i>Note: HTML is not translated!</i>
              </div> --><!-- .text_review -->

              <!-- <input type="submit" value="发表评论" />
            </form> --> <!-- .add_comments -->
          <div class="clear"></div>
          </div><!-- .tab2 .tab_body -->


          <div class="tab5 tab_body">
            <h4>售后服务尚未开通</h4>
          <div class="clear"></div>
          </div>

          <div class="clear"></div>

        </div>​<!-- #wrapper_tab -->
        <div class="clear"></div>
      </div><!-- .grid_9 -->

      <div class="clear"></div>

    </div><!-- .product_page -->
    <div class="clear"></div>

       </div><!-- #content -->
       </#if>
      <div class="clear"></div>



    </div><!-- .container_12 -->
  </section><!-- #main -->
<!--hidden params area-->
<!--用于重新登录后的跳转链接-->
<input type="hidden" id="hidurl" name="hidurl" value=""/>
<!-- 隐藏的goodsid -->
<input type="hidden" id="hidgoodsid" name="hidgoodsid" value="${goodsdetail.goodsid}"/>
<!-- 隐藏的商品名称 -->
<input type="hidden" id="hidgoodsname" name="hidgoodsname" value="${goodsdetail.goodsname}"/>
<!-- 隐藏的浏览次数 -->
<#if goodsdetail.readcount?exists>
<input type="hidden" id="hidreadcount" name="hidreadcount" value="${goodsdetail.readcount}"/>
</#if>
<!-- 隐藏的市场价 -->
<input type="hidden" id="hidprice" name="hidprice" value="${goodsdetail.price}"/>
<!-- 隐藏的图片地址 -->
<input type="hidden" id="hidpictureurl" name="hidpictureurl" value="${goodsdetail.pictureurl}">
<!-- 隐藏的静态页地址 -->
<input type="hidden" id="hidhtmlpath" name="hidhtmlpath" value="${goodsdetail.htmlPath}">
<!-- 隐藏的会员价 -->
<input type="hidden" id="hidmemberprice" name="hidmemberprice" value="${(goodsdetail.memberprice)}"/>
<!--隐藏的规格标记表示是否开启了规格-->
<input type="hidden" id="hidguigeflag" name="hidguigeflag" value="1"/>
<!--隐藏的产品id唯一且只有一个值-->
<input type="hidden" id="hidproductid" name="hidproductid" value=""/>
  <div class="clear"></div>
<#include "/WEB-INF/theme/default/shop/footer.ftl">
</body>
</html>
