package boardgames;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.sun.corba.se.spi.orbutil.fsm.Action;
@WebServlet("/disservlet")
public class disservlet extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
	private static final String CHARSET_CODE = "UTF-8";
	private InitialContext ctxt = null;
	private DataSource ds = null;

	public void init(ServletConfig config) throws ServletException {
		try {
			ctxt = new InitialContext();
			ds = (DataSource) ctxt.lookup("java:comp/env/jdbc/TableGameDB");
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
		String action = request.getParameter("action");

		try {
			disDAO disDAO = new disDAO(ds.getConnection());

			switch (action) {
			case "new":
				showNewForm(request, response);
				break;
			case "insert":
				insertComment(request, response);
				break;
			case "delete":
				deleteComment(request, response);
				break;
			case "update":
				updateComment(request, response);
				break;

			default:
				listAllComments(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listAllComments(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		disDAO disDAO = new disDAO(ds.getConnection());
		List<setdis> listAllComments = disDAO.listAllComments();
		request.setAttribute("listcomment", listAllComments);
		RequestDispatcher dispatcher = request.getRequestDispatcher("T1.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("T1.jsp");
		dispatcher.forward(request, response);
	}

	private void insertComment(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("user");
		String comment = request.getParameter("comment");
		String date = request.getParameter("time");

		setdis newsetdis = new setdis(id, name, comment, date);
		disDAO disDAO = new disDAO(ds.getConnection());
		disDAO.insertcomment(newsetdis);
	}

	private void updateComment(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String id = request.getParameter("id");
		System.out.println(request.getParameter("id"));
//			        String name = request.getParameter("name");
		String comment = request.getParameter("comment");
//			        String date =  request.getParameter("date");

		setdis newsetdis = new setdis(id, null, comment, null);
		disDAO disDAO = new disDAO(ds.getConnection());
		disDAO.updatecomment(newsetdis);
		System.out.println(request.getParameter("id"));
		response.sendRedirect("list");
	}

	private void deleteComment(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		
		
		String id = request.getParameter("id");

		setdis newsetdis = new setdis(id, null, null, null);
		disDAO disDAO = new disDAO(ds.getConnection());
		disDAO.deletecomment(newsetdis);
		response.sendRedirect("list");
	}

}
