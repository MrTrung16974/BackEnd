package com.vnp.template.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "functions")
public class Function {

    @Id
    @Column(name = "function_code")
    private String functionCode;

    @Column(name = "description")
    private String description;
}

