<html lang="zh-CN" class="translated-ltr"><head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<!-- CSS -->
	<link rel="stylesheet" href="/static/css/bootstrap-reboot.min.css">
	<link rel="stylesheet" href="/static/css/bootstrap-grid.min.css">
	<link rel="stylesheet" href="/static/css/owl.carousel.min.css">
	<link rel="stylesheet" href="/static/css/nouislider.min.css">
	<link rel="stylesheet" href="/static/css/select2.min.css">
	<link rel="stylesheet" href="/static/css/jquery.mCustomScrollbar.min.css">
	<link rel="stylesheet" href="/static/css/ionicons.min.css">
	<link rel="stylesheet" href="/static/css/main.css">

	<!-- Favicons -->
	<link rel="icon" type="image/png" href="/static/icon/favicon-32x32.png" sizes="32x32">
	<link rel="apple-touch-icon" href="/static/icon/favicon-32x32.png">
	<link rel="apple-touch-icon" sizes="72x72" href="/static/icon/apple-touch-icon-72x72.png">
	<link rel="apple-touch-icon" sizes="114x114" href="/static/icon/apple-touch-icon-114x114.png">
	<link rel="apple-touch-icon" sizes="144x144" href="/static/icon/apple-touch-icon-144x144.png">

	<meta name="description" content="">
	<meta name="keywords" content="">
	<meta name="author" content="Dmitry Volkov">
	<title>Home</title>

<body>
	<!-- header -->
	<header class="header">
		<div class="container">
			<div class="row">
				<div class="col-7 col-md-9 col-lg-8 col-xl-9">
					<div class="header__content">
						<!-- header menu btn -->
						<button class="header__btn" type="button">
							<span></span>
							<span></span>
							<span></span>
						</button>
						<!-- end header menu btn -->

						<!-- header logo -->
						<a href="/" class="header__logo">
							<img src="/static/img/logo.svg" alt="">
						</a>
						<!-- end header logo -->

						<!-- header nav -->
						<ul class="header__nav">
							<!-- dropdown -->
							<li class="header__nav-item">
								<a href="/" class="header__nav-link"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">首页</font></font></a>
							</li>
							<!-- end dropdown -->



							<!-- dropdown -->
							<li class="header__nav-item">
								<a class="dropdown-toggle header__nav-link" href="#" role="button" id="dropdownMenuCompanies" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">介绍</font></font></a>

								<ul class="dropdown-menu header__dropdown-menu" aria-labelledby="dropdownMenuCompanies">
									<li><a href="#"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">公司介绍</font></font></a></li>
									<li><a href="#"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">公司简介</font></font></a></li>
								</ul>
							</li>
							<!-- end dropdown -->



							<!-- dropdown -->
							<li class="header__nav-item">
								<a class="dropdown-toggle header__nav-link" href="#" role="button" id="dropdownMenuPages" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">其他</font></font></a>

								<ul class="dropdown-menu header__dropdown-menu" aria-labelledby="dropdownMenuPages">
									<li><a href="/login"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">登入</font></font></a></li>
									<li><a href="/logout"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">退出</font></font></a></li>
								</ul>
							</li>
							<!-- end dropdown -->
						</ul>
						<!-- end header nav -->

						<!-- header search -->
						<form action="#" class="header__search">
							<input class="header__search-input" type="text" placeholder="搜索...">
							<button class="header__search-button" type="button">
								<i class="icon ion-ios-search"></i>
							</button>
						</form>
						<!-- end header search -->
					</div>
				</div>

				<div class="col-5 col-md-3 col-lg-4 col-xl-3">
					<div class="header__content header__content--end">
						<a href="#" class="header__messages header__messages--active">
							<i class="icon ion-ios-mail"></i>
						</a>

						<div class="header__notifications">
							<a class="dropdown-toggle header__notifications-btn header__notifications-btn--active" href="#" role="button" id="dropdownMenuNotifications" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								<i class="icon ion-ios-notifications"></i>
							</a>

							<div class="dropdown-menu dropdown-menu-right header__dropdown-menu header__dropdown-menu--right header__dropdown-menu--ntf" aria-labelledby="dropdownMenuNotifications">
								<div class="header__ntf">
									<a href="#" class="header__ntf-img">
										<img src="/static/img/user3.jpg" alt="">
									</a>
									<h6 class="header__ntf-title">
										<span><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Marsha Baldwin</font></font></span><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">评论您的项目。
									</font></font></h6>
								</div>

								<div class="header__ntf">
									<a href="#" class="header__ntf-img">
										<img src="/static/img/user7.jpg" alt="">
									</a>
									<h6 class="header__ntf-title">
										<span><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">安迪·拉莫斯（Andy Ramos）</font></font></span><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">对您的项目发表评论。
									</font></font></h6>
								</div>



								<a href="#" class="header__ntf-more"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">查看更多</font></font></a>
							</div>
						</div>

						<div class="header__profile">
							<a class="dropdown-toggle header__profile-btn" href="#" role="button" id="dropdownMenuProfile" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								<img src="/static/img/user5.jpg" alt="">
								<span><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">${user.name!}</font></font></span>
							</a>

							<ul class="dropdown-menu dropdown-menu-right header__dropdown-menu header__dropdown-menu--right" aria-labelledby="dropdownMenuProfile">
								<li><a href="#"><i class="icon ion-ios-settings"></i><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"> 设定</font></font></a></li>
								<li><a href="/logout"><i class="icon ion-ios-exit"></i><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"> 登出</font></font></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
	<!-- end header -->

	<!-- main content -->
	<main class="main">
		<div class="container">
			<div class="row">
				<div class="col-12 col-md-5 col-lg-4 col-xl-3">
					<!-- user -->
					<div class="user">
						<div class="user__head">
							<div class="user__img">
								<img src="/static/img/user5.jpg" alt="">
							</div>
						</div>
						<div class="user__title">
							<h2><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">${user.name!}</font></font></h2>
							<p><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">${user.introduce!}</font></font></p>
						</div>
						<div class="user__btns">
							<a href="#" class="user__btn user__btn--blue"><span><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">写点文章</font></font></span></a>
							<a href="/" class="user__btn user__btn--orange"><span><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">浏览首页</font></font></span></a>
						</div>
						<ul class="user__stats">
							<li>
								<p><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">以下</font></font></p>
								<span><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">26</font></font></span>
							</li>
							<li>
								<p><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">追随者</font></font></p>
								<span><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">88</font></font></span>
							</li>
						</ul>
						<a href="#" class="sidebox__more"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">查看资料</font></font></a>
					</div>
					<!-- end user -->

<#--					<!-- sidebox &ndash;&gt;
					<div class="sidebox">
						<h4 class="sidebox__title"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">意见建议</font></font></h4>
						<div class="sidebox__content">
							<div class="sidebox__user">
								<a href="#" class="sidebox__user-img">
									<img src="/static/img/user7.jpg" alt="">
								</a>
								<div class="sidebox__user-title">
									<h5><a href="#"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">安迪·拉莫斯（Andy Ramos）</font></font></a></h5>
									<p><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">秘书</font></font></p>
								</div>
								<button class="sidebox__user-btn" type="button">
									<i class="icon ion-ios-add"></i>
								</button>
							</div>

							<div class="sidebox__user">
								<a href="#" class="sidebox__user-img">
									<img src="/static/img/user4.jpg" alt="">
								</a>
								<div class="sidebox__user-title">
									<h5><a href="#"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">玛莎·鲍德温（Marsha Baldwin）</font></font></a></h5>
									<p><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">园丁</font></font></p>
								</div>
								<button class="sidebox__user-btn" type="button">
									<i class="icon ion-ios-add"></i>
								</button>
							</div>
						</div>
						<a href="#" class="sidebox__more"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">查看更多</font></font></a>
					</div>
					<!-- end sidebox &ndash;&gt;-->


				</div>

				<div class="col-12 col-md-7 col-lg-8 col-xl-6">
					<#list blogs as blog>


					<!-- post -->
					<div class="post">
						<div class="post__head">
							<a href="#" class="post__head-img">
								<img src="/static/img/user8.jpg" alt="">
							</a>
							<div class="post__head-title">
								<h5><a href="#"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">${user.name}</font></font></a></h5>
								<p><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">${blog.createdAt?datetime}</font></font></p>
							</div>


						</div>



						<h2 class="post__title"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">${blog.title}</font></font></h2>

						<div class="post__options">
							<p><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">${blog.createdAt?datetime}</font></font></p>
						</div>



						<div class="post__description">
							<p><font style="vertical-align: inherit;">
									${blog.content}
								</font>
							</p>
							<a href="#"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">查看详情</font></font></a>
						</div>

						<div class="post__tags">
							<a href="#"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">HTML </font></font></a>
							<a href="#"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">CSS </font></font></a>
							<a href="#"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">PHP</font></font></a>
						</div>

						<div class="post__stats">
							<div>
								<a class="post__likes" href="#"><i class="icon ion-ios-heart"></i> <span><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">15</font></font></span></a>
								<a class="post__comments" data-toggle="collapse" href="#collapse1" role="button" aria-expanded="false" aria-controls="collapse1"><i class="icon ion-ios-text"></i> <span><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">0</font></font></span></a>
							</div>

							<div class="post__views">
								<i class="icon ion-ios-eye"></i> <span><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">214</font></font></span>
							</div>
						</div>

						<div class="collapse post__collapse" id="collapse1">
							<form action="#" class="post__form">
								<input type="text" placeholder="输入您的评论...">
								<button type="button"><i class="icon ion-ios-paper-plane"></i></button>
							</form>
						</div>
					</div>
					<!-- end post -->
					</#list>


					<!-- view more -->
					<button class="main__btn" type="button"><span><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">加载更多</font></font></span></button>
					<!-- end view more -->
				</div>

				<div class="col-12 col-md-5 col-lg-4 col-xl-3">



					<!-- sidebox -->
					<div class="sidebox sidebox--desk">
						<h4 class="sidebox__title"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">最热文章</font></font></h4>
						<div class="sidebox__content">

							<#list latestblogs as lblog>
							<div class="sidebox__job">
								<div class="sidebox__job-title">
									<a href="#"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">${lblog.title} </font></font></a>
									<span><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">${lblog.createdAt?date}</font></font></span>
								</div>
								<p class="sidebox__job-description"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">${lblog.content}
								</font></font></p>
							</div>

							</#list>


						</div>
						<a href="#" class="sidebox__more"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">查看更多</font></font></a>
					</div>
					<!-- end sidebox -->

				</div>
			</div>
		</div>
	</main>
	<!-- end main content -->

	<!-- footer -->
	<footer class="footer">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="footer__content">
						<a href="/" class="footer__logo">
							<img src="/static/img/logo.svg" alt="">
						</a>

						<span class="footer__copyright"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">©2021 </font></font><br><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><a href="http://blog.cnscud.com/" target="_blank">由飞云开发</a></font></font></span>

						<nav class="footer__nav">
							<a href="#"><span style="vertical-align: inherit;"><font style="vertical-align: inherit;">联系</font></span></a>
							<a href="#"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">常见问题解答</font></font></a>
							<a href="#"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">隐私政策</font></font></a>
						</nav>

						<button class="footer__back" type="button">
							<i class="icon ion-ios-arrow-round-up"></i>
						</button>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<!-- end footer -->

	<!-- JS -->
	<script src="/static/js/jquery-3.4.1.min.js"></script>
	<script src="/static/js/bootstrap.bundle.min.js"></script>
	<script src="/static/js/owl.carousel.min.js"></script>
	<script src="/static/js/wNumb.js"></script>
	<script src="/static/js/nouislider.min.js"></script>
	<script src="/static/js/select2.min.js"></script>
	<script src="/static/js/jquery.mousewheel.min.js"></script>
	<script src="/static/js/jquery.mCustomScrollbar.min.js"></script>
	<script src="/static/js/main.js"></script>


</body></html>