package br.com.meli.socialmeli.service;

import br.com.meli.socialmeli.entity.Follower;
import br.com.meli.socialmeli.repository.FollowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FollowerService {

    @Autowired
    private FollowerRepository followerRepository;

    public List<Follower> getFollowersListOfId(long userId) {
        List<Follower> followers = followerRepository.getList();
        return followers.stream()
                .filter(follower -> follower.getFollowed() == userId).collect(Collectors.toList());
    }
}
