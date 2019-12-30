package restaurant.model.dao;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

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

import Photo.model.dao.PhotoDAO;
import common.exception.MyException;
import restaurant.model.vo.Restaurant;
import restaurant.model.vo.RestaurantMap;

public class RestaurantDAO {
	
	private Properties prop = new Properties();
	
	public RestaurantDAO() {
		String fileName = PhotoDAO.class.getResource("/sql/restaurant/restaurant-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public Restaurant selectOneByRName(Connection conn, String rName) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectOneByRName");
		Restaurant r = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, rName);
			
			rset = pstmt.executeQuery();
			r = new Restaurant();
			if(rset.next()) {
				r.setrName(rset.getString("r_name"));
				r.setType(rset.getString("type"));
				r.setLocation(rset.getString("location"));
				r.setDescription(rset.getString("description"));
				r.setCategory(rset.getString("category"));
				r.setGrade(rset.getDouble("grade"));
				r.setrPhone(rset.getString("r_phone"));
				r.setParkingYN(rset.getString("parking_yn"));
				r.setOpenTime(rset.getInt("open_time"));
				r.setCloseTime(rset.getInt("close_time"));
				r.setHoliday(rset.getString("holiday"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MyException("selectOneByRname쿼리조회 실패");
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return r;
	}

	public RestaurantMap selectMapOnebyRname(Connection conn, String rName) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectMapOnebyRname");
		RestaurantMap m = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, rName);
			
			rset = pstmt.executeQuery();
			m = new RestaurantMap();
			if(rset.next()) {
				m.setLat(rset.getString("lat"));
				m.setLng(rset.getString("lng"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MyException("selectOneByRname쿼리조회 실패");
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
	}
	public List<Restaurant> selectByFood(String srchFood) {
		PreparedStatement pstmt = null;
		List<Restaurant> list = null;
		Connection conn = null;
		ResultSet rset = null;
		String query = prop.getProperty("searchSelectByFood");
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+srchFood+"%");
			pstmt.setString(2, "%"+srchFood+"%");
			pstmt.setString(3, "%"+srchFood+"%");
			pstmt.setString(4, "%"+srchFood+"%");
			rset = pstmt.executeQuery();
			
			list = new ArrayList<>();
			while(rset.next()) {
				Restaurant r = new Restaurant();
				r.setrName(rset.getString("r_name"));
				r.setType(rset.getString("type"));
				r.setLocation(rset.getString("location"));
				r.setCategory(rset.getString("category"));
				
				list.add(r);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public List<Restaurant> recentRestaurant(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("recentRestaurantList");
		List<Restaurant> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,userId);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Restaurant r = new Restaurant();
				r.setrName(rset.getString("r_name"));
				r.setGrade(rset.getInt("grade"));
				r.setLocation(rset.getString("location"));
				r.setType(rset.getString("type"));
				
				list.add(r);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public List<Restaurant> wishRestaurant(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("wishRestaurantList");
		List<Restaurant> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,userId);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Restaurant r = new Restaurant();
				r.setrName(rset.getString("r_name"));
				r.setGrade(rset.getInt("grade"));
				r.setLocation(rset.getString("location"));
				r.setType(rset.getString("type"));
				
				list.add(r);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

}
