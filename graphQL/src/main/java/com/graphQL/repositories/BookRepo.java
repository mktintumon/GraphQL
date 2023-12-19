package com.graphQL.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graphQL.entities.Book;

@Repository
public interface BookRepo extends JpaRepository<Book , Integer>{
    
}
