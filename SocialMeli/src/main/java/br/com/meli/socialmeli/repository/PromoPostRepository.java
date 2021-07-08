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

<<<<<<< HEAD
=======
import br.com.meli.socialmeli.entity.Product;
>>>>>>> master
import br.com.meli.socialmeli.entity.PromoPost;

@Repository
public class PromoPostRepository {
<<<<<<< HEAD
    private static final File FILE = new File("postPromo.json");
=======
	private static final File FILE = new File("postPromo.json");
>>>>>>> master

    @Autowired
    private ObjectMapper mapper;

    public List<PromoPost> getList(){
        List<PromoPost> promoPosts = new ArrayList<>();
        try {
            FileInputStream is = new FileInputStream(FILE);
            TypeReference<List<PromoPost>> typeReference = new TypeReference<List<PromoPost>>() {};
            promoPosts = mapper.readValue(is, typeReference);
            is.close();
        } catch (IOException e) {
<<<<<<< HEAD

=======
        	
>>>>>>> master
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
<<<<<<< HEAD

            e.printStackTrace();
        }
    }
}
=======
        	
            e.printStackTrace();
        }
    }
}
>>>>>>> master
