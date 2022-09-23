package model.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.domain.User;
import util.DBUtil;

public class userDAO {
	// 모든 유저 검색
	public static ArrayList<User> getAllUser() throws SQLException{
		// 2단계 : DB연결
		Connection con = null; 
		Statement stmt = null;
		ResultSet rset = null; // SELECT문 할때만 사용 
		
		ArrayList<User> allData;
		try {
			System.out.println("connection 전");
			con = DBUtil.getConnection();
			System.out.println("connection 후");
			// 3단계 : SQL 문장 객체(Statement)
			stmt = con.createStatement();
			
			
			// 4단계 : SQL 실행(DB에서 SELECT * FROM user;) -> 반환된 결과를 담을 수 있는 객체(ResultSet) 필요
			rset = stmt.executeQuery("SELECT * FROM USER;");
			
			allData = new ArrayList<User>();
			while(rset.next()) {
				// 5단계 : 데이터의 활용(검색)
				allData.add(new User(rset.getString(1),rset.getString(2),rset.getString(3),rset.getInt(4),rset.getString(5),rset.getString(6),rset.getString(7),rset.getInt(8)));				
			}
		
			// 6단계 : DB 종료(자원 반환)
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
