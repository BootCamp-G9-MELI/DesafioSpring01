package br.com.meli.socialmeli.controller;

import br.com.meli.socialmeli.dto.NewPostDTO;
import br.com.meli.socialmeli.dto.PostListPromoDTO;
import br.com.meli.socialmeli.entity.Post;
import br.com.meli.socialmeli.service.PostService;
import br.com.meli.socialmeli.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{userId}/list/")
    public ResponseEntity<PostListPromoDTO> getListPromoPost(@PathVariable long userId){
        PostListPromoDTO promoPostList = postService.getList(userId);
        return new ResponseEntity<>(promoPostList,HttpStatus.OK);
    }
}