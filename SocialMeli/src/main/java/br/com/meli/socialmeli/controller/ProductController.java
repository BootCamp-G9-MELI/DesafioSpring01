package br.com.meli.socialmeli.controller;

import br.com.meli.socialmeli.dto.NewPostDTO;
import br.com.meli.socialmeli.dto.PostsFromFollowedDTO;
import br.com.meli.socialmeli.entity.Post;
import br.com.meli.socialmeli.exception.BadRequestException;
import br.com.meli.socialmeli.service.PostService;
import br.com.meli.socialmeli.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostsFromFollowedDTO> postsFromFollowedLastTwoWeeks(
            @PathVariable Long userId, @RequestParam(defaultValue = "post_asc") String order) {
        PostsFromFollowedDTO postList = postService.postsFromFollowedLastTwoWeeks(userId, order);
        return new ResponseEntity<>(postList, HttpStatus.OK);
    }
}