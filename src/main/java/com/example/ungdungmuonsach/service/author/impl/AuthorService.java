package com.example.ungdungmuonsach.service.author.impl;

import com.example.ungdungmuonsach.model.Author;
import com.example.ungdungmuonsach.repository.IAuthorRepo;
import com.example.ungdungmuonsach.service.author.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService implements IAuthorService {
    @Autowired
    private IAuthorRepo iAuthorRepo;
    @Override
    public Iterable<Author> findAll() {
        return iAuthorRepo.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return iAuthorRepo.findById(id);
    }

    @Override
    public void save(Author author) {
        iAuthorRepo.save(author);
    }

    @Override
    public void remove(Long id) {
        iAuthorRepo.deleteById(id);;
    }
}
