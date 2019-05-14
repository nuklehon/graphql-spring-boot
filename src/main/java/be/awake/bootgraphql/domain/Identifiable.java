package be.awake.bootgraphql.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public class Identifiable {

    @Id
    protected Long id;

}
