package be.awake.bootgraphql.repository.graphql;

import be.awake.bootgraphql.domain.Author;
import be.awake.bootgraphql.domain.Movie;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class MovieResolver implements GraphQLResolver<Movie> {

    @Transactional(readOnly = true)
    public Author getAuthor(final Movie movie) {
        return movie.getAuthor();
    }

}
