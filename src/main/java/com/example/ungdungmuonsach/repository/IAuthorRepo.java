package com.example.ungdungmuonsach.repository;

import com.example.ungdungmuonsach.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthorRepo extends JpaRepository<Author, Long> {
}
