package com.example.ungdungmuonsach.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "author_name")
    private String authorName;
    @OneToMany(mappedBy = "author")
    private List<Books> books = new ArrayList<>();

    public Author() {
    }

    public Author(String authorName, List<Books> books) {
        this.authorName = authorName;
        this.books = books;
    }

    public Author(Long id, String authorName, List<Books> books) {
        this.id = id;
        this.authorName = authorName;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                ", books=" + books +
                '}';
    }
}
