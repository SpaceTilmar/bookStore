package com.finalexam.bookstorefixed.service;

import com.finalexam.bookstorefixed.model.Book;
import com.finalexam.bookstorefixed.model.Category;
import com.finalexam.bookstorefixed.repository.BookRepository;
import com.finalexam.bookstorefixed.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final CategoryService categoryService;

    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    @Autowired
    public BookService(BookRepository bookRepository, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.categoryService = categoryService;
    }

    public Book createBook(Book book) {
        Category existingCategory = categoryService.getCategoryById(book.getCategory().getId());
        logger.info("Creating book");
        if (existingCategory == null) {

            return null;
        }

        book.setCategory(existingCategory);

        return bookRepository.save(book);
    }

    public Book getBookById(Long bookId) {
        logger.info("Getting book by ID");
        return bookRepository.findById(bookId).orElse(null);
    }

    public List<Book> getAllBooks() {
        logger.info("Getting all books");
        return (List<Book>) bookRepository.findAll();
    }

    public List<Book> searchBooks(String name, String sku) {
        logger.info("Searching for book by name and SKU");
        return bookRepository.findByNameContainingAndSkuContaining(name, sku);
    }

    public Book updateBook(Long bookId, Book updatedBook) {
        Book existingBook = getBookById(bookId);
        logger.info("Updating book");

        if (existingBook != null && existingBook.getId().equals(updatedBook.getId())) {
            Category existingCategory = categoryService.getCategoryById(updatedBook.getCategory().getId());
            if (existingCategory == null) {
                return null;
            }

            updatedBook.setCategory(existingCategory);

            existingBook.setName(updatedBook.getName());
            existingBook.setSku(updatedBook.getSku());
            existingBook.setDescription(updatedBook.getDescription());
            existingBook.setPrice(updatedBook.getPrice());
            existingBook.setImage(updatedBook.getImage());
            existingBook.setStock(updatedBook.getStock());

            return bookRepository.save(existingBook);
        }
        return null;
    }

    public void deleteBook(Long bookId) {
        logger.info("Deleted Book");
        bookRepository.deleteById(bookId);
    }

    public List<Book> getBooksByCategory(Long categoryId) {
        logger.info("Fetching books by category ID: {}", categoryId);
        List<Book> books = bookRepository.findByCategoryId(categoryId);

        if (books.isEmpty()) {
            String errorMessage = "No books exist with a category id of: " + categoryId;
            logger.error(errorMessage);
            throw new RuntimeException(errorMessage);
        }

        return books;
    }
}