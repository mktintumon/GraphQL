package com.graphQL.controllers;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import com.graphQL.entities.Book;
import com.graphQL.services.BookService;

import lombok.Data;


@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @MutationMapping("createBook")
    public Book createBook(@Argument BookInput book){
        Book b = new Book();
        b.setTitle(book.getTitle());
        b.setAuthor(book.getAuthor());
        b.setPrice(book.getPrice());
        b.setLanguage(book.getLanguage());

        return this.bookService.createBook(b);
    }

    @QueryMapping("allBooks")
    public List<Book> getAllBooks(){
        return this.bookService.getAllBooks();
    }

    @QueryMapping("getBook")
    public Book getBookById(@Argument int id){
        return this.bookService.getBookById(id);
    }
}


@Data
class BookInput{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String author;
    private int price;
    private String language;
}
