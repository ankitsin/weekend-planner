<script type="text/javascript" src="js/lib/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="js/lib/masonry.pkgd.min.js"></script>
<script type="text/javascript" src="js/lib/jquery.parallax-1.1.3.js"></script>
<script type="text/javascript" src="js/lib/jquery.owl.carousel.js"></script>
<script type="text/javascript" src="js/lib/jquery-ui.js"></script>
<script type="text/javascript" src="js/scripts.js"></script>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<script type="text/javascript">
	$('#form1').click(function() {

		var destinationType = '';
		$('[class="destype"]').each(function(i, e) {
			if ($(e).is(':checked')) {
				var comma = destinationType.length === 0 ? '' : ',';
				destinationType += (comma + e.value);
			}
		});
		$('#filterdes').attr('value', destinationType);

		var numOfDay = '';
		$('[class="numdays"]').each(function(i, e) {
			if ($(e).is(':checked')) {
				var comma = numOfDay.length === 0 ? '' : ',';
				numOfDay += (comma + e.value);
			}
		});
		$('#numofday').attr('value', numOfDay);
		console.log(destinationType);
		console.log(numOfDay);
	});

	/* function signOut() {
		var auth2 = gapi.auth2.getAuthInstance();
		auth2.signOut().then(function(a) {

			console.log('User signed out.');
		});
	}
	function login() {
		var auth2 = gapi.auth2.getAuthInstance();
		auth2.signIn({
			scope : 'https://www.googleapis.com/auth/user.phonenumbers.read',
			redirect_uri : 'localhost:8080?status=success'
		}).then(function(a, b) {
			console.log(a);
			console.log(b);
		});
	} */
	function onSignIn(googleUser) {
		var profile = googleUser.getBasicProfile();
		console.log(profile);
		console.log('ID: ' + profile.getId());
		console.log('Name: ' + profile.getName());
		console.log('Image URL: ' + profile.getImageUrl());
		console.log('Email: ' + profile.getEmail());
	}
	function signOut() {
		var auth2 = gapi.auth2.getAuthInstance();
		auth2.signOut().then(function(a) {
			document.getElementById("signout").style.display = "none";
			console.log('User signed out.');
		});
	}
	function change() {
		document.getElementById("signout").style.display = "";
	}
	function login(googleUser) {
		var profile = googleUser.getBasicProfile();
		console.log(googleUser.getAuthResponse().id_token);
		var profile = googleUser.getBasicProfile();
		$.post('/weekend_planner/login', {
			name : profile.getName(),
			id : profile.getId(),
			email : profile.getEmail()
		});
	}
	function onSignIn(googleUser) {
		var profile = googleUser.getBasicProfile();
		console.log(profile);
		console.log('ID: ' + googleUser.getAuthResponse().id_token);
		console.log('Name: ' + profile.getName());
		console.log('Image URL: ' + profile.getImageUrl());
		console.log('Email: ' + profile.getEmail());

	}
</script>
