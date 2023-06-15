package com.example.ungdungmuonsach.repository;

import com.example.ungdungmuonsach.model.Author;
import com.example.ungdungmuonsach.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepo extends JpaRepository<Books, Long> {
    Iterable<Books> findAllByAuthor(Author author);
}
