package br.com.meli.socialmeli.service;

import br.com.meli.socialmeli.entity.Follower;
import br.com.meli.socialmeli.repository.FollowerRepository;

import java.util.List;

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




	public List<Follower> getList() {
		return followerRepository.getList();
	}

}
