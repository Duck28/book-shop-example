package com.example.application.entity;

/**
 * A stub for test of BookResource.java.
 */

public class TestBook {

    private int id;
    private String title;
    private String author;
    private String publisher;
    private int year;

    public TestBook() {
        id = 1;
        title = "Metamorphosis";
        author = "Franz Kafka";
        publisher = "Praha";
        year = 1945;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
