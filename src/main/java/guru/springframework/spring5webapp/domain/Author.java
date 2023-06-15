package guru.springframework.spring5webapp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Author {
    // to set ids to be generated auto
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //Normal vars
    private String firstName;
    private String lasName;

    // for data to be connected to books
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

    // constructors
    public Author(){

    }
    public Author(String firstName, String lasName) {
        this.firstName = firstName;
        this.lasName = lasName;

    }

    //getters and setters
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

    public String getLasName() {
        return lasName;
    }

    public void setLasName(String lasName) {
        this.lasName = lasName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    // toString method override to print to console neater
    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lasName='" + lasName + '\'' +
                '}';
    }

    // methods for hibernate and many to many relationship with books
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return Objects.equals(id, author.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
