package be.awake.bootgraphql.repository.graphql;

import be.awake.bootgraphql.domain.Author;
import be.awake.bootgraphql.domain.Movie;
import com.coxautodev.graphql.tools.GraphQLResolver;
import com.google.common.collect.ImmutableList;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class AuthorResolver implements GraphQLResolver<Author> {

    @Transactional(readOnly = true)
    public List<Movie> getMovies(final Author author) {
        return ImmutableList.copyOf(author.getMovies());
    }

}