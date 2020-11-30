
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.*;

import mvc.bean.*;
import java.io.*;
import java.sql.*;

import javax.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.bean.regisBean;

/**
 * Servlet implementation class regisServlet
 */
@WebServlet("/regisServlet")
public class regisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
	 private static final String CHARSET_CODE = "UTF-8";
	 public void init(ServletConfig config) throws ServletException
	 {
        super.init(config);
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding(CHARSET_CODE);
	    response.setContentType(CONTENT_TYPE);
	    
	    response.setHeader("Cache-Control","no-cache"); // HTTP 1.1
		response.setHeader("Pragma","no-cache"); // HTTP 1.0
		response.setDateHeader ("Expires", -1); // Prevents caching at the proxy server
		if(request.getParameter("submit")!=null)
			gotoSubmitProcess(request,response);
		else if (request.getParameter("confirm")!=null)
		     gotoConfirmProcess(request, response);
	}
	
	public void gotoSubmitProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
		String location;
		String name;
		String birthyear,birthmonth,birthday;
		String id;
		String address;
	    String phone;
	    String mailaddress;
		
	location = request.getParameter("location");
	name = request.getParameter("name").trim();
    birthyear = request.getParameter("birthyear").trim();
    birthmonth = request.getParameter("birthmonth").trim();
    birthday = request.getParameter("birthday").trim();
    id = request.getParameter("id").trim();
    address = request.getParameter("address").trim();
    phone = request.getParameter("phone").trim();
    mailaddress = request.getParameter("mailaddress").trim();
    regisBean reg_regis =  new regisBean(location, name, birthyear, birthmonth, birthday, id, address, phone, mailaddress);
    request.getSession(true).setAttribute("reg_regis",reg_regis);
    request.getRequestDispatcher("/Displayregis.jsp").forward(request,response);
	}

		public void gotoConfirmProcess(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException
		{
		 DataSource ds = null;
		    InitialContext ctxt = null;
		    Connection conn = null;
		    
		    try {
		     PrintWriter out =response.getWriter();
		      //�إ�Context Object,�s��JNDI Server
		      ctxt = new InitialContext();

		      //�ϥ�JNDI API���DataSource
		      ds = ( DataSource ) ctxt.lookup("java:comp/env/jdbc/TableGameDB");
		     //ds = ( DataSource ) ctxt.lookup("jdbc/OracleXE");
		      //�VDataSource�nConnection
		      conn = ds.getConnection();

		      //�إ�Database Access Object,�t�dTable��Access
		      RegisDAO regisDAO = new RegisDAO(conn);
		      regisBean regisData = (regisBean)request.getSession(true).getAttribute("reg_regis");
		      if (regisDAO.insertRegis(regisData))
		        {
		          System.out.println("Get some SQL commands done!");
		          request.getSession(true).invalidate();

		          out.println("報名成功");
		        }
		    } catch (NamingException ne) {
		      System.out.println("Naming Service Lookup Exception");  
		    } catch (SQLException e) {
		    	System.out.println(e);
		      System.out.println("Database Connection Error"); 
		    } finally {
		      try {
		        if (conn != null) conn.close();
		      } catch (Exception e) {
		        System.out.println("Connection Pool Error!");
		      }
		    }
		           
		  }
}

			// TODO Auto-generated method stub