package boardgames;

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

@WebServlet("/T1")

public class T1 extends HttpServlet {

	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
	private static final String CHARSET_CODE = "UTF-8";
	private InitialContext ctxt = null;
	private DataSource ds = null;

	public void init(ServletConfig config) throws ServletException {
		try {
			ctxt = new InitialContext();
			ds = (DataSource) ctxt.lookup("java:comp/env/jdbc/BoardGameDB");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding(CHARSET_CODE);
		response.setContentType(CONTENT_TYPE);

		PrintWriter pw = response.getWriter();
		ArrayList<setdis> all = new ArrayList<setdis>();
		try {
			disDAO disDAO = new disDAO(ds.getConnection());
			ResultSet rs = disDAO.select();
			while (rs.next()) {
				all.add(new setdis(rs.getNString(1), rs.getNString(2), rs.getNString(3), rs.getNString(4)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String json = "[";
		for (int i = 0; i < all.size(); i++) {
			json += ("{\"id\":\"" + all.get(i).getid() + "\",\"name\":\"" + all.get(i).getname() + "\",\"comment\":\""
					+ all.get(i).getcomment() + "\",\"date\":\"" + all.get(i).getDate() + "\"}");
			if (i != all.size() - 1) {
				json += ",";
			}
		}
		json += "]";

		System.out.println(json);
		pw.print(json);
		pw.close();
	}

}
