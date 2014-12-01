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
		<span class="current">
			<a href="#">酒水饮料</a>
		</span>
		<span>&#8250;</span>
		<a href="#">所有商品类目</a>
		<span>&#8250;</span>
		<a href="#">葡萄酒</a>
		<span>&#8250;</span>
		<a href="#">法国白葡萄酒</a>
		<span>&#8250;</span>
		<a href="#">马赛农庄</a>
		<span>&#8250;</span>
		<a href="#">经典白葡萄酒1.2L</a>
	</div>
	<!-- .breadcrumbs -->
</div>
<!-- .grid_12 -->
</div>
<!-- .container_12 -->

<div class="clear"></div>

<section id="main">
<div class="container_12">
	<div id="sidebar" class="grid_3">
		<aside id="categories_nav">
			<h3>Blog Categories</h3>

			<nav class="left_menu">
				<ul>
					<li>
						<a href="#">Entertainment</a>
					</li>
					<li>
						<a href="#">Fashion</a>
					</li>
					<li>
						<a href="#">Sports</a>
					</li>
					<li>
						<a href="#">Vacation</a>
					</li>
					<li>
						<a href="#">Movies</a>
					</li>
					<li>
						<a href="#">Relationships</a>
					</li>
					<li class="last">
						<a href="#">Food</a>
					</li>
				</ul>
			</nav>
			<!-- .left_menu -->
		</aside>
		<!-- #categories_nav -->

		<aside id="manufacturers">
			<h3>Archives</h3>

			<nav class="left_menu">
				<ul>
					<li>
						<a href="#">August 2012</a>
					</li>
					<li>
						<a href="#">September 2012</a>
					</li>
					<li>
						<a href="#">October 2012</a>
					</li>
					<li>
						<a href="#">November 2012</a>
					</li>
					<li class="last">
						<a href="#">December 2012</a>
					</li>
				</ul>
			</nav>
			<!-- .left_menu -->
		</aside>
		<!-- #categories_nav -->

		<aside id="tags">
			<h3>Tags</h3>
			<a class="t1" href="#">california</a>
			<a class="t2" href="#">canada</a>
			<a class="t3" href="#">canon</a>
			<a class="t4" href="#">cat</a>
			<a class="t5" href="#">chicago</a>
			<a class="t6" href="#">christmas</a>
			<a class="t7" href="#">mars</a>
			<a class="t8" href="#">church</a>
			<a class="t9" href="#">city</a>
			<a class="t10" href="#">clouds</a>
			<a class="t11" href="#">color</a>
			<a class="t12" href="#">concert</a>
			<a class="t13" href="#">dance</a>
			<a class="t14" href="#">day</a>
			<a class="t15" href="#">dog</a>
			<a class="t16" href="#">england</a>
			<a class="t17" href="#">europe</a>
		</aside>
		<!-- #tags -->

		<aside id="newsletter_signup">
			<h3>Newsletter Signup</h3>
			<p>
				Phasellus vel ultricies felis. Duis 
		     rhoncus risus eu urna pretium.
			</p>

			<form class="newsletter">
				<input type="email" name="newsletter" class="your_email" value="" placeholder="Enter your email address..."/>
				<input type="submit" id="submit" value="Subscribe" />
			</form>
		</aside>
		<!-- #newsletter_signup -->

		<aside id="banners">
			<a id="ban_next" class="next arows" href="#">
				<span>Next</span>
			</a>
			<a id="ban_prev" class="prev arows" href="#">
				<span>Prev</span>
			</a>

			<h3>Banners</h3>

			<div class="list_carousel">
				<ul id="list_banners">
					<li class="banner">
						<a href="#">
							<div class="prev">
								<img src="images/banner.png" alt="" title="" />
							</div>
							<!-- .prev -->

							<h2>New smells</h2>

							<p>in the next series</p>
						</a>
					</li>

					<li class="banner">
						<a href="#">
							<div class="prev">
								<img src="images/banner.png" alt="" title="" />
							</div>
							<!-- .prev -->

							<h2>New smells</h2>

							<p>in the next series</p>
						</a>
					</li>

					<li class="banner">
						<a href="#">
							<div class="prev">
								<img src="images/banner.png" alt="" title="" />
							</div>
							<!-- .prev -->

							<h2>New smells</h2>

							<p>in the next series</p>
						</a>
					</li>
				</ul>
			</div>
			<!-- .list_carousel -->
		</aside>
		<!-- #banners -->

	</div>
	<!-- .sidebar -->

	<div id="content" class="grid_9">
		<h1 class="page_title">Our Blog</h1>

		<article class="post">
			<h2 class="title_article">
				<a href="blog_post.html">Citrus Magic Solid Air Freshener</a>
			</h2>
			<div class="content_article">
				<p>
					Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source.
				</p>
			</div>
			<!-- .content_article -->
			<div class="footer_article">
				<div class="number_c">3</div>
				<span>
					Mike Example,
					<time datetime="2012-11-03">03.11.2012</time>
				</span>
				|
				<span>
					Posted in
					<a href="#">Sports</a>
					,
					<a href="#">Movies</a>
				</span>
			</div>
		</article>

		<article class="post">
			<h2 class="title_article">
				<a href="blog_post.html">Citrus Magic Solid Air Freshener</a>
			</h2>
			<div class="content_article">
				<p>
					Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source.
				</p>
			</div>
			<!-- .content_article -->
			<div class="footer_article">
				<div class="number_c">3</div>
				<span>
					Mike Example,
					<time datetime="2012-11-03">03.11.2012</time>
				</span>
				|
				<span>
					Posted in
					<a href="#">Sports</a>
					,
					<a href="#">Movies</a>
				</span>
			</div>
		</article>

		<article class="post">
			<h2 class="title_article">
				<a href="blog_post.html">Citrus Magic Solid Air Freshener</a>
			</h2>
			<div class="content_article">
				<p>
					Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source.
				</p>
			</div>
			<!-- .content_article -->
			<div class="footer_article">
				<div class="number_c">3</div>
				<span>
					Mike Example,
					<time datetime="2012-11-03">03.11.2012</time>
				</span>
				|
				<span>
					Posted in
					<a href="#">Sports</a>
					,
					<a href="#">Movies</a>
				</span>
			</div>
		</article>

		<article class="post">
			<h2 class="title_article">
				<a href="blog_post.html">Citrus Magic Solid Air Freshener</a>
			</h2>
			<div class="content_article">
				<p>
					Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source.
				</p>
			</div>
			<!-- .content_article -->
			<div class="footer_article">
				<div class="number_c">3</div>
				<span>
					Mike Example,
					<time datetime="2012-11-03">03.11.2012</time>
				</span>
				|
				<span>
					Posted in
					<a href="#">Sports</a>
					,
					<a href="#">Movies</a>
				</span>
			</div>
		</article>

		<article class="post">
			<h2 class="title_article">
				<a href="blog_post.html">Citrus Magic Solid Air Freshener</a>
			</h2>
			<div class="content_article">
				<p>
					Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source.
				</p>
			</div>
			<!-- .content_article -->
			<div class="footer_article">
				<div class="number_c">3</div>
				<span>
					Mike Example,
					<time datetime="2012-11-03">03.11.2012</time>
				</span>
				|
				<span>
					Posted in
					<a href="#">Sports</a>
					,
					<a href="#">Movies</a>
				</span>
			</div>
		</article>

		<article class="post">
			<h2 class="title_article">
				<a href="blog_post.html">Citrus Magic Solid Air Freshener</a>
			</h2>
			<div class="content_article">
				<p>
					Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source.
				</p>
			</div>
			<!-- .content_article -->
			<div class="footer_article">
				<div class="number_c">3</div>
				<span>
					Mike Example,
					<time datetime="2012-11-03">03.11.2012</time>
				</span>
				|
				<span>
					Posted in
					<a href="#">Sports</a>
					,
					<a href="#">Movies</a>
				</span>
			</div>
		</article>

		<article class="post">
			<h2 class="title_article">
				<a href="blog_post.html">Citrus Magic Solid Air Freshener</a>
			</h2>
			<div class="content_article">
				<p>
					Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source.
				</p>
			</div>
			<!-- .content_article -->
			<div class="footer_article">
				<div class="number_c">3</div>
				<span>
					Mike Example,
					<time datetime="2012-11-03">03.11.2012</time>
				</span>
				|
				<span>
					Posted in
					<a href="#">Sports</a>
					,
					<a href="#">Movies</a>
				</span>
			</div>
		</article>

		<article class="post">
			<h2 class="title_article">
				<a href="blog_post.html">Citrus Magic Solid Air Freshener</a>
			</h2>
			<div class="content_article">
				<p>
					Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source.
				</p>
			</div>
			<!-- .content_article -->
			<div class="footer_article">
				<div class="number_c">3</div>
				<span>
					Mike Example,
					<time datetime="2012-11-03">03.11.2012</time>
				</span>
				|
				<span>
					Posted in
					<a href="#">Sports</a>
					,
					<a href="#">Movies</a>
				</span>
			</div>
		</article>

		<article class="post">
			<h2 class="title_article">
				<a href="blog_post.html">Citrus Magic Solid Air Freshener</a>
			</h2>
			<div class="content_article">
				<p>
					Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source.
				</p>
			</div>
			<!-- .content_article -->
			<div class="footer_article">
				<div class="number_c">3</div>
				<span>
					Mike Example,
					<time datetime="2012-11-03">03.11.2012</time>
				</span>
				|
				<span>
					Posted in
					<a href="#">Sports</a>
					,
					<a href="#">Movies</a>
				</span>
			</div>
		</article>

		<article class="post">
			<h2 class="title_article">
				<a href="blog_post.html">Citrus Magic Solid Air Freshener</a>
			</h2>
			<div class="content_article">
				<p>
					Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source.
				</p>
			</div>
			<!-- .content_article -->
			<div class="footer_article">
				<div class="number_c">3</div>
				<span>
					Mike Example,
					<time datetime="2012-11-03">03.11.2012</time>
				</span>
				|
				<span>
					Posted in
					<a href="#">Sports</a>
					,
					<a href="#">Movies</a>
				</span>
			</div>
		</article>

		<div class="pagination">
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
		</div>
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