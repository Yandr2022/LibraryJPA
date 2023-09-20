package by.Yandr2022.spring.learn.models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Full Name should not be empty")
    @Size(min = 3, max = 50, message = "Full Name should be between 3 and 50 characters")
    @Column(name="full_name")
    private String fullName;
    @Min(value = 1900, message = "Year of Birth should be greater than 1900")
    @Column(name="year_of_birth")
    private int yearOfBirth;
    @OneToMany(mappedBy = "reader")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Book> books;

    public Person() {
    }

    public Person(String fullName, int yearOfBirth) {
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && yearOfBirth == person.yearOfBirth && Objects.equals(fullName, person.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, yearOfBirth);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }
}
