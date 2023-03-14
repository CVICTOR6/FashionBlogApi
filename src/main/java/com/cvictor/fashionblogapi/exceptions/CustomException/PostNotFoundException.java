package com.cvictor.fashionblogapi.exceptions.CustomException;

public class PostNotFoundException extends RuntimeException{

    public PostNotFoundException(String message) {
        super(message);
    }
}
