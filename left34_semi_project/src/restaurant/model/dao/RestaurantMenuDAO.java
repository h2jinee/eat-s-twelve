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
import restaurant.model.vo.RestaurantMenu;

import static common.JDBCTemplate.*;

public class RestaurantMenuDAO {
	
	private Properties prop = new Properties();
	
	public RestaurantMenuDAO() {
		String fileName = PhotoDAO.class.getResource("/sql/restaurant/restaurantMenu-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public RestaurantMenu selectYNByRName(Connection conn, String rName) {
		
		RestaurantMenu rm = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectYNByRName");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, rName);
			rset = pstmt.executeQuery();
			rm = new RestaurantMenu();
			if(rset.next()) {
				rm.setrName(rName);
				if(rset.getInt("cnt")==0) {
					rm.setSingleYN("N");
				}
				else {
					rm.setSingleYN("Y");
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return rm;
	}
}
