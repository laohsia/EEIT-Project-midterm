<%@page import="userDAO.UserDao"%>
<jsp:useBean id="u" class="userBean.User"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
UserDao.delete(u);
response.sendRedirect("viewusers.jsp");
%>