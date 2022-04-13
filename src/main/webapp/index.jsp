<%@ page import="com.example.demo_web.entity.Account" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%
    Account account = (Account) session.getAttribute("currenAccount");
    boolean isLogin = false;
    if (account != null){
        isLogin = true;
    }
    String currenUsername = account == null ? "Plesase to login!" : account.getUsername();
%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <%="I love You"%>
    <%if (isLogin){%>
        <div class="container">
            <div class="col-md-6" style="text-align: center">
                <img src="https://thuthuatnhanh.com/wp-content/uploads/2019/05/gai-xinh-toc-ngan-facebook.jpg">

            </div>
        </div>
    <%}else {%>
        <p><a href="login">Mày phải đăng nhập vào.</a>. <a href="register"> Chưa có tk thì đăng ký.</a></p>
    <%}%>
</body>
</html>