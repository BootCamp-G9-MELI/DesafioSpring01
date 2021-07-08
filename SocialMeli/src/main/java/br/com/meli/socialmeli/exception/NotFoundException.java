package br.com.meli.socialmeli.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String mensagem) {
        super(mensagem);
    }
}
