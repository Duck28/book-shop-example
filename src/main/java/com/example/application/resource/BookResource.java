package com.example.application.resource;

import com.example.application.DAO.BookDAO;
import com.example.application.entity.Book;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("/books")
public class BookResource {

    @Inject
    private BookDAO bookDAO;

//    private TestBook t = new TestBook();


    @GET
    @Produces("application/json")
    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Book getBookById(@PathParam("id") int id) {
        return bookDAO.getBookById(id);
    }

//    @GET
//    @Produces("application/json")
//    public List<TestBook> getTestBook() {
//        List<TestBook> list = new ArrayList<TestBook>();
//        list.add(t);
//
//        return list;
//    }


    @POST
    @Path("/add")
    @Consumes("application/json")
    public Response addBook(Book book) {
        bookDAO.addBook(book);
        return Response.ok().build();
    }

    @PUT
    @Path("/update/{id}")
    @Consumes("application/json")
    public Response updateBook(@PathParam("id") int id, Book book) {
        int count = bookDAO.updateBook(id, book);
        if (count == 0) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Consumes("application/json")
    public Response deleteBook(@PathParam("id") int id) {
        int count = bookDAO.deleteBook(id);
        if (count == 0) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }


}
