<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import= "beans.Book" %>
<%@ page import= "java.util.ArrayList" %>
<%@ include file="menu.jsp" %>
<%@ include file="include.jsp" %>
<%@ page import="org.apache.commons.lang3.StringEscapeUtils" %>
<%
ArrayList list =  (ArrayList)request.getAttribute("book-list");
%>


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
<div align="center">

</div>
<br>
<br>
<br>
<br>
<div align="center">

</div>
</BODY>

<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Ubuntu" />
<font face="游ゴシック">
<div class="container">
    <div class="row">
         <div class="brand">
         <h4> 書籍一覧(全<%=list.size()%>件)</h4>
         </div>
            <ul class="list-group">
                <li class="list-group-item">
                <% for(int i=0;i<list.size();i++){ %>
                 <%Book book = (Book)list.get(i);%>
                  <TR>
                   <TD><li class="list-group-item"><a href="./GetOneBookServlet?number=<%=book.getNumber()%>">      <%=StringEscapeUtils.escapeHtml4(book.getName())%>      </a></li></TD>
                  </TR>
                <% } %>
            </ul>
        </div>
</div>
</font>
</HTML>