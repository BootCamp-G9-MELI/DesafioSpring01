package br.com.meli.socialmeli.controller;

import br.com.meli.socialmeli.dto.NewPostDTO;
import br.com.meli.socialmeli.dto.NewPromoPostDTO;
import br.com.meli.socialmeli.entity.Post;
import br.com.meli.socialmeli.entity.PromoPost;
import br.com.meli.socialmeli.service.PostService;
import br.com.meli.socialmeli.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final PostService postService;

    @Autowired
    public ProductController(ProductService productService, PostService postService) {
        this.productService = productService;
        this.postService = postService;
    }

    @PostMapping("/newpost")
    public ResponseEntity<Post> newPost(@RequestBody NewPostDTO newPostDTO){
        postService.newPost(newPostDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    
    @PostMapping("/newpromopost")
    public ResponseEntity<PromoPost> newPromoPost(@RequestBody NewPromoPostDTO newPromoPostDTO){
    	postService.newPromoPost(newPromoPostDTO);
    	return ResponseEntity.status(HttpStatus.OK).build();
    }
}