package com.haritaspring.spring6webapp.services;

import com.haritaspring.spring6webapp.model.domain.Book;
import com.haritaspring.spring6webapp.repositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //Yes, when using findAll() in Spring Data JPA, it typically returns an Iterable<T> by default.

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}
