package com.example.demo.repository;

import com.example.demo.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void bookTest() {
        Book book = new Book();
        book.setName("JPA");
        book.setAuthorId(1L);

        bookRepository.save(book);

        System.out.println(bookRepository.findAll());
    }

    @Test
    @Transactional
    void bookRelationTest() {
        givenBookAndReview();

        User user = userRepository.findById(1L).get();

        System.out.println("User : " + user);
        System.out.println("Review : " + user.getReviewList());
        System.out.println("Book : " + user.getReviewList().get(0).getBook());
        System.out.println("Publisher : " + user.getReviewList().get(0).getBook().getPublisher());
    }

    private void givenBookAndReview() {
        givenReview(givenUser(), givenBook(givenPublisher()));
    }

    private void givenReview(User user, Book book) {
        Review review = new Review();
        review.setTitle("내 인생을 바꾼 책");
        review.setContent("너무너무 재미있고 즐거운 책이었습니다.");
        review.setScore(5.0f);
        review.setUser(user);
        review.setBook(book);
        user.getReviewList().add(review);
        book.getReviewList().add(review);

        reviewRepository.save(review);
    }

    private User givenUser() {
        User user = new User();
        user.setName("jack");
        user.setEmail("davied@naver.com");
        user.setGender(Gender.MALE);

        User savedUser = userRepository.save(user);
        User findUser = userRepository.findById(1L).get();
        return findUser;
    }

    private Book givenBook(Publisher publisher) {
        Book book = new Book();
        book.setName("JPA 패키지");
        book.setPublisher(publisher);

        return bookRepository.save(book);
    }

    private Publisher givenPublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("fast");

        return publisherRepository.save(publisher);
    }
}
