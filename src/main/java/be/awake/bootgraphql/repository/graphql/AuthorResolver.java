package be.awake.bootgraphql.repository.graphql;

import be.awake.bootgraphql.domain.Author;
import be.awake.bootgraphql.domain.Movie;
import be.awake.bootgraphql.repository.AuthorRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;
import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
    public Optional<Author> findById(Long id)    {
        return authorRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Movie> getMovies(final Author author) {
        return ImmutableList.copyOf(author.getMovies());
    }

    @Transactional
    protected void mockAuthors() {
        Author author = new Author();
        author.setName("Anthony");

        Movie movie = new Movie();
        movie.setTitle("Title");
        author.addMovie(movie);

        authorRepository.save(author);
    }

}