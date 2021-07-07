package br.com.meli.socialmeli.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Post {

	private long id;
	private LocalDate date;
	private Product detail;
	private String category;
	private BigDecimal price;
	private User user;
	
	public Post(long id, LocalDate date, Product detail, String category, BigDecimal price, User user) {
		super();
		this.id = id;
		this.date = date;
		this.detail = detail;
		this.category = category;
		this.price = price;
		this.user = user;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
