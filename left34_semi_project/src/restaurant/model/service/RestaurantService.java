package restaurant.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;

import restaurant.model.dao.RestaurantDAO;
import restaurant.model.vo.Restaurant;
import restaurant.model.vo.RestaurantMap;

public class RestaurantService {

	public Restaurant selectOneByRName(String rName) {
		
		Connection conn = getConnection();
		
		Restaurant r = null;
		
		r = new RestaurantDAO().selectOneByRName(conn, rName);
		
		close(conn);
		
		return r;
	}

	public RestaurantMap selectMapOnebyRname(String rName) {
		
		Connection conn = getConnection();
		
		RestaurantMap m  = null;
		
		m = new RestaurantDAO().selectMapOnebyRname(conn, rName);
		
		close(conn);
		
		return m;
	}

}
