package br.com.meli.socialmeli.dto;

import br.com.meli.socialmeli.entity.Post;
import br.com.meli.socialmeli.entity.Product;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PostFromFollowedDTO {
    private long id;
    private LocalDate date;
    private Product detail;
    private String category;
    private BigDecimal price;

    public PostFromFollowedDTO(long id, LocalDate date, Product detail, String category, BigDecimal price) {
        super();
        this.id = id;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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

    public static PostFromFollowedDTO convert(Post p) {
        return new PostFromFollowedDTO(
                p.getId(),
                p.getDate(),
                p.getDetail(),
                p.getCategory(),
                p.getPrice()
        );
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", date=" + date +
                ", detail=" + detail +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
