package com.haritaspring.spring6webapp.bootstrap;
//Initalising the data-- this used H2 memory database
//

import com.haritaspring.spring6webapp.model.domain.Author;
import com.haritaspring.spring6webapp.model.domain.Book;
import com.haritaspring.spring6webapp.model.domain.Publisher;
import com.haritaspring.spring6webapp.repositories.AuthorRepository;
import com.haritaspring.spring6webapp.repositories.BookRepository;
import com.haritaspring.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//CommandLineRunner -  It is mainly used for Initialization purpose
// Spring Boot application, the implementation flow often begins from the controller in a web-based application because it handles HTTP requests.
// However, the CommandLineRunner interface serves a different purpose than a controller.
// It is not part of the request-response cycle but provides a mechanism to run startup logic before handling any requests.
@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    //This is constructor Injection - We will see more abput this
    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author hazel = new Author();
        hazel.setFirstName("Hazel");
        hazel.setLastName("G");

        Book intro = new Book();
        intro.setTitle("Introduction");
        intro.setIsbn("4444");

        //Converting unsaved instance to saved instance and persisting it into the database
        Author hazelsave = authorRepository.save(hazel);
        Book introsave = bookRepository.save(intro);

        Author tammi = new Author();
        tammi.setFirstName("Tammi");
        tammi.setLastName("G");

        Book inspo = new Book();
        inspo.setTitle("Inspiration");
        inspo.setIsbn("1111");

        Author tammisave = authorRepository.save(tammi);
        Book insposave = bookRepository.save(inspo);
        //Till here we have created two seperate databases but we dont have the connection between them

        hazelsave.getBooks().add(introsave); // created an association
        tammisave.getBooks().add(insposave);

        //Persisting the association
        authorRepository.save(hazelsave);
        authorRepository.save(tammisave);

        System.out.println("In BootStrap");
        System.out.println("Author Count: " +authorRepository.count());
        System.out.println("Book Count: " +bookRepository.count());

        Publisher akki = new Publisher();
        akki.setPublisherName("Akki");
        akki.setAddress("1");
        akki.setCity("Ithica");
        akki.setState("New York");
        akki.setZip("14850");

        Publisher ammu = new Publisher();
        ammu.setPublisherName("Ammu");
        ammu.setAddress("4");
        ammu.setCity("Ashivelle");
        ammu.setState("North Carolina");
        ammu.setZip("28704");

        Publisher akkisave = publisherRepository.save(akki);
        Publisher ammusave = publisherRepository.save(ammu);
        System.out.println("Publisher count: " +publisherRepository.count());

    }
}



















