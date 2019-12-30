package admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import admin.model.dao.AdminDAO;
import admin.model.service.AdminService;
import user.model.vo.User;

/**
 * Servlet implementation class AdminVisit
 */
@WebServlet("/admin/adminvisit")
public class AdminVisit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		AdminService adminService=new AdminService();
		List<Map<String,Object>> list =adminService.adminVisit();
		
		
		JSONArray jsonArr = new JSONArray();
		
		for(Map<String,Object> map: list){
				JSONObject json = new JSONObject();
				json.put("id", map.get("id"));
				json.put("total", map.get("total"));
				json.put("visit_time", map.get("visit_time"));
				jsonArr.add(json);
		}
		System.out.println("rankList="+jsonArr);
		
		//4.응답객체에 출력
		response.setContentType("application/json; charset=utf-8"); 
//		PrintWriter out = response.getWriter();
//		out.print(jsonArr);
		response.getWriter().append(jsonArr.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
