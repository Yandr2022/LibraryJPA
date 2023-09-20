package by.Yandr2022.spring.learn.dao;

import by.Yandr2022.spring.learn.models.Book;
import by.Yandr2022.spring.learn.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {
//    private final JdbcTemplate jdbcTemplate;
//
//
//    @Autowired
//    public PersonDAO(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public List<Person> index() {
//        return jdbcTemplate.query("SELECT * FROM library.person",
//                new BeanPropertyRowMapper<>(Person.class));
//    }
//
//    public Person show(int id) {
//        return jdbcTemplate.query("SELECT * from library.person where person.id=?", new Object[]{id}
//                , new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
//    }
//    public Optional<Person> show(String fullName, int yearOfBirth) {
//        return jdbcTemplate.query("SELECT * from library.person where person.full_name=? AND person.year_of_birth=?", new Object[]{fullName, yearOfBirth}
//                , new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
//    }
//    public List<Book> getBooksByPersonId(int id) {
//        return jdbcTemplate.query("SELECT * from library.book where book.person_id=?"
//                ,new Object[]{id}, new BeanPropertyRowMapper<>(Book.class));
//    }
//    public void save(Person person) {
//        jdbcTemplate.update("INSERT INTO library.person(full_name, year_of_birth) " +
//                "VALUES (?,?)", person.getFullName(), person.getYearOfBirth());
//    }
//
//    public void update(int id, Person updatedPerson) {
//        jdbcTemplate.update("UPDATE library.person SET full_name=?, year_of_birth=? WHERE id=?"
//                , updatedPerson.getFullName(), updatedPerson.getYearOfBirth(),  updatedPerson.getId());
//    }
//
//    public void delete(int id) {
//        jdbcTemplate.update("DELETE FROM library.person WHERE id=?", id);
//    }
}
