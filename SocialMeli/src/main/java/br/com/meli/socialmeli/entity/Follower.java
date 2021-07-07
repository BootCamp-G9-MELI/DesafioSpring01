package br.com.meli.socialmeli.entity;

public class Follower {

	private long followed;
	private long follower;

	public Follower(long followed, long follower) {
		this.followed = followed;
		this.follower = follower;
	}
	public Follower(){

	}

	public long getFollowed() {
		return followed;
	}
	
	public void setFollowed(long followed) {
		this.followed = followed;
	}
	
	public long getFollower() {
		return follower;
	}
	
	public void setFollower(long follower) {
		this.follower = follower;
	}
	
	
	
}
