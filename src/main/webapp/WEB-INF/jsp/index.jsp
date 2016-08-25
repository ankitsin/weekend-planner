<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<!--<![endif]-->
	<div id="page-wrap">
		<div class="preloader"></div>
		<header id="header-page">
			<div class="header-page__inner">
				<div class="container">
					<div class="logo">
						<a href="" style="font-size: 30px; font-weight: bolder;">Weekend
							Planner</a>
					</div>
					<nav class="navigation awe-navigation" data-responsive="1200">
						<ul class="menu-list">
							<li class="menu-item-has-children"><a href="">Home</a></li>
							<li class="menu-item-has-children"><a
								href="destinations-list.jsp">Destinations</a></li>
							<li class="menu-item-has-children"><a href="login.jsp">Login</a></li>
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
						<h2 class="text-center">Search Your Trip</h2>
						<form action="search" method="get">
							<div class="form-group">
								<div class="form-elements">
									<label>Destination</label>
									<div class="form-item">
										<div class="page-top">
											<select class="awe-select" name="destinationName"><option></option>
												<c:forEach var="destination" items="${destinations}">
													<option>${destination.getLocation()}</option>
												</c:forEach>
											</select>
										</div>
									</div>
								</div>
								<div class="form-elements">
									<label>In Between Date(Start)</label>
									<div class="form-item">
										<i class="awe-icon awe-icon-calendar"></i> <input type="text"
											name="startDate" class="awe-calendar" value="Date">
									</div>
								</div>
								<div class="form-elements">
									<label>In Between Date(End)</label>
									<div class="form-item">
										<i class="awe-icon awe-icon-calendar"></i> <input type="text"
											name="endDate" class="awe-calendar" value="Date">
									</div>
								</div>
								<div class="form-actions">
									<input type="submit" value="Find My Trip">
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</section>
		<section class="filter-page">
			<div class="container">
				<div class="row">
					<div class="col-md-9 col-md-push-3">
						<div class="filter-page__content">
							<div class="filter-item-wrapper">
								<c:forEach var="eachTrip" items="${getAllTrip}">
									<div class="trip-item">
										<div class="item-media">
											<div class="image-cover">
												<img src="images/${eachTrip.getDestinationLocation()}.jpg"
													alt="">
											</div>

										</div>
										<div class="item-body">
											<div class="item-title">
												<h2>${eachTrip.getTripName()}</h2>
											</div>
											<div class="item-list">
												<ul>
													<li>Trip Date: ${eachTrip.getGoingDate()}</li>
													<li>Average Cost: Rs ${eachTrip.getAverageCost()}</li>
													<li>Number Of Days: ${eachTrip.getNumOfDay()}</li>
													<li>Space Left: ${eachTrip.getSpaceLeft()}</li>
												</ul>
											</div>
											<div class="item-footer">
												<div class="item-rate">
													<span>Destination Type:
														${eachTrip.getDestinationType()}</span>
												</div>

											</div>
										</div>
										<div class="item-price-more">
											<a href="#" class="awe-btn">Register in Trip</a>
										</div>
									</div>
								</c:forEach>
							</div>
							<div class="page__pagination">
								<span class="pagination-prev"><i class="fa fa-caret-left"></i></span>
								<span class="current">1</span> <a href="#">2</a> <a href="#">3</a>
								<a href="#">4</a> <a href="#" class="pagination-next"><i
									class="fa fa-caret-right"></i></a>
							</div>
						</div>
					</div>
					<div class="col-md-3 col-md-pull-9">
						<div class="page-sidebar">
							<form action="search" method="get">
								<div class="sidebar-title">
									<h2 style=""float:left">Filters</h2>
									<div class="form-actions">
										<input id="form1" type="submit" value="Apply"
											style="float: left; position: relative; display: block; background-color: #0091ea; color: #fff; margin-left: 50px; font-size: 14px; font-weight: 600; border: 0; text-align: center; line-height: normal; padding-bottom: 6px; -webkit-box-shadow: inset 0 -2px 0 0 rgba(0, 0, 0, 0.3); -moz-box-shadow: inset 0 -2px 0 0 rgba(0, 0, 0, 0.3); box-shadow: inset 0 -2px 0 0 rgba(0, 0, 0, 0.3); -webkit-border-radius: 3px; -moz-border-radius: 3px; -ms-border-radius: 3px; -o-border-radius: 3px; border-radius: 3px; -webkit-transition: all 0.3s ease; -moz-transition: all 0.3s ease; -ms-transition: all 0.3s ease; -o-transition: all 0.3s ease; transition: all 0.3sease;">
									</div>
									<div class="clear-filter">
										<a href="./">Clear all</a>
									</div>
								</div>
								<div class="widget widget_has_radio_checkbox">
									<h3>Trip Type</h3>
									<ul>
										<c:forEach var="filter" items="${destFilters}">
											<li><label><input type="checkbox" class="typetemp"
													value="${filter}"> <i
													class="awe-icon awe-icon-check"></i> ${filter}</label></li>
										</c:forEach>
										<input type="hidden" id="test" name="destinationType">
									</ul>
								</div>
							</form>
							<!-- <div class="widget widget_price_filter">
								<h3>Price Level</h3>
								<div class="price-slider-wrapper">
									<div class="price-slider"></div>
									<div class="price_slider_amount">
										<div class="price_label">
											<span class="from"></span> - <span class="to"></span>
										</div>
									</div>
								</div>
							</div> -->


						</div>
					</div>
				</div>
			</div>
	</div>
	</section>
	<footer id="footer-page">
		<div class="container">
			<div class="copyright">
				<p>&#169;2016 Practo Technologies Pvt. Ltd. All rights reserved.</p>
			</div>
		</div>
	</footer>
	</div>

	<script type="text/javascript" src="js/lib/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="js/lib/masonry.pkgd.min.js"></script>
	<script type="text/javascript" src="js/lib/jquery.parallax-1.1.3.js"></script>
	<script type="text/javascript" src="js/lib/jquery.owl.carousel.js"></script>
	<script type="text/javascript" src="js/lib/jquery-ui.js"></script>
	<script type="text/javascript" src="js/scripts.js"></script>
	<script type="text/javascript">
		$('#form1').click(function() {
			var destinationType = '';

			$('[class="typetemp"]').each(function(i, e) {
				if ($(e).is(':checked')) {
					var comma = destinationType.length === 0 ? '' : ',';
					destinationType += (comma + e.value);
				}
			});
			$('#test').attr('value', destinationType);
			console.log(destinationType);
		});
	</script>
</body>
</html>