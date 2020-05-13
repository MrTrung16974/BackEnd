package com.example.storebook.model;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;

@Table(name = "author")
@Entity
public class Author implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "name")
    private String nameAuthor;

    @Column(name = "birthday")
    private Date birthdayAuthor;

    public Author() {

    }

    public Author(String nameAuthor, Date birthdayAuthor) {
        this.nameAuthor = nameAuthor;
        this.birthdayAuthor = birthdayAuthor;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public Date getBirthdayAuthor() {
        return birthdayAuthor;
    }

    public void setBirthdayAuthor(Date birthdayAuthor) {
        this.birthdayAuthor = birthdayAuthor;
    }
}
