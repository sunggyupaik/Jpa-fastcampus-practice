package com.example.demo.service;

import com.example.demo.repository.CommentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CommentServiceTest {
    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentRepository commentRepository;

    @Test
    void commentTest() {
        //commentService.run();

        commentService.update();
        commentService.insert();

        commentRepository.findAll().forEach(System.out::println);
    }
}