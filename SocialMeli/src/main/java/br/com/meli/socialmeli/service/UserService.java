package br.com.meli.socialmeli.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meli.socialmeli.dto.UserListFollowerDTO;
import br.com.meli.socialmeli.entity.User;
import br.com.meli.socialmeli.repository.UserRepository;

@Service
public class UserService {
	
    private UserRepository userRepository;
    private FollowerService followerService;
    
	
	@Autowired
	public UserService(UserRepository userRepository, FollowerService followerService) {
		super();
		this.userRepository = userRepository;
		this.followerService = followerService;
	}

	public User getUserById(long id){
        List<User> users = userRepository.getList();
        Optional<User> userOptional= users.stream().filter(user -> user.getid() == id).findFirst();
        return userOptional.orElse(null);
    }

    public UserListFollowerDTO getUserListFollowers(long idUser) {
    	List<User> followers = new ArrayList<>();
    	User user = getUserById(idUser);
   
    	followerService.getFollowersByIdUser(idUser).stream().forEach(follower -> followers.add(getUserById(follower.getFollower())));
    	UserListFollowerDTO userDTO = new UserListFollowerDTO(user,followers);
    	
    	return userDTO;
    }

}
