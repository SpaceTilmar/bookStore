package com.finalexam.bookstorefixed.service;

import com.finalexam.bookstorefixed.model.Book;
import com.finalexam.bookstorefixed.model.Category;
import com.finalexam.bookstorefixed.repository.BookRepository;
import com.finalexam.bookstorefixed.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final CategoryService categoryService;

    @Autowired
    public BookService(BookRepository bookRepository, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.categoryService = categoryService;
    }

    public Book createBook(Book book) {
        Category existingCategory = categoryService.getCategoryById(book.getCategory().getId());
        if (existingCategory == null) {

            return null;
        }

        book.setCategory(existingCategory);

        return bookRepository.save(book);
    }

    public Book getBookById(Long bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    public List<Book> getAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    public List<Book> searchBooks(String name, String sku) {
        return bookRepository.findByNameContainingAndSkuContaining(name, sku);
    }

    public Book updateBook(Long bookId, Book updatedBook) {
        Book existingBook = getBookById(bookId);

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
        bookRepository.deleteById(bookId);
    }

    public List<Book> getBooksByCategory(String categoryName) {
        return bookRepository.findByCategoryCategoryName(categoryName);
    }
}