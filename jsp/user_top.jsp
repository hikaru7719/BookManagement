<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="include.jsp" %>
<html>
<head>
<title>利用者メニュー</title>
</head>


<style>
body {
  font-size: 20px;
  background-color:#ECF0F1;
}

.btn-change1{
    height: 150px;
    width: 250px;
    background:#CA4B7C;
    margin: 50px;
    float: left;
    border: 0px;
    color: #fff;
    box-shadow: 0 0 1px #ccc;
    -webkit-transition-duration: 0.5s;
    -webkit-box-shadow: 0px 0px 0 0 #3FC1C9 inset , 0px 0px 0 0 #3FC1C9 inset;
}
.btn-change1:hover{
    -webkit-box-shadow: 150px 0px 0 0 #3FC1C9 inset , -150px 0px 0 0 #3FC1C9 inset;
}
</style>



<body>

<div class="container">
	<div class="row">
	<font face="游ゴシック">
		<h2 class="text-center page-header">メニュー</h2>
        <a href ="./GetBookServlet"><button class="btn-change1">書籍一覧</button></a>
        <a href ="./Search.jsp"><button class="btn-change1">書籍の検索</button></a>
        <a href ="./LogoutServlet"><button class="btn-change1">ログアウト</button></a>
        </font>
	</div>
</div>

</body>
</html>