package by.Yandr2022.spring.learn.util;


import by.Yandr2022.spring.learn.dao.PersonDAO;
import by.Yandr2022.spring.learn.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

//@Component
//public class PersonValidator implements Validator {
////    private final PersonDAO personDAO;
////
////    @Autowired
////    public PersonValidator(PersonDAO personDAO) {
////        this.personDAO = personDAO;
////    }
////
////
////    @Override
////    public boolean supports(Class<?> clazz) {
////        return Person.class.equals(clazz);
////    }
////
////    @Override
////    public void validate(Object target, Errors errors) {
////        Person person = (Person) target;
////        Optional<Person> temp = personDAO.show(person.getFullName(), person.getYearOfBirth());
////        if (temp.isPresent() && temp.get().getId() != person.getId()) {
////            errors.rejectValue("fullName", "", "This account is already taken");
////            errors.rejectValue("yearOfBirth", "", "This account is already taken");
////        }
////
////    }
//}
