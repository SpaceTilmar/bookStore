package com.finalexam.bookstorefixed.service;

import com.finalexam.bookstorefixed.model.Category;
import com.finalexam.bookstorefixed.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public Category createCategory(Category category){

        return categoryRepository.save(category);
    }
    public Iterable<Category> getAllCategories(){
        Iterable<Category> categories = categoryRepository.findAll();
        return categories;
    }
    public Category updateCategory(Category category, Long categoryId){
        Optional<Category> findCategoryById = categoryRepository.findById(categoryId);
        if(findCategoryById.isPresent()){
            Category updatedCategory = findCategoryById.get();
            updatedCategory.setCategoryName(category.getCategoryName());
            return updatedCategory;
        }

        return category;
    }

    public void deleteCategory(Long categoryId){
        categoryRepository.deleteById(categoryId);
    }
}
