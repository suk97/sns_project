package user;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.BoardDTO;

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
    	
		System.out.println(id + pw);
//		User users = new User(id, pw);
//		boolean Login;
//		try {
//			Login = userDAO.getAllUser(newuser);
//			if(Login) {
//				request.getRequestDispatcher("login").forward(request, response);	
//			}else {
//				request.getRequestDispatcher("loginfail").forward(request, response);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
		// 로그인 유저 아이디
		BoardDTO userId = LoginUserId.getUserId(id);
		
		// 로그인 유저 아이디, 패스워드
		User usr = LoginValidTest.loginTest(id, pw);
		HttpSession session = request.getSession();
		if (usr !=null) {
			session.setAttribute("id", usr.getId());
			session.setAttribute("pw", usr.getPassword());
		}
//		request.getRequestDispatcher("").forward(request, response);
		if(usr == null) {
			response.sendRedirect("login.html");
		} else {
			request.getRequestDispatcher("login").forward(request, response);
//			request.getRequestDispatcher("bookwrite.jsp").forward(request, response);
			
		}
	}

}
