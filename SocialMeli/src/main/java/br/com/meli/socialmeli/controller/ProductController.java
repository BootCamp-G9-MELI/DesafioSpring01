package br.com.meli.socialmeli.controller;

import br.com.meli.socialmeli.dto.NewPostDTO;
import br.com.meli.socialmeli.dto.PostsFromFollowedDTO;
import br.com.meli.socialmeli.entity.Post;
import br.com.meli.socialmeli.service.PostService;
import br.com.meli.socialmeli.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
            @PathVariable Long userId) {
        PostsFromFollowedDTO postList = postService.postsFromFollowedLastTwoWeeks(userId);
        return new ResponseEntity<>(postList, HttpStatus.OK);
    }
}