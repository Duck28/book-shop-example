package com.example.application;

import com.example.application.resource.BookResource;
import com.example.application.resource.HelloService;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;


public class JaxRsConfiguration extends Application {


    public JaxRsConfiguration() {
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(HelloService.class);
        classes.add(BookResource.class);
        return classes;
    }

}
