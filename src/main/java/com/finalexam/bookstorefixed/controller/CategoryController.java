package com.finalexam.bookstorefixed.controller;

import com.finalexam.bookstorefixed.model.Category;
import com.finalexam.bookstorefixed.repository.CategoryRepository;
import com.finalexam.bookstorefixed.service.CategoryService;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * creates a category
     *
     * @return
     */
    @PostMapping(value = "/categories")
    public ResponseEntity<Category> createCategory(@Validated @RequestBody Category category) {
        Category createdCategory = categoryService.createCategory(category);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    /**
     * updates a category
     *
     * @param categoryId
     * @param category
     * @return
     */
    @PutMapping(value = "/categories/{categoryId}")
    public ResponseEntity<Category> updateCategoryById(@PathVariable Long categoryId, @Validated @RequestBody Category category) {
        Category updatedCategory = categoryService.updateCategory(category, categoryId);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    /**
     * deletes a category
     *
     * @param categoryId
     * @return
     */
    @DeleteMapping(value = "/categories/{categoryId}")
    public ResponseEntity<?> deleteCategoryById(@PathVariable Long categoryId) {
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping
    public ResponseEntity<Iterable<Category>> getAllCategories() {
        Iterable<Category> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
