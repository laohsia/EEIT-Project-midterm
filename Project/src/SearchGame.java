
import java.io.IOException;
import java.io.PrintWriter;
import java.security.spec.DSAGenParameterSpec;
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
 * Servlet implementation class CreatNewGame
 */
@WebServlet("/CreatNewGame")
public class SearchGame extends HttpServlet {
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String c_name = request.getParameter("c_name");
		// out.print(c_name);

		// String sql = "select * from product where C_name like "+"'"+c_name+"'";
		String sql = "select * from product where C_name like ?";

		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, "%" + request.getParameter("c_name") + "%");
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				while (rs.next()) {
					out.println("<h1>" + rs.getString("c_name") + "</h1>");
					out.println("<h3>英文名字 : " + rs.getString("E_name") + "</h3>");
					out.println("<h3>圖片網址 : " + rs.getString("img_url") + "</h3>");
					out.println("<h3>遊戲作者 : " + rs.getString("G_maker") + "</h3>");
					out.println("<h3>插畫家 : " + rs.getString("iss") + "</h3>");
					out.println("<h3>遊戲介紹 : " + rs.getString("info") + "</h3>");
					out.println("<h3>遊戲價格 : " + rs.getString("Price") + "</h3>");
					out.println("<hr>");
				}
			} else {
				out.println("<h1>此遊戲不存在於資料庫中</h1>");
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
