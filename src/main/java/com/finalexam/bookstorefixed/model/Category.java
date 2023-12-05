package com.finalexam.bookstorefixed.model;


import jakarta.persistence.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotEmpty
    @Column(name = "categoryId")
    private Long id;

    @NotEmpty
    @Column(name = "categoryName")
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<Book> books;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category() {
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
