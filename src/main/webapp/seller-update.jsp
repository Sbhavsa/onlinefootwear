<%@page import="model.product"%>
<%@page import="model.seller"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<<!DOCTYPE HTML>
<html>
<head>
<title>Footwear - Free Bootstrap 4 Template by Colorlib</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="style.css" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,600,700"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Rokkitt:100,300,400,700"
	rel="stylesheet">

<!-- Animate.css -->
<link rel="stylesheet" href="css/animate.css">
<!-- Icomoon Icon Fonts-->
<link rel="stylesheet" href="css/icomoon.css">
<!-- Ion Icon Fonts-->
<link rel="stylesheet" href="css/ionicons.min.css">
<!-- Bootstrap  -->
<link rel="stylesheet" href="css/bootstrap.min.css">

<!-- Magnific Popup -->
<link rel="stylesheet" href="css/magnific-popup.css">

<!-- Flexslider  -->
<link rel="stylesheet" href="css/flexslider.css">

<!-- Owl Carousel -->
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">

<!-- Date Picker -->
<link rel="stylesheet" href="css/bootstrap-datepicker.css">
<!-- Flaticons  -->
<link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

<!-- Theme style  -->
<link rel="stylesheet" href="css/style.css">

</head>
<body>

<%
seller s = null;
if(session.getAttribute("data")!=null){
	s = (seller)session.getAttribute("data");
}
else{
	response.sendRedirect("seller-login.jsp");
}
%>

	<div class="colorlib-loader"></div>

	<div id="page">
		<nav class="colorlib-nav" role="navigation">
			<div class="top-menu">
				<div class="container">
					<div class="row">
						<div class="col-sm-7 col-md-9">
							<div id="colorlib-logo">
								<a href="index.html">Footwear</a>
							</div>
						</div>
						<div class="col-sm-5 col-md-3">
							<form action="sellercontroller" class="search-wrap" method="post" >
								<div class="form-group">
									<input type="search" class="form-control search"
										placeholder="Search">
									<button class="btn btn-primary submit-search text-center"
										type="submit" >
										<i class="icon-search"></i>
									</button>
									
									
								</div>
							</form>
						</div>
					</div>
					
					<div class="row">
						<div class="col-sm-12 text-left menu-1">
							<ul>
								<li class="active"><a href="index.html">Home</a></li>
								<li class="has-dropdown"><a href="men.html">Men</a>
									<ul class="dropdown">
										<li><a href="product-detail.html">Product Detail</a></li>
										<li><a href="cart.html">Shopping Cart</a></li>
										<li><a href="checkout.html">Checkout</a></li>
										<li><a href="order-complete.html">Order Complete</a></li>
										<li><a href="add-to-wishlist.html">Wishlist</a></li>
									</ul></li>
								<li><a href="women.html">Women</a></li>

								<li><a href="about.html">About</a></li>
								<li><a href="contact.html">Contact</a></li>
								<li class="has-dropdown"><a >Product</a>
									<ul class="dropdown">
										<li><a href="seller-upload-product.jsp">Upload Product</a></li>
										<li><a href="seller-manage-product.jsp">Manage Product</a></li>
										
									</ul></li>
								<li class="has-dropdown"><a><%=s.getName()%></a>
								<ul class="dropdown">
										<li><a href="seller-profile.jsp"> profile</a></li>
										<li><a href="seller-changepassword.jsp">change password</a></li>
										<li><a href="seller-logout.jsp">logout</a></li>
										
									</ul></li>
								
								
								
								<li class="cart"><a href="cart.html"><i
										class="icon-shopping-cart"></i> Cart [0]</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div class="sale">
				<div class="container">
					<div class="row">
						<div class="col-sm-8 offset-sm-2 text-center">
							<div class="row">
								<div class="owl-carousel2">
									<div class="item">
										<div class="col">
											<h3>
												<a href="#">25% off (Almost) Everything! Use Code:
													Summer Sale</a>
											</h3>
										</div>
									</div>
									<div class="item">
										<div class="col">
											<h3>
												<a href="#">Our biggest sale yet 50% off all summer
													shoes</a>
											</h3>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</nav>
		<aside id="colorlib-hero">
			<div class="flexslider">
				<ul class="slides">
					<li style="background-image: url(images/img_bg_1.jpg);">
						<div class="overlay"></div>
						<div class="container-fluid">
							<div class="row">
						<div class="col-sm-12 text-left menu-1">
							<ul>
								<li class="active"><a href="index.html">Home</a></li>
								<li class="has-dropdown"><a href="men.html">Men</a>
									<ul class="dropdown">
										<li><a href="product-detail.html">Product Detail</a></li>
										<li><a href="cart.html">Shopping Cart</a></li>
										<li><a href="checkout.html">Checkout</a></li>
										<li><a href="order-complete.html">Order Complete</a></li>
										<li><a href="add-to-wishlist.html">Wishlist</a></li>
									</ul></li>
								<li><a href="women.html">Women</a></li>

								<li><a href="about.html">About</a></li>
								<li><a href="contact.html">Contact</a></li>
								<li class="has-dropdown"><a >Product</a>
									<ul class="dropdown">
										<li><a href="seller-upload-product.jsp">Upload Product</a></li>
										<li><a href="seller-manage-product.jsp">Manage Product</a></li>
										
									</ul></li>
								<li class="has-dropdown"><a><%=s.getName()%></a>
								<ul class="dropdown">
										<li><a href="seller-profile.jsp"> profile</a></li>
										<li><a href="seller-changepassword.jsp">change password</a></li>
										<li><a href="seller-logout.jsp">logout</a></li>
										
									</ul></li>
								<li class="cart"><a href="cart.html"><i
										class="icon-shopping-cart"></i> Cart [0]</a></li>
							</ul>
						</div>
							
						
					
				</div>
						</div>
					</li>
					<li style="background-image: url(images/img_bg_2.jpg);">
						<div class="overlay"></div>
						<div class="container-fluid">
							<div class="row">
								<div class="col-sm-6 offset-sm-3 text-center slider-text">
									<div class="slider-text-inner">
										<div class="desc">
											<h1 class="head-1">Huge</h1>
											<h2 class="head-2">Sale</h2>
											<h2 class="head-3">
												<strong class="font-weight-bold">50%</strong> Off
											</h2>
											<p class="category">
												<span>Big sale sandals</span>
											</p>
											<p>
												<a href="#" class="btn btn-primary">Shop Collection</a>
											</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</li>
					<li style="background-image: url(images/img_bg_3.jpg);">
						<div class="overlay"></div>
						<div class="container-fluid">
							<div class="row">
								<div class="col-sm-6 offset-sm-3 text-center slider-text">
									<div class="slider-text-inner">
										<div class="desc">
											<h1 class="head-1">New</h1>
											<h2 class="head-2">Arrival</h2>
											<h2 class="head-3">
												up to <strong class="font-weight-bold">30%</strong> off
											</h2>
											<p class="category">
												<span>New stylish shoes for men</span>
											</p>
											<p>
												<a href="#" class="btn btn-primary">Shop Collection</a>
											</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</aside>
		<div class="colorlib-intro">
			<div class="container">
				
			</div>
		</div>
	</div>

	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="ion-ios-arrow-up"></i></a>
	</div>

	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- popper -->
	<script src="js/popper.min.js"></script>
	<!-- bootstrap 4.1 -->
	<script src="js/bootstrap.min.js"></script>
	<!-- jQuery easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Flexslider -->
	<script src="js/jquery.flexslider-min.js"></script>
	<!-- Owl carousel -->
	<script src="js/owl.carousel.min.js"></script>
	<!-- Magnific Popup -->
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/magnific-popup-options.js"></script>
	<!-- Date Picker -->
	<script src="js/bootstrap-datepicker.js"></script>
	<!-- Stellar Parallax -->
	<script src="js/jquery.stellar.min.js"></script>
	<!-- Main -->
	<script src="js/main.js"></script>
	
	<form  action="productcontroller" method="post" enctype="multipart/form-data">
	
	<div class="main">
	<div class="register">
		<h2> Update Product </h2>
		     <%//String msg = (String)request.getAttribute("msg"); %>
			<%//if(//msg!=null){ %>
				<h4><%//out.print(msg); %></h4>
				<%//} %>
				
				<%product p1 = (product)request.getAttribute("product"); %>
				
				
				<%//String msg1 = (String)request.getAttribute("msg1"); %>
			<%//if(//msg1!=null){ %>
				<h4><%//out.print(msg1); %></h4>
				<%//} %>
		
			
			<input type="hidden" name="sid"  value="<%=s.getId()%>">
			<label>Product Image:</label>
			<input type="file" name="image" height=200 width=200 value="<%=p1.getImage()%>"><br><br>
			<label>Product Name:</label>
			<input type="text" name="pn" placeholder="Enter your product name" value="<%=p1.getPname()%>" ><br><br><br>
			<label>Product Price</label>
			<input type="text" name="pp" placeholder="Enter your product price" value="<%=p1.getPprice()%>"><br><br><br>
			<label>Product Category</label>
			<input type="text" name="pc" placeholder="Enter your Product Category" value="<%=p1.getPcategory()%>"><br><br><br>
		    
		    
		    
		    <input type ="submit" name="action" value="update" >
		</form>
	</div>
	</div>

</body>
</html>

