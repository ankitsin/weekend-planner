<%@include file="header.jsp"%>
<body>
	<div id="page-wrap">
		<div class="preloader"></div>
		<%@include file="menu.jsp"%>
		<section class="awe-parallax category-heading-section-demo">
			<div class="awe-overlay"></div>
			<div class="container">
				<div
					class="category-heading-content category-heading-content__2 text-uppercase">

					<div class="find">
						<h2 class="text-center"></h2>

					</div>
				</div>
			</div>
		</section>
		<section class="filter-page">
			<div class="container">
				<div class="row">
					<div class="col-md-19 col-md-push-3">
						<div class="filter-page__content">
							<div class="filter-item-wrapper">
								<div class="trip-item">
									<div class="item-media">
										<div class="image-cover">
											<img
												src="images/${postedDetail.getDestinationLocation()}.jpg"
												alt="">
										</div>

									</div>
									<div class="item-body">
										<div class="item-title">
											<h2>Your Trip has been Posted</h2>
										</div>
										<div class="item-list">
											<ul>
												<li>Trip Name: ${postedDetail.getTripName()}</li>
												<li>Trip Date: ${postedDetail.getGoingDate()}</li>
												<li>Average Cost: Rs ${postedDetail.getAverageCost()}</li>
												<li>Number Of Days: ${postedDetail.getNumOfDay()}</li>
												<li>Number Of People Going Now:
													${postedDetail.getGoingPeople()}</li>
												<li>Space Left: ${postedDetail.getSpaceLeft()}</li>
												<li>Destination Type:
													${postedDetail.getDestinationType()}</li>
												<%-- <li>${emailId}</li> --%>
											</ul>
										</div>

									</div>
									<div class="item-price-more">
										<a href="./" class="awe-btn">Got It</a>
										<!-- <form action="/">
											<input type="submit" class="awe-btn" value="Got It">
										</form> -->
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>


		</section>
		<footer id="footer-page">
			<div class="container">
				<div class="copyright">
					<p>&#169;2016 Practo Technologies Pvt. Ltd. All rights
						reserved.</p>
				</div>
			</div>
		</footer>
	</div>
	<%@include file="footer.jsp"%>



</body>
</html>