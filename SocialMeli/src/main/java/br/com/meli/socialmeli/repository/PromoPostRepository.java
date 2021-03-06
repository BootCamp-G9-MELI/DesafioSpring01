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

import br.com.meli.socialmeli.entity.PromoPost;

@Repository
public class PromoPostRepository {

	private static final File FILE = new File("postPromo.json");

    private final ObjectMapper mapper;

    @Autowired
    public PromoPostRepository(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public List<PromoPost> getList(){
        List<PromoPost> promoPosts = new ArrayList<>();
        try {
            FileInputStream is = new FileInputStream(FILE);
            TypeReference<List<PromoPost>> typeReference = new TypeReference<List<PromoPost>>() {};
            promoPosts = mapper.readValue(is, typeReference);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return promoPosts;
    }

    public void add(PromoPost promo) {
        try {
            List<PromoPost> promoPosts = getList();
            promoPosts.add(promo);
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
            mapper.writeValue(out, promoPosts);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
