package com.example.demo.service;

import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
public class UserService {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void put() {
        User user = new User();
        user.setName("reUser");
        user.setEmail("reUser@fastcampus.com");

        entityManager.persist(user);
        //entityManager.detach(user);

        user.setName("newreUser");

        //entityManager.merge(user);

        entityManager.remove(user);
    }
}
