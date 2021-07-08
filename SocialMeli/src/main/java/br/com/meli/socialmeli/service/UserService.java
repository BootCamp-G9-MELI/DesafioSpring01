package br.com.meli.socialmeli.service;

import java.util.*;

import br.com.meli.socialmeli.exception.BadRequestException;
import br.com.meli.socialmeli.util.SortUserByName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meli.socialmeli.dto.UserFollowedDTO;
import br.com.meli.socialmeli.dto.UserFollowerDTO;
import br.com.meli.socialmeli.dto.UserListFollowerDTO;
import br.com.meli.socialmeli.entity.Follower;
import br.com.meli.socialmeli.entity.User;
import br.com.meli.socialmeli.exception.NotFoundException;
import br.com.meli.socialmeli.repository.UserRepository;

@Service
public class UserService {
    
	
    private final UserRepository userRepository;
    private final FollowerService followerService;
    
    @Autowired
    public UserService(UserRepository userRepository, FollowerService followerService) {
		super();
		this.userRepository = userRepository;
		this.followerService = followerService;
	}

	public User getUserById(long id){
        List<User> users = userRepository.getList();
        Optional<User> userOptional= users.stream().filter(user -> user.getid() == id).findFirst();
        if(userOptional.isPresent()) {
            return userOptional.get();
        }
        throw new NotFoundException("Usuário não encontrado");
    }

    public UserFollowerDTO getFollowersCountOfUser(long id) {
        User user = getUserById(id);
        List<Follower> followersOfUser = followerService.getFollowersListOfId(id);
        return new UserFollowerDTO(user.getid(), user.getUsername(), followersOfUser.size());
    }

	public UserFollowedDTO getFollowerByUser(long userId, String order) {
		
		List<Follower> listFollowed = followerService.getListFollower();
		List <User> listUser = new ArrayList<>();
		listFollowed.stream().filter(follower -> follower.getFollower() == userId)
                .forEach(follower -> listUser.add(getUserById(follower.getFollowed())));
        orderUserByName(listUser, order);
		return UserFollowedDTO.convert(getUserById(userId), listUser);
		
	}

    public void setFollower(long userId, long userIdToFollow){
        Follower followHasClass = new Follower(userIdToFollow,userId);
        List<Follower> followers = this.followerService.getListFollower();

        this.getUserById(userId);
        this.getUserById(userIdToFollow);

        if( followers.stream().anyMatch(follower -> follower.getFollower() == userId && follower.getFollowed() == userIdToFollow) ){
            throw new BadRequestException("Você já segue esse usuário.");
        } else {
            this.followerService.addFollower(followHasClass);
        }
    }

    public UserListFollowerDTO getUserListFollowers(long idUser, String order) {
    	List<User> followers = new ArrayList<>();
    	User user = getUserById(idUser);
   
    	followerService.getFollowersListOfId(idUser).forEach(follower -> followers.add(getUserById(follower.getFollower())));
        orderUserByName(followers, order);
    	return new UserListFollowerDTO(user,followers);
    }

    private void orderUserByName(List<User> users, String order) {
        switch (order) {
            case "name_asc":
                users.sort(new SortUserByName());
                break;
            case "name_desc":
                users.sort(new SortUserByName().reversed());
                break;
            default:
                break;
        }
    }

}
