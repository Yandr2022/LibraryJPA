package by.Yandr2022.spring.learn.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Temporal;

@Service
@Transactional(readOnly = true)
public class BookService {
}
