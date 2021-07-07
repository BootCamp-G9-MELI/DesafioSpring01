package br.com.meli.socialmeli.controller;

import br.com.meli.socialmeli.dto.UserFollowedDTO;
import br.com.meli.socialmeli.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return new ResponseEntity<UserFollowedDTO>(userAndFollowed,HttpStatus.OK);

    }

}
