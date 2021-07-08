package br.com.meli.socialmeli.dto;

public class UserFollowersCountDTO {
    private long userId;
    private String username;
    private int followersCount;

    public UserFollowersCountDTO(long userId, String username, int followersCount) {
        this.userId = userId;
        this.username = username;
        this.followersCount = followersCount;
    }

    public UserFollowersCountDTO() {
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
