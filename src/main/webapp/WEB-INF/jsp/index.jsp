<%@include file="header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<body>
	<div id="page-wrap">
		<div class="preloader"></div>
		<%@include file="menu.jsp"%>
		<section class="awe-parallax category-heading-section-demo">
			<div class="container">
				<div
					class="category-heading-content category-heading-content__2 text-uppercase">
					<div class="find">
						<h2 class="text-center">Search Trip</h2>
						<form action="search" method="get">
							<div class="form-group">
								<div class="form-elements">
									<label>Destination</label>
									<div class="form-item">
										<div class="page-top">
											<select class="awe-select" name="destinationName"><option>${filtername}</option>
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
											name="startDate" class="awe-calendar" value="${filterstart}"
											readonly="true">
									</div>
								</div>
								<div class="form-elements">
									<label>In Between Date(End)</label>
									<div class="form-item">
										<i class="awe-icon awe-icon-calendar"></i> <input type="text"
											name="endDate" class="awe-calendar" value="${filterend}"
											readonly='true'>
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
													<li>Posted By: ${eachTrip.getUserName()}
														(${eachTrip.getUserEmailID()})</li>
													<li>Trip Date: ${eachTrip.getGoingDate()}</li>
													<li>Average Cost: Rs ${eachTrip.getAverageCost()}</li>
													<li>Number Of Days: ${eachTrip.getNumOfDay()}</li>
													<li>Space Left: ${eachTrip.getSpaceLeft()}</li>
													<li>Going People: ${eachTrip.getGoingPeople()}</li>
													<li>Destination Type: ${eachTrip.getDestinationType()}</li>
													<%-- <li>${emailId}</li> --%>
												</ul>
											</div>
											<%-- <div class="item-footer">
												<div class="item-rate">
													<span>Destination Type:
														${eachTrip.getDestinationType()}</span>
												</div>
											</div> --%>
										</div>
										<form action="signup" method="post">
											<input type="hidden" id="desttype" name="tripId"
												value="${eachTrip.getTripId()}">
											<div class="item-price-more">
												<input type="submit" class="awe-btn"
													value="Register For Trip">
											</div>
										</form>
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

											<li><label> <%-- <c:if
														test="${fn:contains(${filtertype},${filter})}"> --%> <input
													type="checkbox" class="destype" value="${filter}"
													<c:if
                                                        test="${fn:contains(filtertype,filter)}">checked="checked" </c:if> />
													<i class="awe-icon awe-icon-check"></i> ${filter}
											</label></li>
										</c:forEach>
										<input type="hidden" id="filterdes" name="destinationType">
									</ul>
								</div>
								<div class="widget widget_has_radio_checkbox">
									<h3>Number of Days</h3>
									<ul>
										<c:forEach var="i" begin="1" end="5">
											<li><label><input type="checkbox"
													class="numdays" value="${i}"
													<c:if
                                                        test="${fn:contains(filterdays,i)}">checked="checked" </c:if>>
													<i class="awe-icon awe-icon-check"></i> ${i}</label></li>
										</c:forEach>
										<input type="hidden" id="numofday" name="numOfDays">
									</ul>
								</div>
								<div class="widget widget_has_radio_checkbox">
									<div class="form-group">
										<div class="form-elements">
											<label>In Between Date(Start)</label>
											<div class="form-item">
												<i class="awe-icon awe-icon-calendar"></i> <input
													type="text" name="startDate" value="${filterstart}"
													class="awe-calendar">
											</div>
										</div>
									</div>
								</div>
								<div class="widget widget_has_radio_checkbox">
									<div class="form-group">
										<div class="form-elements">
											<label>In Between Date(End)</label>
											<div class="form-item">
												<i class="awe-icon awe-icon-calendar"></i> <input
													type="text" name="endDate" value="${filterend}"
													class="awe-calendar" readonly='true'>
											</div>
										</div>
									</div>
								</div>
								<div class="widget widget_has_radio_checkbox">
									<div class="form-group">
										<div class="form-elements">
											<label>Max Average Cost</label>
											<div class="form-item">
												<i class="awe-icon"></i> <input type="number"
													name="averageCost" value="${filtercost}">
											</div>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</section>
		<footer id="footer-page">
			<div class="container">
				<div class="copyright">
					<p>&#169;2016 Ankit Singh. All rights reserved.</p>
				</div>
			</div>
		</footer>
	</div>
	<%@include file="footer.jsp"%>

</body>
</html>