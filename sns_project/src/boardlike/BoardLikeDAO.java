package boardlike;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import util.DBUtil;

public class BoardLikeDAO {
	
	public static ArrayList<BoardLikeDTO> getAllLike() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		ArrayList<BoardLikeDTO> allData;
		
		try {
			con = DBUtil.getConnection();
			stmt = con.createStatement();
			rset = stmt.executeQuery("select * from board_like");
			
			allData = new ArrayList<BoardLikeDTO>();
			
			while(rset.next()) {
				allData.add(new BoardLikeDTO(rset.getInt(1), rset.getInt(2), rset.getString(3), rset.getString(4), rset.getInt(5)));
			}
			
		} finally {
			DBUtil.close(con, stmt, rset);
		}
		return allData;
		
		
	}
	// 좋아요 
//	public static boolean likeBoard(BoardLikeDTO vo) {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		boolean result = false;
//		
//		try {
//			con = DBUtil.getConnection();
//			pstmt = con.prepareStatement("insert into board_like ()")
//	}
//	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
