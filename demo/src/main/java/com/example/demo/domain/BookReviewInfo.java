package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BookReviewInfo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //private Long bookId;
    @OneToOne(optional = false)
    private Book book;

    private float averageReviewScore;

    private Integer reviewCount;
}
