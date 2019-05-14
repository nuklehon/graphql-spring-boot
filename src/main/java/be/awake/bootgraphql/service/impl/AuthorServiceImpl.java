package be.awake.bootgraphql.service.impl;

import be.awake.bootgraphql.domain.Author;
import be.awake.bootgraphql.repository.AuthorRepository;
import be.awake.bootgraphql.service.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(final AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Optional<Author> findById(final Long id) {
        log.debug("Invoking AuthorService.findBydId({})", id);
        return authorRepository.findById(id);
    }

}
