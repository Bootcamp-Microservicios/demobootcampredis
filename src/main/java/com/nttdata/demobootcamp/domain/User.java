package com.nttdata.demobootcamp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class User implements Serializable {

    @Id
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_USER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
    private Integer id;
    private String userName;
    private String lastName;

    public User() {
    }

    public User(String userName, String lastName) {
        this.userName = userName;
        this.lastName = lastName;
    }



}
