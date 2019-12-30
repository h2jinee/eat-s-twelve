package user.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import user.model.vo.User;
import user.model.vo.recentUser;

public class UserDAO {
	private Properties prop = new Properties();
	
	public UserDAO() {
		String fileName = UserDAO.class.getResource("/sql/user/user-query.properties")
										 .getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public recentUser userRecent(Connection conn, String userId, String r_name) {
		recentUser u = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("userRecent");
		
		try {
			//1.Statement객체 생성
			pstmt = conn.prepareStatement(query);//미완성쿼리전달
			//2.미완성 쿼리 값 대입
			pstmt.setString(1, userId);
			pstmt.setString(2, r_name);
			//3.쿼리실행 => ResultSet
			rset = pstmt.executeQuery();
			//4.ResultSet => Member
			if(rset.next()) {
				u = new recentUser();
				u.setUserId(rset.getString("userId"));
				u.setR_name(rset.getString("r_name"));
			}
//			System.out.println("member@dao.selectOne="+m);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//5.자원반납
			close(rset);
			close(pstmt);
		}
		
		return u;
		
	}

}
