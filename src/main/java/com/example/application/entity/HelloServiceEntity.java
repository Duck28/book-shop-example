package com.example.application.entity;



public class HelloServiceEntity {
    private String message;

    public void setMessage(String message){
        this.message  = message;
    }
    public String getMessage(){
        return "Your Message : Hello " + message;
    }
}
