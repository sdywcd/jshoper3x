<!DOCTYPE HTML>
<html>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta name="keywords" content="">
<title>优系商城</title>


</head>
<body>
	<div class="container_12">
 <#include "/WEB-INF/theme/default/shop/header.ftl">
		<!-- #branding -->
	</div>
	<!-- .container_12 -->

	<div class="clear"></div>

	<div id="block_nav_primary">
		<div class="container_12">
			<div class="grid_12">
				<nav class="primary">
					<ul>
						<li class="all"><a href="#">123,9</a>
							<ul class="sub">
								<li><a href="index.html"><img
										src="${basepath}/ui/default/images/menuitem/all/01.png" alt="" title="手机、影像数码" /></a></li>
								<li><a href="text_page.html"><img
										src="${basepath}/ui/default/images/menuitem/all/02.png" alt="" title="笔记本、台式电脑、硬件外设" /></a></li>
								<li><a href="catalog_grid.html"><img
										src="${basepath}/ui/default/images/menuitem/all/03.png" alt="" title="商用服务器" /></a></li>
								<li><a href="catalog_list.html"><img
										src="${basepath}/ui/default/images/menuitem/all/04.png" alt="" title="食品、饮料、生鲜" /></a></li>
								<li><a href="product_page.html"><img
										src="${basepath}/ui/default/images/menuitem/all/05.png" alt="" title="厨卫电器、生活电器" /></a></li>
							</ul></li>
						<li class="curent"><a href="index.html"><img
								src="${basepath}/ui/default/images/menuitem/01.png" alt="" title="主页" /></a></li>
						<li><a href="catalog_grid.html"><img
								src="${basepath}/ui/default/images/menuitem/02.png" alt="" title="购物指南" /></a></li>
						<li><a href="catalog_grid.html"><img
								src="${basepath}/ui/default/images/menuitem/03.png" alt="" title="实验室" /></a>
							<ul class="sub">
								<li><a href="catalog_grid.html">Jshoper框架</a></li>
								<li><a href="catalog_grid.html">JshoperX实验室</a></li>
								<li><a href="catalog_grid.html">我们的微博</a></li>
							</ul></li>
					</ul>
				</nav>
				<!-- .primary -->
			</div>
			<!-- .grid_12 -->
		</div>
		<!-- .container_12 -->
	</div>
	<!-- .block_nav_primary -->

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
							<span>Flexibility</span>
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
					<a href="#" class="button_block best_price"> <img
						src="${basepath}/ui/default/images/banner1.png" alt="Banner 1" />
					</a>
					<!-- .best_price -->
				</div>
				<!-- .grid_4 -->

				<div class="grid_4">
					<a href="#" class="button_block new_smells"> <img
						src="${basepath}/ui/default/images/banner2.png" alt="Banner 2" />
					</a>
					<!-- .new smells -->
				</div>
				<!-- .grid_4 -->

				<div class="grid_4">
					<a href="#" class="button_block only_natural"> <img
						src="${basepath}/ui/default/images/banner3.png" alt="Banner 3" />
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
						<a id="next_c1" class="next arows" href="#"><span>Next</span></a>
						<a id="prev_c1" class="prev arows" href="#"><span>Prev</span></a>
					</div>
					<!-- .grid_2 -->
				</div>
				<!-- .c_header -->

				<div class="list_carousel">

					<ul id="list_product" class="list_product">
						<li class="">
							<div class="grid_3 product">
								<img class="sale" src="${basepath}/ui/default/images/sale.png" alt="Sale" />
								<div class="prev">
									<a href="product_page.html"><img src="${basepath}/ui/default/images/product_1.png"
										alt="" title="" /></a>
								</div>
								<!-- .prev -->
								<h3 class="title">Febreze Air Effects New Zealand Springs</h3>
								<div class="cart">
									<div class="price">
										<div class="vert">
											<div class="price_new">$550.00</div>
											<div class="price_old">$725.00</div>
										</div>
									</div>
									<a href="#" class="obn"></a> <a href="#" class="like"></a> <a
										href="#" class="bay"></a>
								</div>
								<!-- .cart -->
							</div>
							<!-- .grid_3 -->
						</li>

						<li class="">
							<div class="grid_3 product">
								<img class="sale" src="${basepath}/ui/default/images/sale.png" alt="Sale" />
								<div class="prev">
									<a href="product_page.html"><img src="${basepath}/ui/default/images/product_2.png"
										alt="" title="" /></a>
								</div>
								<!-- .prev -->
								<h3 class="title">Febreze Air Effects New Zealand Springs</h3>
								<div class="cart">
									<div class="price">
										<div class="vert">
											<div class="price_new">$550.00</div>
											<div class="price_old">$725.00</div>
										</div>
									</div>
									<a href="#" class="obn"></a> <a href="#" class="like"></a> <a
										href="#" class="bay"></a>
								</div>
								<!-- .cart -->
							</div>
							<!-- .grid_3 -->
						</li>

						<li class="">
							<div class="grid_3 product">
								<div class="prev">
									<a href="product_page.html"><img src="${basepath}/ui/default/images/product_3.png"
										alt="" title="" /></a>
								</div>
								<!-- .prev -->
								<h3 class="title">Febreze Air Effects New Zealand Springs</h3>
								<div class="cart">
									<div class="price">
										<div class="vert">
											<div class="price_new">$550.00</div>
										</div>
									</div>
									<a href="#" class="obn"></a> <a href="#" class="like"></a> <a
										href="#" class="bay"></a>
								</div>
								<!-- .cart -->
							</div>
							<!-- .grid_3 -->
						</li>

						<li class="">
							<div class="grid_3 product">
								<img class="sale" src="${basepath}/ui/default/images/sale.png" alt="Sale" />
								<div class="prev">
									<a href="product_page.html"><img src="${basepath}/ui/default/images/product_4.png"
										alt="" title="" /></a>
								</div>
								<!-- .prev -->
								<h3 class="title">Febreze Air Effects New Zealand Springs</h3>
								<div class="cart">
									<div class="price">
										<div class="vert">
											<div class="price_new">$550.00</div>
											<div class="price_old">$725.00</div>
										</div>
									</div>
									<a href="#" class="obn"></a> <a href="#" class="like"></a> <a
										href="#" class="bay"></a>
								</div>
								<!-- .cart -->
							</div>
							<!-- .grid_3 -->
						</li>

						<li class="">
							<div class="grid_3 product">
								<div class="prev">
									<a href="product_page.html"><img src="${basepath}/ui/default/images/product_8.png"
										alt="" title="" /></a>
								</div>
								<!-- .prev -->
								<h3 class="title">Febreze Air Effects New Zealand Springs</h3>
								<div class="cart">
									<div class="price">
										<div class="vert">
											<div class="price_new">$550.00</div>
											<div class="price_old">$725.00</div>
										</div>
									</div>
									<a href="#" class="obn"></a> <a href="#" class="like"></a> <a
										href="#" class="bay"></a>
								</div>
								<!-- .cart -->
							</div>
							<!-- .grid_3 -->
						</li>

					</ul>
					<!-- #list_product -->
				</div>
				<!-- .list_carousel -->
			</div>
			<!-- .carousel -->

			<div class="carousel">
				<div class="c_header">
					<div class="grid_10">
						<h2>优系主打</h2>
					</div>
					<!-- .grid_10 -->

					<div class="grid_2">
						<a id="next_c2" class="next arows" href="#"><span>Next</span></a>
						<a id="prev_c2" class="prev arows" href="#"><span>Prev</span></a>
					</div>
					<!-- .grid_2 -->
				</div>
				<!-- .c_header -->

				<div class="list_carousel">
					<ul id="list_product2" class="list_product">
						<li class="">
							<div class="grid_3 product">
								<img class="sale" src="${basepath}/ui/default/images/sale.png" alt="Sale" />
								<div class="prev">
									<a href="product_page.html"><img src="${basepath}/ui/default/images/product_5.png"
										alt="" title="" /></a>
								</div>
								<!-- .prev -->
								<h3 class="title">Febreze Air Effects New Zealand Springs</h3>
								<div class="cart">
									<div class="price">
										<div class="vert">
											<div class="price_new">$550.00</div>
											<div class="price_old">$725.00</div>
										</div>
									</div>
									<a href="#" class="obn"></a> <a href="#" class="like"></a> <a
										href="#" class="bay"></a>
								</div>
								<!-- .cart -->
							</div>
							<!-- .grid_3 -->
						</li>

						<li class="">
							<div class="grid_3 product">
								<img class="sale" src="${basepath}/ui/default/images/sale.png" alt="Sale" />
								<div class="prev">
									<a href="product_page.html"><img src="${basepath}/ui/default/images/product_6.png"
										alt="" title="" /></a>
								</div>
								<!-- .prev -->
								<h3 class="title">Febreze Air Effects New Zealand Springs</h3>
								<div class="cart">
									<div class="price">
										<div class="vert">
											<div class="price_new">$550.00</div>
											<div class="price_old">$725.00</div>
										</div>
									</div>
									<a href="#" class="obn"></a> <a href="#" class="like"></a> <a
										href="#" class="bay"></a>
								</div>
								<!-- .cart -->
							</div>
							<!-- .grid_3 -->
						</li>

						<li class="">
							<div class="grid_3 product">
								<div class="prev">
									<a href="product_page.html"><img src="${basepath}/ui/default/images/product_7.png"
										alt="" title="" /></a>
								</div>
								<!-- .prev -->
								<h3 class="title">Febreze Air Effects New Zealand Springs</h3>
								<div class="cart">
									<div class="price">
										<div class="vert">
											<div class="price_new">$550.00</div>
										</div>
									</div>
									<a href="#" class="obn"></a> <a href="#" class="like"></a> <a
										href="#" class="bay"></a>
								</div>
								<!-- .cart -->
							</div>
							<!-- .grid_3 -->
						</li>

						<li class="">
							<div class="grid_3 product">
								<img class="sale" src="${basepath}/ui/default/images/sale.png" alt="Sale" />
								<div class="prev">
									<a href="product_page.html"><img
										src="${basepath}/ui/default/images/produkt_slid1.png" alt="" title="" /></a>
								</div>
								<!-- .prev -->
								<h3 class="title">Febreze Air Effects New Zealand Springs</h3>
								<div class="cart">
									<div class="price">
										<div class="vert">
											<div class="price_new">$550.00</div>
											<div class="price_old">$725.00</div>
										</div>
									</div>
									<a href="#" class="obn"></a> <a href="#" class="like"></a> <a
										href="#" class="bay"></a>
								</div>
								<!-- .cart -->
							</div>
							<!-- .grid_3 -->
						</li>

						<li class="">
							<div class="grid_3 product">
								<div class="prev">
									<a href="product_page.html"><img src="${basepath}/ui/default/images/product_9.png"
										alt="" title="" /></a>
								</div>
								<!-- .prev -->
								<h3 class="title">Febreze Air Effects New Zealand Springs</h3>
								<div class="cart">
									<div class="price">
										<div class="vert">
											<div class="price_new">$550.00</div>
											<div class="price_old">$725.00</div>
										</div>
									</div>
									<a href="#" class="obn"></a> <a href="#" class="like"></a> <a
										href="#" class="bay"></a>
								</div>
								<!-- .cart -->
							</div>
							<!-- .grid_3 -->
						</li>

					</ul>
					<!-- #list_product2 -->
				</div>
				<!-- .list_carousel -->
			</div>
			<!-- .carousel -->

			<div id="content_bottom">
				<div class="grid_4">
					<div class="bottom_block about_as">
						<h3>About Us</h3>
						<p>A block of text is a stack of line boxes. In the case of
							'left', 'right' and 'center', this property specifies how the
							inline-level boxes within each line box align with respect to the
							line box's</p>
						<p>Alignment is not with respect to the viewport. In the case
							of 'justify', this property specifies that the inline-level boxes
							are to be made flush with both sides of the line box if possible.</p>
						<p>by expanding or contracting the contents of inline boxes,
							else aligned as for the initial value.</p>
					</div>
					<!-- .about_as -->
				</div>
				<!-- .grid_4 -->

				<div class="grid_4">
					<div class="bottom_block news">
						<h3>News</h3>
						<ul>
							<li><time datetime="2012-03-03">3 january 2012</time> <a
								href="#">A block of text is a stack of line boxes. In the
									case of 'left', 'right' and 'center', this property specifies</a></li>

							<li><time datetime="2012-02-03">2 january 2012</time> <a
								href="#">A block of text is a stack of line boxes. In the
									case of 'left', 'right' and 'center', this property specifies</a></li>

							<li><time datetime="2012-01-03">1 january 2012</time> <a
								href="#">A block of text is a stack of line boxes. In the
									case of 'left', 'right' and 'center', this property specifies
									how the inline-level boxes within each line</a></li>
						</ul>
					</div>
					<!-- .news -->
				</div>
				<!-- .grid_4 -->

				<div class="grid_4">
					<div class="bottom_block newsletter">
						<h3>Newsletter</h3>
						<p>Cursus in dapibus ultrices velit fusce. Felis lacus erat.
							Fermentum parturient lacus tristique habitant nullam morbi et
							odio nibh mus dictum tellus erat.</p>
						<form class="letter_form">
							<input type="email" name="newsletter" class="l_form" value=""
								placeholder="Enter your email address..." /> <input
								type="submit" id="submit" value="" />
						</form>
						<div class="lettel_description">Vel lobortis gravida. Cursus
							in dapibus ultrices velit fusce. Felis lacus erat.</div>
						<!-- .lettel_description -->
					</div>
					<!-- .newsletter -->
				</div>
				<!-- .grid_4 -->

				<div class="clear"></div>
			</div>
			<!-- #content_bottom -->
			<div class="clear"></div>

		</div>
		<!-- .container_12 -->
	</section>
	<!-- #main -->

	<div class="clear"></div>


 <#include "/WEB-INF/theme/default/shop/footer.ftl">

</body>
</html>
