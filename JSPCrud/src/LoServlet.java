

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvcdemo.bean.LoBean;


@WebServlet("/LoServlet")
public class LoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
	private static final String CHARSET_CODE = "UTF-8";
    
	public LoServlet() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{ 
			LoBean user = new LoBean();
		     user.setAccount(request.getParameter("account"));
		     user.setPassword(request.getParameter("password"));
		     		     

		     user = LoDAO.login(user);
			   		    
		     if (user.isValid())
		     {
			        
		          HttpSession session = request.getSession(true);	    
		          session.setAttribute("currentSessionUser",user); 
		          response.sendRedirect("index.jsp"); //logged-in page      		
		     }
			        
		     else 
		          response.sendRedirect("invalidLogin.jsp"); //error page 
		} 
				
				
		catch (Throwable theException) 	    
		{
		     System.out.println(theException); 
		}
		 
		
	}

}
