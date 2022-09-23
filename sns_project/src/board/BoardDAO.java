package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import user.LoginController;
import user.LoginUserId;
import user.LoginValidTest;
import util.DBUtil;

public class BoardDAO {
	
	// �α��� �� �������̵� ��������
	public static BoardDTO getUserId(String id) {
		return getUserId(id);
	}
	
	// ��� �Խñ� �ҷ�����
	public static ArrayList<BoardDTO> getAllBoard() throws SQLException{
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		ArrayList<BoardDTO> allData;
		try {
			con = DBUtil.getConnection();
			
			stmt = con.createStatement();
			
			rset = stmt.executeQuery("SELECT * FROM BOARD");
			
			allData = new ArrayList<BoardDTO> ();
			
			while(rset.next()) {
				allData.add(new BoardDTO(rset.getInt(1), rset.getString(2), rset.getNString(3),rset.getNString(4)));
			}
			
			
		} finally {
			DBUtil.close(con, stmt, rset);
		}
		return allData;
	}
	
	// �Խñ� ����
	@SuppressWarnings("null")
	public static boolean writeBoard(BoardDTO vo) throws SQLException{
		Connection con = null;	
		PreparedStatement pstmt = null;
		boolean result = false;
		
		// �޼ҵ�� id �� �ҷ�����
		BoardDTO board = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into board (user_id, title, text)values (?, ?, ?)");
			pstmt.setString(1, board.getUserId());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getText());
			
			int count = pstmt.executeUpdate();
			if(count != 0) {
				result = true;
			}
			
		} finally {
			DBUtil.close(con, pstmt);
		}
		return result;
	}
	
	public static void main(String[] args) {
		try {
			for(BoardDTO board : getAllBoard()) {
				System.out.println(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
