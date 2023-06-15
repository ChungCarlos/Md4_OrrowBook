package com.example.ungdungmuonsach.model;

import jakarta.persistence.*;

@Entity
@Table
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_name")
    private String bookName;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author  author;

    @Column(name = "quantity")
    private int quantity;

    public Books() {
    }

    public Books(String bookName, Author author, int quantity) {
        this.bookName = bookName;
        this.author = author;
        this.quantity = quantity;
    }

    public Books(Long id, String bookName, Author author, int quantity) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author=" + author +
                ", quantity=" + quantity +
                '}';
    }
}
