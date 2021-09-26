package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@ToString
//@DiscriminatorValue("Books")
public class Books extends Item {
    private String author;

    private String ISBN;
}
