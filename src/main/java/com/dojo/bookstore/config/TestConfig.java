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
        Category cat2 = new Category(null,"Ficção-Cientifica","livro de ficção-cientifica");
        Category cat3 = new Category(null,"Biografias","livro de Biografias");

        Book livro1 = new Book(null,"Clean Code","Robert Martin","xpto",cat1);
        Book livro2 = new Book(null,"Engenharia de software","Louis V.Gerstner","xpto",cat1);
        Book livro3 = new Book(null,"A Máquina do tempo","H. G. Wells","xpto",cat2);
        Book livro4 = new Book(null,"Guerras dos mundos","H. G. Wells","xpto",cat2);
        Book livro5 = new Book(null,"Eu, Robô","Isaac Asimov","xpto",cat2);

        cat1.getBooks().addAll(Arrays.asList(livro1,livro2));
        cat2.getBooks().addAll(Arrays.asList(livro3,livro4,livro5));

        this.categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
        this.bookRepository.saveAll(Arrays.asList(livro1,livro2,livro3,livro4,livro5));

    }
}
