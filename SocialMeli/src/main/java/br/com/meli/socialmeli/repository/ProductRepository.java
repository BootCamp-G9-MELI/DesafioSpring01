package br.com.meli.socialmeli.repository;

import br.com.meli.socialmeli.entity.Product;
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
public class ProductRepository {

    private static final File FILE = new File("product.json");

    @Autowired
    private ObjectMapper mapper;

    public List<Product> getList(){
        List<Product> products = new ArrayList<>();
        try {
            FileInputStream is = new FileInputStream(FILE);
            TypeReference<List<Product>> typeReference = new TypeReference<List<Product>>() {};
            products = mapper.readValue(is, typeReference);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return products;
    }

    public void add(Product product) {
        try {
            List<Product> products = getList();
            products.add(product);
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
            mapper.writeValue(out, products);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
