<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Weekend Trip Planner</title>
<meta name="viewport"
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
<meta name="format-detection" content="telephone=no">
<meta name="apple-mobile-web-app-capable" content="yes">

<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:700,600,400,300"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Oswald:400"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Lato:400,700"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="css/lib/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="css/lib/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="css/lib/awe-booking-font.css">
<link rel="stylesheet" type="text/css" href="css/lib/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="css/lib/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/demo.css">
<link id="colorreplace" rel="stylesheet" type="text/css"
	href="css/colors/blue.css">
<!--[if lt IE 9]><script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script><![endif]-->

</head>
<!--[if IE 7]><body class="ie7 lt-ie8 lt-ie9 lt-ie10"><![endif]-->
<!--[if IE 8]><body class="ie8 lt-ie9 lt-ie10"><![endif]-->
<!--[if IE 9]><body class="ie9 lt-ie10"><![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->

<body>
	<script type="text/javascript">
		function validateForm() {
			if (document.getElementById("tokenid").value == null
					|| document.getElementById("tokenid").value == "") {
				login();
				return false;
			}

		}
	</script>

	<!--<![endif]-->
	<div id="page-wrap">
		<div class="preloader"></div>
		<header id="header-page">
			<div class="header-page__inner">
				<div class="container">
					<div class="logo">
						<a href="./" style="font-size: 30px; font-weight: bolder;">Weekend
							Planner</a>
					</div>
					<nav class="navigation awe-navigation" data-responsive="1200">
						<ul class="menu-list">
							<li class="menu-item-has-children"><a href="./">Home</a></li>
						</ul>
					</nav>

					<a class="toggle-menu-responsive" href="#">
						<div class="hamburger">
							<span class="item item-1"></span> <span class="item item-2"></span>
							<span class="item item-3"></span>
						</div>
					</a>
				</div>
			</div>
		</header>
		<section class="awe-parallax category-heading-section-demo">
			<div class="awe-overlay"></div>
			<div class="container">
				<div
					class="category-heading-content category-heading-content__2 text-uppercase">

					<div class="find">
						<h2 class="text-center">
							Oops, Something went Wrong. We are working on it<br>
							${messafe}
						</h2>
					</div>
				</div>
			</div>
		</section>
	</div>

	<script type="text/javascript" src="js/lib/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="js/lib/masonry.pkgd.min.js"></script>
	<script type="text/javascript" src="js/lib/jquery.parallax-1.1.3.js"></script>
	<script type="text/javascript" src="js/lib/jquery.owl.carousel.js"></script>
	<script type="text/javascript" src="js/lib/jquery-ui.js"></script>
	<script type="text/javascript" src="js/scripts.js"></script>
	<script src="https://apis.google.com/js/platform.js" async defer></script>
</body>
</html>