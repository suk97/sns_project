package user;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logincontroller")
public class LoginController extends HttpServlet {
	String value;
	
	@Override
	public void init(ServletConfig config) {
		System.out.println("checks : init()");
		String value = config.getInitParameter("testParameter");
		System.out.println(value);
	}
	@SuppressWarnings("unused")
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String env = this.getInitParameter("charset");
//		request.setCharacterEncoding(env); 
		
    	String id = request.getParameter("id");	
    	String pw = request.getParameter("pw");
    	
    	request.setAttribute("id", id);
    	request.setAttribute("pw", pw);
    	
    	
		User usr = LoginValidTest.loginTest(id, pw);
		System.out.println("user :"+usr);
		HttpSession session = request.getSession();
		if (usr !=null) {
			session.setAttribute("id", usr.getId());
			session.setAttribute("pw", usr.getPassword());
		}
		if(usr == null) {
			response.sendRedirect("login.html");
			
		} else {
			request.getRequestDispatcher("login").forward(request, response);
		}
	}

}
