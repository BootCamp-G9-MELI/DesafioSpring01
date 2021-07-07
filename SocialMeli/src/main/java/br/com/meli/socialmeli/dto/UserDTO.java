package br.com.meli.socialmeli.dto;

import br.com.meli.socialmeli.entity.User;

public class UserDTO {

	private long userId;
	private String userName;
	
	public UserDTO(long userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public static UserDTO convert(User user) {
		return new UserDTO(user.getid(), user.getUsername());
	}
	
	
	
	
	
}
