<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import= "beans.Book" %>
<%@ page import= "beans.ReserveInfo" %>
<%@ page import= "java.util.ArrayList" %>
<%@ page import= "beans.User" %>
<%@ include file="menu.jsp" %>
<%@ include file="include.jsp" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="org.apache.commons.lang3.StringEscapeUtils" %>
<%
HttpSession session2 = ((HttpServletRequest)request).getSession();
Book book =  (Book)request.getAttribute("book");
User user1 = (User) session2.getAttribute("user");
ArrayList list=(ArrayList)request.getAttribute("list");
ReserveInfo info = (ReserveInfo)list.get(0) ;
String number2 = (String) request.getAttribute("number2");
%>



<HTML>
<head>
<title>BookManagement</title>
</head>
<style type ="text/css">
body{
  background-color:#ECF0F1;
}
.glyphicon-lg
{
    font-size:4em;
    padding:20px;
}
.info-block
{
    border-right:10px solid #E6E6E6;
    font-size:20px;
    margin:25px;
    padding-top:20px;
    padding-bottom:20px;
    background-color:white
}
.info-block .square-box
{
    width:150px;min-height:150px;margin-right:22px;text-align:center!important;background-color:#676767;padding:20px 0
}
.info-block.block-info
{
    border-color:#20819e
}
.info-block.block-info .square-box
{
    background-color:#20819e;color:#FFF
}



.btn-change1{
    height: 150px;
    width: 250px;
    background:#C57F1E;
    margin: 50px;
    float: left;
    border: 0px;
    font-size:20px;
    color: #fff;
    box-shadow: 0 0 1px #ccc;
    -webkit-transition-duration: 0.5s;
    -webkit-box-shadow: 0px 0px 0 0 #20819e inset , 0px 0px 0 0 #20819e inset;
}
.btn-change1:hover{
    -webkit-box-shadow: 150px 0px 0 0 #20819e inset , -150px 0px 0 0 #20819e inset;
}

</style>


<SCRIPT type="text/JavaScript">
function disp(){
	if( window.confirm('この本を借りますか？')){
	 location.href= "./LendServlet?number=<%=book.getNumber()%>";
	 }
	 }
function disp2(){
	if(window.confirm('この本を予約しますか？')){
		location.href="./ReserveServlet?number=<%=book.getNumber()%>";
	}
}
function disp3(){
	if( window.confirm('この本を借りますか？')){
	 location.href= "./LendReserveServlet?number=<%=book.getNumber()%>&reserve_book_number=<%=info.getNumber()%>";
	 }
	 }
</SCRIPT>
<BODY>


<div align="center">
<font size="+8"></font>
<BR>
</div>
<br>
<br>
<br>
<br>



<div class="container">
	<div class="row">
	<font face="游ゴシック">
		<h3><%=StringEscapeUtils.escapeHtml4(book.getName()) %></h3>
               <div class="info-block block-info clearfix">
                    <div class="square-box pull-left">
                        <span class="glyphicon glyphicon-book glyphicon-lg"></span>
                    </div>

                    <span>著者        :　<%=StringEscapeUtils.escapeHtml4(book.getAuthor()) %></span><br>
                    <span>分類        :　<%=StringEscapeUtils.escapeHtml4(book.getGroup()) %></span><br>
                    <span>出版年月日  :　<%=book.getDate() %></span><br>
                    <span>貸出状況    :　<%if(book.getLendstatus()==0) %>貸し出し可<%else %>貸し出し中</span>
                    <br>
                    <span>貸出予約者  :　<%if(list.isEmpty() != true){%>
                    					<% 	if(list.size()!=1){%>
	                                     <% for(int i=1;i<list.size();i=i+2){%>
		                                 <%=list.get(i)%>
		                                 <%} %>
		                                 <%} %>
		                                 <%} %></span>
               </div>

           <%if(number2 != null && number2.equals("1")){ %>
	              <a href = "./edit.jsp?number=<%=book.getNumber()%>&name=<%=book.getName()%>&author=<%=book.getAuthor()%>&group=<%=book.getGroup()%>&date=<%=book.getDate()%>&lendstatus=<%=book.getLendstatus()%>">
	              <button class="btn-change1">編集・削除</button></a>

           <%} else{%>

           <%if(book.getLendstatus()==0 ) {%>
           		<% if(list.size() == 1){%>
                  <button class="btn-change1" onClick="disp()">借りる</button><%} %>
                  <%if(list.size() != 1){ %>
                		<%if(info.getUser_id().equals(user1.getId())) {%>
                		<button class="btn-change1" onClick="disp3()">借りる</button><%} %>
                		<% } }%>
           <%if(book.getLendstatus()==1) {%>
                  <div align="right"><button class="btn-change1" onClick="disp2()">予約する</button></div>
           <%} %>
           <%} %>

    </font>
	</div>
</div>

</BODY>
</HTML>