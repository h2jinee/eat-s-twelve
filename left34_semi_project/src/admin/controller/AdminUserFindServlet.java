package admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
 * Servlet implementation class AdminUserFindServlet
 */
@WebServlet("/admin/UserFind")
public class AdminUserFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	
		AdminService adminService=new AdminService();
		
		//2.파라미터핸들링
		String srchName = request.getParameter("srchName");
		System.out.println("srchName="+srchName);
		
		//유효성 검사
//		if(srchName.trim().isEmpty()) return;
		
		//3.업무로직
		List<User> list= adminService.selectByNameId(srchName);

		JSONArray jsonArray = new JSONArray();
		
		for(User u : list) {
				if(u!=null){
				JSONObject jsonMember = new JSONObject();
				jsonMember.put("id",u.getUserId());
				jsonMember.put("name", u.getName());
				jsonMember.put("gender",u.getGender());
				jsonMember.put("age",u.getAge()+"");
				jsonMember.put("address",u.getAddress());
				jsonMember.put("phone",u.getPhone());
				jsonArray.add(jsonMember);
			}
		}
		System.out.println(jsonArray);
		
		//4.응답객체에 출력
		response.setContentType("application/json; charset=utf-8"); 
		PrintWriter out = response.getWriter();
		out.print(jsonArray);		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
