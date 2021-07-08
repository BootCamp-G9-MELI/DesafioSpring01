package br.com.meli.socialmeli.repository;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.meli.socialmeli.entity.Follower;

@Repository
public class FollowerRepository {

    private static final File FILE = new File("follower.json");

    private final ObjectMapper mapper;

    @Autowired
    public FollowerRepository(ObjectMapper mapper) {
        this.mapper = mapper;
    }

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

    public void remove(Follower follower){
        try {
            List<Follower> followers = getList();
            followers.remove(follower);
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
            mapper.writeValue(out, followers);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
