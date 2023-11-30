package com.finalexam.bookstorefixed.repository;

import com.finalexam.bookstorefixed.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

}
