package com.example.ungdungmuonsach.service.book.impl;

import com.example.ungdungmuonsach.model.Author;
import com.example.ungdungmuonsach.model.Books;
import com.example.ungdungmuonsach.repository.IBookRepo;
import com.example.ungdungmuonsach.service.book.IBookservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService implements IBookservice {
    @Autowired
    private IBookRepo iBookRepo;

    @Override
    public Iterable<Books> findAll() {
        return iBookRepo.findAll();
    }

    @Override
    public Optional<Books> findById(Long id) {
        return iBookRepo.findById(id);
    }

    @Override
    public void save(Books books) {
        iBookRepo.save(books);
    }

    @Override
    public void remove(Long id) {
        iBookRepo.deleteById(id);
    }

    @Override
    public Iterable<Books> findAllByAuthor(Author author) {
        return iBookRepo.findAllByAuthor(author);
    }
    public void borrowBook(Books book) {
        int quantity = book.getQuantity();
        if (quantity > 0) {
            book.setQuantity(quantity - 1);
            iBookRepo.save(book);
            // Ghi log hành động mượn sách
            System.out.println("Mượn sách: " + book.getBookName());
        } else {
            // Ghi log lỗi khi không thể mượn sách do hết hàng
            System.out.println("Lỗi: Số lượng sách không đủ");
        }
    }
    public void returnBook(Books book) {
        int quantity = book.getQuantity();
        book.setQuantity(quantity + 1);
        iBookRepo.save(book);
        // Ghi log hành động trả sách
        System.out.println("Trả sách: " + book.getBookName());
    }
}
