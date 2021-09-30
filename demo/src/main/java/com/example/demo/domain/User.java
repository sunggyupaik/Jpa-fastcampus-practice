package com.example.demo.domain;

import com.example.demo.domain.listener.UserEntityListener;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@EntityListeners(value = { UserEntityListener.class })
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column=@Column(name = "home_city")),
            @AttributeOverride(name = "district", column=@Column(name = "home_district")),
            @AttributeOverride(name = "detail", column=@Column(name = "home_detail")),
            @AttributeOverride(name = "zipCode", column=@Column(name = "home_zip_code"))
    })
    private Address homeAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column=@Column(name = "company_city")),
            @AttributeOverride(name = "district", column=@Column(name = "company_district")),
            @AttributeOverride(name = "detail", column=@Column(name = "company_detail")),
            @AttributeOverride(name = "zipCode", column=@Column(name = "company_zip_code"))
    })
    private Address companyAddress;



    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @ToString.Exclude
    private List<UserHistory> userHistoryList = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private List<Review> reviewList = new ArrayList<>();
}
