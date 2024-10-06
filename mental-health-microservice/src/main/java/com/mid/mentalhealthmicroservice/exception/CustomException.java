package com.mid.mentalhealthmicroservice.exception;

public class CustomException extends Exception{
    private static final String TEXT="Doesn't Exist";
    public CustomException(){
        super(TEXT);
    }
    public CustomException(String s){
        super(s);
    }

}
