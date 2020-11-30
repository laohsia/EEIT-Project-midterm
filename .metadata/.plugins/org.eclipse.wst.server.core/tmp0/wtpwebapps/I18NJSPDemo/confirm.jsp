<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8" />
<html>
<fmt:setLocale value="${param.locale}"  />
<head>
<fmt:bundle basename="app">
<title>developerWorks <fmt:message key="email"/></title>
</head>
<body>

<table border="1">
<tr>
<td colspan=2 bgcolor="black">
<br/>
<center><font face="arial" size=+2 color="white"><b>
       <i>developer</i>Works <fmt:message key="email"/>
         </b></font></center>
<br/>

</td>
</tr>
<tr>
<td><fmt:message key="userid"/></td>
<td>${param.userid}</td>
</tr>

<tr>
<td><fmt:message key="password"/></td>
<td>${param.pass}</td>
</tr>





</table>


</body>
</fmt:bundle>

</html>











