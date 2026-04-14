package com.spring.exception;

public class MovieAlreadyPresent extends RuntimeException{
    public MovieAlreadyPresent(String movieName){
        super("This Movie is Already Present: "+movieName);
    }
}
