package by.Yandr2022.spring.learn.repositories;

import by.Yandr2022.spring.learn.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {
}