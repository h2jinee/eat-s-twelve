package restaurant.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;

import restaurant.model.dao.RestaurantMenuDAO;
import restaurant.model.vo.RestaurantMenu;

public class RestaurantMenuService {

	public RestaurantMenu selectYNByRName(String rName) {
		
		Connection conn = getConnection();
		
		RestaurantMenu rm = new RestaurantMenuDAO().selectYNByRName(conn,rName);
		
		close(conn);
		
		return rm;
	}

}
