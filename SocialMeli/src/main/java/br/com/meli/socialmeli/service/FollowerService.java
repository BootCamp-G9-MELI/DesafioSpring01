package br.com.meli.socialmeli.service;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meli.socialmeli.entity.Follower;
import br.com.meli.socialmeli.repository.FollowerRepository;

@Service
public class FollowerService {

	
    private final FollowerRepository followerRepository;

    @Autowired
	public FollowerService(FollowerRepository followerRepository){
        this.followerRepository = followerRepository;
    }
     

    public List<Follower> getFollowersListOfId(long userId) {
        List<Follower> followers = followerRepository.getList();
        return followers.stream()
                .filter(follower -> follower.getFollowed() == userId).collect(Collectors.toList());

    }

    public List<Follower> getListFollower(){
        return followerRepository.getList();
    }

    public void addFollower(Follower follower){
        this.followerRepository.add(follower);
    }
}
