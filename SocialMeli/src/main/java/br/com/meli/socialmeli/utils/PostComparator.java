package br.com.meli.socialmeli.utils;

import java.util.Comparator;

import br.com.meli.socialmeli.entity.Post;

public class PostComparator implements Comparator<Post> {

	@Override
	public int compare(Post o1, Post o2) {
		if(o1.getDate().isAfter(o2.getDate())) {
		    return -1;
		}
		if(o1.getDate().isBefore(o2.getDate())) {
		    return 1;
		}
		
		return 0;
	}

}
