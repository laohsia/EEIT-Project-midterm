<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<sql:setDataSource var="ds" dataSource="jdbc/EmployeeDB" />
<sql:query sql="select * from books" var="rs" dataSource="${ds}" /> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test Database Connection Pooling</title>
</head>
<body>
 <h2>Results</h2>
  <table border="1" >
  	<th>id</th>
    <th>author</th>
    <th>title</th> 
    <th>price</th>
    <th>qty</th>
    <c:forEach var="row" items="${rs.rows}">
    <tr>
    <td>${row.id}</td>
    <td>${row.author}</td>
    <td>${row.title}</td>
    <td>${row.price}</td>
    <td>${row.qty}</td>
    </tr>
    </c:forEach>
  </table>
</body>
</html>