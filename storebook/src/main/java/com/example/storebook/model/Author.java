package com.example.storebook.model;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.io.Serializable;

@Table(name = "author")
@Entity
public class Author implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "name")
    private String name;

    @Column(name = "birthday")
    private Data birthday;

    public Author() {

    }

    public Author(String name, Data birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Data getBirthday() {
        return birthday;
    }

    public void setBirthday(Data birthday) {
        this.birthday = birthday;
    }
}
