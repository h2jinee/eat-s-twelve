package restaurant.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import Photo.model.dao.PhotoDAO;
import common.exception.MyException;
import restaurant.model.vo.Restaurant;
import restaurant.model.vo.RestaurantMap;

import static common.JDBCTemplate.*;

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

}
