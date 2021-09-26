package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DTYPE")
@Getter
@Setter
@ToString
public abstract class Item {
    @Id @GeneratedValue
    private Long id;

    private String name;

    private int price;
}
