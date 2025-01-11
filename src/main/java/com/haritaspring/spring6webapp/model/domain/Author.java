package com.haritaspring.spring6webapp.model.domain;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    //We are creating a relationship between the tables
    //MappingBy is used to indicate that this side of the relationship is the inverse side
    //So it means that the books field is managed by the authors field in the Book entity
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    //toString() does not convert methods. Instead, it provides a string describing an object’s data.
    //You override it to customize how your objects are displayed.
    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", books=" + books +
                '}';
    }

    //Equals() method is used to check if there are any similar objects
    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Author author)) return false;

        return Objects.equals(id, author.id);
    }

    // Generates a numeric code (hash) representing the object, used in hash-based collections like HashMap or HashSet
    //Two objects with the same equals() should have same hashcode()
    //Both together ensure objects are correctly handled for uniqueness and efficiently stored.
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}












