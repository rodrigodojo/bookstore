package com.dojo.bookstore.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@Entity
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "field title is requested")
    @Length(min = 3 , max = 50 , message = "this field get a minimal 3 letters and max that 50")
    private String title;
    @NotEmpty(message = "field author is requested")
    @Length(min = 3 , max = 50 , message = "this field get a minimal 3 letters and max that 50")
    private String author;
    @NotEmpty(message = "field text is requested")
    @Length(min = 3 , max = 200000 , message = "this field get a minimal 3 letters and max that 200.000")
    private String text;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id")
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
