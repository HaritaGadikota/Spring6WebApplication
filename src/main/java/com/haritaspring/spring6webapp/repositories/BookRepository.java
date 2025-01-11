package com.haritaspring.spring6webapp.repositories;

import com.haritaspring.spring6webapp.model.domain.Book;
import org.springframework.data.repository.CrudRepository;

//We dont perform any implementation, The CrudRepository will take care of everything - we declare not implement
public interface BookRepository extends CrudRepository<Book, Long> {

}
