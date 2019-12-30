package user.model.vo;

import java.io.Serializable;

public class recentUser implements Serializable  {

	private static final long serialVersionUID = 1L;
	private String userId;
	private String r_name;
	
	public recentUser() {}

	public recentUser(String userId, String r_name) {
		super();
		this.userId = userId;
		this.r_name = r_name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getR_name() {
		return r_name;
	}

	public void setR_name(String r_name) {
		this.r_name = r_name;
	}

	@Override
	public String toString() {
		return "recentUser [userId=" + userId + ", r_name=" + r_name + "]";
	}
	
	
}
