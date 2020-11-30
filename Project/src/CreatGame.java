
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
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
public class CreatGame extends HttpServlet {
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
		//response.setHeader("content-type", "text-html ; charset=utf-8");
		//response.setContentType("text/html");// 獲取當前的時間
		
		PrintWriter out = response.getWriter();
		String E_name = request.getParameter("e_name");
		String c_name = request.getParameter("c_name");
		String img_url = request.getParameter("img_url");
		String Gmaker = request.getParameter("g_maker");
		String Iss = request.getParameter("iss");
		String Info = request.getParameter("info");
		String price = request.getParameter("price"); 
		
		String sql = "select C_name from product where C_name = "+"'"+c_name+"'";
		String sql1 = "insert into product values (?,?,?,?,?,?,?)";
		
		
		try(Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				PreparedStatement pstmt1 = con.prepareStatement(sql1);
				ResultSet rs = pstmt.executeQuery();
				){
			System.out.println(rs.next());
			if(rs.next()) {
//				E_name=null;c_name = null;	img_url=null;Gmaker=null;Iss=null;Info=null;price=null;		
				
				
				
				out.append("<h1>該遊戲已存在!</h1>");
				out.append("<h3>將於3秒後重新導向</h3>");
				//response.setIntHeader("Refresh", 3);
				out.append("<meta http-equiv=\"Refresh\" content=\"3; url=CreatGame.html\" >");
				out.println();
				//return;
										
			}else{
		
			pstmt1.setString(1,E_name);
			pstmt1.setString(2,c_name);
			pstmt1.setString(3,img_url);
			pstmt1.setString(4,Gmaker);
			pstmt1.setString(5,Iss);
			pstmt1.setString(6,Info);
			pstmt1.setInt(7,Integer.valueOf(price));
			pstmt1.execute();
			
			out.append("<h1>成功新增 1 筆資料</h1>");
			out.append("<meta http-equiv=\"Refresh\" content=\"3; url=CreatGame.html\" >");
			out.println();
			
			//return;
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
