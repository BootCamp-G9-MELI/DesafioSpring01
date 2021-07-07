package br.com.meli.socialmeli.controller;

import br.com.meli.socialmeli.dto.UserListFollowerDTO;
import br.com.meli.socialmeli.repository.UserRepository;
import br.com.meli.socialmeli.service.FollowerService;
import br.com.meli.socialmeli.service.UserService;

import java.util.List;

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

    
    private FollowerService followerService;
    private UserRepository repository;
    
    private UserService userService;
    
    
    
    public UserController(FollowerService followerService, UserRepository repository, UserService userService) {
		super();
		this.followerService = followerService;
		this.repository = repository;
		this.userService = userService;
	}



	@GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserListFollowerDTO> getFollowersByUserId(@PathVariable long userId){
    	UserListFollowerDTO userDTO = userService.getUserListFollowers(userId);
    	
    	return new ResponseEntity<UserListFollowerDTO>(userDTO,HttpStatus.OK);
    }

}
