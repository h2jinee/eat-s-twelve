package admin.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;


import user.model.vo.User;

public class AdminDAO {
	private Properties prop=new Properties();
	public AdminDAO() {
		
		String fileName=AdminDAO.class.getResource("/sql/admin/admin-query.properties").getPath();
	
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
	public int insertId(Connection conn, String memberId, String time) {
		PreparedStatement pstmt=null;
		int result=0;
		String query =prop.getProperty("insertId");
		
		User u=null;
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setString(2, time);
			
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public List<Map<String, Object>> adminVisit(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String query =prop.getProperty("adminVisit");
		List<Map<String, Object>> list = null;
		
		User u=null;
		try {
			pstmt=conn.prepareStatement(query);
			list = new ArrayList<>();
			
			rset=pstmt.executeQuery();
			while(rset.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("id", rset.getString("id"));
				map.put("total", rset.getInt("total"));
				map.put("visit_time", rset.getString("visit_time"));
				list.add(map);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<Map<String, Object>> totalvisit(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String query =prop.getProperty("totalvisit");
		List<Map<String, Object>> list = null;
		try {
			pstmt=conn.prepareStatement(query);	
			rset=pstmt.executeQuery();
			list = new ArrayList<>();
			
			while(rset.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("visit_time", rset.getString("visit_time"));
				map.put("total", rset.getInt("total"));
				list.add(map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
}

