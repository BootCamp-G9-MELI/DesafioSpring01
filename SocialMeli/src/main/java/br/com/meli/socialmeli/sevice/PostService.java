package br.com.meli.socialmeli.sevice;

import br.com.meli.socialmeli.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
}
