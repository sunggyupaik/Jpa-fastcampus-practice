package com.example.demo.repository;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookReviewInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookReviewInfoRepositoryTest {
    @Autowired
    private BookReviewInfoRepository bookReviewInfoRepository;

    @Autowired
    private BookRepository bookRepository;

    @Test
    void crudTest() {
        BookReviewInfo bookReviewInfo = new BookReviewInfo();
        //bookReviewInfo.setBookId(1L);
        bookReviewInfo.setAverageReviewScore(4.5f);
        bookReviewInfo.setReviewCount(2);

        bookReviewInfoRepository.save(bookReviewInfo);

        System.out.println(">>> " + bookReviewInfoRepository.findAll());
    }

    @Test
    void bookTest2() {
        givenBookReviewInfo(givenBook());

        System.out.println("bookReviewInfoRepository.findById(1L)");
        Book result = bookReviewInfoRepository
                        .findById(1L)
                        .orElseThrow(RuntimeException::new)
                        .getBook();

        System.out.println("result");
        System.out.println(">>> " + result);

        System.out.println("bookRepository.findById(1L)");
        BookReviewInfo result2 = bookRepository
                .findById(1L)
                .orElseThrow(RuntimeException::new)
                .getBookReviewInfo();

        System.out.println("result2");
        System.out.println(">>> " + result2);
    }

    public Book givenBook() {
        Book book = new Book();
        book.setName("JPA");
        book.setAuthorId(1L);

        return bookRepository.save(book);
    }

    public void givenBookReviewInfo(Book book) {
        BookReviewInfo bookReviewInfo = new BookReviewInfo();
        bookReviewInfo.setBook(book);
        bookReviewInfo.setAverageReviewScore(4.5f);
        bookReviewInfo.setReviewCount(2);

        bookReviewInfoRepository.save(bookReviewInfo);

        System.out.println("bookReviewInfoRepository.findAll()");
        System.out.println(">>> " + bookReviewInfoRepository.findAll());
        System.out.println("bookReviewInfoRepository.findAll() finish");
    }
}