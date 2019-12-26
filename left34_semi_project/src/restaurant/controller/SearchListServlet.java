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
		
		//업무로직
		
		//a.컨텐츠 영역
		String searchKeyword = request.getParameter("searchKeyword");
		
		int totalCount = new PhotoService().selectPhotoCount(searchKeyword);
		final int numPerPage = 8;
		int totalPage = (int)Math.ceil((double)totalCount/numPerPage);
		
		
		int cPage = 1;
		try {
			cPage= Integer.parseInt(request.getParameter("cPage"));
		} catch (NumberFormatException e) {
			
		}
		
		List<Photo> list = new PhotoService().selectPhotoList(cPage,numPerPage, searchKeyword);
		
		
		//b.페이징바 영역
		int pageBarSize = 5;
		
		int pageStart = ((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd = pageStart+pageBarSize-1;
		int pageNo = pageStart;
		
		String pageBar = "";
		
		if(pageNo!=1) {
			pageBar += "<a href='"+request.getContextPath()+"/searchList?searchKeyword="+searchKeyword+"&cPage="+(pageNo-1)+"'>[이전]</a>";
		}
		
		while(pageNo<=pageEnd&&pageNo<=totalPage) {
			if(pageNo==cPage) {
				pageBar += "<span class='cPage'>"+pageNo+"</span>";
			}
			else {
				pageBar += "<a href='"+request.getContextPath()+"/searchList?searchKeyword="+searchKeyword+"&cPage="+pageNo+"'>"+pageNo+"</a>";
			}
			
			pageNo++;
		}
		
		if(pageNo<=totalPage) {
			pageBar += "<a href='"+request.getContextPath()+"/searchList?searchKeyword="+searchKeyword+"&cPage="+pageNo+"'>[다음]</a>";
		}
		request.setAttribute("list", list);
		request.setAttribute("pageBar", pageBar);		
		request.setAttribute("totalPage", totalPage);
		
		request.getRequestDispatcher("/WEB-INF/views/searchlist/search.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
