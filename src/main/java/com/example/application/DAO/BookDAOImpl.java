package com.example.application.DAO;

import com.example.application.session.SessionUtil;
import com.example.application.entity.Book;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.Session;

import java.util.List;

public class BookDAOImpl implements BookDAO{

    @Override
    public List<Book> getAllBooks() {
        Session session = SessionUtil.getSession();
        Query query = session.createQuery("from Book");
        List<Book> books = query.list();
//        List<Books> books = query.getResultList();
        session.close();
        return books;
    }


    @Override
    public Book getBookById(int id) {
        if (id <=0) {
            return null;
        }
        Session session = SessionUtil.getSession();
        Query query = session.createQuery("select b from Book  b where b.id =" + id);
        Object result = query.uniqueResult();
        return (Book) result;
    }

    @Override
    public void addBook(Book Book) {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.save(Book);
        tx.commit();
        session.close();
    }

    @Override
    public int updateBook(int id, Book Book) {
        if(id <=0)
            return 0;
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("update Book set title = :title, author = :author, publisher = :publisher, year = :year where id =" + id);
        query.setParameter("title", Book.getTitle());
        query.setParameter("author", Book.getAuthor());
        query.setParameter("publisher", Book.getPublisher());
        query.setParameter("year", Book.getYear());
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        tx.commit();
        session.close();
        return rowCount;
    }

    @Override
    public int deleteBook(int id) {
        if (id<=0) {
            return 0;
        }
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("delete from Book where id =" + id);
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        tx.commit();
        session.close();
        return rowCount;
    }
}
