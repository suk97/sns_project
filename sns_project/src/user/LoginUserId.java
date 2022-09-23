package user;

import board.BoardDTO;

public class LoginUserId {
	public static BoardDTO getUserId(String id) {
		return board.BoardDAO.getUserId(id);
	}
}
