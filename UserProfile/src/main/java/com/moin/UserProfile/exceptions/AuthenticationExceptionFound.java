package com.moin.UserProfile.exceptions;

public class AuthenticationExceptionFound extends RuntimeException{
    public AuthenticationExceptionFound(String message){
        super(message);
    }
}
