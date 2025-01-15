package com.haritaspring.spring6webapp.services;

import com.haritaspring.spring6webapp.model.domain.Author;

public interface AuthorService {
    public Iterable<Author> findAll();
}
