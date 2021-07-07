package br.com.meli.socialmeli.dto;

import br.com.meli.socialmeli.entity.User;

public class UserDTO {
		
    private long id;
    private String username;

    public UserDTO(long id, String username) {
        this.id = id;
        this.username = username;
    }

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.id = user.getid();
        this.username = user.getUsername();
    }

    public static UserDTO converte(User user) {
        return new UserDTO(user.getid(), user.getUsername());
    }
}
