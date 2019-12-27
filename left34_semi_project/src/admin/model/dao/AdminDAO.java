package admin.model.dao;

import java.io.FileNotFoundException;
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

public class AdminDAO {
	private Properties prop=new Properties();
	public AdminDAO() {
		System.out.println("ddd");
		String fileName=AdminDAO.class.getResource("/sql/admin/admin-query.properties").getPath();
		System.out.println("dsadasasdd");
		try {
			prop.load(new FileReader(fileName));
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<User> selectUserList(Connection conn, int cPage, int numPerPage) {
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String query =prop.getProperty("selectMemberList");
		List<User> list=new ArrayList<>();
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				User u=new User();
				u.setUserId(rset.getString("id"));
				u.setName(rset.getString("name"));
				u.setGender(rset.getString("gender"));
				u.setAge(rset.getInt("age"));
				u.setAddress(rset.getString("address"));
				u.setPhone(rset.getString("phone"));
			list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public int selectMemberCount(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String query =prop.getProperty("selectMemberCount");
		int totalInfo=0;

		try {
			pstmt=conn.prepareStatement(query);

			rset=pstmt.executeQuery();
			if(rset.next()) {
				totalInfo=rset.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return totalInfo;

	}
	public List<User> selectByNameId(Connection conn, String srchName) {
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String query =prop.getProperty("searchUser");
		List<User> list=new ArrayList<>();
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, "%"+srchName+"%");
			pstmt.setString(2, "%"+srchName+"%");
			pstmt.setString(3, "%"+srchName+"%");
			pstmt.setString(4, "%"+srchName+"%");
			pstmt.setString(5, "%"+srchName+"%");
			pstmt.setString(6, "%"+srchName+"%");
			rset=pstmt.executeQuery();
			while(rset.next()) {
				User u=new User();
				u.setUserId(rset.getString("id"));
				u.setName(rset.getString("name"));
				u.setGender(rset.getString("gender"));
				u.setAge(rset.getInt("age"));
				u.setAddress(rset.getString("address"));
				u.setPhone(rset.getString("phone"));
			list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public User searchById(Connection conn, String id) {
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String query =prop.getProperty("searchById");
		
		User u=null;
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, id);
			
			rset=pstmt.executeQuery();
			while(rset.next()) {
				 u=new User();
				u.setUserId(rset.getString("id"));
				u.setName(rset.getString("name"));
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

