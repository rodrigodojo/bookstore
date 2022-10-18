package com.dojo.bookstore.domain;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@Entity
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String title;
    private String author;
    private String text;

    private Category categories;

    public Book(Integer id, String title, String author, String text, Category categories) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.text = text;
        this.categories = categories;
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

    public Category getCategories() {
        return categories;
    }

    public void setCategories(Category categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
