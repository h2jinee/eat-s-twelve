package admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import admin.model.service.AdminService;
import user.model.vo.User;

/**
 * Servlet implementation class AdminChartServelt
 */
@WebServlet("/admin/adminchart")
public class AdminChartServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminChartServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		AdminService adminService=new AdminService();
		
	

		//3.업무로직
		List<Map<String,Object>> list = adminService.totalvisit();

		JSONArray jsonArr = new JSONArray();
		
		for(Map<String,Object> map: list){
			JSONObject json = new JSONObject();
			json.put("visit_time", map.get("visit_time"));
			json.put("total", map.get("total"));
			
			jsonArr.add(json);
	}
		System.out.println("total="+jsonArr);
		
		//4.응답객체에 출력
		response.setContentType("application/json; charset=utf-8"); 
		PrintWriter out = response.getWriter();
		out.print(jsonArr);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
