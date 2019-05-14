package be.awake.bootgraphql.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
public class Movie extends Identifiable {

    @Column
    private String title;

}
