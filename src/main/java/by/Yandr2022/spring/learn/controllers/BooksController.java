package by.Yandr2022.spring.learn.controllers;


import by.Yandr2022.spring.learn.models.Book;
import by.Yandr2022.spring.learn.models.Person;
import by.Yandr2022.spring.learn.services.BookService;
import by.Yandr2022.spring.learn.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Component
@RequestMapping("/books")
public class BooksController {
    private final BookService bookService;
    private final PersonService personService;


    @Autowired
    public BooksController(BookService bookService, PersonService personService) {
        this.bookService = bookService;

        this.personService = personService;
    }

    @GetMapping()
    public String index(Model model, @RequestParam(value = "page", required = false) Integer page,
                        @RequestParam(value = "per_page", required = false) Integer perPage,
                        @RequestParam(value = "sort_by_title", required = false) boolean sortByTitle) {
        if (page == null || perPage == null) {
            model.addAttribute("books", bookService.findAll(sortByTitle));
        }else {
            model.addAttribute("books", bookService.findWithPagination(page, perPage,sortByTitle));

        }
        return "books/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model, @ModelAttribute("person") Person person) {
        model.addAttribute("book", bookService.findOneById(id));

        Optional<Person> reader = bookService.getBookReader(id);

        if (reader.isPresent()) {
            model.addAttribute("reader", reader.get());
        } else {
            model.addAttribute("people", personService.findAll(true));
        }

        return "books/show";
    }

    @GetMapping("/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "books/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return "books/new";

        bookService.save(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("book", bookService.findOneById(id));
        return "books/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult
            , @PathVariable("id") int id) {

        if (bindingResult.hasErrors())
            return "books/edit";

        bookService.update(id, book);
        return "redirect:/books";
    }


    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        bookService.delete(id);
        return "redirect:/books";
    }

    @PatchMapping("/{id}/release")
    public String release(@PathVariable("id") int id) {
        bookService.release(id);
        return "redirect:/books/" + id;
    }

    @PatchMapping("/{id}/assign")
    public String assign(@PathVariable("id") int id, @ModelAttribute Person selectedReader) {
        bookService.assign(id, selectedReader);
        return "redirect:/books/" + id;
    }

    @GetMapping("/search")
    public String searchPage() {
        return "books/search";
    }

    @PostMapping("/search")
    public String makeSearch(Model model, @RequestParam("query") String query) {
        model.addAttribute("books", bookService.findByTitleStartsWith(query));
        return "books/search";
    }
}
