package restaurant.model.service;

import static common.JDBCTemplate.*;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

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
	
	public List<Restaurant> selectByFood(String srchFood) {
		Connection conn = getConnection();
		List<Restaurant> foodList = new ArrayList<>();
		RestaurantDAO restaurantDAO = new RestaurantDAO();
		
		foodList = restaurantDAO.selectByFood(srchFood);

		close(conn);
		
		
		return foodList;
	}
	
	public List<Restaurant> recentRestaurant(String userId) {
		Connection conn = getConnection();
		
		List<Restaurant> list = new ArrayList<>();
		RestaurantDAO restaurantDAO = new RestaurantDAO();
		
		list = restaurantDAO.recentRestaurant(conn, userId);
		
		close(conn);
		
		return list;
	}
	
	public List<Restaurant> wishRestaurant(String userId) {
		
		Connection conn = getConnection();

		List<Restaurant> list = new ArrayList<>();
		RestaurantDAO restaurantDAO = new RestaurantDAO();

		list = restaurantDAO.wishRestaurant(conn, userId);

		close(conn);

		return list;
	}

}
