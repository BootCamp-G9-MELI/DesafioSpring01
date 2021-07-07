package br.com.meli.socialmeli.service;

import br.com.meli.socialmeli.dto.UserListFollowerDTO;
import br.com.meli.socialmeli.entity.Follower;
import br.com.meli.socialmeli.repository.FollowerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowerService {

    @Autowired
    private FollowerRepository followerRepository;
    
    public List<Follower> getList(){
    	return followerRepository.getList();
    }
    
    public List<Follower> getFollowersByIdUser(long idUser){
    	
    	List<Follower> followers = getList().stream().filter(follower -> follower.getFollowed() == idUser).collect(Collectors.toList());
    	
    	return followers;
    }
    
    public void add(Follower follower) {
    	followerRepository.add(follower);
    }


}
