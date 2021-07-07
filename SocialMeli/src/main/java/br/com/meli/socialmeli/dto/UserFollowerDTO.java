package br.com.meli.socialmeli.dto;

public class UserFollowerDTO {
    private long userId;
    private String username;
    private int followersCount;

    public UserFollowerDTO(long userId, String username, int followersCount) {
        this.userId = userId;
        this.username = username;
        this.followersCount = followersCount;
    }

    public UserFollowerDTO() {
    }

    public long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public int getFollowersCount() {
        return followersCount;
    }
}
