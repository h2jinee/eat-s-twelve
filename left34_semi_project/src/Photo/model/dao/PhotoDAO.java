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

	public List<String> selectPhotoList(Connection conn, String searchKeyword) {
		
		List<String> list = null;
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

			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(rset.getString("r_name"));
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

	public List<String> selectPhotoListByLike(Connection conn, String searchKeyword) {
		List<String> list = null;
		String query = prop.getProperty("selectPhotoListByLike");
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			list = new ArrayList<>();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchKeyword+"%");
			pstmt.setString(2, "%"+searchKeyword+"%");
			pstmt.setString(3, "%"+searchKeyword+"%");
			pstmt.setString(4, "%"+searchKeyword+"%");

			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(rset.getString("r_name"));
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

	public Photo selectOneByRName(Connection conn, String rName) {
		
		Photo p = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectOneByRName");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, rName);
			
			rset = pstmt.executeQuery();
			p = new Photo();
			if(rset.next()) {
				p.setrName(rName);
				p.setImgNo(rset.getInt("img_no"));
				p.setImgName(rset.getString("img_name"));
				p.setLocation(rset.getString("location"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MyException("selectOneByRname(photo)조회 실패");
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return p;
	}

}
