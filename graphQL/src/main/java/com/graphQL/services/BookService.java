package com.graphQL.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graphQL.entities.Book;
import com.graphQL.repositories.BookRepo;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public Book createBook(Book book) {
        return bookRepo.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Book getBookById(int id) {
        return this.bookRepo.findById(id).orElseThrow(() -> new RuntimeException("Book not found!!!"));
    }
}
