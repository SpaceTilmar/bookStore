package com.finalexam.bookstorefixed.controller;

import com.finalexam.bookstorefixed.model.Category;
import com.finalexam.bookstorefixed.repository.CategoryRepository;
import com.finalexam.bookstorefixed.service.CategoryService;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryService categoryService;

    /**
     * creates a category
     *
     * @return
     */
    @PostMapping(value = "/categories")
    public ResponseEntity<?> createCategory(@Validated Category category){
        return new ResponseEntity<>(categoryService.createCategory(category), HttpStatus.OK);
    }


    /**
     * updates a category
     * @param categoryId
     * @param category
     * @return
     */
    public ResponseEntity<?> updateCategoryById(Category category, Long categoryId){
        return new ResponseEntity<>(categoryService.updateCategory(category,categoryId), HttpStatus.OK);
    }
    /**
     * deletes a category
     * @param categoryId
     * @return
     */
    @DeleteMapping(value = "/categories/{categoryId]")
    public ResponseEntity<?> deleteCategoryById(@PathVariable Long categoryId){
        return new ResponseEntity<>(categoryService.deleteCategory(categoryId), HttpStatus.NO_CONTENT);
    }
    /**
     * gets all categories
     * @return
     */

}
