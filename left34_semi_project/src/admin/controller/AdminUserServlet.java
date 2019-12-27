package admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import user.model.vo.User;
import admin.model.service.AdminService;

/**
 * Servlet implementation class AdminUserServlet
 */
@WebServlet("/admin/adminList")
public class AdminUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AdminUserServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		AdminService adminService=new AdminService();
		
		//1.�Ķ���� �ڵ鸵
		final int numPerPage = 5;
		int cPage = 1;
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));			
		}catch(NumberFormatException e) {
		}
		//2.��������
		//a.����������
		List<User> list
			= adminService.selectUserList(cPage, numPerPage);
		System.out.println("list@servlet="+list);
		//b.����¡�ٿ���
		//��ü�Խñۼ�, ��ü��������
		int totalContent = adminService.selectMemberCount();
		int totalPage =  (int)Math.ceil((double)totalContent/numPerPage);//(����2)
		String pageBar = "";
		int pageBarSize = 5;
		int pageStart = ((cPage-1)/pageBarSize)*pageBarSize+1;//(����3)
		int pageEnd = pageStart+pageBarSize-1;
		int pageNo = pageStart;
		//[����] section
		if(pageNo == 1 ){
			//pageBar += "<span>[����]</span>";
		}
		else {
			pageBar += "<a href='"+request.getContextPath()+"/admin/adminList?cPage="+(pageNo-1)+"'>[����]</a> ";
		}
		// pageNo section
		while(pageNo<=pageEnd && pageNo<=totalPage){
			if(cPage == pageNo ){
				pageBar += "<span class='cPage'>"+pageNo+"</span> ";
			}
			else {
				pageBar += "<a href='"+request.getContextPath()+"/admin/adminList?cPage="+pageNo+"'>"+pageNo+"</a> ";
			}
			pageNo++;
		}
		//[����] section
		if(pageNo > totalPage){
		} else {
			pageBar += "<a href='"+request.getContextPath()+"/admin/adminList?cPage="+pageNo+"'>[����]</a>";
		}
		//4.��� ������		
		RequestDispatcher reqDispatcher = request.getRequestDispatcher("/WEB-INF/views/admin/adminMemberInfo.jsp");
		request.setAttribute("list",list);
		request.setAttribute("pageBar",pageBar);	
		
		reqDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
