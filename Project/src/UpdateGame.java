
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.sun.xml.internal.txw2.Document;

/**
 * Servlet implementation class UpdateGame
 */
@WebServlet("/UpdateGame")
public class UpdateGame extends HttpServlet {
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
		String E_name = request.getParameter("e_name");
		String c_name = request.getParameter("c_name");
		String img_url = request.getParameter("img_url");
		String Gmaker = request.getParameter("g_maker");
		String Iss = request.getParameter("iss");
		String Info = request.getParameter("info");
		String price = request.getParameter("price");

//		String test = "update Product set";
//		String condition_array[] = {"e_name =(?),","img_url=(?),","g_maker=(?),","iss=(?),","info=(?),","price=(?),"};
//		String para_array [] = { E_name,img_url,Gmaker,Iss,Info,price};
//		for(int i =0; i<= para_array.length;i++) {
//			if(para_array[i] != null) {
//				test +=condition_array[i];
//			}
//			
//		}
//		test +="where c_name=(?)";
//		System.out.println(test);
		
		String sql = "update Product set e_name = (?), img_url=(?),g_maker=(?),iss=(?),info=(?),price=(?) where c_name=(?)";
		String sql1 = "select C_name from product where C_name = " + "'" + c_name + "'";
		// System.out.println(sql);
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				PreparedStatement pstmt1 = con.prepareStatement(sql1);
				ResultSet rs = pstmt1.executeQuery();
				) {
			if (!rs.next()) {
				out.append("<h1>該遊戲不存在資料庫中!</h1>");
				out.append("<h3>將於3秒後重新導向至新增遊戲頁面</h3>");
				// response.setIntHeader("Refresh", 3);
				out.append("<meta http-equiv=\"Refresh\" content=\"3; url=CreatGame.html\" >");
				out.println();

			} else {

				pstmt.setString(1, E_name);
				pstmt.setString(2, img_url);
				pstmt.setString(3, Gmaker);
				pstmt.setString(4, Iss);
				pstmt.setString(5, Info);
				pstmt.setInt(6, Integer.valueOf(price));
				pstmt.setString(7, c_name);

				int result = pstmt.executeUpdate();

				out.append("<h1>資料異動共 : " + result + " 筆</h1>");
				out.append("<h3>將於3秒後重新導向</h3>");
				// response.setIntHeader("Refresh", 3);
				out.append("<meta http-equiv=\"Refresh\" content=\"3; url=UpdateGame.html\" >");
				out.println();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
