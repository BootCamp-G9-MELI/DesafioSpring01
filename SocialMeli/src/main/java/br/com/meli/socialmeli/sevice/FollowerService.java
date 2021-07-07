package br.com.meli.socialmeli.sevice;

import br.com.meli.socialmeli.repository.FollowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowerService {

    @Autowired
    private FollowerRepository followerRepository;


}
