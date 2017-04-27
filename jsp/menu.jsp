<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="include.jsp" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import= "beans.User" %>
<%	HttpSession session1 = ((HttpServletRequest)request).getSession();
User user = (User) session1.getAttribute("user"); %>
<html>

<style>
.menu
{
background-color: #00547E;
border-bottom: 4px solid #FCCF5B;
width:100%;
height: 100px;;
padding: 30px 10px;
position: fixed;
margin: 0px;
z-index: 1;
opacity: 0.9;
}

.menu  .navbar-nav > .active > a
{
background-color : #FCCF5B;
color: white;
font-weight: bold;
}

.menu  .navbar-nav >  li >  a
{
font-size: 18px;
color: white;
padding: 10px 35px;

}
.menu  .navbar-nav >  li >  a:hover
{
background-color: #FCCF5B;
}

.navbar-header > a
{

padding: 0px;
margin: 0px;
text-decoration: none;
color: white;
font-size: 25px;
padding: 5px 30px;
}
.navbar-header > a:hover
{
text-decoration: none;
color: #FCCF5B;
}

</style>
<head>
<body>
<div class="menu">
    <div class="container-fluid">
		<div class="navbar-header">
			<a href="./manager_top.jsp">BookManagement</a>
		</div>
		<div>
			<ul class="nav navbar-nav navbar-right">
			    <%if(user.getRole()==1) %><li><a href="./manager_top.jsp" >メニュー</a></li>
			    <%if(user.getRole()==0) %><li><a href="./user_top.jsp" >メニュー</a></li>
				<li><a href="./LogoutServlet"><span class="glyphicon glyphicon-log-out"></span>　ログアウト</a></li>
			</ul>
		</div>
	</div>
</div>
</body>
</head>
</html>