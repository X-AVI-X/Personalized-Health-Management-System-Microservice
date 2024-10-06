package com.mid.communityandsocialintegration.exception;

import com.mid.communityandsocialintegration.response.ActionResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CustomException extends Exception{
    private ActionResponse errorResponse;
    public CustomException(String message){
        errorResponse = new ActionResponse(message);
    }
}
