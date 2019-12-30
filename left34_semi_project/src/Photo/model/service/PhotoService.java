package Photo.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import Photo.model.dao.PhotoDAO;
import Photo.model.vo.Photo;

public class PhotoService {

	public int selectPhotoCount(String searchKeyword) {
		
		Connection conn = getConnection();
		
		int totalPage = 0;
		
		totalPage = new PhotoDAO().selectPhotoCount(conn, searchKeyword);
		
		close(conn);
		
		return totalPage;
	}

	public List<String> selectPhotoList(String searchKeyword) {
		List<String> list = new ArrayList<>();
		Connection conn = getConnection();
		
		list = new PhotoDAO().selectPhotoList(conn,searchKeyword);
		
		close(conn);
		
		return list;
	}

	public List<String> selectPhotoListByLike(String searchKeyword) {
		List<String> list = new ArrayList<>();
		Connection conn = getConnection();
		
		list = new PhotoDAO().selectPhotoListByLike(conn,searchKeyword);
		
		close(conn);
		
		return list;
	}

	public Photo selectOneByRName(String rName) {
		
		Photo p = new Photo();
		Connection conn = getConnection();
		
		p = new PhotoDAO().selectOneByRName(conn,rName);
		
		close(conn);
		
		return p;
	}

}
