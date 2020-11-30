
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.security.spec.DSAGenParameterSpec;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.sun.beans.util.Cache;
import com.sun.crypto.provider.RSACipher;

import ProjectBean.GameBean;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

/**
 * Servlet implementation class CreatNewGame
 */
@WebServlet("/CreatNewGame")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InitialContext ctxt = null;
	private DataSource ds = null;

	public void init(ServletConfig config) throws ServletException {
		try {
			ctxt=new InitialContext();
			ds = (DataSource) ctxt.lookup("java:comp/env/jdbc/TableGameDB");
			//Connection conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		if (request.getParameter("creat") != null) {

			gotoCreatGameProcess(request, response);

		} else if (request.getParameter("search") != null) {
			gotoSearchGameProcess(request, response);
			//response.sendRedirect("../WebContent/Standard/Catch_Standard_JSP_test2.jsp");


		} else if (request.getParameter("delete") != null) {
			gotoDeleteGameProcess(request, response);

		} else if (request.getParameter("update") != null) {
			gotoUpdateGameProcess(request, response);

		}
	}

	public void gotoCreatGameProcess(HttpServletRequest request, HttpServletResponse response) {
		
		String E_name = request.getParameter("e_name");
		String c_name = request.getParameter("c_name");
		String img_url = request.getParameter("img_url");
		String Gmaker = request.getParameter("g_maker");
		String Iss = request.getParameter("iss");
		String Info = request.getParameter("info");
		String price ;
		if (request.getParameter("price") == "") {
			price = "0";
		} else {
			price = request.getParameter("price");
		}
		GameBean NewGame = new GameBean(E_name, c_name, img_url, Gmaker, Iss, Info, price);
		request.setAttribute("NewGame", NewGame);
		
		try {
			PrintWriter out = response.getWriter();
			GameDAO gameDAO = new GameDAO(ds.getConnection());
			GameBean Gamedata = (GameBean) request.getAttribute("NewGame");

			if (gameDAO.checkGame(Gamedata.getC_name())) {
				out.append("<h1>此筆資料已存在!</h1>");
				out.append("<br>");
				out.append("將於3秒導回管理頁面");
				out.append("<meta http-equiv=\"Refresh\" content=\"3; url=./Standard/manager_page.html\" >");
				out.println();
				
//				if (gameDAO.updateGame(Gamedata)) {
//					out.print("<h1>資料更新成功</h1>");
//				} else {
//					out.print("<h1>資料更新失敗</h1>");
//				}
			} else {
				out.append("<h1>資料不存在</h1>");
//				out.print("<h1>預備將此筆資料新增至資料庫</h1>");
				if (gameDAO.createGame(Gamedata)) {
					out.append("<h1>資料已用新遊戲的方式新增至資料庫</h1>");
					out.append("<br>");
					out.append("將於3秒導回管理頁面");
					out.append("<meta http-equiv=\"Refresh\" content=\"3; url=./Standard/manager_page.html\" >");
					out.println();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void gotoSearchGameProcess(HttpServletRequest request, HttpServletResponse response) {

		String c_name = request.getParameter("c_name");
		String e_name = request.getParameter("e_name");
		try {
			PrintWriter out = response.getWriter();
			GameDAO gameDAO = new GameDAO(ds.getConnection());
			if(e_name!="") {				
				ResultSet rs = gameDAO.SearchGame(c_name,e_name);
				if(rs.next()) {
					out.println("<h1>" + rs.getString(2) + "</h1>");
					out.println("<h3>英文名字 : " + rs.getString(1) + "</h3>");
					out.println("<h3>圖片網址 : " + rs.getString(3) + "</h3>");
					out.println("<h3>遊戲作者 : " + rs.getString(4) + "</h3>");
					out.println("<h3>插畫家 : " + rs.getString(5) + "</h3>");
					out.println("<h3>遊戲介紹 : " + rs.getString(6) + "</h3>");
					out.println("<h3>遊戲價格 : " + rs.getInt(7) + "</h3>");
					out.println("<hr>");
				}
			}else if(e_name ==""){			
				ResultSet rs1 = gameDAO.SearchGame(c_name);
				if(rs1.next()) {
					out.println("<h1>" + rs1.getString(2) + "</h1>");
					out.println("<h3>英文名字 : " + rs1.getString(1) + "</h3>");
					out.println("<h3>圖片網址 : " + rs1.getString(3) + "</h3>");
					out.println("<h3>遊戲作者 : " + rs1.getString(4) + "</h3>");
					out.println("<h3>插畫家 : " + rs1.getString(5) + "</h3>");
					out.println("<h3>遊戲介紹 : " + rs1.getString(6) + "</h3>");
					out.println("<h3>遊戲價格 : " + rs1.getInt(7) + "</h3>");
					out.println("<hr>");
					while (rs1.next()) {
						out.println("<h1>" + rs1.getString(2) + "</h1>");
						out.println("<h3>英文名字 : " + rs1.getString(1) + "</h3>");
						out.println("<h3>圖片網址 : " + rs1.getString(3) + "</h3>");
						out.println("<h3>遊戲作者 : " + rs1.getString(4) + "</h3>");
						out.println("<h3>插畫家 : " + rs1.getString(5) + "</h3>");
						out.println("<h3>遊戲介紹 : " + rs1.getString(6) + "</h3>");
						out.println("<h3>遊戲價格 : " + rs1.getInt(7) + "</h3>");
						out.println("<hr>");
					}
				}
			}
			else {
				out.append("<h1>查無資料</h1>");
				out.append("<br>");
				out.append("將於3秒導回管理頁面");
				out.append("<meta http-equiv=\"Refresh\" content=\"3; url=./Standard/manager_page.html\" >");
				out.println();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void gotoDeleteGameProcess(HttpServletRequest request, HttpServletResponse response) {
		String c_name = request.getParameter("delete");

		try {
			PrintWriter out = response.getWriter();

			GameDAO gameDAO = new GameDAO(ds.getConnection());
			if (gameDAO.checkGame(c_name)) {
				System.out.println("此筆資料存在!");
				if (gameDAO.deleteGame(c_name)) {
					out.append("<h1>資料刪除成功</h1>");
					out.append("<br>");
					out.append("將於3秒導回管理頁面");
					out.append("<meta http-equiv=\"Refresh\" content=\"3; url=./Standard/manager_page.html\" >");
					out.println();
				} else {
					out.append("<h1>資料刪除失敗</h1>");
					out.append("<br>");
					out.append("將於3秒導回管理頁面");
					out.append("<meta http-equiv=\"Refresh\" content=\"3; url=./Standard/manager_page.html\" >");
					out.println();
				}
			} else {
				out.append("<h1>資料不存在</h1>");out.append("<br>");
				out.append("將於3秒導回管理頁面");
				out.append("<meta http-equiv=\"Refresh\" content=\"3; url=./Standard/manager_page.html\" >");
				out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void gotoUpdateGameProcess(HttpServletRequest request, HttpServletResponse response) {
		
		
		String E_name = request.getParameter("e_name");
		String c_name = request.getParameter("c_name");
		String img_url = request.getParameter("img_url");
		String Gmaker = request.getParameter("g_maker");
		String Iss = request.getParameter("iss");
		String Info = request.getParameter("info");
		String price ;
		if (request.getParameter("price") == "") {
			price = "0";
		} else {
			price = request.getParameter("price");
		}
		GameBean NewGame = new GameBean(E_name, c_name, img_url, Gmaker, Iss, Info, price);
		request.setAttribute("NewGame", NewGame);
		
		try {
			PrintWriter out = response.getWriter();
			GameDAO gameDAO = new GameDAO(ds.getConnection());
			GameBean Gamedata = (GameBean) request.getAttribute("NewGame");
			if (gameDAO.updateGame(Gamedata)) {
				System.out.println("此筆資料存在!");
				if (gameDAO.updateGame(Gamedata)) {
					out.append("<h1>資料更新成功</h1>");
					out.append("<br>");
					out.append("將於3秒導回管理頁面");
					out.append("<meta http-equiv=\"Refresh\" content=\"3; url=./Standard/manager_page.html\" >");
					out.println();
				} else {
					out.append("<h1>資料更新失敗</h1>");
					out.append("<br>");
					out.append("將於3秒導回管理頁面");
					out.append("<meta http-equiv=\"Refresh\" content=\"3; url=./Standard/manager_page.html\" >");
					out.println();
				}
			} else {
				if (gameDAO.createGame(Gamedata)) {
					out.append("<h1>資料不存在</h1>");
					out.append("<h1>資料已用新遊戲的方式新增至資料庫</h1>");
					out.append("<br>");
					out.append("將於3秒導回管理頁面");
					out.append("<meta http-equiv=\"Refresh\" content=\"3; url=./Standard/manager_page.html\" >");
					out.println();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
