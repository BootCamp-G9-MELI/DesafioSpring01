package br.com.meli.socialmeli.service;
import java.util.List;
import java.util.stream.Collectors;

import br.com.meli.socialmeli.entity.Follower;
import br.com.meli.socialmeli.repository.FollowerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowerService {

    private final FollowerRepository followerRepository;

    @Autowired
	public FollowerService(FollowerRepository followerRepository) {
		super();
		this.followerRepository = followerRepository;
	}

    public List<Follower> getFollowersListOfId(long userId) {
        List<Follower> followers = followerRepository.getList();
        return followers.stream()
                .filter(follower -> follower.getFollowed() == userId).collect(Collectors.toList());
    }

    public List<Follower> getFollowedListById(long userId) {
        List<Follower> followers = followerRepository.getList();
        return followers.stream()
                .filter(follower -> follower.getFollower() == userId).collect(Collectors.toList());
    }

    public List<Follower> getListFollower(){
        return followerRepository.getList();
    }
    
    public void addFollower(Follower follower){
        this.followerRepository.add(follower);
    }

    public void removeFollower(Follower follower){
        this.followerRepository.remove(follower);
    }
  
    public List<Follower> getFollowedByUserId(long userId) {
        List<Follower> followerList = followerRepository.getList();
        return followerList.stream()
                .filter(f -> f.getFollower() == userId).collect(Collectors.toList());
    }
  
}
