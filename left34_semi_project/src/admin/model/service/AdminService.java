package admin.model.service;

import java.sql.Connection;
import java.util.List;

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

	



}
