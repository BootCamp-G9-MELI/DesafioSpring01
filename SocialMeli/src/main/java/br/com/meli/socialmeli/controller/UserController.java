package br.com.meli.socialmeli.controller;

import br.com.meli.socialmeli.dto.UserFollowerDTO;
import br.com.meli.socialmeli.entity.User;
import br.com.meli.socialmeli.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserFollowerDTO> countUserFollowers(@PathVariable long userId) {
        try {
            UserFollowerDTO userFollowersCount = userService.getFollowersCountOfUser(userId);
            return new ResponseEntity<>(userFollowersCount, HttpStatus.OK);
        } catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<User> userFollow(@PathVariable long userId, @PathVariable long userIdToFollow){
        Boolean follow = this.userService.setFollower(userId,userIdToFollow);
        if(follow){
            return new ResponseEntity<User>(this.userService.getUserById(userId),HttpStatus.OK);
        }else {
            return new ResponseEntity<User>(this.userService.getUserById(userId),HttpStatus.BAD_REQUEST);
        }
    }

}
