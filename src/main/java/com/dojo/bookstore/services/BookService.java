package com.dojo.bookstore.services;

import com.dojo.bookstore.dto.BookDTO;
import com.dojo.bookstore.entities.Book;
import com.dojo.bookstore.entities.Category;
import com.dojo.bookstore.repositories.BookRepository;
import com.dojo.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryService categoryService;

    public Book findById(Integer id){
        Optional<Book> obj = bookRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. Id : " + id + " Tipo: " + Book.class.getName()));
    }

    public List<Book> findAll(Integer id_cat){
        categoryService.findById(id_cat);
        return bookRepository.findAllByCategory(id_cat);
    }

    public Book create(Integer id_cat ,Book obj){
        obj.setId(null);
        Category cat = categoryService.findById(id_cat);
        obj.setCategories(cat);
        return bookRepository.save(obj);
    }

    public Book update(Integer id, Book obj) {
        Book newObj = findById(id);
        updateData(newObj,obj);
        return bookRepository.save(newObj);
    }

    private void updateData(Book newObj, Book obj) {
        newObj.setTitle(obj.getTitle());
        newObj.setAuthor(obj.getAuthor());
        newObj.setText(obj.getText());
    }

    public void delete(Integer id) {
        Book obj = findById(id);
        bookRepository.deleteById(id);
    }
}
