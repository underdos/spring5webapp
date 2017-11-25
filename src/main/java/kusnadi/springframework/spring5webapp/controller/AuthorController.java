package kusnadi.springframework.spring5webapp.controller;

import kusnadi.springframework.spring5webapp.repositories.AuthorRepository;
import kusnadi.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;

    @RequestMapping("/authors")
    public String getAuthors(Model model) {
        model.addAttribute("authors", authorRepository.findAll());

        return "authors";
    }
}
