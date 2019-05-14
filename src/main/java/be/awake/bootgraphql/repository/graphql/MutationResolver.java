package be.awake.bootgraphql.repository.graphql;

import be.awake.bootgraphql.domain.Author;
import be.awake.bootgraphql.domain.Movie;
import be.awake.bootgraphql.repository.AuthorRepository;
import be.awake.bootgraphql.repository.MovieRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Component
public class MutationResolver implements GraphQLMutationResolver {

    private final MovieRepository movieRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public MutationResolver(final MovieRepository movieRepository,
                            final AuthorRepository authorRepository) {
        this.movieRepository = movieRepository;
        this.authorRepository = authorRepository;
    }

    @Transactional
    public Movie createMovie(final String title, final Optional<Long> authorId) {
        final Movie movie = new Movie();
        movie.setTitle(title);
        authorId.ifPresent(id -> authorRepository.findById(id).ifPresent(movie::setAuthor));
        return movieRepository.save(movie);
    }

    @Transactional
    public Author createAuthor(final String name) {
        final Author author = new Author();
        author.setName(name);
        return authorRepository.save(author);
    }

}
