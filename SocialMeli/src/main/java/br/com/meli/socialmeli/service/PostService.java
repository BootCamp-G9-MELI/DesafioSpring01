package br.com.meli.socialmeli.service;

import br.com.meli.socialmeli.dto.NewPostDTO;
import br.com.meli.socialmeli.dto.NewPromoPostDTO;
import br.com.meli.socialmeli.entity.Post;
import br.com.meli.socialmeli.entity.PromoPost;
import br.com.meli.socialmeli.entity.User;
import br.com.meli.socialmeli.repository.PostRepository;
import br.com.meli.socialmeli.repository.PromoPostRepository;
import br.com.meli.socialmeli.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserService userService;
    private final PromoPostRepository promoPostRepository;

    @Autowired
    public PostService(PostRepository postRepository, UserService userService, PromoPostRepository promoPostRepository) {
        this.postRepository = postRepository;
        this.userService = userService;
        this.promoPostRepository = promoPostRepository;
    }

    public void newPost(NewPostDTO newPostDTO) {
    	
    	
        User user = userService.getUserById(newPostDTO.getUserId());
        Long postId = (long) postRepository.getList().size()+1;
        Post post = NewPostDTO.convert(user, postId, newPostDTO);
        postRepository.add(post);
    }
    
    public void newPromoPost(NewPromoPostDTO newPromoPostDTO) {
    		User user = userService.getUserById(newPromoPostDTO.getUserId());
    		System.err.println(newPromoPostDTO.getDiscount());
    		PromoPost promoPost = new PromoPost(newPromoPostDTO, user);
    		promoPost.setId(promoPostRepository.getList().size()+1);
    		System.out.println(promoPost.toString());
    		promoPostRepository.add(promoPost);
    		
    		
    }
}
