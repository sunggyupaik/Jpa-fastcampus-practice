package com.example.demo.domain.converter;

import com.example.demo.dto.BookStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class BookStatusConverter implements AttributeConverter<BookStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(BookStatus attribute) {
        return attribute.getCode();
    }

    @Override
    public BookStatus convertToEntityAttribute(Integer dbData) {
        //return new BookStatus(dbData); null에 대한 대비를 해야한다.
        return dbData != null ? new BookStatus(dbData) : null;
    }
}
