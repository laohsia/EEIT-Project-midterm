
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.sun.xml.internal.ws.api.model.wsdl.editable.EditableWSDLService;

/**
 * Servlet implementation class activityServlet
 */
@WebServlet("/activityServlet")
public class activityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InitialContext ctxt = null;
	private DataSource ds = null;

	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
	private static final String CHARSET_CODE = "UTF-8";

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// TODO Auto-generated constructor stub
		try {
			ctxt = new InitialContext();
			ds = (DataSource) ctxt.lookup("java:comp/env/jdbc/TableGameDB");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding(CHARSET_CODE);
		response.setContentType(CONTENT_TYPE);

		response.setHeader("Cache-Control", "no-cache"); // HTTP 1.1
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0
		response.setDateHeader("Expires", -1); // Prevents caching at the proxy server

		try {
			if (request.getParameter("submit") != null) {
				gotoSubmitProcess(request, response);
			} else if (request.getParameter("search") != null) {
				System.out.println(request.getParameter("search"));
				gotoSearchProcess(request, response);
			} else if (request.getParameter("delete") != null) {
				gotoDeletProcess(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

//			try {
//			} catch (ServletException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

	}

	// }

	public void gotoSubmitProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String area = request.getParameter("area");
		String activity = request.getParameter("activity").trim();
		String type = request.getParameter("type").trim();
		String date_time_1 = request.getParameter("date_time_1").trim();
		String date_time_2 = request.getParameter("date_time_2").trim();
		String day = request.getParameter("day").trim();
		String location = request.getParameter("location").trim();
		String address = request.getParameter("address").trim();
		String limit_per = request.getParameter("limit_per").trim();
		String cost = request.getParameter("cost").trim();

		try (Connection conn = ds.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement("insert into Activity values (?,?,?,?,?,?,?,?,?,?)");

			pstmt.setString(1, area);
			pstmt.setString(2, activity);
			pstmt.setString(3, type);
			pstmt.setString(4, date_time_1);
			pstmt.setString(5, date_time_2);
			pstmt.setInt(6, Integer.parseInt(day));
			pstmt.setString(7, location);
			pstmt.setString(8, address);
			pstmt.setInt(9, Integer.parseInt(limit_per));
			pstmt.setInt(10, Integer.parseInt(cost));
			pstmt.executeUpdate();

			PrintWriter out = response.getWriter();

			out.println("活動區域: " + area + "<br>");
			out.println("活動類型: " + activity + "<br>");
			out.println("活動形式: " + type + "<br>");
			out.println("活動時間(1): " + date_time_1 + "<br>");
			out.println("活動時間(2): " + date_time_2 + "<br>");
			out.println("活動天數: " + day + "<br>");
			out.println("活動地點: " + location + "<br>");
			out.println("活動地址: " + address + "<br>");
			out.println("人數限制: " + limit_per + "<br>");
			out.println("活動費用: " + cost + "<br>");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void gotoSearchProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String search = "select * from Activity where area  like '%" + request.getParameter("search") + "%'"
				+ "or activity like '%" + request.getParameter("search") + "%'" + "or type like '%"
				+ request.getParameter("search") + "%'";

		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(search);
				ResultSet rs = pstmt.executeQuery();) {

			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>\r\n" + "<html lang=\"en\">\r\n" + "<head>\r\n"
					+ "    <meta charset=\"UTF-8\">\r\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "    <title>Document</title>\r\n" + "    <style>\r\n" + "        td{\r\n"
					+ "            border: 1px solid black;\r\n" + "        }\r\n" + "        table {\r\n"
					+ "            border: 1px solid black;\r\n" + "        }\r\n" + "    </style>\r\n" + "</head>");
			out.println("<table>");
			out.println(
					"<tr><td>地區</td><td>類型</td><td>名稱</td><td>時間1</td><td>時間2</td><td>天數</td><td>地點</td><td>地址</td><td>人數</td><td>費用</td></tr>");
			while (rs.next()) {

				out.println("<tr><td>" + rs.getString(1) + "</td>");
				out.println("<td>" + rs.getString(2) + "</td>");
				out.println("<td>" + rs.getString(3) + "</td>");
				out.println("<td>" + rs.getString(4) + "</td>");
				out.println("<td>" + rs.getString(5) + "</td>");
				out.println("<td>" + rs.getString(6) + "</td>");
				out.println("<td>" + rs.getString(7) + "</td>");
				out.println("<td>" + rs.getString(8) + "</td>");
				out.println("<td>" + rs.getString(9) + "</td>");
				out.println("<td>" + rs.getString(10) + "</td></tr>");

			}
			out.println("</table>");
			out.println("</body>\r\n" + "</html>");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void gotoDeletProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		String area = request.getParameter("area");
		String activity = request.getParameter("activity");
		String type = request.getParameter("type");
		String date_time_1 = request.getParameter("date_time_1");

		String delete = "delete from activity where area like '%" + area + "%'" + "and activity like '%" + activity
				+ "%'" + "and type like '%" + type + "%'" + "and date_time_1 = '" + date_time_1 + "'";
		try (Connection conn = ds.getConnection(); Statement stmt = conn.createStatement();) {
			PrintWriter out = response.getWriter();
			if (stmt.executeUpdate(delete) > 0) {
				out.println("刪除成功");
			} else {
				out.println("無此資料");
			}
		}
	}

}
