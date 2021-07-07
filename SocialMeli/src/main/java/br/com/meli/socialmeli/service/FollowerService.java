package br.com.meli.socialmeli.service;

import br.com.meli.socialmeli.entity.Follower;
import br.com.meli.socialmeli.repository.FollowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowerService {


    private final FollowerRepository followerRepository;

    @Autowired
    public FollowerService(FollowerRepository followerRepository){
        this.followerRepository = followerRepository;
    }

    public List<Follower> getListFollower(){
        return followerRepository.getList();
    }

    public void addFollower(Follower follower){
        this.followerRepository.add(follower);
    }
}
