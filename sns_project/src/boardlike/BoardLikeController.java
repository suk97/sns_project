package boardlike;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BoardLikeController
 */
@WebServlet("/like")
public class BoardLikeController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		String userId = (String) session.getAttribute("userId");

		boolean result = false;
		
//		try {
//			result = BoardLikeDAO.likeBoard(new BoardLikeDTO(0, boardId, userId, "", 0));
//			request.setAttribute("boardLikeList", result);
//			request.getRequestDispatcher("boardLikeList.jsp").forward(request, response);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return ;
		
	}
}
