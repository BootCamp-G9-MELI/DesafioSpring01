package br.com.meli.socialmeli.dto;

import br.com.meli.socialmeli.entity.User;

public class UserDTO {
		
    private long id;
    private String username;

    public UserDTO(long id, String username) {
        this.id = id;
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static UserDTO converte(User user) {
        return new UserDTO(user.getid(), user.getUsername());
    }
}
