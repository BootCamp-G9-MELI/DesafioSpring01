package br.com.meli.socialmeli.controller;

import br.com.meli.socialmeli.entity.User;
import br.com.meli.socialmeli.repository.FollowerRepository;
import br.com.meli.socialmeli.repository.UserRepository;
import br.com.meli.socialmeli.service.FollowerService;
import br.com.meli.socialmeli.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FollowerService followerService;

    @Autowired
    private final UserService userService = new UserService(followerService,userRepository);

    @PutMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<User> userFollow(@Validated @PathVariable long userId, @Validated @PathVariable long userIdToFollow){
        Boolean follow = userService.setFollower(userId,userIdToFollow);
        if(follow){
            return new ResponseEntity<User>(userService.getUserById(userId),HttpStatus.OK);
        }else {
            return new ResponseEntity<User>(userService.getUserById(userId),HttpStatus.BAD_REQUEST);
        }
    }

}
