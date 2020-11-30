<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<c:set var="loc" value="en_GB"/>
<c:if test="${!(empty param.locale)}">
  <c:set var="loc" value="${param.locale}"/>
</c:if>
<fmt:setLocale value="${loc}" />


<fmt:bundle basename="app">
<head>
<title>developerWorks <fmt:message key="email"/></title>
</head>
<body>

<c:url value="confirm.jsp" var="formActionURL" />

<form action="${formActionURL}" method="post">
<table>
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
<td>

<input type="hidden" name="locale" value="${loc}"/>
<input type="text" name="userid" size="40"/></td>
</tr>

<tr>
<td><fmt:message key="password"/></td>
<td><input type="text" name="pass" size="40"/></td>
</tr>


<tr>
<td colspan="2" align="center">
<input type="submit" value="<fmt:message key='login'/>"/></td>
</tr>

</table>

</form>

</body>
</fmt:bundle>

</html>











