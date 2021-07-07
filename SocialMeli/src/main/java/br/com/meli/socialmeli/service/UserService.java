package br.com.meli.socialmeli.service;

import br.com.meli.socialmeli.dto.UserFollowerDTO;
import br.com.meli.socialmeli.entity.Follower;
import br.com.meli.socialmeli.entity.User;
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
    public UserService(UserRepository userRepository, FollowerService followerService) {
        this.userRepository = userRepository;
        this.followerService = followerService;
    }

    public User getUserById(long id){
        List<User> users = userRepository.getList();
        Optional<User> userOptional= users.stream().filter(user -> user.getid() == id).findFirst();
        return userOptional.orElse(null);
    }

    public UserFollowerDTO getFollowersCountOfUser(long id) {
        User user = getUserById(id);
        List<Follower> followersOfUser = followerService.getFollowersListOfId(id);
        return new UserFollowerDTO(user.getid(), user.getUsername(), followersOfUser.size());
    }


}
