package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import util.DBUtil;

public class userDAO {
	
	//로그인 검증
	public static User getUser(String id, String pw) {
		
		
		Connection con = null; 
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		User usr = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from user where id = ? and password = ?");
			
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				usr = new User(rset.getString(1), rset.getString(2), rset.getString(3), rset.getInt(4), rset.getString(5), rset.getString(6), rset.getString(7), rset.getInt(8));
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return usr;
	}
	
	
	// 모든 유저 검색
	public static ArrayList<User> getAllUser() throws SQLException{
		Connection con = null; 
		Statement stmt = null;
		ResultSet rset = null; 
		
		ArrayList<User> allData;
		try {
			con = DBUtil.getConnection();
			stmt = con.createStatement();
			
			
			rset = stmt.executeQuery("SELECT * FROM USER;");
			
			allData = new ArrayList<User>();
			while(rset.next()) {
				allData.add(new User(rset.getString(1),rset.getString(2),rset.getString(3),rset.getInt(4),rset.getString(5),rset.getString(6),rset.getString(7),rset.getInt(8)));				
			}
		
		} finally {
			DBUtil.close(con, stmt, rset);
		}
		
		return allData;
		
	}
	
	public static void main(String[] args) {
		try {
			for(User user: getAllUser()) {
			System.out.println(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
