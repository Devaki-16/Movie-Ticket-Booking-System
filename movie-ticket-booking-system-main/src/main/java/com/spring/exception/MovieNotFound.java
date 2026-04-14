package com.spring.exception;

public class MovieNotFound extends RuntimeException{
    public MovieNotFound(String title){
        super("This Movie is not Present: "+ title);
    }
}
