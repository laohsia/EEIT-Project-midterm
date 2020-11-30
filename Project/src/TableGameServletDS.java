import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.naming.*;
import javax.sql.*;


public class TableGameServletDS extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
                    throws ServletException, IOException {

    DataSource ds = null;
    InitialContext ctxt = null;
    Connection conn = null;
    
    
    try {
     
      //建立Context Object,連到JNDI Server
      ctxt = new InitialContext();

      //使用JNDI API找到DataSource
      ds = ( DataSource ) ctxt.lookup("java:comp/env/jdbc/TablegameDB");
     
      //向DataSource要Connection
      conn = ds.getConnection();

      //建立Database Access Object,負責Table的Access
      TableGameDAO tableGameDAO = new TableGameDAO(conn);

      //如果要編碼值為UTF-8
     request.setCharacterEncoding("UTF-8");

      if (request.getParameter("QUERY") != null) {
        processQuery(request,response,tableGameDAO);
      } 

//      if (request.getParameter("UPDATE") != null) {
//        processUpdate(request,response,tableGameDAO);
//      } 
    } catch (NamingException ne) {
      System.out.println("Naming Service Lookup Exception");  
    } catch (SQLException e) {
      System.out.println("Database Connection Error"); 
    } finally {
      try {
        if (conn != null) conn.close();
      } catch (Exception e) {
        System.out.println("Connection Pool Error!");
      }
    }
  }

//  private void processUpdate(HttpServletRequest request,
//                             HttpServletResponse response,
//                             TableGameDAO tableGameDAO) throws SQLException, IOException {
//    String C_name = request.getParameter("C_name");
//    String E_name = request.getParameter("E_name");
//    
//    TableGame game = tableGameDAO.findGame(C_name);
//    if (game == null) showError(response, " can not find this game" + C_name);
//  else {
//     game.setC_name(C_name);
//      if (tableGameDAO.updateDept(dept)) showForm(response,dept);
//      else showError(response," update failure");
//    }
//  }

  private void processQuery(HttpServletRequest request, 
                            HttpServletResponse response,
                            TableGameDAO tableGameDAO) throws SQLException,IOException {
	//讀取部門代號
    String C_name = request.getParameter("C_name");

    //透過DAO元件Access Dept Table
    TableGame game = tableGameDAO.findGame(C_name);
    if (game == null) showError(response, " can not find this game" + C_name);
    else              showForm(response, game);

  }

  private void showError(HttpServletResponse response, String message)
                  throws IOException  {
    PrintWriter out = response.getWriter();
    out.println("<HTML>");
    out.println("<HEAD>");
    out.println("<TITLE>Department Form</TITLE>");
    out.println("</HEAD>");
    out.println("<BODY BGCOLOR='#FDF5E6'>");
    out.println("message:"+ message);                  
    out.println("</BODY>");
    out.println("</HTML>");  
    out.close();
  }

  private void showForm(HttpServletResponse response, TableGame game)
                  throws IOException  {
	  
    response.setContentType("text/html;charset=UTF-8");              
    PrintWriter out = response.getWriter();
    out.println("<HTML>");
    out.println("<HEAD>");
    out.println("<TITLE>Department Form</TITLE>");
    out.println("</HEAD>");
    out.println("<BODY BGCOLOR='#FDF5E6'>");
    out.println("<H1 ALIGN='CENTER'>Department Form</H1>");                  
    out.println("<FORM ACTION='./TableGameServletDS'>");
    out.println("Department No:<INPUT TYPE='TEXT' NAME='gamename' VALUE='" +
                game.getC_name() + "'><BR>");
//    out.println("Department Name:  <INPUT TYPE='TEXT' NAME='dname' VALUE='" +
//                dept.getDname() + "'><BR>");
    out.println("  <CENTER>");
    out.println("<INPUT NAME='QUERY'  TYPE='SUBMIT' VALUE='QUERY'>");
    //out.println("<INPUT NAME='UPDATE' TYPE='SUBMIT' VALUE='UPDATE'>");
    out.println("</CENTER>");
    out.println("</FORM>");
    out.println("</BODY>");
    out.println("</HTML>");  
    out.close();
  }

}