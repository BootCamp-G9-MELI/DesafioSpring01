package br.com.meli.socialmeli.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Post {

	private long id;
	private LocalDate date;
	private Product detail;
	private String category;
	private BigDecimal price;
	private User user;
	
	
	public Post() {
		super();
	}

	public Post(long id, LocalDate date, Product detail, String category, BigDecimal price, User user) {
		super();
		this.id = id;
		this.date = date;
		this.detail = detail;
		this.category = category;
		this.price = price;
		this.user = user;
	}

	public Post(long id, String date, Product detail, String category, BigDecimal price, User user) {
		super();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-LL-yyyy");
		LocalDate dateContverted = LocalDate.parse(date, formatter);

		this.id = id;
		this.date = dateContverted;
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

	@Override
	public String toString() {
		return "Post{" +
				"id=" + id +
				", date=" + date +
				", detail=" + detail +
				", category='" + category + '\'' +
				", price=" + price +
				", user=" + user +
				'}';
	}
}
