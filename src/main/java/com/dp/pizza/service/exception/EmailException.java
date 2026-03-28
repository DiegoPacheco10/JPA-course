package com.dp.pizza.service.exception;

public class EmailException extends RuntimeException{

    public EmailException(){
        super("Error sending email!");
    }
}
