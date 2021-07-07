package br.com.meli.socialmeli.service;

import br.com.meli.socialmeli.dto.UserFollowerDTO;
import br.com.meli.socialmeli.entity.Follower;
import br.com.meli.socialmeli.entity.User;
import br.com.meli.socialmeli.exception.NotFoundException;
import br.com.meli.socialmeli.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final FollowerService followerService;

    @Autowired
    public UserService(FollowerService followerService,UserRepository userRepository){
        this.followerService = followerService;
        this.userRepository = userRepository;
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

    public Boolean setFollower(long userId, long userIdToFollow){
        Follower followHasClass = new Follower(userIdToFollow,userId);
        List<Follower> followers = this.followerService.getListFollower();

        // Caso não exista nenhum usuário
        User user = this.getUserById(userId);
        User userToFollow = this.getUserById(userIdToFollow);
        if( user == null || userToFollow == null){
            return false;
        }

        //Caso já exista o vinculo entre esses dois usuários
        if( followers.stream().anyMatch(follower -> follower.getFollower() == userId && follower.getFollowed() == userIdToFollow) ){
            return true;
        }

        this.followerService.addFollower(followHasClass);
        return true;
    }


}
