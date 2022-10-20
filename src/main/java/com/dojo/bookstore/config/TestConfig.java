package com.dojo.bookstore.config;

import com.dojo.bookstore.entities.Book;
import com.dojo.bookstore.entities.Category;
import com.dojo.bookstore.repositories.BookRepository;
import com.dojo.bookstore.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoriaRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null,"Informatica","livro de TI");

        Book livro1 = new Book(null,"Clean Code","Robert Martin","xpto",cat1);

        cat1.getBooks().addAll(Arrays.asList(livro1));

        this.categoriaRepository.saveAll(Arrays.asList(cat1));
        this.bookRepository.saveAll(Arrays.asList(livro1));

    }
}
