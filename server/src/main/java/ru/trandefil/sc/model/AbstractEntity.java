package ru.trandefil.sc.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public abstract class AbstractEntity {

    protected String id ;

    public AbstractEntity(String id) {
        this.id = id;
    }

    public boolean isNew(){
        return id == null;
    }

}
