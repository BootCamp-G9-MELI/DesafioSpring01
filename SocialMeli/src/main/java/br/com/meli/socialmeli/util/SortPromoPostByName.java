package br.com.meli.socialmeli.util;

import java.util.Comparator;

import br.com.meli.socialmeli.entity.PromoPost;

public class SortPromoPostByName implements Comparator<PromoPost>{

	@Override
	public int compare(PromoPost o1, PromoPost o2) {
		
		return o1.getDetail().getName().compareToIgnoreCase(o2.getDetail().getName());
	}

}
