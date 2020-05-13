package com.example.storebook.model;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "categorys")
@Entity
public class Category implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

    @Column(name = "name")
    private String name;

    public Category() {

    }

    public Category(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
