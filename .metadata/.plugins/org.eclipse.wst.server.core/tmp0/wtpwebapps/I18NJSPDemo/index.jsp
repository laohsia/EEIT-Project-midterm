<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Select Language</title>
</head>
<body>
<table>
<tr>
<td colspan=5 bgcolor="black">
<br/>
<center><font face="arial" size=+2 color="white"><b><i>developer</i>Works Email</b></font></center>
<br/>

</td>
</tr>
 <tr><td>

 <c:url value="login.jsp" var="englishURL">
   <c:param name="locale" value="en_GB"/>
 </c:url>

 <a href="${englishURL}">
    <img src="english.gif"/>
 </a>
</td>
<td>
  <c:url value="login.jsp" var="japaneseURL">
     <c:param name="locale" value="ja_JP"/>
  </c:url>

  <a href="${japaneseURL}"> 
       <img src="japanese.gif"/>
  </a>
</td>
<td>
  <c:url value="login.jsp" var="koreanURL">
     <c:param name="locale" value="ko_KR"/>
  </c:url>

  <a href="${koreanURL}"> 
       <img src="korean.gif"/>
  </a>
</td>
<td>
  <c:url value="login.jsp" var="taiwanURL">
     <c:param name="locale" value="zh_TW"/>
  </c:url>

  <a href="${taiwanURL}"> 
       <img src="taiwan.gif"/>
  </a>
</td>
<td>
  <c:url value="login.jsp" var="chinaURL">
     <c:param name="locale" value="zh_CN"/>
  </c:url>

  <a href="${chinaURL}"> 
       <img src="china.gif"/>
  </a>
</td>
</tr>
</table>
</body>
</html> 
