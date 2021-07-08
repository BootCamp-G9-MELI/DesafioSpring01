package br.com.meli.socialmeli.repository;

import br.com.meli.socialmeli.entity.User;
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
public class UserRepository {

    private static final File FILE = new File("user.json");

    private final ObjectMapper mapper;

    @Autowired
    public UserRepository(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public List<User> getList(){
        List<User> users = new ArrayList<>();
        try {
            FileInputStream is = new FileInputStream(FILE);
            TypeReference<List<User>> typeReference = new TypeReference<List<User>>() {};
            users = mapper.readValue(is, typeReference);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }

    public void add(User user) {
        try {
            List<User> users = getList();
            users.add(user);
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
            mapper.writeValue(out, users);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
