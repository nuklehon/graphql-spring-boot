package be.awake.bootgraphql.repository.graphql;

import be.awake.bootgraphql.domain.Author;
import be.awake.bootgraphql.domain.Movie;
import be.awake.bootgraphql.repository.AuthorRepository;
import be.awake.bootgraphql.repository.MovieRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Component
public class QueryResolver implements GraphQLQueryResolver {

    private AuthorRepository authorRepository;
    private MovieRepository movieRepository;

    @Autowired
    public QueryResolver(final AuthorRepository authorRepository, final MovieRepository movieRepository) {
        this.authorRepository = authorRepository;
        this.movieRepository = movieRepository;
    }

    @Transactional(readOnly = true)
    public List<Author> getAuthors(final Optional<Long> id) {
        return id
                .map(i -> ImmutableList.of(authorRepository.findById(i).orElseThrow(EntityNotFoundException::new)))
                .orElseGet(() -> ImmutableList.copyOf(authorRepository.findAll()));
    }

    @Transactional(readOnly = true)
    public List<Movie> getMovies(final Optional<Long> id) {
        return id
                .map(i -> ImmutableList.of(movieRepository.findById(i).orElseThrow(EntityNotFoundException::new)))
                .orElseGet(() -> ImmutableList.copyOf(movieRepository.findAll()));
    }

}
