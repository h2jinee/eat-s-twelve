package user.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import admin.model.dao.AdminDAO;
import user.model.vo.User;

public class UserDAO {
	private Properties prop=new Properties();
public UserDAO(){	
	String fileName=AdminDAO.class.getResource("/sql/user/user-query.properties").getPath();	
	try {
		prop.load(new FileReader(fileName));
	}  catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	public User selectOne(Connection conn, String memberId) {
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String query =prop.getProperty("selectOne");
		
		User u=null;
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, memberId);			
			rset=pstmt.executeQuery();
			while(rset.next()) {
				 u=new User();
				u.setUserId(rset.getString("id"));
				u.setPwd(rset.getString("pwd"));
				u.setGender(rset.getString("gender"));
				u.setAge(rset.getInt("age"));
				u.setAddress(rset.getString("address"));
				u.setPhone(rset.getString("phone"));
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	}


