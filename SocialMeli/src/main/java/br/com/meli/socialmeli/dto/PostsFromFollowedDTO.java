package br.com.meli.socialmeli.dto;

import java.util.List;

public class PostsFromFollowedDTO {
    private Long userId;
    private List<PostFromFollowedDTO> posts;

    public PostsFromFollowedDTO(Long userId, List<PostFromFollowedDTO> posts) {
        this.userId = userId;
        this.posts = posts;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<PostFromFollowedDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PostFromFollowedDTO> posts) {
        this.posts = posts;
    }

    public static PostsFromFollowedDTO convert(long userId, List<PostFromFollowedDTO> postFromFollowedDTOList) {
        return new PostsFromFollowedDTO(userId, postFromFollowedDTOList);
    }

    @Override
    public String toString() {
        return "PostsFromFollowedDTO{" +
                "userId=" + userId +
                ", posts=" + posts +
                '}';
    }
}
