package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@ToString
//@DiscriminatorValue("Album")
public class Album extends Item {
    private String artist;
}
