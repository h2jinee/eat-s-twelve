package restaurant.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Photo.model.service.PhotoService;
import Photo.model.vo.Photo;

/**
 * Servlet implementation class SearchListServlet
 */
@WebServlet("/searchList")
public class SearchListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		//파라미터핸들링
		String searchKeyword = request.getParameter("searchKeyword");
		//업무로직
		int totalCount = new PhotoService().selectPhotoCount(searchKeyword);
		final int numPerPage = 8;
		
	
		request.setAttribute("searchKeyword", searchKeyword);
		request.setAttribute("totalCount", totalCount);
		
		request.getRequestDispatcher("/WEB-INF/views/searchlist/search.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
