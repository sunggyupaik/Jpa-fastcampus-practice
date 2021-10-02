package com.example.demo.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Address {
    private String city; //시
    private String district; //구
    private String detail; //상세주소
    private String zipCode; //우편번호

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Address address = (Address) o;
        return Objects.equals(city, address.city)
                && Objects.equals(district, address.district)
                && Objects.equals(detail, address.detail)
                && Objects.equals(zipCode, address.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city,
                district,
                detail,
                zipCode);
    }
}
