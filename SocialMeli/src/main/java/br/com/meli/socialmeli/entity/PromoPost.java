package br.com.meli.socialmeli.entity;

import java.math.BigDecimal;

import br.com.meli.socialmeli.dto.NewPromoPostDTO;

public class PromoPost extends Post{

	private boolean hasPromo;
	private BigDecimal discount;
	
	public PromoPost() {
		super();
	}

	public PromoPost(NewPromoPostDTO newPromoPostDTO, User user) {
		super(0, newPromoPostDTO.getDate(), newPromoPostDTO.getDetail(), newPromoPostDTO.getCategory(), newPromoPostDTO.getPrice(), user);
		
		this.hasPromo = newPromoPostDTO.isHasPromo();
		this.discount = newPromoPostDTO.getDiscount();
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

	@Override
	public String toString() {
		return super.toString()+", hasPromo='"+this.hasPromo+"'"+", discount='"+this.discount+"'";
	}

}
