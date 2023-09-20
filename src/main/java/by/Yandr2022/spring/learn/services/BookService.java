package by.Yandr2022.spring.learn.services;

import by.Yandr2022.spring.learn.models.Book;
import by.Yandr2022.spring.learn.models.Person;
import by.Yandr2022.spring.learn.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAllByPerson(Person reader) {
        return bookRepository.findByReader(reader);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
