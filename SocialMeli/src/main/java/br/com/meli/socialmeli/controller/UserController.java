package br.com.meli.socialmeli.controller;
import br.com.meli.socialmeli.dto.UserFollowedDTO;
import br.com.meli.socialmeli.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.meli.socialmeli.dto.UserFollowersCountDTO;
import br.com.meli.socialmeli.dto.UserFollowersDTO;
import br.com.meli.socialmeli.entity.User;

@RestController
@RequestMapping("/users")
public class UserController {
   
    private final UserService userService;
    
    @Autowired
    public UserController(UserService userService) {
		super();
		this.userService = userService;
	}


	@GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserFollowedDTO> getFollowedByUser(@PathVariable long userId,
                                                             @RequestParam(defaultValue = "name_asc") String order){
    	UserFollowedDTO userFollowedDTO = userService.getFollowedByUser(userId, order);
        return new ResponseEntity<>(userFollowedDTO, HttpStatus.OK);
	}

	@GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserFollowersDTO> getFollowersByUserId(@PathVariable long userId,
                                                                 @RequestParam(defaultValue = "name_asc") String order){
    	UserFollowersDTO userFollowersDTO = userService.getUserFollowers(userId, order);
    	return new ResponseEntity<>(userFollowersDTO, HttpStatus.OK);
	}

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserFollowersCountDTO> countUserFollowers(@PathVariable long userId) {
        UserFollowersCountDTO userFollowersCount = userService.getFollowersCountOfUser(userId);
        return new ResponseEntity<>(userFollowersCount, HttpStatus.OK);
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<User> userFollow(@PathVariable long userId, @PathVariable long userIdToFollow){
        this.userService.setFollower(userId,userIdToFollow);
        return new ResponseEntity<>(this.userService.getUserById(userId),HttpStatus.OK);
    }

}
