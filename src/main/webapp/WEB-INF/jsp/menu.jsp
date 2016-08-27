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
					<li class="menu-item-has-children"><a href="postpage">Post</a></li>
					<li class="menu-item-has-children"><a href="signout"
						onclick="signOut()">SignOut</a></li>
					<li class="menu-item-has-children"><%@include
							file="google.jsp"%></li>
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