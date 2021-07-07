package br.com.meli.socialmeli.repository;

import br.com.meli.socialmeli.entity.Post;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository {

    private static final File FILE = new File("post.json");

    private final ObjectMapper mapper;

    @Autowired
    public PostRepository(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public List<Post> getList(){
        List<Post> posts = new ArrayList<>();
        try {
            FileInputStream is = new FileInputStream(FILE);
            TypeReference<List<Post>> typeReference = new TypeReference<List<Post>>() {};
            posts = mapper.readValue(is, typeReference);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return posts;
    }

    public void add(Post post) {
        try {
            List<Post> posts = getList();
            posts.add(post);
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
            mapper.writeValue(out, posts);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
