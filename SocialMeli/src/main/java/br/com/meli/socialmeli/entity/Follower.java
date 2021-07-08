package br.com.meli.socialmeli.entity;

import java.util.Objects;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Follower follower1 = (Follower) o;
		return followed == follower1.followed && follower == follower1.follower;
	}
}
