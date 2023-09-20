package by.Yandr2022.spring.learn.services;

import by.Yandr2022.spring.learn.models.Book;
import by.Yandr2022.spring.learn.models.Person;
import by.Yandr2022.spring.learn.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    public List<Book> findAll(boolean sortByTitle) {
        return sortByTitle ? bookRepository.findAll(Sort.by("title")) : bookRepository.findAll();
    }

    public List<Book> findWithPagination(Integer page, Integer perPage, boolean sortByTitle) {
        return sortByTitle
                ? bookRepository.findAll(PageRequest.of(page, perPage, Sort.by("title"))).getContent()
                : bookRepository.findAll(PageRequest.of(page, perPage)).getContent();
    }

    public Book findOneById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Optional<Person> getBookReader(int id) {
        // Eager loading
        return bookRepository.findById(id).map(Book::getReader);
    }

    @Transactional
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Transactional
    public void update(int id, Book updatedBook) {
        updatedBook.setId(id);
        bookRepository.save(updatedBook);
    }

    @Transactional
    public void delete(int id) {
        bookRepository.deleteById(id);
    }
    @Transactional
    public void release(int id) {
        bookRepository.findById(id).ifPresent(
                book -> book.setReader(null));
    }
    @Transactional
    public void assign(int id, Person selectedReader) {
        bookRepository.findById(id).ifPresent(
                book -> book.setReader(selectedReader));
    }
}
