package com.example.demo.repository;

import com.example.demo.domain.Gender;
import com.example.demo.domain.User;
import com.example.demo.domain.UserHistory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserHistoryRepository userHistoryRepository;

    @Test
    public void saveUser() {
        User user = new User();
        user.setEmail("melon9751");
        user.setName("paik");

        User savedUser = userRepository.save(user);

        userRepository.findAll();

        User user2 = new User();
        user.setEmail("melon9751");
        user.setName("paik");

        User savedUser2 = userRepository.save(user2);

        System.out.println(userRepository.findAll());
        System.out.println(userRepository.findById(1L).get().getCreatedAt());
    }

    @Test
    void userRelationTest() {
        User user = new User();
        user.setName("jack");
        user.setEmail("davied@naver.com");
        user.setGender(Gender.MALE);
        userRepository.save(user);

        user.setEmail("bert@naver.com");
        userRepository.save(user);

        user.setName("bert");
        userRepository.save(user);

        System.out.println(userHistoryRepository.findAll());

        List<UserHistory> result = userRepository.findByEmail("bert@naver.com").get().getUserHistoryList();

        System.out.println(result);

        System.out.println("UserHistory.getUser() : " + userHistoryRepository.findAll().get(0).getUser());
    }
}