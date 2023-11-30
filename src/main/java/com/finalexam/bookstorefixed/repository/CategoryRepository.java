package com.finalexam.bookstorefixed.repository;

import com.finalexam.bookstorefixed.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
