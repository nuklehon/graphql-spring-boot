package be.awake.bootgraphql.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Author extends Identifiable {

    @Column
    private String name;

    @OneToMany(
            mappedBy = "author",
            cascade = CascadeType.ALL
    )
    private Set<Movie> movies = new HashSet<>();

    public void addMovie(final Movie movie) {
        movies.add(movie);
    }

}
