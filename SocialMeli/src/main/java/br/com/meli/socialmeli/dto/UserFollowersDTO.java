package br.com.meli.socialmeli.dto;

import java.util.List;

import br.com.meli.socialmeli.entity.User;

public class UserFollowersDTO {
	private long id;
	private String username;
	private List<User> followers;
	
	public UserFollowersDTO() {
	}

	public UserFollowersDTO(long id, String username, List<User> followers) {
		super();
		this.id = id;
		this.username = username;
		this.followers = followers;
	}
	
	public UserFollowersDTO(User user, List<User> followers) {
		this.id = user.getid();
		this.username = user.getUsername();
		this.followers = followers;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<User> getFollowers() {
		return followers;
	}

	public void setFollowers(List<User> followers) {
		this.followers = followers;
	}

}
