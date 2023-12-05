package com.finalexam.bookstorefixed.service;

import com.finalexam.bookstorefixed.model.Category;
import com.finalexam.bookstorefixed.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    private static final Logger logger = LoggerFactory.getLogger(CategoryService.class);

    public Category createCategory(Category category){
        logger.info("Created Category");
        return categoryRepository.save(category);
    }
    public Iterable<Category> getAllCategories(){
        Iterable<Category> categories = categoryRepository.findAll();
        logger.info("Got all categoriew");
        return categories;
    }
    public Category updateCategory(Category category, Long categoryId){
        Optional<Category> findCategoryById = categoryRepository.findById(categoryId);
        if(findCategoryById.isPresent()){
            Category updatedCategory = findCategoryById.get();
            updatedCategory.setCategoryName(category.getCategoryName());
            return categoryRepository.save(updatedCategory);
        }
        logger.info("Updated category");
        return category;
    }
    public Category getCategoryById(Long categoryId) {
        logger.info("Got category by ID");
        return categoryRepository.findById(categoryId).orElse(null);
    }

    public void deleteCategory(Long categoryId){
        logger.info("Deleted category");
        categoryRepository.deleteById(categoryId);
    }
}
