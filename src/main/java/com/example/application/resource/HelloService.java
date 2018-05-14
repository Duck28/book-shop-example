package com.example.application.resource;

import com.example.application.entity.HelloServiceEntity;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * Simple test Hello service at /message.
 */

@Path("/message")
public class HelloService {

    @GET
    @Path("/{param}")
    public Response printMessage(@PathParam("param") String msg) {
        HelloServiceEntity helloEntity = new HelloServiceEntity();
        helloEntity.setName(msg);
        return Response.status(200).entity(helloEntity.getName()).build();
    }
}

