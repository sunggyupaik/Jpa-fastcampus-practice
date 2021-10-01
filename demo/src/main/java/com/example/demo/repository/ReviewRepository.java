package com.example.demo.repository;

import com.example.demo.domain.Review;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("select r FROM Review r join fetch r.comments")
    List<Review> findAllByFetchJoin();

    @EntityGraph(attributePaths = "comments")
    @Query("select r FROM Review r")
    List<Review> findAllByEntityGraph();

    @EntityGraph(attributePaths = "comments")
    List<Review> findAll();
}
