package br.com.meli.socialmeli.repository;

import br.com.meli.socialmeli.entity.Follower;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FollowerRepository {

    private static final File FILE = new File("follower.json");

    @Autowired
    private ObjectMapper mapper;

    public List<Follower> getList(){
        List<Follower> followers = new ArrayList<>();
        try {
            FileInputStream is = new FileInputStream(FILE);
            TypeReference<List<Follower>> typeReference = new TypeReference<List<Follower>>() {};
            followers = mapper.readValue(is, typeReference);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return followers;
    }

    public void add(Follower follower) {
        try {
            List<Follower> followers = getList();
            followers.add(follower);
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
            mapper.writeValue(out, followers);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
