package br.com.meli.socialmeli.controller;

import br.com.meli.socialmeli.dto.NewPostDTO;
import br.com.meli.socialmeli.entity.Post;
import br.com.meli.socialmeli.service.PostService;
import br.com.meli.socialmeli.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;
    PostService postService;

    @Autowired
    public ProductController(ProductService productService, PostService postService) {
        this.productService = productService;
        this.postService = postService;
    }

    @PostMapping("/newpost")
    public ResponseEntity<Post> newPost(@RequestBody NewPostDTO newPostDTO){
        try{
            postService.newPost(newPostDTO);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}