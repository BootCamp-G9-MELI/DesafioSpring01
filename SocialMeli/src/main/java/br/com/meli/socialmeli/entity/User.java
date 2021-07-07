package br.com.meli.socialmeli.entity;

public class User {

	private long id;
	private String username;
	
	public User(long id, String username) {
		super();
		this.id = id;
		this.username = username;
	}

	public long getid() {
		return id;
	}

	public void setid(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", username='" + username + '\'' +
				'}';
	}
}
