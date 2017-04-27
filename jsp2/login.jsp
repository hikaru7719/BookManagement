<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="include.jsp" %>
<HTML>
<head>
<title>図書管理システム</title>

</head>


<style>
body {

	background: #eee
		url(../img/book.png);
	background-size: cover

}
*:focus{
    outline:none;
}

.container {
    position: center;
}

.form-login {
    background-color: #EDEDED;
    padding-top: 10px;
    padding-bottom: 10px;
    padding-left: 20px;
    padding-right: 20px;
    border-radius: 15px;
    border-color:#d2d2d2;
    border-width: 20px;
    box-shadow:0 1px 0 #cfcfcf;
    position:center;
}

h3 {
 border:0 solid #fff;
 border-bottom-width:1px;
 padding-bottom:10px;
 text-align: center;
}

.form-control {
    border-radius: 10px;
}

.wrapper {
    text-align: center;
}
</style>

<br>
<br>
<br>
<br>
<br>
<center>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<form method="POST" action="./LoginServlet">
<div class="container">
    <div class="row">
        <div class="col-md-offset-5 col-md-3">
            <div class="form-login">
            <h3><font face="游ゴシック">図書管理システム</font></h3>
            <br>
            <br>
            <label for="id">ID</label>
            <input type="text" name="id" class="form-control input-sm chat-input" placeholder="id" maxlength="25"/>
            <br>
            <label for="password">Password</label>
            <input type="password" name="pass" class="form-control input-sm chat-input" placeholder="password" maxlength="25"/>
            <br>
            <br>
            <div class="wrapper">
            <span class="group-btn">
                <INPUT type="submit" value="Login" class="btn btn-primary btn-md">
            </span>
            </div>
            <br>
            <font color="red" face="游ゴシック">
                  ${error}
            </font>
            </div>
        </div>
    </div>
</div>
</form>
</center>
</body>
</HTML>