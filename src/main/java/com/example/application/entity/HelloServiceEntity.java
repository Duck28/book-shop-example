package com.example.application.entity;



public class HelloServiceEntity {
    private String name;

    public void setName(String name){
        this.name = name;
    }
    public String getName() {
        return "Hello " + name;
    }
}
