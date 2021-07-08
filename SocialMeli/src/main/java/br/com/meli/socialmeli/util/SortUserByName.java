package br.com.meli.socialmeli.util;

import br.com.meli.socialmeli.entity.User;

import java.util.Comparator;

public class SortUserByName implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        return o1.getUsername().compareTo(o2.getUsername());
    }
}
