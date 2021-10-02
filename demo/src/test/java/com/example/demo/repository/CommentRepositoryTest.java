package com.example.demo.repository;

import com.example.demo.domain.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

@SpringBootTest
class CommentRepositoryTest {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    @Transactional
    void commentTest() {
        Comment comment = commentRepository.findById(1L).get();
        comment.setCommentedAt(LocalDateTime.now());

        commentRepository.saveAndFlush(comment);

//        entityManager.clear();

        commentRepository.findAll().forEach(System.out::println);
    }

    @Test
    @Transactional
    void commentDynamicInsertTest() {
        Comment comment = new Comment();
        comment.setComment("좀 별로였습니다.");

        commentRepository.saveAndFlush(comment);

        entityManager.clear();

        System.out.println(comment+"=comment");

//        System.out.println(commentRepository.findById(1L).get());
        commentRepository.findAll().forEach(System.out::println);
    }

    @Test
    @Transactional
    void commentTest2() {
        Comment comment = commentRepository.findById(1L).get();

        comment.setComment("좀 별로였습니다.");

        commentRepository.saveAndFlush(comment);

//        entityManager.clear();

        commentRepository.findAll().forEach(System.out::println);
    }
}