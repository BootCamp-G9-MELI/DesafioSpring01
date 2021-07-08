package br.com.meli.socialmeli.controller;

import br.com.meli.socialmeli.dto.NewPostDTO;
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

	@GetMapping("followed/{userId}/list")
	public ResponseEntity<List<Post>> getOrdPost(@PathVariable long userId, @RequestParam String order){
		List<Post> lstPost = null;
		if(order.equals("date_asc")) {
			lstPost = postService.getPostOrd(false);
		} else if (order.equals("date_desc")){
			lstPost = postService.getPostOrd(true);
		} else {
			// Usar controller implementada na US0006
		}
        return new ResponseEntity<>(lstPost,HttpStatus.OK);
	}
}