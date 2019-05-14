package be.awake.bootgraphql.repository.graphql;

import be.awake.bootgraphql.domain.Author;
import be.awake.bootgraphql.repository.AuthorRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class AuthorResolver implements GraphQLResolver<Author> {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
        this.mockAuthors();
    }

    @Transactional(readOnly = true)
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Transactional
    protected void mockAuthors() {
        Author author = new Author();
        author.setId(1L);
        author.setName("Anthony");
        authorRepository.save(author);
    }

}