package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootTest
public class EntityManagerTest {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    @Test
    void entityManagerTest() {
        System.out.println(entityManager.createQuery("select u from User u").getResultList());
    }

    @Test
    void cacheFindTest() {
        System.out.println(userRepository.findByEmail("fastcampus@naver.com").get());
        System.out.println(userRepository.findByEmail("fastcampus@naver.com").get());
        System.out.println(userRepository.findByEmail("fastcampus@naver.com").get());

        System.out.println(userRepository.findById(2L).get());
        System.out.println(userRepository.findById(2L).get());
        System.out.println(userRepository.findById(2L).get());

        userRepository.deleteById(2L);
    }

    @Test
    @Transactional
    void cacheFindTest2() {
        User user = userRepository.findById(1L).get();
        user.setName("berrrrrrrrrt");
        userRepository.save(user);

        //entityManager.flush();

        user.setEmail("berrrrrrrrrt@naver.com");
        userRepository.save(user);

        //entityManager.flush();

        //System.out.println(userRepository.findById(1L));

        System.out.println(userRepository.findAll());
    }
}
