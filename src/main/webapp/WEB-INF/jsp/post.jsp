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
						<h2 class="text-center">Post Your Trip</h2>
						<form action="post" method="post">
							<div class="form-group">
								<div class="form-elements">
									<label>Trip Name</label>
									<div class="form-item">
										 <input type="text" id="tripid"
											name="tripName" maxlength="100" required>
									</div>
								</div>
								<div class="form-elements">

									<label>Destination</label>
									<div class="form-item">
										<div class="page-top">
											<select class="awe-select" id="destid" name="destinationName"
												required><option></option>
												<c:forEach var="destination" items="${destinations}">
													<option>${destination.getLocation()}</option>
												</c:forEach>
											</select>
										</div>
									</div>
								</div>
								<div class="form-elements">
									<label>Going Date</label>
									<div class="form-item">
										<i class="awe-icon awe-icon-calendar"></i> <input type="text"
											id="calenderid" name="goingDate" class="awe-calendar"
											readonly='true' required />
									</div>
								</div>
								<div class="form-elements">
									<label>Number Of People Going</label>
									<div class="form-item">
										<input type="number" id="numof" name="goingPeople" required>
									</div>
								</div>
								<div class="form-elements">
									<label>Space Left</label>
									<div class="form-item">
										<input type="number" id="space" name="spaceLeft" required>
									</div>
								</div>
								<div class="form-elements">
									<label>Number Of Days</label>
									<div class="form-item" style="padding-right: 40px;">
										<input type="number" id="days" name="numOfDay" required>
									</div>
								</div>
								<div class="form-elements">
									<label>Average Cost/Person</label>
									<div class="form-item" style="padding-right: 40px;">
										<input type="number" id="cost" name="averageCost" required>
									</div>
								</div>
								<input type="hidden" id="tokenid" name="token" required />
								<div class="form-actions">
									<input type="submit" class="form1" value="Post the Trip">
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
							<div class="filter-item-wrapper"></div>

						</div>
					</div>
				</div>
			</div>
		</section>
		<%@include file="copyright.jsp"%>
	</div>
	<%@include file="footer.jsp"%>

</body>
</html>