package com.example.application.DAO;

import com.example.application.session.SessionUtil;
import com.example.application.session.SessionUtilImpl;
import com.example.application.entity.Book;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;

@Component
public class BookDAOImpl implements BookDAO{

    private final SessionUtil util;

    @Inject
    public BookDAOImpl(SessionUtil util) {
        this.util = util;
    }

    @Override
    public List<Book> getAllBooks() {
        Session session = util.getSessionFactory().openSession();
        Query query = session.createQuery("from Book");
        List<Book> books = query.list();
//        List<Books> books = query.getResultList();
        session.close();
        util.shutdown();
        return books;
    }


    @Override
    public Book getBookById(int id) {
        if (id <=0) {
            return null;
        }
        Session session = util.getSessionFactory().openSession();
        Query query = session.createQuery("select b from Book  b where b.id =" + id);
        Object result = query.uniqueResult();
        util.shutdown();
        return (Book) result;
    }

    @Override
    public void addBook(Book Book) {
        Session session = util.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(Book);
        tx.commit();
        session.close();
        util.shutdown();
    }

    @Override
    public int updateBook(int id, Book Book) {
        if(id <=0)
            return 0;
        Session session = util.getSessionFactory().openSession();
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
        util.shutdown();
        return rowCount;
    }

    @Override
    public int deleteBook(int id) {
        if (id<=0) {
            return 0;
        }
        Session session = util.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("delete from Book where id =" + id);
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        tx.commit();
        session.close();
        util.shutdown();
        return rowCount;
    }
}
