package be.awake.bootgraphql.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
public class Author extends Identifiable {

    @Column
    private String name;

}
