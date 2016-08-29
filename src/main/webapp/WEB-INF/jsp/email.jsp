<%@include file="header.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
											<c:if test="${ empty signedUp.getDestinationLocation()}">
												<img src="images/register.jpg" alt="">

											</c:if>
											<c:if test="${not empty signedUp.getDestinationLocation()}">

												<img src="images/${signedUp.getDestinationLocation()}.jpg"
													alt="">
											</c:if>

										</div>

									</div>
									<div class="item-body">
										<div class="item-title">
											<c:if test="${ empty signedUp.getDestinationLocation()}">
												<h2>You have already Registered fro This Trip</h2>
										</div>
										</c:if>
										<c:if test="${not empty signedUp.getDestinationLocation()}">
											<h2>You have Registered for the Trip</h2>
									</div>
									<div class="item-list">
										<ul>
											<li>Trip Name: ${signedUp.getTripName()}</li>

											<li>Trip Date: <fmt:formatDate
													value="${signedUp.getGoingDate()}" pattern="dd-MMM-yyyy" /></li>
											<li>Average Cost: Rs ${signedUp.getAverageCost()}</li>
											<li>Number Of Days: ${signedUp.getNumOfDay()}</li>
											<li>Destination Type: ${signedUp.getDestinationType()}</li>
											<%-- <li>${emailId}</li> --%>
										</ul>
									</div>
									</c:if>



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
				<p>&#169;2016 Practo Technologies Pvt. Ltd. All rights reserved.</p>
			</div>
		</div>
	</footer>
	</div>
	<%@include file="footer.jsp"%>



</body>
</html>