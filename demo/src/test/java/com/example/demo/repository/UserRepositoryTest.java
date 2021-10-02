package com.example.demo.repository;

import com.example.demo.domain.Address;
import com.example.demo.domain.Gender;
import com.example.demo.domain.User;
import com.example.demo.domain.UserHistory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserHistoryRepository userHistoryRepository;

    @Autowired
    EntityManager entityManager;

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

    @Test
    void embedTest() {
        User user = new User();
        user.setName("steve");
        user.setHomeAddress(new Address("서울시", "강남구", "강남대로 마왕빌딩", "06241"));
        user.setCompanyAddress(new Address("수원시", "장안구", "화성행궁", "281464"));

        //userRepository.save(user);

        User user1 = new User();
        user1.setName("bert");
        user1.setHomeAddress(null);
        user1.setCompanyAddress(null);

        userRepository.save(user1);

        User user2 = new User();
        user2.setName("john");
        user2.setHomeAddress(new Address());
        user2.setCompanyAddress(new Address());

        userRepository.save(user2);

//        entityManager.clear();

        userRepository.findAll().forEach(System.out::println);
        userHistoryRepository.findAll().forEach(System.out::println);

        assertAll(
                () -> assertThat(userRepository.findById(1L).get().getHomeAddress()).isNull(),
                () -> assertThat(userRepository.findById(2L).get().getHomeAddress()).isInstanceOf(Address.class)
        );
    }
}