package com.finalexam.bookstorefixed.model;

import jakarta.persistence.*;

import javax.validation.constraints.NotEmpty;

@Entity
public class Book {
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotEmpty
    @Column(name = "bookId")
    private Long Id;
    @NotEmpty
    @Column(name = "bookName")
    private String name;
    @NotEmpty
    @Column(name = "bookSku")
    private String sku;
    @NotEmpty
    @Column(name = "bookDescription")
    private String description;
    @NotEmpty
    @Column(name = "bookPrice")
    private String price;
    @NotEmpty
    @Column(name = "bookCover")
    private String image;
    @NotEmpty
    @Column(name = "bookStock")
    private int stock;

}
