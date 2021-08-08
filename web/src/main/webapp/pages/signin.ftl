<html lang="zh-CN" class="translated-ltr">
<head>
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

    <title>登录</title>
</head>

<body>
<div class="sign">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <div class="sign__content">
                    <!-- authorization form -->
                    <form action="#" class="sign__form">
                        <a href="index.html" class="sign__logo">
                            <img src="/static/img/logo.jpg" alt="">
                        </a>

                        <div class="sign__group">
                            <input type="text" name="username" id="username" class="sign__input" placeholder="账号名">
                        </div>

                        <div class="sign__group">
                            <input type="password" name="password" id="password" class="sign__input" placeholder="密码">
                        </div>

                        <div class="sign__group sign__group--checkbox">
                            <input id="remember" name="remember" type="checkbox" checked="checked">
                            <label for="remember"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">记住账号</font></font></label>
                        </div>

                        <button class="sign__btn" type="button" onclick="gologin()"><span><font style="vertical-align: inherit;"><font
                                            style="vertical-align: inherit;">登入</font></font></span>
                        </button>

                        <span class="sign__text"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">还没有帐号？</font></font><a
                                    href="#"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">注册！</font></font></a></span>

                        <span class="sign__text"><a href="#"><font style="vertical-align: inherit;"><font
                                            style="vertical-align: inherit;">忘记密码？</font></font></a></span>
                    </form>
                    <!-- end authorization form -->
                </div>
            </div>
        </div>
    </div>
</div>

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

<script type="application/javascript">
    function gologin() {

        $.ajax({
            url: '/login',
            type: 'POST',
            dataType: "json",
            data: {
                "username": $("#username").val(),
                "password": $("#password").val()
            },
            success: function (res) {
                if (res && res.code === 0) {
                    location.href = "/home";
                }
                else {
                    alert('登录失败: ' + res.msg);
                }
            },
            error: function (res) {
                // 错误时处理逻辑
                alert('登录失败: ' + res);
            }
        });

    }
</script>


<div class="goog-te-spinner-pos">
    <div class="goog-te-spinner-animation">
        <svg xmlns="http://www.w3.org/2000/svg" class="goog-te-spinner" width="96px" height="96px" viewBox="0 0 66 66">
            <circle class="goog-te-spinner-path" fill="none" stroke-width="6" stroke-linecap="round" cx="33" cy="33" r="30"></circle>
        </svg>
    </div>
</div>
</body>
</html>