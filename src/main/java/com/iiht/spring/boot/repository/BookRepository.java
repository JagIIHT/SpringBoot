package com.iiht.spring.boot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iiht.spring.boot.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

}