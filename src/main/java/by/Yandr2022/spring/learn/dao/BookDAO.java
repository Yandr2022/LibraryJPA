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
public class BookDAO {
//    private final JdbcTemplate jdbcTemplate;
//
//
//    @Autowired
//    public BookDAO(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public List<Book> index() {
//        return jdbcTemplate.query("SELECT * FROM book",
//                new BeanPropertyRowMapper<>(Book.class));
//    }
//
//    public Book show(int id) {
//        return jdbcTemplate.query("SELECT * from book where book.id=?", new Object[]{id}
//                , new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
//    }
//
//    public void save(Book book) {
//        jdbcTemplate.update("INSERT INTO book (title, author, year) " +
//                "VALUES (?,?,?)", book.getTitle(), book.getAuthor(), book.getYear());
//    }
//
//    public void update(int id, Book updatedBook) {
//        jdbcTemplate.update("UPDATE book SET title=?, author=?, year=? WHERE id=?", updatedBook.getTitle()
//                , updatedBook.getAuthor(), updatedBook.getYear(), updatedBook.getId());
//    }
//
//    public void delete(int id) {
//        jdbcTemplate.update("DELETE FROM book WHERE id=?", id);
//    }
//
//    public Optional<Person> getBookReader(int id) {
//        return jdbcTemplate.query("SELECT * from book join person on person.id=book.person_id where book.id=?"
//                , new Object[]{id}, new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
//    }
//
//    public void assign(int id, Person reader) {
//        jdbcTemplate.update("UPDATE book set book.person_id=? where id=?", reader.getId(), id);
//    }
//
//    public void release(int id) {
//        jdbcTemplate.update("UPDATE book set book.person_id=null where id=?", id);
//    }
}
