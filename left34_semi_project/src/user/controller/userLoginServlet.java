package user.controller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.model.service.AdminService;
import user.model.service.UserService;
import user.model.vo.User;

/**
 * Servlet implementation class userLoginServlet
 */
@WebServlet("/user/login")
public class userLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.encoding
				request.setCharacterEncoding("utf-8");
				
				//2.parameter
				String memberId = request.getParameter("memberId");
				String password = request.getParameter("password");
				System.out.println("memberId="+memberId);
				System.out.println("password="+password);
				
				//3.businessLogic
				User u = new UserService().selectOne(memberId);
//				System.out.println("member@loginServlet="+m);
				
				String msg = "";
				String loc = "/WEB-INF/views/	user/login.jsp";
				RequestDispatcher reqDispatcher 
					= request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
				
				//���̵� �������� �ʴ� ��� => �α��� ����
				if(u == null) {
					msg = "�������� �ʴ� ���̵��Դϴ�.";
					request.setAttribute("msg", msg);
					request.setAttribute("loc", loc);
					reqDispatcher.forward(request, response);
					
				}
				else {
					//������Էº���� dbȸ��������� ��
					//����� Ʋ�� ��� =>  �α��� ����
					if(!u.getPwd().equals(password)) {
						msg = "��й�ȣ�� Ʋ�Ƚ��ϴ�.";
						request.setAttribute("msg", msg);
						request.setAttribute("loc", loc);
						reqDispatcher.forward(request, response);
						
					}
					//���̵�/����� ��� ��ġ�� ��� => �α��� ����
					else {
						//������ ������, �ش缼���� �����ϰ�, ������, ���λ����ؼ� ����
						HttpSession session = request.getSession(true);
						System.out.println("SESSIONID="+session.getId());
						//���ǿ� �α����� ȸ����ü �Ӽ����� ����
						session.setAttribute("memberLoggedIn", u);
						
						//��¥���� ����
						Calendar oCalendar = Calendar.getInstance( );
						String time=oCalendar.get(Calendar.YEAR)+"-"+(oCalendar.get(Calendar.MONTH) + 1)+"-"+ oCalendar.get(Calendar.DAY_OF_MONTH)+" "+oCalendar.get(Calendar.HOUR_OF_DAY)+":"+oCalendar.get(Calendar.MINUTE)+":"+oCalendar.get(Calendar.SECOND);
						System.out.println(time);
						
						AdminService adminService=new AdminService();
						int result=adminService.insertId(memberId,time);
						//session��ȿ�ð� ����: �ʴ���
						session.setMaxInactiveInterval(60*30);
						
						//���̵����� ��Ű����
						//üũ�Ȱ��:"on", üũ���� ���� ���:null
						String saveId = request.getParameter("saveId");
//						System.out.println("saveId@loginServlet="+saveId);
						
						//üũ�Ѱ��
						if(saveId != null) {
							Cookie c = new Cookie("saveId", memberId);
							c.setMaxAge(7*24*60*60);//7���� �Ҹ�
							c.setPath("/");//��Ű�����丮. ������ �������� �����.
							response.addCookie(c);
						}
						//üũ���� ���� ���
						else {
							Cookie c = new Cookie("saveId", memberId);
							c.setMaxAge(0);//������ ���� ��ȿ�Ⱓ�� 0���� ����
							c.setPath("/");
							response.addCookie(c);
						}
						
						//�α����� ������ �����̷�Ʈ
						String referer = request.getHeader("Referer");
						System.out.println(referer);
						
						
						//�������̾ƴ� �����̷�Ʈó��
						//3xx status code�� ����.
						//Ŭ���̾�Ʈ���� �ش��ּҷ� ���û�ϰ� ��.
//						response.sendRedirect(request.getContextPath());// "/mvc"
						response.sendRedirect(referer);// "http://localhost:9090/mvc/board/boardView?boardNo=123
						
					}
					
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
