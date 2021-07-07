package br.com.meli.socialmeli.controller;

import br.com.meli.socialmeli.sevice.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FollowerController {
    @Autowired
    FollowerService followerService;
}
