package be.awake.bootgraphql.controller;

import be.awake.bootgraphql.domain.Author;
import be.awake.bootgraphql.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(final AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/{id}")
    public Author byId(@PathVariable final Long id) {
        return authorService.findById(id).orElseThrow(EntityNotFoundException::new);
    }

}
