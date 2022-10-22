package com.dojo.bookstore.dto;

import com.dojo.bookstore.entities.Book;
import com.dojo.bookstore.entities.Category;

import java.io.Serializable;

public class BookDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String title;
    private String author;
    private String text;

    public BookDTO(){super();}

    public BookDTO(Integer id, String title, String author, String text) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.text = text;
    }

    public BookDTO(Book obj) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
