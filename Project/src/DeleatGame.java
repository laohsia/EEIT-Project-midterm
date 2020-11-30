

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/DeleatGame")
public class DeleatGame extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DataSource ds = null;
       
	public void init(ServletConfig config) throws ServletException {
		InitialContext ctxt = null;
		try {
			ctxt = new InitialContext();
			ds = (DataSource) ctxt.lookup("java:comp/env/jdbc/TableGameDB");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//String E_name = request.getParameter("e_name");
		String c_name = request.getParameter("c_name");
		String sql1 = "select C_name from product where C_name = " + "'" + c_name + "'";
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt1 = con.prepareStatement(sql1);
				ResultSet rs = pstmt1.executeQuery();
				) {
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
