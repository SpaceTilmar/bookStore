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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "category=" + category +
                ", Id=" + Id +
                ", name='" + name + '\'' +
                ", sku='" + sku + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", image='" + image + '\'' +
                ", stock=" + stock +
                ", id=" + getId() +
                '}';
    }
}
