package br.com.meli.socialmeli.dto;

public class UserPromoPostCountDTO {
    private long userId;
    private String username;
    private int promoProductsCount;

    public UserPromoPostCountDTO(long userId, String username, int promoProductsCount) {
        this.userId = userId;
        this.username = username;
        this.promoProductsCount = promoProductsCount;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPromoProductsCount() {
        return promoProductsCount;
    }

    public void setPromoProductsCount(int promoProductsCount) {
        this.promoProductsCount = promoProductsCount;
    }
}
