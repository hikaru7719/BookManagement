<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="include.jsp" %>
<%@ include file="menu.jsp" %>


<HTML>
<head>
<title>書籍管理システム</title>
<style type ="text/css">
body{
    font-family:"游ゴシック";
    font-size:25px;
    background:#ECF0F1;
}

.bookname{
    margin:30px;
    margin-left:200px;
}

.writer{
    margin:30px;
    margin-left:200px
}

.group{
    margin:30px;
    margin-left:200px
}

.date{
    margin:30px;
    margin-left:200px
}

.btn-change1{
    height: 150px;
    width: 250px;
    background:#3482AA;
    margin: 50px;
    margin-left:250px;
    float: left;
    border: 0px;
    font-size:20px;
    color: #fff;
    box-shadow: 0 0 1px #ccc;
    -webkit-transition-duration: 0.5s;
    -webkit-box-shadow: 0px 0px 0 0 #A070A1 inset , 0px 0px 0 0 #A070A1 inset;
}
.btn-change1:hover{
    -webkit-box-shadow: 150px 0px 0 0 #A070A1 inset , -150px 0px 0 0 #A070A1 inset;
}

</style>
</head>

<body>
<SCRIPT language="JavaScript">

</SCRIPT>

<br>
<br>
<br>
<h2 class="text-center page-header">書籍登録</h2>

<br>

<FORM method="POST" action="./RegistServlet">


<div class="bookname">
         <TD>書籍名</TD>
         <TD><INPUT size="40" type="text" name="name" maxlength="20"></TD>
</div>
<div class="writer">
         <TD>著者名</TD>
         <TD><INPUT size="40" type="text" name="author"maxlength="20"></TD>
</div>
<div class="group">
         <TD>分類</TD>

<select name="group">
<option value="情報一般">情報一般</option>
<option value="ハードウェア">ハードウェア</option>
<option value="OS">OS</option>
<option value="言語">言語</option>
<option value="アプリケーション">アプリケーション</option>
<option value="情報通信/インターネット">情報通信/インターネット</option>
<option value="情報科学">情報科学</option>
<option value="コンピュータ資格試験">コンピュータ資格試験</option>
<option value="その他">その他</option>
</select>
</div>
<div class="date">
		<td>出版年月日</td>

      <input type="date" name="date" >

</div>
<button class="btn-change1">登録</button>


</FORM><font color="red">
${error}
</font>
</body>
</HTML>