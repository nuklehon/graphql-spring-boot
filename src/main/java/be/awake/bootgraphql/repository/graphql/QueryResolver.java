package be.awake.bootgraphql.repository.graphql;

import be.awake.bootgraphql.domain.Author;
import be.awake.bootgraphql.repository.AuthorRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class QueryResolver implements GraphQLQueryResolver {

    private AuthorRepository authorRepository;

    @Autowired
    public QueryResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional(readOnly = true)
    public List<Author> getAuthors() {
        return ImmutableList.copyOf(authorRepository.findAll());
    }

}
