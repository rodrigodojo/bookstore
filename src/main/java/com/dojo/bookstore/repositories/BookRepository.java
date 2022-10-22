package com.dojo.bookstore.repositories;

import com.dojo.bookstore.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    @Query("SELECT obj FROM Book obj WHERE obj.categories.id = :id_cat ORDER BY title")
    List<Book> findAllByCategory(@Param(value = "id_cat") Integer id_cat);
}
