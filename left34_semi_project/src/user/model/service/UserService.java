package user.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;

import user.model.dao.UserDAO;
import user.model.vo.User;

public class UserService {

	public User selectOne(String memberId) {
		Connection conn=getConnection();
		User user=new UserDAO().selectOne(conn,memberId);
		close(conn);
		return	user;
	}

}
