

import java.io.IOException;
import java.io.PrintWriter;
import java.security.spec.DSAGenParameterSpec;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import coreservlets.ShopCar;

/**
 * Servlet implementation class test
 */
@WebServlet("/test")

public class shopCarServlet extends HttpServlet {
	private InitialContext ctxt = null;
	private DataSource ds = null;
	private int Visitors = 1;
	public void init(ServletConfig config) throws ServletException {
		  try {
			  ctxt = new InitialContext();
			  ds = (DataSource) ctxt.lookup("java:comp/env/jdbc/TableGameDB");
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
	}
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8"); 
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		ArrayList<ShopCar> all = new ArrayList<ShopCar>();		
		try {
			ShopCarDAO shopcarDAO = new ShopCarDAO(ds.getConnection());
			String SQLDoWhat;
			ResultSet rs = null;
			switch(request.getParameter("doWhich")) {
				case "":
					SQLDoWhat = "select C_name,img_url,price,E_name from product";
					rs = shopcarDAO.select(SQLDoWhat);
					while(rs.next()) {
						all.add(new ShopCar("Visitors" + Visitors, rs.getNString(2), rs.getNString(1), rs.getInt(3), 1, rs.getNString(4)));
					}
					break;
				case "select":
					break;
				case "delete":
					SQLDoWhat = "DELETE FROM BuyList where whoBuy=N'" + request.getParameter("user") + "' and buyWhat = N'" + request.getParameter("EName") + "';";
					shopcarDAO.delete(SQLDoWhat);
					break;
				case "updata":
					SQLDoWhat = "update BuyList set buyHowMuch =" + Integer.parseInt(request.getParameter("buyHowmuch")) + " where whoBuy=N'" + request.getParameter("user") + "' and buyWhat = N'" + request.getParameter("EName") + "';";
					shopcarDAO.updata(SQLDoWhat);
					break;
				case "insert":
					SQLDoWhat = "select C_name,img_url,price,E_name from product where E_name = N'" + request.getParameter("EName") + "'";				
					rs = shopcarDAO.select(SQLDoWhat);
					while(rs.next()) {
						all.add(new ShopCar(request.getParameter("user"), rs.getNString(2), rs.getNString(1), rs.getInt(3), 1, rs.getNString(4)));
						SQLDoWhat = "insert into BuyList values (N'" + request.getParameter("user") + "',N'" + rs.getNString(4) + "',1)";
						shopcarDAO.insert(SQLDoWhat);
					}
					break;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String json = "[";
		for(int i=0; i<all.size(); i++) {
			json += ("{\"imgUrl\":\"" + all.get(i).getImgUrl() + "\",\"message\":\"" + all.get(i).getCName() + "\",\"price\":\"" + all.get(i).getPrice() + "\",\"buyHowmuch\":\"" + all.get(i).getButHowmuch() + "\",\"E_Name\":\"" + all.get(i).getE_Name() + "\",\"Visitors\":\"" + Visitors + "\"}");
			if(i != all.size()-1) {
				json += ",";
			}
		}
		json += "]";
		if(request.getParameter("doWhich").equals("")) {
			Visitors++;
		}
		pw.print(json);
		pw.close(); 
	}

}
