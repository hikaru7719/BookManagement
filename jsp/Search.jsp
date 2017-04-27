<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="include.jsp" %>
<%@ include file="menu.jsp" %>
<%String number = (String)request.getParameter("number"); %>

<HTML>

<style>
body{
    font-family:"游ゴシック";
    font-size:25px;
    background:#ECF0F1;

}
.bookname{
    margin:0px;
    margin-left:200px;
}

.group{
    margin:50px;
    margin-left:200px;
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
<BODY>
<div class="bookname">

<br>
<br>
<br>
<br>
<FORM action="./SearchServlet" method="post">
書籍名の入力　
<INPUT type="text" name="name" maxlength="20">
<%if(number != null){ %>
<input type= "hidden" name = "number" value="<%=number%>" >
<%} %>
</div>


<div class="group">
分類選択　　　
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
<option value="">指定なし</option>
</select>
</div>


<button class="btn-change1">検索</button><br>
</center>
<br>
</FORM>

</center>
</BODY>
</HTML>
