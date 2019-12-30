package user.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import user.model.dao.UserDAO;
import user.model.vo.User;
import user.model.vo.recentUser;

public class UserService {

	public recentUser userRecent(String userId, String r_name) {
		Connection conn = getConnection();
		recentUser u = new UserDAO().userRecent(conn, userId, r_name);
		
		close(conn);
		
		return u;
	}


}
