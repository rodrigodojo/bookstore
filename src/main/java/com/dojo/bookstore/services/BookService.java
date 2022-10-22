package com.dojo.bookstore.services;

import com.dojo.bookstore.dto.BookDTO;
import com.dojo.bookstore.entities.Book;
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

    public Book create(Book obj){
        obj.setId(null);
        return bookRepository.save(obj);
    }

    public Book update(Integer id, BookDTO objDTO) {
        Book obj = findById(id);
        obj.setTitle(objDTO.getTitle());
        return bookRepository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            bookRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new com.dojo.bookstore.services.exceptions.DataIntegrityViolationException("Objeto não pode ser deletado , possui associados");
        }
    }
}
