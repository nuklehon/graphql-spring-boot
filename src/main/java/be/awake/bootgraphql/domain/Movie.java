package be.awake.bootgraphql.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Movie extends Identifiable {

    @Column
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;

}
