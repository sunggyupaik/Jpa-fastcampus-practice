package com.example.demo.service;

import com.example.demo.domain.Comment;
import com.example.demo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Transactional
    public void run() {
        for(int i=0; i<10; i++) {
            Comment comment = new Comment();
            comment.setComment("최고에요");

            commentRepository.save(comment);
        }
    }

    @Transactional
    public void update() {
        List<Comment> comments = commentRepository.findAll();
        for (Comment comment : comments) {
            comment.setComment("별로에요.");

            commentRepository.save(comment);
        }
    }

    @Transactional
    public void insert() {
        Comment comment = new Comment();
        comment.setComment("감동이에요");
    }
}
