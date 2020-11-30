

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

/**
 * Servlet implementation class CreatNewActivity
 */
@WebServlet("/CreatNewActivity")
public class CreatNewActivity extends HttpServlet {
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
		String area = request.getParameter("area");
		String activity = request.getParameter("activity");
		String type = request.getParameter("type");
		String date_time_1 = request.getParameter("date_time_1");
		String date_time_2 = request.getParameter("date_time_2");
		String day = request.getParameter("day");
		String location = request.getParameter("location");
		String address = request.getParameter("address");
		String limit_per = request.getParameter("limit_per");
		String cost = request.getParameter("cost");

		
		String sql = "select activity from Activity where type = "+"'"+type+"'";
		String sql1 = "insert into product values (?,?,?,?,?,?,?,?,?,?)";
		
		try(Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				PreparedStatement pstmt1 = con.prepareStatement(sql1);
				ResultSet rs = pstmt.executeQuery();
				){

			System.out.println(rs.next());
			rs.next();
		
	
			pstmt1.setString(1,area);
			pstmt1.setString(2,activity);
			pstmt1.setString(3,type);
			pstmt1.setString(4,date_time_1);
			pstmt1.setString(5,date_time_2);
			pstmt1.setInt(6,Integer.valueOf(day));
			pstmt1.setString(7,location);
			pstmt1.setString(8,address);
			pstmt1.setInt(9,Integer.valueOf(limit_per));
			pstmt1.setInt(10,Integer.valueOf(cost));
			pstmt1.execute();
			
			
			
			out.append("<h1>已新增 1 筆活動資料</h1>");
			out.append("<meta http-equiv=\"Refresh\" content=\"3; url=CreatGame.html\" >");
			out.println();
			
			//return;
			
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}