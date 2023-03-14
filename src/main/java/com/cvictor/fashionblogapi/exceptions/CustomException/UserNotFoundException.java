package com.cvictor.fashionblogapi.exceptions.CustomException;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message) {
        super(message);
    }

}
