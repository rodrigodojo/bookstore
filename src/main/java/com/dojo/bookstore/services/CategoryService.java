package com.dojo.bookstore.services;

import com.dojo.bookstore.dto.CategoryDTO;
import com.dojo.bookstore.entities.Category;
import com.dojo.bookstore.repositories.CategoryRepository;
import com.dojo.bookstore.services.exceptions.DataIntegrityViolationException;
import com.dojo.bookstore.services.exceptions.DatabaseException;
import com.dojo.bookstore.services.exceptions.ObjectNotFoundException;
import com.dojo.bookstore.services.exceptions.SQLIntegrityConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

    public Category update(Integer id, CategoryDTO objDTO) {
        Category obj = findById(id);
        obj.setName(objDTO.getName());
        obj.setDescription(objDTO.getDescription());
        return categoryRepository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            categoryRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ObjectNotFoundException(id.toString());
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException("Objeto não pode ser deletado , possui associados");
        }catch (SQLIntegrityConstraintViolationException e) {
            throw new SQLIntegrityConstraintViolationException("Objeto não pode ser deletado , possui associados");
        }
    }
}
