<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import= "beans.Book" %>
<%@ page import= "java.util.ArrayList" %>
<%@ include file="menu.jsp" %>
<%@ include file="include.jsp" %>
<%@ page import="org.apache.commons.lang3.StringEscapeUtils" %>
>
<%
ArrayList list =  (ArrayList)request.getAttribute("list");
%>
<% String number2 =(String)request.getAttribute("number"); %>

<HTML>
<head>
<title>BookManagement</title>
<style type ="text/css">
</style>
</head>
<style>

body {
  font-size: 18px;
  background-color:#ECF0F1;
}


</style>


<SCRIPT language="JavaScript">
</SCRIPT>
<BR>

</div>
<br>
<br>
<br>
<br>
<div align="center">



</div>

<FORM>
<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Ubuntu" />
<font face="游ゴシック">
<div class="container">
    <div class="row">
         <div class="brand">
         <h4> 検索結果(全<%=list.size()%>件)</h4>
         </div>
          <% for(int i=0;i<list.size();i++){ %>
            <ul class="list-group">
                <li class="list-group-item">

                        <%Book book = (Book)list.get(i);%>

                        <%if(number2 != null){ %><TD><FONT><a href="./GetOneBookServlet?number=<%=book.getNumber()%>&number2=<%=number2%>">       <%=StringEscapeUtils.escapeHtml4(book.getName())%></a></FONT></TD></li>
                        <% }else {%><TD><FONT><a href="./GetOneBookServlet?number=<%=book.getNumber()%>">       <%=StringEscapeUtils.escapeHtml4(book.getName())%>     </a></FONT></TD></li><%} %>

                        <% } %>
            </ul>
        </div>
</div>
</font>
</FORM>
</BODY>
</HTML>