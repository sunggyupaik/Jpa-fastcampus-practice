package com.example.demo.repository;

import com.example.demo.domain.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
public class ReviewRepositoryTest {
    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    @Transactional
    void reviewTest() {
        List<Review> reviewList = reviewRepository.findAllByFetchJoin();

        reviewList.forEach(System.out::println);

//        List<Review> reviewList = reviewRepository.findAllByEntityGraph();

//        reviewList.forEach(System.out::println);

//        List<Review> reviewList = reviewRepository.findAll();

//        reviewList.forEach(System.out::println);

//        System.out.println("전체를 가져왔습니다.");

//        System.out.println(reviewList.get(0).getComments());
//        System.out.println("첫번째 리뷰의 코멘트를 가져왔습니다");

//        System.out.println(reviewList.get(1).getComments());
//        System.out.println("두번째 리뷰의 코멘트를 가져왔습니다");
    }
}
