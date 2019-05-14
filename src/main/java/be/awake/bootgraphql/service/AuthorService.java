package be.awake.bootgraphql.service;

import be.awake.bootgraphql.domain.Author;

import java.util.Optional;

public interface AuthorService {

    /**
     * @param id - Long
     * @return Optional<Author>
     */
    Optional<Author> findById(final Long id);

}
