package com.project.crystalball.exception;

public class NoSuchItemFoundException extends RuntimeException{

    public NoSuchItemFoundException(String message){
        super(message);
    }
}
