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

import Photo.model.service.PhotoService;
import Photo.model.vo.Photo;
import restaurant.model.service.RestaurantMenuService;
import restaurant.model.service.RestaurantService;
import restaurant.model.vo.Restaurant;
import restaurant.model.vo.RestaurantMap;
import restaurant.model.vo.RestaurantMenu;


@WebServlet("/searchListFilter")
public class SearchListFilterServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.encoding
				request.setCharacterEncoding("utf-8");
				
				//2.parameter handling
				String searchKeyword = request.getParameter("searchKeyword");
				System.out.println(searchKeyword);
				String value = request.getParameter("value");
				List<String> searchList = new ArrayList<>();
				//전송확인
//				System.out.println(rNames);
						
				
				
				//3.business logic
				//value값에 따른 분기처리
				if("grade".equals(value)) {
					searchList = new PhotoService().selectPhotoList(searchKeyword);
				}
				else {
					searchList = new PhotoService().selectPhotoListByLike(searchKeyword);
				}
				
				//필요한 정보(order by r_Name)
				//a.restaurant table->location, open_time, close_time, parking_yn, holliday, 
				//					grade, type, best_yn, description, category
				//b.r_menu table -> price, single_yn
				//c.photo -> img_name
				
				//a-1 restaurant table list 가져오기
				List<Restaurant> rList = new ArrayList<>();
				for(int i=0;i<searchList.size();i++) {
					Restaurant r = new RestaurantService().selectOneByRName(searchList.get(i));
					rList.add(r);
				}
				//b-1 r_menu table list 가져오기(Single_yn에 Y가 하나라도 없으면 N)
				List<RestaurantMenu> rmList = new ArrayList<>();
				for(int i=0;i<searchList.size();i++) {
					RestaurantMenu rm = new RestaurantMenuService().selectYNByRName(searchList.get(i));
					rmList.add(rm);
				}
				//c-1 photo table에서 1.png 또는 1.jpg 가져오기
				List<Photo> pList = new ArrayList<>();
				for(int i=0;i<searchList.size();i++) {
					Photo p = new PhotoService().selectOneByRName(searchList.get(i));
					pList.add(p);
				}
				
				//d-1 map table에서 좌표 가져오기
				List<RestaurantMap> mList = new ArrayList<>();
				for(int i=0;i<searchList.size();i++) {
					RestaurantMap m = new RestaurantService().selectMapOnebyRname(searchList.get(i));
					mList.add(m);
				}
				
				//가져온 객체 jason에 담기
				//rList -> r_name, type, location, best_yn, grade, description, category, rPhone,
				//		parkingYN, openTime, closeTime, holiday
				//rmList -> singleYn
				//pList -> img_name
				JSONArray jArr = new JSONArray();
				
				for(int i=0;i<searchList.size();i++) {
					JSONObject obj = new JSONObject();
					obj.put("rName", searchList.get(i));
					obj.put("type", rList.get(i).getType());
					obj.put("location", rList.get(i).getLocation());
					obj.put("bestYN", rList.get(i).getBestYN());
					obj.put("description", rList.get(i).getDescription());
					obj.put("category", rList.get(i).getCategory());
					obj.put("rPhone", rList.get(i).getrPhone());
					obj.put("grade", rList.get(i).getGrade());
					obj.put("parkingYN", rList.get(i).getParkingYN());
					obj.put("openTime", rList.get(i).getOpenTime());
					obj.put("closeTime", rList.get(i).getCloseTime());
					obj.put("holiday", rList.get(i).getHoliday());
					obj.put("singleYN", rmList.get(i).getSingleYN());
					obj.put("imgName", pList.get(i).getImgName());
					obj.put("lat", mList.get(i).getLat());
					obj.put("lng", mList.get(i).getLng());
					
					jArr.add(obj);
				}
				
				//객체 response로 넘기기
				response.setContentType("application/json; charset=utf-8");
				response.getWriter().append(jArr.toString());
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
