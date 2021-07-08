package br.com.meli.socialmeli.dto;

import br.com.meli.socialmeli.entity.PromoPost;

import java.util.List;

public class PostListPromoDTO {
    private long userId;
    private String userName;
    private List<PromoPost> post;

    public PostListPromoDTO(long userId, String userName, List<PromoPost> post) {
        this.userId = userId;
        this.userName = userName;
        this.post = post;
    }
    public PostListPromoDTO(){

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

    public List<PromoPost> getPost() {
        return post;
    }

    public void setPost(List<PromoPost> post) {
        this.post = post;
    }
}
