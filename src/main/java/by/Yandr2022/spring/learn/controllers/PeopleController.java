package by.Yandr2022.spring.learn.controllers;

import by.Yandr2022.spring.learn.dao.PersonDAO;
import by.Yandr2022.spring.learn.models.Person;
import by.Yandr2022.spring.learn.services.BookService;
import by.Yandr2022.spring.learn.services.PersonService;
import by.Yandr2022.spring.learn.util.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonValidator personValidator;
    private final PersonService personService;
    private final BookService bookService;

    @Autowired
    public PeopleController(PersonValidator personValidator, PersonService personService, BookService bookService) {
        this.bookService = bookService;
        this.personValidator = personValidator;
        this.personService = personService;
    }

    @GetMapping()
    public String index(Model model, @RequestParam(value = "page", required = false) Integer page,
                        @RequestParam(value = "per_page", required = false) Integer perPage,
                        @RequestParam(value = "sort_by_full_name", required = false) boolean sortByFullName) {
        if (page == null || perPage == null) {
            model.addAttribute("people", personService.findAll(sortByFullName)); // выдача всех книг
        } else {
            model.addAttribute("people", personService.findWithPagination(page, perPage, sortByFullName));
        }
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personService.findOne(id));
        model.addAttribute("books", bookService.findAllByPerson(personService.findOne(id)));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        personValidator.validate(person, bindingResult);

        if (bindingResult.hasErrors())
            return "people/new";

        personService.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", personService.findOne(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult
            , @PathVariable("id") int id) {
        personValidator.validate(person, bindingResult);

        if (bindingResult.hasErrors())
            return "people/edit";

        personService.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        personService.delete(id);
        return "redirect:/people";
    }
}
