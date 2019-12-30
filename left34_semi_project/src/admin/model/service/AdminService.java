package admin.model.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import admin.model.dao.AdminDAO;

import static common.JDBCTemplate.*;
import user.model.vo.User;

public class AdminService {

	public List<User> selectUserList(int cPage, int numPerPage) {
		Connection conn=getConnection();
		List<User>list=new AdminDAO().selectUserList(conn,cPage,numPerPage);
		close(conn);
		return	list;
	}

	public int selectMemberCount() {
		Connection conn=getConnection();
		int result=new AdminDAO().selectMemberCount(conn);
		close(conn);
		return	result;
	}

	public List<User> selectByNameId(String srchName) {
		Connection conn=getConnection();
		List<User>list=new AdminDAO().selectByNameId(conn,srchName);
		close(conn);
		return	list;
	}

	public User searchById(String id) {
		Connection conn=getConnection();
		User user=new AdminDAO().searchById(conn,id);
		close(conn);
		return	user;
	}

	public int insertId(String memberId, String time) {
		Connection conn=getConnection();
		int result=new AdminDAO().insertId(conn,memberId,time);
		close(conn);
		return result;
	}

	public List<Map<String, Object>> adminVisit() {
		Connection conn=getConnection();
		List<Map<String, Object>> list=new AdminDAO().adminVisit(conn);
		close(conn);
		return list;
	}

	public List<Map<String, Object>> totalvisit() {
		Connection conn=getConnection();
		
		List<Map<String, Object>> list=new AdminDAO().totalvisit(conn);
		System.out.println("ц╒ец"+list.toString());
		close(conn);
		return list;
	}

	



}
