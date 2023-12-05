package com.finalexam.bookstorefixed.repository;

import com.finalexam.bookstorefixed.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {


    List<Book> findByNameContainingAndSkuContaining(String name, String sku);

    List<Book> findByCategoryCategoryName(String categoryName);
}
