package br.com.meli.socialmeli.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.meli.socialmeli.entity.User;

public class UserFollowedDTO {

	private long userId;
	private String userName;
	private List <UserDTO> followed;
	
	public UserFollowedDTO(long userId, String userName, List <UserDTO> followed) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.followed = followed;
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

	public List <UserDTO> getFollowed() {
		return followed;
	}

	public void setFollowed(List <UserDTO> followed) {
		this.followed = followed;
	}
	
	public static UserFollowedDTO convert(User mainUser, List<User> userFollowed) {
		List<UserDTO> lstFollowed =  userFollowed.stream().map(p -> UserDTO.convert(p)).collect(Collectors.toList());
		return new UserFollowedDTO(mainUser.getid(), mainUser.getUsername(), lstFollowed);
	}
	
	
	
}
