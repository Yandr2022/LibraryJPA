package by.Yandr2022.spring.learn.services;

import by.Yandr2022.spring.learn.models.Person;
import by.Yandr2022.spring.learn.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll(boolean sortByFullName) {
        return sortByFullName ? personRepository.findAll(Sort.by("fullName")) : personRepository.findAll();
    }

    public List<Person> findWithPagination(Integer page, Integer perPage, boolean sortByFullName) {
        return sortByFullName
                ? personRepository.findAll(PageRequest.of(page, perPage, Sort.by("fullName"))).getContent()
                : personRepository.findAll(PageRequest.of(page, perPage)).getContent();
    }

    public Person findOne(int id) {
        return personRepository.findById(id).orElse(null);
    }

    public Optional<Person> findOneByFullNameAndYearOfBirth(String fullName, int yearOfBirth) {
        return personRepository.findByFullNameAndYearOfBirth(fullName, yearOfBirth);
    }

    @Transactional
    public void save(Person person) {
        personRepository.save(person);
    }

    @Transactional
    public void update(int id, Person updatedPerson) {
        updatedPerson.setId(id);
        personRepository.save(updatedPerson);
    }

    @Transactional
    public void delete(int id) {
        personRepository.deleteById(id);
    }
}
