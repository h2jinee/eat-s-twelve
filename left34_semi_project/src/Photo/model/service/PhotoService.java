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

	public List<Photo> selectPhotoList(int cPage, int numPerPage, String searchKeyword) {
		List<Photo> list = new ArrayList<>();
		Connection conn = getConnection();
		
		list = new PhotoDAO().selectPhotoList(conn, cPage, numPerPage, searchKeyword);
		
		close(conn);
		
		return list;
	}

}
