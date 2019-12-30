package restaurant.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import restaurant.model.service.RestaurantService;
import restaurant.model.vo.Restaurant;

/**
 * Servlet implementation class wishRestaurantServlet
 */
@WebServlet("/restaurant/wishRestaurant")
public class wishRestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userId = request.getParameter("userId");
		List<Restaurant> list = new ArrayList<>();
		RestaurantService restaurantService = new RestaurantService();
		
		list = restaurantService.wishRestaurant(userId);

		JSONArray jsonArray = new JSONArray();

		for(Restaurant r : list) {
			JSONObject jsonPhoto = new JSONObject();
			jsonPhoto.put("rName", r.getrName());
			jsonPhoto.put("grade", r.getGrade());
			jsonPhoto.put("location", r.getLocation());
			jsonPhoto.put("type", r.getType());
			jsonArray.add(jsonPhoto);
		}

		response.setContentType("application/json; charset=utf-8");
		response.getWriter().append(jsonArray.toString());
	
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
