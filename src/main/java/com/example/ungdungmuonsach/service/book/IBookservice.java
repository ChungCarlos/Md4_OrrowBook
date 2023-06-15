package com.example.ungdungmuonsach.service.book;

import com.example.ungdungmuonsach.model.Author;
import com.example.ungdungmuonsach.model.Books;
import com.example.ungdungmuonsach.service.IGeneralService;

import java.util.Optional;

public interface IBookservice extends IGeneralService<Books> {
    Iterable<Books> findAllByAuthor(Author author);
    void borrowBook(Books books);
    void returnBook(Books books);
    // Hàm để tạo mã borrowCode mới không trùng lặp

}
