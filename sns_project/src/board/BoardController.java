package board;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.domain.userDAO;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("/board")
public class BoardController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
	
	public void write(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		BoardDTO board = null;
		// 게시글 아이디는 어떻게..?
		@SuppressWarnings("null")
		int boardId = board.getBoardId();
		String id = board.getUserId();
		String title = request.getParameter("title");
		String text = request.getParameter("text");
		
		System.out.println(id + title + text + boardId);
		boolean result = false;
		
		try {
			result = BoardDAO.writeBoard(new BoardDTO(boardId, id, title, text));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(result) {
			response.sendRedirect("boardwrite.jsp");
		} else {
			request.getRequestDispatcher("boardwrite.jsp").forward(request, response);
		}
		
	}

}
