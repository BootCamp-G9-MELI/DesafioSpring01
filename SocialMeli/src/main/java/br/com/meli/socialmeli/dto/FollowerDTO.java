package br.com.meli.socialmeli.dto;

import br.com.meli.socialmeli.entity.Follower;

public class FollowerDTO {
    private long followed;
    private long follower;

    public FollowerDTO(long followed, long follower) {
        this.followed = followed;
        this.follower = follower;
    }

    public FollowerDTO() {
    }

    public FollowerDTO(Follower follower) {
        this.followed = follower.getFollowed();
        this.follower = follower.getFollower();
    }

    public long getFollowed() {
        return followed;
    }

    public long getFollower() {
        return follower;
    }

    public FollowerDTO converte(Follower follower) {
        return new FollowerDTO(follower.getFollowed(), follower.getFollower());
    }
}
