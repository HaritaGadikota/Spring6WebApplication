package com.haritaspring.spring6webapp.repositories;

import com.haritaspring.spring6webapp.model.domain.Author;
import org.springframework.data.repository.CrudRepository;
//JpaRepository is a pre-defined interface that extends:
//PagingAndSortingRepository: Adds pagination and sorting methods.
//CrudRepository: Provides basic CRUD functionality. - We are using in this code
//If we go to the Repository class, the parent class - Needs two parameters <T -type, ID - type of ID>
//Generics (<T>) define what type of data the method or class can work with.
// Input parameters (()) define what data the method expects to receive.

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
