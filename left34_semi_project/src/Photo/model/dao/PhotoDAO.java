package Photo.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import Photo.model.vo.Photo;
import common.exception.MyException;

public class PhotoDAO {
	
	private Properties prop = new Properties();
	
	public PhotoDAO() {
		String fileName = PhotoDAO.class.getResource("/sql/photo/photo-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public int selectPhotoCount(Connection conn, String searchKeyword) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectPhotoCount");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchKeyword+"%");
			pstmt.setString(2, "%"+searchKeyword+"%");
			pstmt.setString(3, "%"+searchKeyword+"%");
			pstmt.setString(4, "%"+searchKeyword+"%");
			pstmt.setString(5, "%"+searchKeyword+"%");

			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MyException("검색 사진 전체 수 조회 실패!");
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public List<Photo> selectPhotoList(Connection conn, int cPage, int numPerPage, String searchKeyword) {
		
		List<Photo> list = null;
		String query = prop.getProperty("selectPhotoList");
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			list = new ArrayList<>();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchKeyword+"%");
			pstmt.setString(2, "%"+searchKeyword+"%");
			pstmt.setString(3, "%"+searchKeyword+"%");
			pstmt.setString(4, "%"+searchKeyword+"%");
			pstmt.setString(5, "%"+searchKeyword+"%");
			pstmt.setInt(6, (cPage-1)*numPerPage+1);
			pstmt.setInt(7, cPage*numPerPage);

			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Photo p = new Photo();
				p.setImgNo(rset.getInt("img_no"));
				p.setrName(rset.getString("r_name"));
				p.setLocation(rset.getString("location"));
				p.setImgName(rset.getString("img_name"));
				list.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MyException("검색 사진 로드 실패!");
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return list;
	}

}
