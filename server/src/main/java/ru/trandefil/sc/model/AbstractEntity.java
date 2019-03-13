package ru.trandefil.sc.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    protected String id ;

    public AbstractEntity(String id) {
        this.id = id;
    }

    public boolean isNew(){
        return id == null;
    }

}
