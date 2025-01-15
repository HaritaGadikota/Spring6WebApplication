package com.haritaspring.spring6webapp.services;

import com.haritaspring.spring6webapp.model.domain.Book;

public interface BookService {

    public Iterable<Book> findAll();
}
