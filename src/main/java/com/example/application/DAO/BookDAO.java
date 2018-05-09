package com.example.application.DAO;

import com.example.application.entity.Book;

import java.util.List;

public interface BookDAO {

    List<Book> getAllBooks();
    Book getBookById(int id);
    void addBook(Book Book);
    int updateBook(int id, Book Book);
    int deleteBook(int id);

}
