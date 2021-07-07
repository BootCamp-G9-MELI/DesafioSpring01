package br.com.meli.socialmeli.controller;

import br.com.meli.socialmeli.sevice.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @Autowired
    PostService postService;
}
