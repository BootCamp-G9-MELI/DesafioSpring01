package br.com.meli.socialmeli.controller;
import br.com.meli.socialmeli.dto.UserFollowedDTO;
import br.com.meli.socialmeli.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.socialmeli.dto.UserFollowerDTO;
import br.com.meli.socialmeli.dto.UserListFollowerDTO;
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
    public ResponseEntity<UserFollowedDTO> getFollowers(@PathVariable long userId){
    	UserFollowedDTO  userAndFollowed = userService.getFollowerByUser(userId);
        return new ResponseEntity<>(userAndFollowed,HttpStatus.OK);
	}

	@GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserListFollowerDTO> getFollowersByUserId(@PathVariable long userId){
    	UserListFollowerDTO userDTO = userService.getUserListFollowers(userId);
    	return new ResponseEntity<>(userDTO,HttpStatus.OK);
	}

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserFollowerDTO> countUserFollowers(@PathVariable long userId) {
        UserFollowerDTO userFollowersCount = userService.getFollowersCountOfUser(userId);
        return new ResponseEntity<>(userFollowersCount, HttpStatus.OK);
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<User> userFollow(@PathVariable long userId, @PathVariable long userIdToFollow){
        this.userService.setFollower(userId,userIdToFollow);
        return new ResponseEntity<>(this.userService.getUserById(userId),HttpStatus.OK);
    }

}
