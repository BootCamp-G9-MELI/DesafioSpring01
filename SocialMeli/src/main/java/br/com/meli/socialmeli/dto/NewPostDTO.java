package br.com.meli.socialmeli.dto;

import br.com.meli.socialmeli.entity.Post;
import br.com.meli.socialmeli.entity.Product;
import br.com.meli.socialmeli.entity.User;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NewPostDTO {
    private Long userId;
    private String date;
    private Product detail;
    private String category;
    private BigDecimal price;

    public NewPostDTO(Long userId, String date, Product detail, String category, BigDecimal price) {
        this.userId = userId;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Product getDetail() {
        return detail;
    }

    public void setDetail(Product detail) {
        this.detail = detail;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public static Post convert(User user, Long postId, NewPostDTO newPostDTO) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-LL-yyyy");
        LocalDate date = LocalDate.parse(newPostDTO.getDate(), formatter);
        return new Post(
                postId,
                date,
                newPostDTO.getDetail(),
                newPostDTO.getCategory(),
                newPostDTO.getPrice(),
                user);
    }

    @Override
    public String toString() {
        return "NewPostDTO{" +
                "userId=" + userId +
                ", date='" + date + '\'' +
                ", detail=" + detail +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
