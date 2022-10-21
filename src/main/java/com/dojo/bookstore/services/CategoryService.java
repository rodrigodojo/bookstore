package com.dojo.bookstore.services;

import com.dojo.bookstore.entities.Category;
import com.dojo.bookstore.repositories.CategoryRepository;
import com.dojo.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category findById(Integer id){
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. Id : " + id + " Tipo: " + Category.class.getName()));
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category create(Category obj){
        obj.setId(null);
        return categoryRepository.save(obj);
    }
}
