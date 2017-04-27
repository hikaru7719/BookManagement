x<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import= "beans.LendInfo" %>
<%@ page import= "java.util.ArrayList" %>
<%@ include file="menu.jsp" %>
<%@ include file="include.jsp" %>
<%@ page import="org.apache.commons.lang3.StringEscapeUtils" %>
<%
ArrayList list =  (ArrayList)request.getAttribute("list");
%>
<%int j,k; %>


<HTML>
<head>
<title>BookManagement</title>
<style type ="text/css">
</style>
</head>
<SCRIPT type="text/JavaScript">

</SCRIPT>
<style>
body{
    font-family:"游ゴシック";
    font-size:25px;
    background:#ECF0F1;
}
.bookname{
    font-size:25px;
    margin:10px;
}

.name{
    font-size:20px;
    margin:10px;
}


.btn-change1{
    height: 100px;
    width: 150px;
    background:#3482AA;
    margin: 50px;
    margin-left:250px;
    float: left;
    border: 0px;
    font-size:15px;
    color: #fff;
    box-shadow: 0 0 1px #ccc;
    -webkit-transition-duration: 0.5s;
    -webkit-box-shadow: 0px 0px 0 0 #A070A1 inset , 0px 0px 0 0 #A070A1 inset;
}
.btn-change1:hover{
    -webkit-box-shadow: 150px 0px 0 0 #A070A1 inset , -150px 0px 0 0 #A070A1 inset;
}
</style>


<SCRIPT language="JavaScript">
</SCRIPT>

<div align="center">
<font size="+8"></font>
<BR>
<br>
<br>
<br>
<font>全貸出件数：<%=list.size()/3%>件</font>
</div>
<br>
<br>

<div align="center">

<CENTER>
<TABLE border="1" cellpadding="0">
   <TBODY>
      <% for(int i=0;i<list.size();i=i+3){ %>
       <%LendInfo info = (LendInfo)list.get(i);%>
       <%j=i+1; %>
       <%k=i+2; %>
        <TR>
         <TD><FONT><div class="bookname"><%=StringEscapeUtils.escapeHtml4((String)list.get(j))%></div><div class="name"> <%=list.get(k)%></div>
         <form method="post" action="./ReturnServlet?number=<%=info.getBook_number()%>&lend_number=<%=info.getNumber()%>">
         <button class="btn-change1">返却</button></form></FONT></TD>
        </TR>
      <% } %>
   </TBODY>
</TABLE>
</CENTER>
     <FONT><h4><a href="./manager_top.jsp">戻る</a></h></FONT>
</div>
</BODY>
</HTML>