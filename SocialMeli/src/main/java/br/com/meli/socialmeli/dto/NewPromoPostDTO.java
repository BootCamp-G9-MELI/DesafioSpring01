package br.com.meli.socialmeli.dto;

import java.math.BigDecimal;

import br.com.meli.socialmeli.entity.Product;

public class NewPromoPostDTO extends NewPostDTO{

	private boolean hasPromo;
	private BigDecimal discount;

	public NewPromoPostDTO(Long userId, String date, Product detail, String category, BigDecimal price, boolean hasPromo, BigDecimal discount) {
		super(userId, date, detail, category, price);
		this.hasPromo = hasPromo;
		this.discount = discount;
	}

	public boolean isHasPromo() {
		return hasPromo;
	}

	public void setHasPromo(boolean hasPromo) {
		this.hasPromo = hasPromo;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

}
