<% request.setCharacterEncoding("UTF-8"); %>
<%
response.setContentType("text/html;charset=UTF-8");
response.setHeader("Cache-Control","no-cache"); // HTTP 1.1
response.setHeader("Pragma","no-cache"); // HTTP 1.0
response.setDateHeader ("Expires", -1); // Prevents caching at the proxy server
%> 
<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.Console"%>
<%@page import="userDAO.UserDao"%>
<jsp:useBean id="u" class="userBean.User"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>
<%
int i=UserDao.insert(u);
if(i>0){
response.sendRedirect("adduser-success.jsp");

}else{
response.sendRedirect("adduser-error.jsp");

}
%>