import javax.servlet.*;
import javax.servlet.http.*;
import java.io.PrintWriter;
import java.io.IOException;
import java.sql.*;
import javax.naming.*;
import javax.sql.*;

public class GetGameInfoServlet extends HttpServlet {

	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

	DataSource ds = null;

	public void init() throws ServletException {
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String E_name = request.getParameter("e_name");
		String C_name = request.getParameter("c_name");
		String Gmaker = request.getParameter("G_maker");
		String Iss = request.getParameter("iss");
		String age = request.getParameter("age");
		String type = request.getParameter("type"); 
		String people = request.getParameter("people"); 
		String time = request.getParameter("time"); 
		String price = request.getParameter("price"); 
		
		String selectCondition= "select * from Product " + "where E_name = \'" + E_name + "\' and "
		+"C_name = \'"+C_name+"\' and "+"G_maker = \'"+Gmaker+"\' and "+"iss = \'"+Iss+"\'";

		System.out.println(selectCondition);

		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		out.print("<h1>遊戲英文名稱 : "+E_name+"</h1>");
		out.print("<h1>遊戲中文名稱 : "+C_name+"</h1>");
		out.print("<h1>遊戲作者 : "+Gmaker+"</h1>");
		out.print("<h1>遊戲插畫家 : "+Iss+"</h1>");
		out.print("<p>搜尋條件 : <br><p>年齡 : "+age +"</p></p>" );
		out.print("<p>類型 : "+type +"</p>");
		out.print("<p>遊戲人數 : "+people +"</p>");
		out.print("<p>遊戲時間 : "+time +"</p>");
		out.print("<p>價格 : "+price +"</p>");

		

//    try 
//    {
//      Connection conn = ds.getConnection();
//      Statement stmt = conn.createStatement();
//      ResultSet rs = stmt.executeQuery(query);
//
//      out.println("<table border=1 width=50%>");
//      out.println("<tr><th width=25%>Emplyee No</th>" +
//                  "<th width=75%>Employee Name</th></tr>");
//      for (int count = 0; ; count++) 
//      {
//        if (rs.next())
//        {
//          out.println("<tr><td>"+ rs.getInt(1) + "</td><td>" +
//                      rs.getString(2) + "</td></tr>");
//        }
//        else 
//        {
//          out.println("</table><h3>" + count + " rows retrieved</h3>");
//          break;
//        }
//      }
//      rs.close();
//      stmt.close();
//      conn.close();
//    }
//    catch (SQLException se)
//    {
//      se.printStackTrace(out);
//    }
//    
//    out.println("</body></html>");
//    out.close();
	}
}